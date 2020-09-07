package com.example.designtokens.animation.core.anim3d

import android.view.View

import com.example.designtokens.animation.core.AnimExpectation

abstract class CameraDistanceExpectation : AnimExpectation() {
  abstract fun getCalculatedCameraDistance(viewToMove: View): Float?
}
