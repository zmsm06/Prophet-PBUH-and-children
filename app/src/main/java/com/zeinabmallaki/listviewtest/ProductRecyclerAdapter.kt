package com.zeinabmallaki.listviewtest

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.zeinabmallaki.listviewtest.databinding.ListItem2Binding

class ProductRecyclerAdapter(
    private val context: Activity,
    private val products: ArrayList<DataProduct>

):RecyclerView.Adapter<ProductRecyclerAdapter.ProductViewHolder>(), Filterable {

    private val productsFull = ArrayList<DataProduct>()
    init {
        productsFull.addAll(products)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder
    {
        val binding = ListItem2Binding.inflate(context.layoutInflater, parent, false)
        return ProductViewHolder(binding)

    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.setDataProduct(products[position])
    }


    inner class ProductViewHolder(
        private val binding: ListItem2Binding

    ): RecyclerView.ViewHolder(binding.root){

        fun setDataProduct(product: DataProduct){

            binding.txtName.text = product.name
            binding.imageView.setImageResource(product.imgAddress)




        binding.root.setOnClickListener {
            val intent = Intent(context, MainActivity2::class.java )
            intent.putExtra("name", product.name)
            intent.putExtra("img", product.imgAddress)
            intent.putExtra("description", product.description)


            context.startActivity(intent)
        }
        }
    }

    override fun getFilter(): Filter =
        object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filterList = ArrayList<DataProduct>()
                if (constraint == null || constraint.isEmpty())
                    filterList.addAll(productsFull)
                else {
                    val filterPattern = constraint.toString().trim()
                    for (item in productsFull) {
                        if (item.name.contains(filterPattern))
                            filterList.add(item)
                    }
                }

                val result = FilterResults()
                result.values = filterList
                return result

            }

            @SuppressLint("NotifyDataSetChanged")
            @Suppress("UNCHECKED_CAST")
            override fun publishResults(constraint: CharSequence?, filter: FilterResults?)
            {
                products.clear()
                products.addAll(filter?.values as ArrayList<DataProduct>)
                notifyDataSetChanged()


            }

        }
}