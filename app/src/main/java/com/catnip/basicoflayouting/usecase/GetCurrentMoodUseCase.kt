package com.catnip.basicoflayouting.usecase

import android.content.Context
import com.catnip.basicoflayouting.R

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/

interface CurrentMoodInterface : CounterManipulator {
    fun calculateMoodByReaction(context: Context) : String
}

interface CounterManipulator{
    fun decrementCounter()
    fun incrementCounter()
    fun setCounterToNeutral()
}

open class GetCurrentMoodUseCase : CurrentMoodInterface{

    private var counter: Int = 0

    override fun decrementCounter() {
        counter -= 1
    }

    override fun incrementCounter() {
        counter += 1
    }

    override fun setCounterToNeutral() {
        counter = 0
    }

    override fun calculateMoodByReaction(context: Context): String {
        return if (counter < 0) {
            context.getString(R.string.text_mood_is_not_good, counter)
        } else if (counter > 0) {
            context.getString(R.string.text_mood_is_good, counter)
        } else {
            context.getString(R.string.text_mood_is_neutral, counter)
        }
    }
}

class AnotherGetCurrentMoodUseCase() : GetCurrentMoodUseCase() {

    override fun calculateMoodByReaction(context: Context): String {
        return super.calculateMoodByReaction(context)
    }
}