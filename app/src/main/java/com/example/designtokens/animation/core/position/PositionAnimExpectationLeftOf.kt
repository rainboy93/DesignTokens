package com.example.designtokens.animation.core.position

import android.view.View

class PositionAnimExpectationLeftOf(otherView: View) : PositionAnimationViewDependant(otherView) {

  init {
    isForPositionX = true
  }

  override fun getCalculatedValueX(viewToMove: View): Float? {
    return viewCalculator!!.finalPositionLeftOfView(otherView) - getMargin(viewToMove) - viewToMove.width.toFloat()
  }

  override fun getCalculatedValueY(viewToMove: View): Float? {
    return null
  }
}
