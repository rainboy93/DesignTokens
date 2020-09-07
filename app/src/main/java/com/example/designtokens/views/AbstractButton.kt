package com.example.designtokens.views

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.FrameLayout

abstract class AbstractButton : FrameLayout {

  /**
   * Holding the state of button [ButtonState]
   */
  var state: ButtonState = ButtonState.Idle
    set(value) {
      field = value
      when (value) {
        ButtonState.Idle -> {
          isEnabled = true
          onIdle()
        }
        ButtonState.Loading -> {
          isEnabled = false
          onLoading()
        }
      }
    }

  constructor(context: Context) : super(context)

  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

  constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int
  ) : super(context, attrs, defStyleAttr)

  open fun onIdle() {
  }

  open fun onLoading() {
  }

  @SuppressLint("ClickableViewAccessibility")
  /**
   * Alpha effect on touched down
   */
  override fun onTouchEvent(event: MotionEvent?): Boolean {
    when (event?.action) {
      MotionEvent.ACTION_DOWN -> {
        if (isEnabled) {
          alpha = 0.5f
        }
      }
      MotionEvent.ACTION_CANCEL, MotionEvent.ACTION_UP -> {
        alpha = 1f
      }
    }
    return super.onTouchEvent(event)
  }
}
