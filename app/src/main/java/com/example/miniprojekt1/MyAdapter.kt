package com.example.miniprojekt1

import android.graphics.Color
import android.graphics.Color.RED
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.miniprojekt1.databinding.ListElementBinding
import com.example.miniprojekt1.MainActivity

class MyAdapter (val productViewModel: ProductViewModel) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var product = emptyList<Product>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ListElementBinding.inflate(inflater)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        val currentProduct = product[position]
//        sharedPreference.getString("username","defaultName")
//        sharedPreference.getLong("l",1L)


        holder.binding.rvTv1.text = currentProduct.name
        holder.binding.rvTv1.setTextColor(Color.RED)
        holder.binding.rvTv2.text = currentProduct.price.toString()
        holder.binding.rvTv3.text = currentProduct.amount.toString()
        holder.binding.rvCb1.isChecked = currentProduct.checked
        holder.binding.rvTv1.setOnClickListener{
            productViewModel.delete(currentProduct)
        }
//        holder.binding.edit.setOnClickListener{
//            productViewModel.update(currentProduct, )
//        }
    }

    override fun getItemCount(): Int = product.size

    inner class ViewHolder(val binding: ListElementBinding) : RecyclerView.ViewHolder(binding.root)

    fun setProduct(product: List<Product>){
        this.product = product
        notifyDataSetChanged()
    }
}