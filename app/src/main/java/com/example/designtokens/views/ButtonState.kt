package com.example.designtokens.views

sealed class ButtonState {
  object Idle : ButtonState()
  object Loading : ButtonState()
}
