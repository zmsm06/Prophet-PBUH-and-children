package com.zeinabmallaki.listviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zeinabmallaki.listviewtest.databinding.CitiesOfIranBinding

class CitiesOfIranActivity : AppCompatActivity() {
    private lateinit var binding: CitiesOfIranBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CitiesOfIranBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "شهرهای ایران"

    }


}