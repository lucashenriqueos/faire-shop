package com.faire.faireshop.feature.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.faire.faireshop.databinding.ItemProductBinding
import com.faire.faireshop.domain.response.ProductResponse
import com.faire.faireshop.utils.loadImage

class ProductListAdapter(private val list: List<ProductResponse>) :
    Adapter<ProductListAdapter.ProductListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val binding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ProductListViewHolder(private val binding: ItemProductBinding) :
        ViewHolder(binding.root) {

        fun bind(product: ProductResponse) {
            binding.tvProductName.text = product.productName
            binding.tvProductDetail.text = product.detailsText
            binding.tvProductPrice.text = "$ ${product.wholesalePrice.price}"
            binding.ivProductImage.loadImage(product.productImage)
        }

    }
}
