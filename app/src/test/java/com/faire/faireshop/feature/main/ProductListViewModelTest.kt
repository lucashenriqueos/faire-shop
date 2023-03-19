package com.faire.faireshop.feature.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.faire.faireshop.RxImmediateSchedulerRule
import com.faire.faireshop.domain.ResultState
import com.faire.faireshop.domain.response.PriceResponse
import com.faire.faireshop.domain.response.ProductResponse
import com.faire.faireshop.domain.usecase.ListProductsUseCase
import io.mockk.every
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ProductListViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var testSchedulerRule = RxImmediateSchedulerRule()

    private lateinit var viewModel: ProductListViewModel

    private var listProductsUseCase: ListProductsUseCase = mockk()

    @Before
    fun before() {
        viewModel = ProductListViewModel(listProductsUseCase)
    }

    @Test
    fun `WHEN getProducts THEN api's response should be propagated by productListLiveData`() {

        val response = listOf(
            ProductResponse(
                productImage = "https://cdn.faire.com/fastly/3219c19bb0c311c209dd924521a85ceca8d9abad446ed682494da882210c569f.png",
                productName = "Explore Journal",
                detailsText = "Keep track of memories",
                wholesalePrice = PriceResponse(
                    price = 11.4
                )
            )
        )

        every { listProductsUseCase.execute() } returns Single.just(response)

        viewModel.getProducts()

        val result = viewModel.productListLiveData.value as ResultState<List<ProductResponse>>
        Assert.assertTrue(result is ResultState.Success)
        Assert.assertSame((result as ResultState.Success).data, response)
    }
}