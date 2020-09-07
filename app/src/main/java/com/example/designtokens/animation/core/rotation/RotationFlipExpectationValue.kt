package com.example.designtokens.animation.core.rotation

import android.view.View

class RotationFlipExpectationValue(private val mRotationX: Float, private val mRotationY: Float) : RotationExpectation() {

  override fun getCalculatedRotation(viewToMove: View): Float? {
    return null
  }

  override fun getCalculatedRotationX(viewToMove: View): Float? {
    return mRotationX
  }

  override fun getCalculatedRotationY(viewToMove: View): Float? {
    return mRotationY
  }

}
