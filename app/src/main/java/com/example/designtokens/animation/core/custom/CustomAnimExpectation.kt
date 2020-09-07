package com.example.designtokens.animation.core.custom

import android.animation.Animator
import android.view.View

import com.example.designtokens.animation.core.AnimExpectation

abstract class CustomAnimExpectation : AnimExpectation() {
  abstract fun getAnimator(viewToMove: View): Animator?
}
