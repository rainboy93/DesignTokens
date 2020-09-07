package com.example.designtokens.animation.core.position

import android.view.View

class PositionAnimExpectationOriginal : PositionAnimExpectation() {
  init {
    isForTranslationX = true
    isForTranslationY = true
  }

  override fun getCalculatedValueX(viewToMove: View): Float? {
    return 0f
  }

  override fun getCalculatedValueY(viewToMove: View): Float? {
    return 0f
  }
}
