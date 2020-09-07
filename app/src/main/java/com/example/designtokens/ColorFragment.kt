package com.example.designtokens

import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_color.*

class ColorFragment : Fragment(R.layout.fragment_color) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val width = gradientText.paint.measureText("Gradient")
        val gradientShader: Shader = LinearGradient(
            0f, 0f, width, gradientText.textSize,
            intArrayOf(
                resources.getColor(R.color.tokenRainbowBlueStart),
                resources.getColor(R.color.tokenRainbowBlueEnd)
            ),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        gradientText.paint.shader = gradientShader
    }
}