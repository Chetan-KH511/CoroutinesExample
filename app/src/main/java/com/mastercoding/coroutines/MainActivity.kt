package com.mastercoding.coroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.mastercoding.coroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private var counter :Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.countBtn.setOnClickListener{
            //by default uses main thread

            binding.counterText.text = counter++.toString()



        }

        binding.downloadBtn.setOnClickListener{

           //Using Coroutines

            CoroutineScope(Dispatchers.IO).launch {
                downloadBigfileFromNet()
            }

            //Using globalscope
//
//            GlobalScope.launch{
//                downloadBigfileFromNet()
//            }
        }
    }

    private fun downloadBigfileFromNet() {
        for(i in 1..100000){
            //Log.i("TAGY", "Downloading $i in ${Thread.currentThread().name}")

        }
    }
}