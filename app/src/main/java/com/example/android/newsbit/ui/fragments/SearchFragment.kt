package com.example.android.newsbit.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.newsbit.R
import com.example.android.newsbit.adapters.NewsAdapter
import com.example.android.newsbit.models.Article
import com.example.android.newsbit.ui.MainActivity
import com.example.android.newsbit.ui.NewsViewModel
import com.example.android.newsbit.utils.Resource
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_search.*
import kotlinx.android.synthetic.main.fragment_search.itemErrorMessage
import kotlinx.android.synthetic.main.fragment_top_news.*
import java.util.*

class SearchFragment : Fragment() {

    lateinit var viewModel: NewsViewModel
    lateinit var btnRetry: Button
    lateinit var tvErrorMessage: TextView
    var isError = false
    var searchKeyword: String = ""
    lateinit var searchNewsAdapter: NewsAdapter
    lateinit var searchItemView: RecyclerView
    lateinit var paginationProgressBarView: ProgressBar
    var searchNewsPageTemp = 1

    var totalResults = 0 // totalResults will be received in news search later
    var isLoading = false
    var isScrolling = false

    val date = Calendar.getInstance()
    var previous = date.add(Calendar.DAY_OF_MONTH, -1); //Goes to previous day
    val year = date.get(Calendar.YEAR)
    val month = date.get(Calendar.MONTH) + 1
    val day = date.get(Calendar.DAY_OF_MONTH)
    var from = "$year-$month-$day"
    lateinit var search : SearchView
    val searchedArgs: SearchFragmentArgs by navArgs()

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Nullable
    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        searchItemView = view.findViewById(R.id.searchItemView2)
        btnRetry = view.findViewById(R.id.btnRetry)
        tvErrorMessage = view.findViewById(R.id.tvErrorMessage)

        search = view.findViewById<SearchView>(R.id.search_view2)
        val keyword: String = searchedArgs.keyword
        searchKeyword = keyword
        search.setQuery(searchKeyword,false)
        Log.e("SEARCHED KEYWORD", searchKeyword)

        searchItemView.visibility = View.VISIBLE
        noresultBg.visibility = View.GONE
        searchNewsRecyclerView()

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(p0: String?): Boolean {
                search.clearFocus()
                if (p0 != null) {
                    if (p0.isNotBlank() || p0.isNotEmpty()) {
                        Toast.makeText(view.context, "AA GAYAA", Toast.LENGTH_SHORT).show()
                        searchKeyword = p0
                        searchNewsByKeyword(searchKeyword)
                    }
                }
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return false
            }
        })


//        requireActivity()
//            .onBackPressedDispatcher
//            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
//                override fun handleOnBackPressed() {
//                    if (isEnabled) {
//                        isEnabled = false
//                        requireActivity().onBackPressed()
//                        view.findViewById<SearchView>(R.id.search_view).setQuery("",false)
//                        search.clearFocus()
//                    }
//
//                }                })

//        search.setOnCloseListener(object : SearchView.OnCloseListener {
//            override fun onClose(): Boolean {
//                searchKeyword = ""
//                searchItemView.visibility = View.GONE
//                bottom_section.visibility = View.VISIBLE
//                navBar.visibility = View.VISIBLE
//                return false
//            }
//        })

        lateinit var savedArticles: List<Article>

        viewModel.getSavedNews().observe(viewLifecycleOwner, Observer { articles ->
            savedArticles=articles
        })

        searchNewsAdapter.setOnBookmarkClickListener {
            //TODO: find out how to write code to prevent duplicate entry

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
//            Log.e(TAG, " Click chala gaya ")
        }

        paginationProgressBarView = view.findViewById(R.id.progress_bar_search2)

        searchNewsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_searchFragment_to_articleFragment,
                bundle
            )
        }

        viewModel.searchedNews.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    hideProgressBar()
                    hideErrorMessage()
                    it.data?.let { newsResponse ->
                        /*Convert mutable list to normal list newsResponse.articles.toList()
                        & then submit */
//                        Log.e(TAG, newsResponse.articles[0].title)
                        Log.e("SEARCHED DATA", newsResponse.articles.toString())
                        if(!newsResponse.articles.isNullOrEmpty()){
                            searchNewsAdapter.differ.submitList(newsResponse.articles.toList())
                            totalResults = newsResponse.totalResults
                            searchItemView.visibility = View.VISIBLE
                            noresultBg.visibility = View.GONE
                        }
                        else{
                            searchItemView.visibility = View.GONE
                            noresultBg.visibility = View.VISIBLE
                        }
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    it.message?.let { message ->
                        showErrorMessage(message)
//                        Log.e(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })

        btnRetry.setOnClickListener {
            viewModel.getSearchedKeywordNews(searchKeyword, "en", from, searchNewsPageTemp)
        }
    }

    private fun searchNewsByKeyword(searchKeyword: String) {
        viewModel.getSearchedKeywordNews(searchKeyword, "en", from, 1)
    }

    private fun hideProgressBar() {
        paginationProgressBarView.visibility = View.GONE
        isLoading = false //use for paging
    }

    private fun showProgressBar() {
        paginationProgressBarView.visibility = View.VISIBLE
        isLoading = true //use for paging
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

            val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()
            val currentItemCount = layoutManager.itemCount
            val shouldPaginate = totalResults > currentItemCount &&
                    firstVisiblePosition >= currentItemCount - 2 &&
                    isScrolling && !isLoading

            if (shouldPaginate == true) {
                viewModel.getSearchedKeywordNews(searchKeyword, "en", from, ++searchNewsPageTemp)
                isScrolling = false
            }
        }

        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                isScrolling = true
            }
        }
    }

    private fun searchNewsRecyclerView() {
        searchNewsAdapter = NewsAdapter()
        searchItemView.apply {
            adapter = searchNewsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(newsScrollListener) //using scroll listener for paging
        }
    }
}