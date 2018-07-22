package com.donbrody.resizablerelativelayout.components.example

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RelativeLayout
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
        wrapper.addView(createField("Password"))
        wrapper.addView(createField("Confirm Password"))
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

    private fun createField(hint: String): EditText {
        val field = EditText(context)
        val lp = LinearLayout.LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT
        )
        lp.topMargin = 15.toDp
        lp.bottomMargin = 15.toDp
        field.layoutParams = lp
        field.hint = hint
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
        return button
    }
}