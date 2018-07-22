package com.donbrody.resizablerelativelayout.components.example

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.text.InputFilter
import android.text.InputType
import android.util.AttributeSet
import android.widget.*
import com.donbrody.resizablerelativelayout.R
import com.donbrody.resizablerelativelayout.components.ResizableRelativeLayout

/**
 * Created by Don.Brody on 7/22/18.
 */
class ResizableForm(context: Context, attr: AttributeSet): ResizableRelativeLayout(context, attr) {

    override fun configureSelf() {
        val wrapper = createComponentWrapper()
        wrapper.addView(createField("User Name"))
        wrapper.addView(createField("Email"))
        wrapper.addView(createField("Password", true))
        wrapper.addView(createField("Confirm Password", true))
        wrapper.addView(createButton("Sign Up"))
        addView(wrapper)
    }

    private fun createComponentWrapper(): LinearLayout {
        val wrapper = LinearLayout(context)
        val lp = RelativeLayout.LayoutParams(
                (measuredWidth * 0.80f).toInt(),
                LayoutParams.WRAP_CONTENT
        )
        lp.addRule(CENTER_HORIZONTAL)
        wrapper.layoutParams = lp
        wrapper.orientation = LinearLayout.VERTICAL
        return wrapper
    }

    private fun createField(hint: String, passwordField: Boolean = false): EditText {
        val field = EditText(context)
        val lp = LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        )
        lp.topMargin = 15.toDp
        lp.bottomMargin = 15.toDp
        field.layoutParams = lp
        field.hint = hint
        field.filters = Array<InputFilter>(1){ InputFilter.LengthFilter(25) }
        if (passwordField) {
            field.inputType = (InputType.TYPE_CLASS_TEXT or
                    InputType.TYPE_TEXT_VARIATION_PASSWORD)
        }
        return field
    }

    private fun createButton(text: String): Button {
        val button = Button(context)
        val lp = LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        )
        lp.topMargin = 80.toDp
        button.layoutParams = lp
        button.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))
        button.setTextColor(Color.WHITE)
        button.text = text

        button.setOnClickListener({
            Toast.makeText(context, "Sign Up Clicked!", Toast.LENGTH_LONG).show()
        })

        return button
    }
}