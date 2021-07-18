package com.example.android.newsbit.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AbsListView
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
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
import kotlinx.android.synthetic.main.fragment_top_news.*
import java.util.*


class SourceNewsFragment : Fragment(R.layout.fragment_source_news) {

    lateinit var viewModel: NewsViewModel
    lateinit var sourceNewsAdapter: NewsAdapter
    lateinit var sourceNewsItemView: RecyclerView
    lateinit var paginationProgressBarView: ProgressBar
    lateinit var btnRetry: Button
    lateinit var tvErrorMessage: TextView
    var totalResults = 0 // totalResults will be received in news response later
    var isError = false
    var isLoading = false
    var isScrolling = false
    val sourceNewsArgs: SourceNewsFragmentArgs by navArgs()
    var sourceId = "the-hindu"
    val TAG = "SourceNewsFragment"
    var sourceNewsPageTemp = 1

    val date = Calendar.getInstance()
    var previous=date.add(Calendar.DAY_OF_MONTH, -1); //Goes to previous day
    val year = date.get(Calendar.YEAR)
    val month = date.get(Calendar.MONTH)+1
    val day = date.get(Calendar.DAY_OF_MONTH)
    var from = "$year-$month-$day"


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as MainActivity).viewModel
        sourceId = sourceNewsArgs.newsSourceId

        Log.e(TAG,sourceId)

        sourceNewsItemView = view.findViewById(R.id.sourceNewsItemView)
        paginationProgressBarView = view.findViewById(R.id.sourceNewsPaginationProgressBar)
        btnRetry = view.findViewById(R.id.btnRetry)
        tvErrorMessage = view.findViewById(R.id.tvErrorMessage)

        setupRecyclerView()

        sourceNewsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("article", it)
            }
            findNavController().navigate(
                R.id.action_sourceNewsFragment_to_articleFragment,
                bundle
            )
        }

        viewModel.sourceNews.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            when (it) {
                is Resource.Success -> {
                    hideProgressBar()
                    hideErrorMessage()
                    it.data?.let { sourceNewsResponse ->

                        if(!sourceNewsResponse.articles.isNullOrEmpty()){
                            sourceNewsAdapter.differ.submitList(sourceNewsResponse.articles.toList())
                            totalResults = sourceNewsResponse.totalResults

                        }
                        else{
                            findNavController().navigate(R.id.action_sourceNewsFragment_to_noResponseFragment)
                        }
                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    it.message?.let { message ->
                        Log.e(TAG, "An error occured: $message")
                        showErrorMessage(message)
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })
        lateinit var savedArticles: List<Article>

        viewModel.getSavedNews().observe(viewLifecycleOwner, Observer { articles ->
            savedArticles=articles
        })

        sourceNewsAdapter.setOnBookmarkClickListener {
            //TODO: find out how to write code to prevent duplicate entry


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

        btnRetry.setOnClickListener {
            viewModel.getSourceNews(sourceId,"en",from,sourceNewsPageTemp)
        }
    }

    private fun hideProgressBar() {
        paginationProgressBarView.visibility = View.INVISIBLE
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

    val sourceNewsScrollListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val layoutManager = recyclerView.layoutManager as LinearLayoutManager

            val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()

            val currentItemCount = layoutManager.itemCount
            val isCurrentItemCountIsLessThan60 = (currentItemCount < 60)
            val shouldPaginate = totalResults > currentItemCount &&
                    firstVisiblePosition >= currentItemCount - 2 &&
                    isScrolling && !isLoading && isCurrentItemCountIsLessThan60

            if (shouldPaginate == true)  {

                viewModel.getSourceNews(sourceId,"en",from,++sourceNewsPageTemp)

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

    private fun setupRecyclerView() {
        sourceNewsAdapter = NewsAdapter()
        sourceNewsItemView.apply {
            adapter = sourceNewsAdapter
            layoutManager = LinearLayoutManager(activity)
            addOnScrollListener(sourceNewsScrollListener)
        }
    }
}