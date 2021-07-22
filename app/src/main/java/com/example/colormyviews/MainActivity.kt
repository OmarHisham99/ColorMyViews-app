package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this ,R.layout.activity_main)
        setListners(binding)

    }
}
    private fun setListners(binding:ActivityMainBinding)
    {
        val clickableView: List<View> = listOf(binding.boxOneText,binding.boxTwoText,binding.boxThreeText,
                                    binding.boxFourText,binding.boxFiveText,binding.constraintLayout,binding.redBtn,binding.greenBtn,binding.yellowBtn)

            for(item in clickableView)
            {
                item.setOnClickListener{makeColored(it,binding)}
            }
    }
    private fun makeColored(view: View,binding:ActivityMainBinding)
    {
        when(view.id)
        {
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)

            R.id.red_btn -> binding.boxThreeText.setBackgroundResource(R.color.my_red)
            R.id.yellow_btn -> binding.boxFourText.setBackgroundResource(R.color.my_yellow)
            R.id.green_btn -> binding.boxFiveText.setBackgroundResource(R.color.my_green)
            // Boxes using Android color resources for background
            R.id.box_three_text -> view.setBackgroundResource(android.R.color.holo_green_light)
            R.id.box_four_text -> view.setBackgroundResource(android.R.color.holo_green_dark)
            R.id.box_five_text -> view.setBackgroundResource(android.R.color.holo_green_light)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }