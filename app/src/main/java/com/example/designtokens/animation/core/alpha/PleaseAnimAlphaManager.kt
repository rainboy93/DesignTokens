package com.example.designtokens.animation.core.alpha

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.view.View

import com.example.designtokens.animation.ViewCalculator
import com.example.designtokens.animation.core.AnimExpectation
import com.example.designtokens.animation.core.PleaseAnimManager

class PleaseAnimAlphaManager(
    animExpectations: List<AnimExpectation>,
    viewToMove: View, viewCalculator: ViewCalculator) : PleaseAnimManager(animExpectations, viewToMove, viewCalculator) {

  private var alpha: Float? = null

  override fun calculate() {
    animExpectations.forEach { expectation ->
      if (expectation is AlphaAnimExpectation) {
        expectation.getCalculatedAlpha(viewToMove)?.let {
          this.alpha = it
        }
      }
    }
  }

  override fun getAnimators(): List<Animator> {
    val animations = mutableListOf<Animator>()

    calculate()

    alpha?.let { alpha ->

      val objectAnimator = ObjectAnimator.ofFloat(viewToMove, View.ALPHA, alpha)

      if (alpha == 0f) {
        if (viewToMove.alpha != 0f) {
          animations.add(objectAnimator)

          objectAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
              viewToMove.visibility = View.INVISIBLE
            }
          })
        }
      } else if (alpha == 1f) {
        if (viewToMove.alpha != 1f) {
          animations.add(objectAnimator)

          objectAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationStart(animation: Animator) {
              viewToMove.visibility = View.VISIBLE
            }
          })
        }
      } else {
        animations.add(objectAnimator)

        objectAnimator.addListener(object : AnimatorListenerAdapter() {
          override fun onAnimationStart(animation: Animator) {
            viewToMove.visibility = View.VISIBLE
          }
        })
      }

    }

    return animations
  }
}
