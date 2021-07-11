package com.example.android.newsbit.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.newsbit.R
import com.example.android.newsbit.adapters.NewsAdapter
import com.example.android.newsbit.models.Article
import com.example.android.newsbit.ui.MainActivity
import com.example.android.newsbit.ui.NewsViewModel
import com.example.android.newsbit.utils.Resource
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_top_news.*


class TopNewsFragment : Fragment(R.layout.fragment_top_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var newsAdapter: NewsAdapter
    lateinit var newsItemView: RecyclerView
    lateinit var paginationProgressBarView: ProgressBar
    lateinit var btnRetry: Button
    lateinit var tvErrorMessage: TextView
    var totalResults = 0 // totalResults will be received in news response later
    var isError = false
    var isLoading = false
    var isScrolling = false
    val TAG = "TopNewsFragment"
    var topNewsPageTemp = 1
    var pressedTime: Long = 0


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
        
        /*if (this::fragViewModel.isInitialized) {
            Log.e(TAG, " chala kya ? ")
        } else {
            Log.e(TAG, " Abhi nahi yaar ")
        }*/

        newsItemView = view.findViewById(R.id.newsItemView)
        paginationProgressBarView = view.findViewById(R.id.paginationProgressBar)
        btnRetry = view.findViewById(R.id.btnRetry)
        tvErrorMessage = view.findViewById(R.id.tvErrorMessage)

        setupRecyclerView()
        
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_topNewsFragment_to_articleFragment,
                bundle
            )
        }

        /* Code for bookmark using bookmark button with headline  */

        lateinit var savedArticles: List<Article>

        viewModel.getSavedNews().observe(viewLifecycleOwner, Observer { articles ->
            savedArticles=articles
        })

        newsAdapter.setOnBookmarkClickListener {
            //TODO: find out how to write code to prevent duplicate entry

            /*
            * Following may not be a good way. I am checking if article is already saved. if not
            * only then insert otherwise not. I could not figure out how to define schema and use
            * onConflictReplace to prevent duplicates. I will try it when I complete other
            * functionalites of this app. Till then I will use below code.
            *
            * Also one more
            * VERY IMPORTANT NOTE:
            * Handle null case in article because some article violate null constraint and crash
            * the app. so handle case when some of the response is null like no image, author etc.s
            */

            //it refers to Article

            var alreadySaved  = false

            for(savedArticle in savedArticles)
            {
                if(savedArticle.url==it.url) alreadySaved=true
            }
            if (alreadySaved==false)
            {
                viewModel.saveArticle(it)
            }
            Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
            Log.e(TAG, " Click chala gaya ")
        }

        viewModel.topNews.observe(viewLifecycleOwner, Observer {
            when(it) {
                is Resource.Success -> {
                    hideProgressBar()
                    hideErrorMessage()
                    it.data?.let { newsResponse ->
                        /*Convert mutable list to normal list newsResponse.articles.toList()
                        & then submit */
                        Log.e(TAG, newsResponse.articles[0].title)
                        newsAdapter.differ.submitList(newsResponse.articles.toList())
                        totalResults=newsResponse.totalResults
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    it.message?.let { message ->
                        Toast.makeText(activity, "An error occured: $message", Toast.LENGTH_LONG).show()
                        showErrorMessage(message)
                    }

                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })

        //ON BACK PRESS PRESS AGAIN TO EXIT PROMPT
        requireActivity()
            .onBackPressedDispatcher
            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    // Do custom work here
                    if (pressedTime + 2000 > System.currentTimeMillis()) {
                        if (isEnabled) {
                            isEnabled = false
                            requireActivity().onBackPressed()
                        }
                    } else {
                        Toast.makeText(requireContext(), "Press back again to exit", Toast.LENGTH_SHORT).show()
                    }
                    pressedTime = System.currentTimeMillis()
                }
            })

        btnRetry.setOnClickListener {
            viewModel.getTopNews("in",topNewsPageTemp)
        }
    }

    private fun hideProgressBar() {
        paginationProgressBarView.visibility = View.INVISIBLE
        isLoading=false //use for paging
    }

    private fun showProgressBar() {
        paginationProgressBarView.visibility = View.VISIBLE
        isLoading=true //use for paging
    }

    private fun hideErrorMessage() {
        itemErrorMessage.visibility = View.INVISIBLE
        isError = false
    }

    private fun showErrorMessage(message: String) {
        itemErrorMessage.visibility = View.VISIBLE
        tvErrorMessage.text = message
        isError = true
    }

    val newsScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val isNoErrors = !isError

            val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()
            val currentItemCount = layoutManager.itemCount
            val shouldPaginate = isNoErrors && totalResults>currentItemCount &&
                                 firstVisiblePosition>= currentItemCount - 2 &&
                                 isScrolling && !isLoading

            if(shouldPaginate==true)
            {
                viewModel.getTopNews("in",++topNewsPageTemp)
                isScrolling = false
            }
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        newsItemView.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(newsScrollListener) //using scroll listener for paging
        }
    }

}
