package com.example.bitcoin_converter_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bitcoin_converter_app.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //initializing the view binding method
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //the listener call the convert action on the button
        binding.convertBtn.setOnClickListener {
            convertNairaToBTC()
        }
    }

    private fun convertNairaToBTC() {
        //user input is received here as string
        val editText = binding.edtText.text.toString().toDouble()
        val btcValue = 19353528.98
        //the btc amount is calculated here
        var amountOfBTC = editText / btcValue

        val roundUp = binding.roundSwitch.isChecked
        if (roundUp) {
            amountOfBTC = Math.ceil((amountOfBTC) * editText / btcValue)
        }
        // val formattedValue = NumberFormat.getCurrencyInstance().format(amountOfBTC)
        val formattedValue = NumberFormat.getCurrencyInstance().format(amountOfBTC)
        binding.displayView.text = getString(R.string.btc_amount, formattedValue)


    }
}