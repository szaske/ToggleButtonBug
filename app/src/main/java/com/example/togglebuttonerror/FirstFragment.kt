package com.example.togglebuttonerror

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    private val buttonBackgroundDrawable by lazy {
        context?.let { context ->
            ContextCompat.getDrawable(context, R.drawable.button_background)
        }
    }

    private fun getButtonBackground(): Drawable? {
        return context?.let { context ->
            ContextCompat.getDrawable(context, R.drawable.button_background)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bugged
        buttonBackgroundDrawable?.let { bgDrawable ->
            toggleButton1.background = bgDrawable
            toggleButton2.background = bgDrawable
            toggleButton3.background = bgDrawable
        }

        // Works
//            toggleButton1.background = getButtonBackground()
//            toggleButton2.background = getButtonBackground()
//            toggleButton3.background = getButtonBackground()

    }
}