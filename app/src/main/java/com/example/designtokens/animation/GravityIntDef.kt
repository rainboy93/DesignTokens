package com.example.designtokens.animation

import android.annotation.SuppressLint
import android.view.Gravity
import androidx.annotation.IntDef

@SuppressLint("RtlHardcoded")
@IntDef(value = [Gravity.LEFT, Gravity.RIGHT, Gravity.END, Gravity.START, Gravity.TOP, Gravity.BOTTOM])
annotation class GravityIntDef