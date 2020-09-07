package com.example.designtokens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_intro.*

class IntroFragment : Fragment(R.layout.fragment_intro) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonColor.setOnClickListener { findNavController().navigate(R.id.action_introFragment_to_colorFragment) }
        buttonFonts.setOnClickListener { findNavController().navigate(R.id.action_introFragment_to_fontsFragment) }
        buttonSpacing.setOnClickListener { findNavController().navigate(R.id.action_introFragment_to_spacingFragment) }
        buttonShadow.setOnClickListener { findNavController().navigate(R.id.action_introFragment_to_shadowFragment) }
        buttonBorder.setOnClickListener { findNavController().navigate(R.id.action_introFragment_to_borderFragment) }
    }
}