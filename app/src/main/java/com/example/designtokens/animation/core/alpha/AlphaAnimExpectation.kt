package com.example.designtokens.animation.core.alpha

import android.view.View

import com.example.designtokens.animation.core.AnimExpectation

abstract class AlphaAnimExpectation : AnimExpectation() {
  abstract fun getCalculatedAlpha(viewToMove: View): Float?
}
