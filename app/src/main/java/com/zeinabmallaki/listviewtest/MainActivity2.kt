package com.zeinabmallaki.listviewtest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zeinabmallaki.listviewtest.databinding.ActivityMain2Binding

class MainActivity2:AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate((layoutInflater))
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        val name = intent.getStringExtra("name")
        val img  = intent.getIntExtra("img",0)
        val description = intent.getStringExtra("description")
        title = name



        binding.imgItemProduct.setImageResource(img)
        binding.txtNameItemProduct.text = name
        binding.descriptionTextView.text = description



    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}