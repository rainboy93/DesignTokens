package com.example.designtokens.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import com.example.designtokens.R
import com.example.designtokens.animation.PleaseAnim
import com.example.designtokens.animation.please
import com.example.designtokens.databinding.ViewsCoreButtonBinding
import com.example.designtokens.views.CoreButton.Type

/**
 * Main theme button which use a gradient background
 * It's inherited from [AbstractButton] which is a [ShadowLayout] the we should calculate the padding around
 * By default, [Type.GRADIENT] has margin of value [tokenSpacing16] because of shadow layer
 */
class CoreButton : AbstractButton {

    private lateinit var viewBinding: ViewsCoreButtonBinding

    private var animation: PleaseAnim? = null

    /**
     * Text label of the button
     */
    var text: String = ""
        set(value) {
            field = value
            viewBinding.buttonAction.text = value
        }

    /**
     * Size of the button
     */
    private var size: Size = Size.SMALL
        set(value) {
            field = value
            updateSize()
        }

    /**
     * Type of the button
     */
    private var type: Type = Type.GRADIENT
        set(value) {
            field = value
            updateType()
        }

    constructor(context: Context) : super(context) {
        init(null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        init(attrs)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(attrs)
    }

    private fun init(attrs: AttributeSet?) {
        viewBinding = ViewsCoreButtonBinding.inflate(LayoutInflater.from(context), this, true)
        if (attrs == null) {
            return
        }

        val ta = context.obtainStyledAttributes(attrs, R.styleable.CoreButton)
        text = ta.getString(R.styleable.CoreButton_cbtText) ?: ""
        size = Size.values()[ta.getInt(R.styleable.CoreButton_cbtSize, 0)]
        type = Type.values()[ta.getInt(R.styleable.CoreButton_cbtType, 0)]
        ta.recycle()
    }

    override fun onIdle() {
        viewBinding.buttonAction.visibility = View.VISIBLE
        viewBinding.loadingIndicator.visibility = View.INVISIBLE
    }

    override fun onLoading() {
        viewBinding.buttonAction.visibility = View.INVISIBLE
        viewBinding.loadingIndicator.visibility = View.VISIBLE
    }

    /**
     * Resize button based on [Size]
     */
    private fun updateSize() {
        val padding = resources.getDimension(size.paddingRes).toInt()
        viewBinding.buttonAction.setPadding(padding, 0, padding, 0)
        val buttonParams = viewBinding.buttonAction.layoutParams as LayoutParams
        buttonParams.height = resources.getDimension(size.heightRes).toInt()
        viewBinding.buttonAction.layoutParams = buttonParams
        viewBinding.buttonAction.setTextAppearance(size.textStyleRes)

        val loadingParams = viewBinding.loadingIndicator.layoutParams as LayoutParams
        val loadingSize = resources.getDimension(size.loadingSizeRes).toInt()
        loadingParams.width = loadingSize
        loadingParams.height = loadingSize
        viewBinding.loadingIndicator.layoutParams = loadingParams
    }

    /**
     * Change styles and shadown based on [Type]
     */
    private fun updateType() {
        viewBinding.viewContainer.setBackgroundResource(type.backgroundRes)
        viewBinding.buttonAction.setTextColor(resources.getColor(type.textColorRes))
        val padding =
            if (type.paddingRes > 0) resources.getDimension(type.paddingRes).toInt() else 0
        viewBinding.shadowLayout.setPadding(padding, padding, padding, padding)
        viewBinding.shadowLayout.radius = type.shadowRadius
        viewBinding.shadowLayout.yShift =
            if (type.yShiftRes > 0) resources.getDimension(type.yShiftRes) else 0f
        viewBinding.loadingIndicator.setColorFilter(resources.getColor(type.loadingColorRes))
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        animation = please(duration = 1500L, interpolator = LinearInterpolator()) {
            animate(viewBinding.loadingIndicator) toBe {
                toBeRotated(360f)
                withEndAction {
                    setPercent(0f)
                    start()
                }
            }
        }
        animation?.start()
    }

    override fun onDetachedFromWindow() {
        animation?.cancel()
        super.onDetachedFromWindow()
    }

    /**
     * Button sizes
     * @param heightRes button height dimens resource
     * @param textStyleRes button text size dimens resource
     * @param paddingRes button padding left and right dimens resources
     * @param loadingSizeRes loading size dimens resources
     */
    enum class Size(
        @DimenRes val heightRes: Int,
        @StyleRes val textStyleRes: Int,
        @DimenRes val paddingRes: Int,
        @DimenRes val loadingSizeRes: Int
    ) {
        SMALL(
            R.dimen.buttonSizeSmall,
            R.style.fontMedium12,
            R.dimen.buttonPaddingSmall,
            R.dimen.buttonLoadingSmall
        ),
        MEDIUM(
            R.dimen.buttonSizeMedium,
            R.style.fontMedium14,
            R.dimen.buttonPaddingMedium,
            R.dimen.buttonLoadingMedium
        ),
        LARGE(
            R.dimen.buttonSizeLarge,
            R.style.fontMedium18,
            R.dimen.buttonPaddingLarge,
            R.dimen.buttonLoadingLarge
        )
    }

    /**
     * Button types
     * @param backgroundRes button background drawable resource
     * @param shadowRadius button background shadow radius, only [Type.GRADIENT]
     * @param yShiftRes button background shadow y shift, only [Type.GRADIENT]
     */
    enum class Type(
        @DrawableRes val backgroundRes: Int,
        @ColorRes val textColorRes: Int,
        @DimenRes val paddingRes: Int,
        val shadowRadius: Float,
        @DimenRes val yShiftRes: Int,
        @ColorRes val loadingColorRes: Int
    ) {
        GRADIENT(
            R.drawable.foundations_button_rainbow_blue_background,
            R.color.tokenWhite,
            R.dimen.tokenSpacing16,
            5f,
            R.dimen._1sdp,
            R.color.tokenWhite
        ),
        OUTLINE(
            R.drawable.foundations_button_outline_background,
            R.color.tokenCyan100,
            0,
            0f,
            0,
            R.color.tokenCyan100
        )
    }
}
