package com.estudos.imccalculation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.estudos.imccalculation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonClick.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_click){
            calculate()
        }
    }

    private fun isValid(): Boolean{
        return(binding.editHeight.text.toString() != ""
                && binding.editWeight.text.toString() != ""
                && binding.editWeight.text.toString().toFloat() != 0f
                && binding.editHeight.text.toString().toFloat() != 0f)
    }

    private fun calculate(){

        if (isValid()){
            val height = binding.editHeight.text.toString().toFloat()
            val weight = binding.editWeight.text.toString().toFloat()

            val totalValue = weight / (height * height)
            val totalValueStr = "Seu IMC é ${"%.2f".format(totalValue)}"

            binding.textImcView.text = totalValueStr
        } else{
            Toast.makeText(this,R.string.validation, Toast.LENGTH_LONG).show()
        }
    }
}