package com.example.designtokens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.designtokens.views.ButtonState
import kotlinx.android.synthetic.main.fragment_shadow.*

class ShadowFragment : Fragment(R.layout.fragment_shadow) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLarge.setOnClickListener { buttonLarge.state = ButtonState.Loading }
        buttonMedium.setOnClickListener { buttonMedium.state = ButtonState.Loading }
        buttonSmall.setOnClickListener { buttonSmall.state = ButtonState.Loading }
    }
}