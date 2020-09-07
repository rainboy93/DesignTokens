package com.example.designtokens.animation.core

import android.animation.Animator
import android.view.View

import com.example.designtokens.animation.ViewCalculator

abstract class PleaseAnimManager(
    protected val animExpectations: List<AnimExpectation>,
    protected val viewToMove: View,
    protected val viewCalculator: ViewCalculator) {

  abstract fun getAnimators(): List<Animator>

  abstract fun calculate()
}
