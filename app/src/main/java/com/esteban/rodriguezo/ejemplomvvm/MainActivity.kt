package com.esteban.rodriguezo.ejemplomvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.esteban.rodriguezo.ejemplomvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        //Opcion 1.

        mainViewModel.totalDone.observe(this, { result ->
            mainBinding.totalTextView.text = result.toString()
        })

        mainViewModel.msgDone.observe(this,{ result ->
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        })

        //Opcion 2.
       /* val totalObserver = Observer<Int> { result->
            mainBinding.totalTextView.text = result.toString()
        }

        mainViewModel.totalDone.observe(this, totalObserver)*/

        with(mainBinding){
            calculateButton.setOnClickListener{
                mainViewModel.realizarSuma(
                    numberOneEditText.text.toString(),
                    numberTwoEditText.text.toString()

                )
            }
        }
    }
}