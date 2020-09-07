package com.example.designtokens.animation.core

import android.view.View

import com.example.designtokens.animation.ViewCalculator

abstract class AnimExpectation {
  var viewCalculator: ViewCalculator? = null

  var viewsDependencies: MutableList<View> = mutableListOf()
}
