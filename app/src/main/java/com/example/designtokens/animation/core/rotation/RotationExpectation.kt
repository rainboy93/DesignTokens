package com.example.designtokens.animation.core.rotation

import android.view.View

import com.example.designtokens.animation.core.AnimExpectation

abstract class RotationExpectation : AnimExpectation() {
  abstract fun getCalculatedRotation(viewToMove: View): Float?
  abstract fun getCalculatedRotationX(viewToMove: View): Float?
  abstract fun getCalculatedRotationY(viewToMove: View): Float?
}
