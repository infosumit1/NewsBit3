package com.example.android.newsbit.ui

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.TYPE_ETHERNET
import android.net.ConnectivityManager.TYPE_WIFI
import android.net.NetworkCapabilities.*
import android.os.Build
import android.provider.ContactsContract.CommonDataKinds.Phone.TYPE_MOBILE
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.newsbit.NewsApplication
import com.example.android.newsbit.models.Article
import com.example.android.newsbit.models.NewsResponse
import com.example.android.newsbit.repository.NewsRepository
import com.example.android.newsbit.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException

class NewsViewModel(
    app: Application,
    val newsRepository: NewsRepository
) : AndroidViewModel(app) {

    val topNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var topNewsResponse: NewsResponse? = null

    val categoryNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var categoryNewsResponse: NewsResponse? = null

    val sourceNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var sourceNewsResponse: NewsResponse? = null


    //KEYWORD NEWSSS IS HEREEE
    val searchedNews: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var searchedNewsResponse: NewsResponse? = null
    var newSearchQuery:String? = null
    var oldSearchQuery:String? = null

    val TAG = "lalalalalla ViewModel"

    init {
        getTopNews("in", 1)
    }
    /*
    The code inside the init block is the first to be executed when the class is instantiated.
    in the init block above we are calling getTopNews function i.e. we are making network call
    for retrieving topNews from here & not from fragment.
    */

    fun getTopNews(countryCode: String, topNewsPageTemp: Int) = viewModelScope.launch {
        safeTopNewsCall(countryCode , topNewsPageTemp)
    }

    fun getCategoryNews(
        countryCode: String,
        category: String,
        categoryNewsPageTemp: Int

        ) = viewModelScope.launch {

        safeCategoryNewsCall(countryCode,
            category,
            categoryNewsPageTemp)
    }


    fun getCustomCategoryNews(
        q: String,
        language: String,
        from: String,
        customCategoryNewsPageTemp: Int
    ) = viewModelScope.launch {
        safeCustomCategoryNewsCall(q,
            language,
            from,
            customCategoryNewsPageTemp)
    }


    fun getSourceNews(
        sources: String,
        language: String,
        from: String,
        sourceNewsPageTemp: Int
    ) = viewModelScope.launch {
        safeSourceNewsCall(sources,
            language,
            from,
            sourceNewsPageTemp)
    }


    //GETTTTTING NEWS  BASED ONNN KEYWORDSSSSSSSSSSSSSSSSSSS


    fun getSearchedKeywordNews(
        q: String,
        language: String,
        from: String,
        searchedNewsPageTemp: Int
    ) = viewModelScope.launch {
       safeSearchNewsCall( q ,
           language ,
           from ,
           searchedNewsPageTemp )
    }


    /* learn more about Response and resource
    response takes type Response but we have wrapper around NewsResponse
    Why so?
     */


    private fun handleTopNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->

                if (topNewsResponse == null) {
                    //if first response then save it in topNewsResponse
                    topNewsResponse = resultResponse
                } else {
                    /*val oldArticles = topNewsResponse?.articles*/
                    val newArticles = resultResponse.articles
                    topNewsResponse?.articles?.addAll(newArticles) //add articles on next page to oldList
                }

                /* Explanation: How next line works
                *    return Resource.Success(topNewsResponse?:resultResponse)
                *
                * if topNewsResponse is null then we return resultResponse else
                * we return topNewsResponse.
                *
                * Normally I could return topNewsResponse directly i.e.
                *   return Resource.Success(topNewsResponse)
                *
                * because if topNewsResponse is null then
                * I am performing
                *  if(topNewsResponse == null) {
                *    //if first response then save it in topNewsResponse
                *    topNewsResponse = resultResponse
                *    }
                * in the code above this comment.
                * But Kotlin says
                * Smart cast to 'Type' is impossible, because 'variable' is a mutable property
                * that could have been changed by this time
                * because it says that some or the other reason between if code above
                * and returning topNewsResponse below,  topNewsResponse could have changed and become
                * null.
                * To read More can refer to this stack overflow question
                * https://stackoverflow.com/questions/44595529/
                */

                return Resource.Success(topNewsResponse ?: resultResponse)
            }
        }
        return Resource.Error(response.message())
    }

    private fun handleCategoryNewsResponse(
        categoryResponse: Response<NewsResponse>,
        categoryNewsPageTemp: Int
    ): Resource<NewsResponse> {
        if (categoryResponse.isSuccessful) {
            categoryResponse.body()?.let { resultResponse ->
                /*Log.e(TAG, resultResponse.articles.size.toString())*/
                /*categoryNewsPage++*/

                if (categoryNewsPageTemp == 1) {
                    categoryNewsResponse = resultResponse
                } else {
                    val newArticles = resultResponse.articles
                    categoryNewsResponse?.articles?.addAll(newArticles)
                }
                return Resource.Success(categoryNewsResponse ?: resultResponse)

            }
        }
        return Resource.Error(categoryResponse.message())
    }


    //HANDLE SEARCHED NEWS HEREEEEEEEEEEEEEEEEEEE!!!!!!!!!!!!!!!!!!!


    private fun handleSearchedNewsResponse(
        searchedResponse: Response<NewsResponse>,
        searchedNewsPageTemp: Int
    ): Resource<NewsResponse> {
        if (searchedResponse.isSuccessful) {
            searchedResponse.body()?.let { resultResponse ->
                /*Log.e(TAG, resultResponse.articles.size.toString())*/
                /*categoryNewsPage++*/

                if (searchedNewsPageTemp == 1) {
                    searchedNewsResponse = resultResponse
                } else {
                    val newArticles = resultResponse.articles
                    searchedNewsResponse?.articles?.addAll(newArticles)
                }
                return Resource.Success(searchedNewsResponse ?: resultResponse)

            }
        }
        return Resource.Error(searchedResponse.message())
    }


    private fun handleSourceNewsResponse(
        sourceResponse: Response<NewsResponse>,
        sourceNewsPageTemp: Int
    ): Resource<NewsResponse> {
        if (sourceResponse.isSuccessful) {
            sourceResponse.body()?.let { resultResponse ->
                /*Log.e(TAG, resultResponse.articles.size.toString())*/
                /*categoryNewsPage++*/

                if (sourceNewsPageTemp == 1) {
                    sourceNewsResponse = resultResponse
                } else {
                    val newArticles = resultResponse.articles
                    sourceNewsResponse?.articles?.addAll(newArticles)
                }
                return Resource.Success(sourceNewsResponse ?: resultResponse)

            }
        }
        return Resource.Error(sourceResponse.message())
    }


    fun saveArticle(article: Article) = viewModelScope.launch {
        newsRepository.upsert(article)
    }

    fun getSavedNews() = newsRepository.getSavedNews()

    fun deleteArticle(article: Article) = viewModelScope.launch {
        newsRepository.deleteArticle(article)
    }

    private suspend fun safeTopNewsCall(countryCode: String, topNewsPageTemp: Int) {
        topNews.postValue(Resource.Loading())
        try {
            if (hasInternetConnection()) {
                val response = newsRepository.getTopNews(
                    countryCode,
                    "",
                    topNewsPageTemp
                ) // in this line we receive network response
                topNews.postValue(handleTopNewsResponse(response))
            // in the above line now we handle that response in handleTopNewsResponse function
            } else {
                topNews.postValue(Resource.Error("No internet connection"))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> topNews.postValue(Resource.Error("Network Failure"))
                else -> topNews.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    private suspend fun safeCategoryNewsCall(countryCode: String,
                                             category: String,
                                             categoryNewsPageTemp: Int) {
        categoryNews.postValue(Resource.Loading())
        try {
            if (hasInternetConnection()) {
                val response = newsRepository.getTopNews(
                    countryCode,
                    category,
                    categoryNewsPageTemp
                ) // in this line we receive network response
                categoryNews.postValue(
                    handleCategoryNewsResponse(
                        response,
                        categoryNewsPageTemp
                    )
                )

                // in the above line now we handle that response in handleTopNewsResponse function
            } else {
                categoryNews.postValue(Resource.Error("No internet connection"))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> categoryNews.postValue(Resource.Error("Network Failure"))
                else -> categoryNews.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    private suspend fun safeCustomCategoryNewsCall(q: String,
                                                   language: String,
                                                   from: String,
                                                   customCategoryNewsPageTemp: Int) {
        categoryNews.postValue(Resource.Loading())
        try {
            if (hasInternetConnection()) {

                val response = newsRepository.getCustomCategoryNews(
                    q,
                    language,
                    from,
                    customCategoryNewsPageTemp
                ) // in this line we receive network response
                categoryNews.postValue(
                    handleCategoryNewsResponse(
                        response,
                        customCategoryNewsPageTemp
                    )
                ) // now we handle that response in handleTopNewsResponse functionv
            } else {
                categoryNews.postValue(Resource.Error("No internet connection"))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> categoryNews.postValue(Resource.Error("Network Failure"))
                else -> categoryNews.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    private suspend fun safeSourceNewsCall(sources: String,
                                           language: String,
                                           from: String,
                                           sourceNewsPageTemp: Int) {
        sourceNews.postValue(Resource.Loading())
        try {
            if (hasInternetConnection()) {
                sourceNews.postValue(Resource.Loading())
                val response = newsRepository.getSourceNews(
                    sources,
                    language,
                    from,
                    sourceNewsPageTemp
                ) // in this line we receive network response
                sourceNews.postValue(
                    handleSourceNewsResponse(
                        response,
                        sourceNewsPageTemp
                    )
                ) // now we handle that response in handleTopNewsResponse function
            } else {
                sourceNews.postValue(Resource.Error("No internet connection"))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> sourceNews.postValue(Resource.Error("Network Failure"))
                else -> sourceNews.postValue(Resource.Error("Conversion Error"))
            }
        }
    }

    private suspend fun safeSearchNewsCall(
        q: String,
        language: String,
        from: String,
        searchedNewsPageTemp: Int
    ) {

        searchedNews.postValue(Resource.Loading())
        try {
            if (hasInternetConnection()) {
                val response = newsRepository.getSearchedNews(
                    q,
                    language,
                    from,
                    searchedNewsPageTemp
                ) // in this line we receive network response
                searchedNews.postValue(
                    handleSearchedNewsResponse(
                        response,
                        searchedNewsPageTemp
                    )
                )
            } else {
                searchedNews.postValue(Resource.Error("No internet connection"))
            }
        } catch (t: Throwable) {
            when (t) {
                is IOException -> searchedNews.postValue(Resource.Error("Network Failure"))
                else -> searchedNews.postValue(Resource.Error("Conversion Error"))
            }
        }
    }


    private fun hasInternetConnection(): Boolean {
        val connectivityManager = getApplication<NewsApplication>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                capabilities.hasTransport(TRANSPORT_WIFI) -> true
                capabilities.hasTransport(TRANSPORT_CELLULAR) -> true
                capabilities.hasTransport(TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.activeNetworkInfo?.run {
                return when (type) {
                    TYPE_WIFI -> true
                    TYPE_MOBILE -> true
                    TYPE_ETHERNET -> true
                    else -> false
                }
            }
        }
        return false
    }


}
