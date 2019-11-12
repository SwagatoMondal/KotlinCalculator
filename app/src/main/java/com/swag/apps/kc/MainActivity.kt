package com.swag.apps.kc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var input: TextView
    private lateinit var result: TextView
    private var holder: NumberHolder = NumberHolder()

    override fun onClick(v: View?) {
        if (v != null) {
            when(v.id) {
                R.id.zero -> {
                    setInput(input, 0)
                }
                R.id.one -> {
                    setInput(input, 1)
                }
                R.id.two -> {
                    setInput(input, 2)
                }
                R.id.three -> {
                    setInput(input, 3)
                }
                R.id.four -> {
                    setInput(input, 4)
                }
                R.id.five -> {
                    setInput(input, 5)
                }
                R.id.six -> {
                    setInput(input, 6)
                }
                R.id.seven -> {
                    setInput(input, 7)
                }
                R.id.eight -> {
                    setInput(input, 8)
                }
                R.id.nine -> {
                    setInput(input, 9)
                }
                R.id.equals -> {
                    result.text = holder.evaluate(input.text.toString()).toString()
                }
                R.id.clear -> {
                    result.text = ""
                    input.text = ""
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.result)
        input = findViewById(R.id.input)
        val sum = findViewById<View>(R.id.sum)
        val diff = findViewById<View>(R.id.diff)
        val mul = findViewById<View>(R.id.multiply)
        val div = findViewById<View>(R.id.divide)

        findViewById<View>(R.id.zero).setOnClickListener(this)
        findViewById<View>(R.id.one).setOnClickListener(this)
        findViewById<View>(R.id.two).setOnClickListener(this)
        findViewById<View>(R.id.three).setOnClickListener(this)
        findViewById<View>(R.id.four).setOnClickListener(this)
        findViewById<View>(R.id.five).setOnClickListener(this)
        findViewById<View>(R.id.six).setOnClickListener(this)
        findViewById<View>(R.id.seven).setOnClickListener(this)
        findViewById<View>(R.id.eight).setOnClickListener(this)
        findViewById<View>(R.id.nine).setOnClickListener(this)
        findViewById<View>(R.id.equals).setOnClickListener(this)
        findViewById<View>(R.id.clear).setOnClickListener(this)

        sum.setOnClickListener {
            result.text = holder.evaluate(input.text.toString()).toString()
            input.text = StringBuilder(input.text).append('+').toString()
        }
        diff.setOnClickListener {
            result.text = holder.evaluate(input.text.toString()).toString()
            input.text = StringBuilder(input.text).append('-').toString()
        }
        mul.setOnClickListener {
            result.text = holder.evaluate(input.text.toString()).toString()
            input.text = StringBuilder(input.text).append('*').toString()
        }
        div.setOnClickListener {
            result.text = holder.evaluate(input.text.toString()).toString()
            input.text = StringBuilder(input.text).append('/').toString()
        }
    }

    private fun setInput(input: TextView, num: Long) {
        input.text = StringBuilder(input.text).append(num).toString()
    }
}
