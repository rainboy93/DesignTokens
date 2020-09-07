package com.example.designtokens.animation.core.rotation

import android.view.View

class RotationExpectationOriginal : RotationExpectation() {

  override fun getCalculatedRotation(viewToMove: View): Float? {
    return 0f
  }

  override fun getCalculatedRotationX(viewToMove: View): Float? {
    return 0f
  }

  override fun getCalculatedRotationY(viewToMove: View): Float? {
    return 0f
  }
}
