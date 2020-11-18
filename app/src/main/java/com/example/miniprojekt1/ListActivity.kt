package com.example.miniprojekt1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miniprojekt1.databinding.ActivityListBinding
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_element.*

class ListActivity : AppCompatActivity() {

    private lateinit var productViewModel: ProductViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rv1.layoutManager = LinearLayoutManager(baseContext)
        binding.rv1.addItemDecoration(DividerItemDecoration(baseContext, DividerItemDecoration.VERTICAL))
        productViewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(this.application)).get(ProductViewModel::class.java)
        productViewModel.allProduct.observe(this, Observer { product ->
            product?.let {
                (binding.rv1.adapter as MyAdapter).setProduct(it)
            }
        })
        binding.button3.setOnClickListener(){
            productViewModel.deleteAll()
        }
//        binding..setTextColor(4242)
        binding.btAdd.setOnClickListener() {
            productViewModel.insert(Product(et_name.text.toString(), false, et_price.text.toString(), et_amount.text.toString()))
            et_name.text.clear()
            et_amount.text.clear()
            et_price.text.clear()
            true
        }
//        productViewModel.insert(Product("ziemniaki", false, "15.5", "4"))
//        productViewModel.insert(Product("kartofle", false, "16.5", "69"))
//        productViewModel.insert(Product("pyry", false, "16.5", "69"))
        binding.rv1.adapter = MyAdapter(productViewModel)
    }


//    fun click_edit(view: View){
//        productViewModel.update(Product("ziemniasadasdki", false, "1335.5", "44"))
//    }


}