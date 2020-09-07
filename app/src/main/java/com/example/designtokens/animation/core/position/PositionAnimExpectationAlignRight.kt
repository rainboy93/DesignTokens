package com.example.designtokens.animation.core.position

import android.view.View

class PositionAnimExpectationAlignRight(otherView: View) : PositionAnimationViewDependant(otherView) {

  init {
    isForPositionX = true
  }

  override fun getCalculatedValueX(viewToMove: View): Float? {
    return viewCalculator!!.finalPositionRightOfView(otherView) - getMargin(viewToMove) - viewToMove.width.toFloat()
  }

  override fun getCalculatedValueY(viewToMove: View): Float? {
    return null
  }
}
