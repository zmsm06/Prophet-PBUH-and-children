package com.zeinabmallaki.listviewtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import com.zeinabmallaki.listviewtest.databinding.ActivitySplBinding

class SplActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgSoghat.startAnimation(anim(R.anim.scal))
        binding.txtSoghat.startAnimation(anim(R.anim.scal))

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000

        )


    }

    private fun anim(animation: Int)= AnimationUtils.loadAnimation(this, animation)
}