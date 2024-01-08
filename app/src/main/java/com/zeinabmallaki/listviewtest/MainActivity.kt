package com.zeinabmallaki.listviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.zeinabmallaki.listviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ProductRecyclerAdapter

    private val data: ArrayList<DataProduct>
        get() = arrayListOf(

            DataProduct(1, "صدای گریه بچه", R.drawable.gerye,getString(R.string.sedayeGerye)),
            DataProduct(2, "پدر و پسر", R.drawable.pedarpesar,getString(R.string.pedarPesar)),
            DataProduct(3, "پروانه های تشنه", R.drawable.parvaneh,getString(R.string.parvaneh)),
            DataProduct(4, "سجده طولانی", R.drawable.sejdeh,getString(R.string.sejdeh)),
            DataProduct(5, "داور کشتی", R.drawable.koshti,getString(R.string.koshti)),
            DataProduct(6, "سه گل پسر", R.drawable.golpesar,getString(R.string.gplpesar)),
            DataProduct(7, "قایم باشک", R.drawable.ghayem,getString(R.string.ghayem)),
            DataProduct(8, "قنوت", R.drawable.ghonut,getString(R.string.ghonut)),
            DataProduct(9, "کلاس اول", R.drawable.madreseh,getString(R.string.kelasaval)),
            DataProduct(10, "صبح بخیر کوچولو", R.drawable.sobh,getString(R.string.sobh)),
            DataProduct(11, "۲۱دانه خرما", R.drawable.khorma,getString(R.string.khorma)),
            DataProduct(12, "مهمان دخترک", R.drawable.mehman,getString(R.string.mehman)),


        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate((layoutInflater))
        setContentView(binding.root)

        title = "پیامبر(ص) و بچه ها"




        adapter = ProductRecyclerAdapter(this, data)
        binding.recyclerView.layoutManager = GridLayoutManager(
            this,
            3,
            RecyclerView.VERTICAL,
            false)
        binding.recyclerView.adapter = adapter

    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.search_menu, menu)
        val item = menu?. findItem(R.id.action_search)
        val searchView = item?.actionView as SearchView

        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })

        return true
    }

}