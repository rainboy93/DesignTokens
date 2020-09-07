package com.example.designtokens.animation.core.scale;

import android.view.View;

import com.example.designtokens.animation.core.scale.ScaleAnimExpectation;

public abstract class ScaleAnimExpectationViewDependant extends ScaleAnimExpectation {

  protected final View otherView;

  public ScaleAnimExpectationViewDependant(View otherView, Integer gravityHorizontal, Integer gravityVertical) {
    super(gravityHorizontal, gravityVertical);
    this.otherView = otherView;

    getViewsDependencies().add(otherView);
  }
}
