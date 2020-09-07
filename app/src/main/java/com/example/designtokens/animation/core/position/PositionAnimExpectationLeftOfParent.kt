package com.example.designtokens.animation.core.position

import android.view.View

class PositionAnimExpectationLeftOfParent : PositionAnimExpectation() {
  init {
    isForPositionX = true
  }

  override fun getCalculatedValueX(viewToMove: View): Float? {
    return getMargin(viewToMove)
  }

  override fun getCalculatedValueY(viewToMove: View): Float? {
    return null
  }
}
