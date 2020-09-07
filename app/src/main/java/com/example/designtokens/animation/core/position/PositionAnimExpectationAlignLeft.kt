package com.example.designtokens.animation.core.position

import android.view.View

class PositionAnimExpectationAlignLeft(otherView: View) : PositionAnimationViewDependant(otherView) {

  init {
    isForPositionX = true
  }

  override fun getCalculatedValueX(viewToMove: View): Float? {
    return viewCalculator!!.finalPositionLeftOfView(otherView) + getMargin(viewToMove)
  }

  override fun getCalculatedValueY(viewToMove: View): Float? {
    return null
  }
}
