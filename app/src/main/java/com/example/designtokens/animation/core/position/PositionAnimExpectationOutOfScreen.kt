package com.example.designtokens.animation.core.position

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.view.View
import android.view.WindowManager

class PositionAnimExpectationOutOfScreen(private val gravities: IntArray) : PositionAnimExpectation() {

  private var windowManager: WindowManager? = null

  init {
    isForPositionX = true
    isForPositionY = true
  }

  private operator fun contains(gravity: Int): Boolean {
    return gravities.contains(gravity)
  }

  @SuppressLint("RtlHardcoded")
  override fun getCalculatedValueX(viewToMove: View): Float? {
    return if (contains(Gravity.RIGHT) || contains(Gravity.END)) {
      if (windowManager == null) {
        windowManager = viewToMove.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
      }
      windowManager!!.defaultDisplay.width.toFloat()
    } else if (contains(Gravity.LEFT) || contains(Gravity.START)) {
      -1f * viewToMove.width
    } else
      null
  }

  override fun getCalculatedValueY(viewToMove: View): Float? {
    return when {
      contains(Gravity.BOTTOM) -> {
        if (windowManager == null) {
          windowManager = viewToMove.context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        }
        windowManager!!.defaultDisplay.height.toFloat()
      }
      contains(Gravity.TOP) -> {
        -1f * viewToMove.height
      }
      else -> null
    }
  }
}
