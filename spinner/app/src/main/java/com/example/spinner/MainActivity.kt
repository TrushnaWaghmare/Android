package com.example.spinner

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val textview = findViewById<TextView>(R.id.textView)
        val editext = findViewById<EditText>(R.id.editTextNumber3)
        val button1 = findViewById<Button>(R.id.button)

        val adapter = ArrayAdapter.createFromResource(
            this, R.array.conversion,
     +
     android.R.layout.simple_spinner_item
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = adapter
        button1.setOnClickListener {
            val input = editext.text.toString()
            val forselectedopt = spinner.selectedItem.toString()
            when (forselectedopt) {
                "Decimal" -> {
                    val decimal = input.toInt()
                    textview.text = "Binary:${decimalToBinary(decimal)}\n" +
                            "Octal:${decimalToOctal(decimal)}\n" +
                            "Hexadecimal:${decimalToHexadecimal(decimal)}"
                }

                "Binary" -> {
                    val binary = input
                    textview.text = "Decimal:${binaryToDecimal(binary.toString())}\n" +
                            "Octal:${binaryToOctal(binary.toString())}\n" +
                            "Hexadecimal:${binaryToHexadecimal(binary.toString())}"
                }
                "Octal" -> {
                    val octal = input
                    textview.text = "Binary:${octalTobinary(octal.toString())}\n" +
                            "Decimal:${octalToDecimal(octal.toString())}\n" +
                            "Hexadecimal:${octalToHexadecimal(octal.toString())}"
                }
                "Hexadecimal" -> {
                    val octal = input
                    textview.text = "Binary:${hexaTobinary(octal)}\n" +
                            "Octal:${hexaToOctal(octal)}"+
                            "Decimal:${hexaToDecimal(octal)}"

                }
            }
        }
    }

    //Decimal to Others

        fun decimalToBinary(num: Int):String
        {
            return Integer.toBinaryString(num)
        }
        fun decimalToOctal(num: Int):String
        {
            return Integer.toOctalString(num)
        }
        fun decimalToHexadecimal(num: Int):String
        {
            return Integer.toHexString(num).toUpperCase(Locale.ROOT)
        }






    

    //binary to others

        fun binaryToDecimal(num: String):Int
        {
            return Integer.parseInt(num,2)
        }
        fun binaryToOctal(num:String):String
        {
            val decimal=Integer.parseInt(num,2)
            return  Integer.toOctalString(decimal)
        }
        fun binaryToHexadecimal (binary:String): String
        {
            val decimal = binaryToDecimal(binary)
            return decimalToHexadecimal(decimal).toUpperCase(Locale.ROOT)
        }
    //octal to others
        fun octalToDecimal(octal: String):Int
        {
            return Integer.parseInt(octal,8)
        }
        fun octalTobinary(octal:String):String
        {
            val todecimal1 = octalToDecimal(octal)
            return decimalToBinary(todecimal1)
        }
        fun octalToHexadecimal(octal:String):String
        {
            val todecimal = octalToDecimal(octal)
            return decimalToHexadecimal(todecimal).toUpperCase(Locale.ROOT)
         }

    //hexa to others

        fun hexaToDecimal(hexadecimal:String):Int
        {
            return Integer.parseInt(hexadecimal,16)
        }

        fun hexaTobinary(octal:String):String
        {
            val todecimal1 = hexaToDecimal(octal)
            return decimalToBinary(todecimal1)
        }
        fun hexaToOctal(octal:String):String
        {
            val todecimal = hexaToDecimal(octal)
            return decimalToHexadecimal(todecimal)
        }

    }
