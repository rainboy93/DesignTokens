package com.example.designtokens.animation.core.position

import android.view.View

class PositionAnimExpectationSameCenterAs(otherView: View, private val horizontal: Boolean, private val vertical: Boolean) : PositionAnimationViewDependant(otherView) {

  init {
    isForPositionX = true
    isForPositionY = true
  }

  override fun getCalculatedValueX(viewToMove: View): Float? {
    return if (horizontal) {
      val x = viewCalculator!!.finalPositionLeftOfView(otherView)
      val myWidth = viewToMove.width / 2f
      val hisWidth = viewCalculator!!.finalWidthOfView(otherView) / 2f

      if (myWidth > hisWidth) {
        x - myWidth + hisWidth
      } else {
        x - hisWidth + myWidth
      }
    } else
      null
  }

  override fun getCalculatedValueY(viewToMove: View): Float? {
    return if (vertical) {
      val y = viewCalculator!!.finalPositionTopOfView(otherView)
      val myHeight = viewToMove.height / 2f
      val hisHeight = viewCalculator!!.finalHeightOfView(otherView) / 2f

      if (myHeight > hisHeight) {
        y + myHeight - hisHeight
      } else {
        y + hisHeight - myHeight
      }
    } else
      null
  }

}
