package com.example.demoapplication


import androidx.lifecycle.*
import com.example.demoapplication.HomeRecyclerViewItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
public class HomeViewModel
@Inject constructor(
    private val savedStateHandle: SavedStateHandle,

    private val repository: Repository
) : ViewModel() {


    private val _homeListItemsLiveData = MutableLiveData<Resource<List<HomeRecyclerViewItem>>>()
    val homeListItemsLiveData: LiveData<Resource<List<HomeRecyclerViewItem>>>
        get() = _homeListItemsLiveData

    init {
        getHomeListItems()
    }

    private fun getHomeListItems() = viewModelScope.launch {
        _homeListItemsLiveData.postValue(Resource.Loading)
        val EduTypesDeferred = async { repository.getEduTypes() }
        val NftSalesDeferred = async { repository.getNftSales() }

        val EduTypes = EduTypesDeferred.await()
        val NftSales = NftSalesDeferred.await()


        val homeItemsList = mutableListOf<HomeRecyclerViewItem>()
        if(EduTypes is Resource.Success<*> ){
          //  homeItemsList.add(HomeRecyclerViewItem.TopPost("", "Recommended EduTypes"))
            homeItemsList.addAll(EduTypes.value as Collection<HomeRecyclerViewItem>)
         //   homeItemsList.add(HomeRecyclerViewItem.TopPost("", "Top NftSales"))
          //  homeItemsList.addAll(NftSales.value as Collection<HomeRecyclerViewItem>)
            _homeListItemsLiveData.postValue(Resource.Success(homeItemsList))
        }else{
            Resource.Failure(false, null, null)
        }
    }
}

