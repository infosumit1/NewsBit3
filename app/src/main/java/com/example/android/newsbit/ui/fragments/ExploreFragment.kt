package com.example.android.newsbit.ui.fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.newsbit.R
import com.example.android.newsbit.adapters.CategoryAdapter
import com.example.android.newsbit.adapters.NewsAdapter
import com.example.android.newsbit.adapters.NewsSourceAdapter
import com.example.android.newsbit.models.Category
import com.example.android.newsbit.models.NewsSource
import com.example.android.newsbit.ui.MainActivity
import com.example.android.newsbit.ui.NewsViewModel
import com.example.android.newsbit.utils.Resource
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Type
import java.util.*


class ExploreFragment : Fragment(R.layout.fragment_explore) {

    lateinit var viewModel: NewsViewModel
    lateinit var categoryAdapter: CategoryAdapter
    lateinit var categoryItemView: RecyclerView
    lateinit var newsSourceAdapter: NewsSourceAdapter
    lateinit var newsSourceItemView: RecyclerView

    //SEARCH KEYWORDSS VARIABLES
    lateinit var searchKeyword: String
    lateinit var searchNewsAdapter: NewsAdapter
    lateinit var searchItemView: RecyclerView
    lateinit var paginationProgressBarView: ProgressBar
    var searchNewsPageTemp = 1

    lateinit var bottom_section: LinearLayout

    lateinit var sharedPreferences: SharedPreferences

    var totalResults = 0 // totalResults will be received in news search later
    var isLoading = false
    var isScrolling = false

    lateinit var navBar: BottomNavigationView

    var categories: MutableList<Category> = mutableListOf()
    var newsSources: MutableList<NewsSource> = mutableListOf()
    val date = Calendar.getInstance()
    var previous = date.add(Calendar.DAY_OF_MONTH, -1); //Goes to previous day
    val year = date.get(Calendar.YEAR)
    val month = date.get(Calendar.MONTH) + 1
    val day = date.get(Calendar.DAY_OF_MONTH)
    var from = "$year-$month-$day"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        categories = mutableListOf(
            Category("Business", R.drawable.briefcase, false),
            Category("Covid", R.drawable.corona, true),
            Category("Entertainment", R.drawable.clapperboard, false),
            Category("Health", R.drawable.hospital, false),
            Category("International", R.drawable.global, true),
            Category("Cryptocurrency", R.drawable.crypto, true),
            Category("Science", R.drawable.science, false),
            Category("Sports", R.drawable.sports, false),
            Category("Technology", R.drawable.satellite, false)
        )



        newsSources = mutableListOf(
            NewsSource("bbc-news", "BBC", R.drawable.bbc),
            NewsSource("engadget", "Engadget", R.drawable.engadget),
            NewsSource("espn", "ESPN", R.drawable.espn),
            NewsSource("polygon", "Polygon", R.drawable.p),
            NewsSource("techcrunch", "Tech Crunch", R.drawable.techcrunch),
            NewsSource("the-times-of-india", "Times Of India", R.drawable.times_of_india),
            NewsSource("the-next-web", "NextWeb", R.drawable.the_next_web),
            NewsSource("the-verge", "Verge", R.drawable.v),
            NewsSource("techradar", "Tech Radar", R.drawable.tr)
        )
    }


    /*https://stackoverflow.com/questions/14678593/the-application-may-be-doing-too-much-work-on-
    its-main-thread*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchKeyword = ""
        categoryItemView = view.findViewById(R.id.categoryItemView)
        newsSourceItemView = view.findViewById(R.id.newsSourceItemView)
        searchItemView = view.findViewById(R.id.searchItemView)
        bottom_section = view.findViewById(R.id.explore_bottom_section)
        ///
        ///
        ///
        val search = view.findViewById<SearchView>(R.id.search_view)

        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(p0: String?): Boolean {
                search.clearFocus()
                if (p0 != null) {
                    if (p0.isNotBlank() || p0.isNotEmpty()) {
                  Toast.makeText(view.context,p0,Toast.LENGTH_SHORT).show()
                        Log.e("KEYWORDD",p0)
                        searchKeyword = p0
                        search.setQuery("",false)
                        viewModel.getSearchedKeywordNews(searchKeyword, "en", from, 1)
                        val bundle = Bundle().apply {
                            putString("keyword", searchKeyword)
                        }
                        findNavController().navigate(
                            R.id.action_exploreFragment_to_searchFragment,
                            bundle
                        )
                    }
                }

                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
//                Log.i("TEXTTTT",p0.toString())
                return false
            }
        })

//        requireActivity()
//            .onBackPressedDispatcher
//            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
//                override fun handleOnBackPressed() {
//                    // Do custom work here
//                    if (!bottom_section.isVisible) {
//                        searchItemView.visibility = View.GONE
//                        bottom_section.visibility = View.VISIBLE
//                        search.setQuery("", true)
//                    } else {
//                        if (isEnabled) {
//                            isEnabled = false
//                            requireActivity().onBackPressed()
//                        }
//                    }
//                    search.clearFocus()
//                }
//            })

//        search.setOnCloseListener(object : SearchView.OnCloseListener {
//            override fun onClose(): Boolean {
//                searchKeyword = ""
//                searchItemView.visibility = View.GONE
//                bottom_section.visibility = View.VISIBLE
//                navBar.visibility = View.VISIBLE
//                return false
//            }
//        })

        paginationProgressBarView = view.findViewById(R.id.progress_bar_search)

//        searchNewsRecyclerView()
//
//        searchNewsAdapter.setOnItemClickListener {
//            val bundle = Bundle().apply {
//                putSerializable("article", it)
//            }
//            findNavController().navigate(
//                R.id.action_topNewsFragment_to_articleFragment,
//                bundle
//            )
//        }

//        viewModel.searchedNews.observe(viewLifecycleOwner, Observer {
//            when (it) {
//                is Resource.Success -> {
//                    hideProgressBar()
//                    it.data?.let { newsResponse ->
//                        /*Convert mutable list to normal list newsResponse.articles.toList()
//                        & then submit */
////                        Log.e(TAG, newsResponse.articles[0].title)
//                        searchNewsAdapter.differ.submitList(newsResponse.articles.toList())
//                        totalResults = newsResponse.totalResults
//                    }
//                }
//                is Resource.Error -> {
//                    hideProgressBar()
//                    it.message?.let { message ->
////                        Log.e(TAG, "An error occured: $message")
//                    }
//                }
//                is Resource.Loading -> {
//                    showProgressBar()
//                }
//            }
//        })

        ///
        ///SEARCH VIEW COMPONENT

        setupCategoryRecyclerView()
        setupNewsSourceRecyclerView()

        categoryAdapter.setOnItemClickListener {

            if (it.isCustomCategory == false) {
                viewModel.getCategoryNews("in", it.categoryName, 1)
            } else {
                if (it.categoryName == "Covid") {
                    viewModel.getCustomCategoryNews("\"Covid\"+India", "en", from, 1)
                } else if (it.categoryName == "Cryptocurrency") {
                    viewModel.getCustomCategoryNews("\"cryptocurrency\"", "en", from, 1)
                } else if (it.categoryName == "International") {
                    viewModel.getCustomCategoryNews("International", "en", from, 1)
                }
            }

            val bundle = Bundle().apply {
                putString("categoryName", it.categoryName)
                putBoolean("isCustomCategory", it.isCustomCategory)
            }
            findNavController().navigate(
                R.id.action_exploreFragment_to_categoryNewsFragment,
                bundle
            )
        }

        newsSourceAdapter.setOnItemClickListener {
            viewModel.getSourceNews(it.newsSourceID, "en", from, 1)
            val bundle = Bundle().apply {
                putString("newsSourceId", it.newsSourceID)

            }
            findNavController().navigate(
                R.id.action_exploreFragment_to_sourceNewsFragment,
                bundle
            )
        }

    }

    private fun setupCategoryRecyclerView() {
        categoryAdapter = CategoryAdapter(categories.toList())
        categoryItemView.apply {
            adapter = categoryAdapter
            layoutManager = GridLayoutManager(activity, 3)
        }
    }

    private fun setupNewsSourceRecyclerView() {
        newsSourceAdapter = NewsSourceAdapter(newsSources.toList())
        newsSourceItemView.apply {
            adapter = newsSourceAdapter
            layoutManager = GridLayoutManager(activity, 3)
        }
    }

//SETTING UP SEARCH RECYCLER VIEW????????????????????????????????????????????????

//    private fun hideProgressBar() {
//        paginationProgressBarView.visibility = View.INVISIBLE
//        isLoading = false //use for paging
//    }
//
//    private fun showProgressBar() {
//        paginationProgressBarView.visibility = View.VISIBLE
//        isLoading = true //use for paging
//    }


//    val newsScrollListener = object : RecyclerView.OnScrollListener() {
//        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//            super.onScrolled(recyclerView, dx, dy)
//
//            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
//
//            val firstVisiblePosition = layoutManager.findFirstVisibleItemPosition()
//            val currentItemCount = layoutManager.itemCount
//            val shouldPaginate = totalResults > currentItemCount &&
//                    firstVisiblePosition >= currentItemCount - 2 &&
//                    isScrolling && !isLoading
//
//            if (shouldPaginate == true) {
//                viewModel.getTopNews("in", ++searchNewsPageTemp)
//                isScrolling = false
//            }
//        }
//
//        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//            super.onScrollStateChanged(recyclerView, newState)
//            if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
//                isScrolling = true
//            }
//        }
//    }

//
//    private fun searchNewsRecyclerView() {
//        searchNewsAdapter = NewsAdapter()
//        searchItemView.apply {
//            adapter = searchNewsAdapter
//            layoutManager = LinearLayoutManager(activity)
//            addOnScrollListener(newsScrollListener) //using scroll listener for paging
//        }
//    }

}