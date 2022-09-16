package com.catnip.basicoflayouting

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.catnip.basicoflayouting.databinding.ActivityMainBinding
import com.catnip.basicoflayouting.usecase.CurrentMoodInterface
import com.catnip.basicoflayouting.usecase.GetCurrentMoodUseCase

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val useCase: CurrentMoodInterface by lazy {
        GetCurrentMoodUseCase()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initButton()
    }

    private fun initButton() {
        binding.apply {
            flReactionSad.setOnClickListener {
                Log.d(TAG, "initButton: Sad Clicked")
                useCase.decrementCounter()
                setMoodText()
            }
            flReactionNeutral.setOnClickListener {
                Log.d(TAG, "initButton: Neutral Clicked")
                useCase.setCounterToNeutral()
                setMoodText()
            }
            flReactionHappy.setOnClickListener {
                Log.d(TAG, "initButton: Happy Clicked")
                useCase.incrementCounter()
                setMoodText()
            }
        }
    }

    private fun setMoodText() {
        binding.tvYourMood.text = useCase.calculateMoodByReaction(this)
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}