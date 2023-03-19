package com.faire.faireshop.feature.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.faire.faireshop.domain.ResultState
import com.faire.faireshop.domain.response.ProductResponse
import com.faire.faireshop.domain.usecase.ListProductsUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable

class ProductListViewModel(
    private val listProductsUseCase: ListProductsUseCase
) : ViewModel() {
    private val disposables = CompositeDisposable()

    private val _productListLiveData = MutableLiveData<ResultState<List<ProductResponse>>>()
    val productListLiveData: LiveData<ResultState<List<ProductResponse>>>
        get() = _productListLiveData

    fun getProducts() {
        listProductsUseCase.execute()
            .doOnSubscribe {
                _productListLiveData.postValue(ResultState.Loading)
            }
            .subscribe({
                _productListLiveData.postValue(ResultState.Success(it))
            }, {
                _productListLiveData.postValue(ResultState.Error("Oops, something went wrong", it))
            }).also { disposables.add(it) }
    }
}