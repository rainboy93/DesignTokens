package com.example.designtokens.animation.core.position

import android.view.View

class PositionAnimExpectationCenterBetweenViewAndParent(otherView: View, private val horizontal: Boolean, private val vertical: Boolean, private val toBeOnRight: Boolean, private val toBeOnBottom: Boolean) : PositionAnimationViewDependant(otherView) {

  init {
    isForPositionY = true
    isForPositionX = true
  }

  override fun getCalculatedValueX(viewToMove: View): Float? {
    if (horizontal) {
      val viewParent = otherView.parent
      if (viewParent is View && horizontal) {
        val parentView = viewParent as View
        val centerOfOtherView = viewCalculator!!.finalCenterXOfView(otherView)
        return if (toBeOnRight) {
          val parentWidth = parentView.width.toFloat()
          (parentWidth + centerOfOtherView) / 2f - viewToMove.width / 2f
        } else {
          centerOfOtherView / 2f - viewToMove.width / 2f
        }
      }
    }
    return null
  }

  override fun getCalculatedValueY(viewToMove: View): Float? {
    if (vertical) {
      val viewParent = viewToMove.parent
      if (viewParent is View && vertical) {
        val parentView = viewParent as View
        val centerOfOtherView = viewCalculator!!.finalCenterYOfView(otherView)
        return if (toBeOnBottom) {
          val parentHeight = parentView.height.toFloat()
          parentHeight + centerOfOtherView / 2f - viewToMove.height / 2f
        } else {
          centerOfOtherView / 2f - viewToMove.height / 2f
        }
      }
    }
    return null
  }
}
