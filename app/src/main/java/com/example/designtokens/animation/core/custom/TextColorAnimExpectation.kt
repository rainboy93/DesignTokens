package com.example.designtokens.animation.core.custom

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.view.View
import android.widget.TextView

class TextColorAnimExpectation(private val textColor: Int) : CustomAnimExpectation() {

  override fun getAnimator(viewToMove: View): Animator? {
    return if (viewToMove is TextView) {
      ValueAnimator.ofInt(viewToMove.currentTextColor, textColor).apply {
        addUpdateListener { valueAnimator ->
          viewToMove.setTextColor(valueAnimator.animatedValue as Int)
        }
        setEvaluator(ArgbEvaluator())
      }
    } else {
      null
    }
  }
}
