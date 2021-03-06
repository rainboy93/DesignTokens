package com.example.designtokens.animation.core.position

import android.view.View
import com.example.designtokens.animation.core.AnimExpectation
import com.example.designtokens.animation.core.Utils

abstract class PositionAnimExpectation : AnimExpectation() {

  var isForPositionY: Boolean = false
    protected set
  var isForPositionX: Boolean = false
    protected set
  var isForTranslationX: Boolean = false
    protected set
  var isForTranslationY: Boolean = false
    protected set

  var margin: Float? = null
  var marginDp: Float? = null

  abstract fun getCalculatedValueX(viewToMove: View): Float?
  abstract fun getCalculatedValueY(viewToMove: View): Float?

  fun getMargin(view: View): Float {
    return when {
      this.margin != null -> this.margin!!
      this.marginDp != null -> Utils.dpToPx(view.context, marginDp!!)
      else -> 0f
    }
  }
}
