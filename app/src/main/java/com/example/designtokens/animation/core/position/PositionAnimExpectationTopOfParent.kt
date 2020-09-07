package com.example.designtokens.animation.core.position

import android.view.View

class PositionAnimExpectationTopOfParent : PositionAnimExpectation() {

  init {
    isForPositionY = true
  }

  override fun getCalculatedValueX(viewToMove: View): Float? {
    return null
  }

  override fun getCalculatedValueY(viewToMove: View): Float? {
    return getMargin(viewToMove)
  }
}
