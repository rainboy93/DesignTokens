package com.example.designtokens.animation.core.alpha

import android.view.View

class AlphaAnimExpectationValue(private val alpha: Float) : AlphaAnimExpectation() {
  override fun getCalculatedAlpha(viewToMove: View): Float? {
    return alpha
  }
}
