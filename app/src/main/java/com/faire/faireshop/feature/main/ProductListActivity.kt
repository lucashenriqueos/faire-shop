package com.faire.faireshop.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.faire.faireshop.databinding.ActivityProductListBinding
import com.faire.faireshop.domain.ResultState
import com.faire.faireshop.utils.gone
import com.faire.faireshop.utils.visible
import org.koin.android.ext.android.inject

class ProductListActivity : AppCompatActivity() {
    private val binding by lazy { ActivityProductListBinding.inflate(layoutInflater) }

    private val viewModel: ProductListViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupRecyclerView()
        initObservers()
        viewModel.getProducts()
    }

    private fun initObservers() {
        viewModel.productListLiveData.observe(this) { state ->
            when (state) {
                is ResultState.Error -> {
                    binding.run {
                        tvEmptyList.text = state.message
                        rvProductList.gone()
                        cpiLoading.gone()
                        tvEmptyList.visible()
                    }
                }
                ResultState.Loading -> {
                    binding.run {
                        tvEmptyList.gone()
                        rvProductList.gone()
                        cpiLoading.visible()
                    }
                }
                is ResultState.Success -> {
                    binding.run {
                        rvProductList.adapter = ProductListAdapter(state.data)
                        tvEmptyList.gone()
                        cpiLoading.gone()
                        rvProductList.visible()
                    }
                }
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvProductList.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
    }
}