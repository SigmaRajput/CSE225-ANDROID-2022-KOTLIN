package com.example.cse225_android_kotlin_2022

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import com.example.cse225_android_kotlin_2022.R

class textViewCustom : AppCompatTextView {
    private var title: String? = null
    private var color = false

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val tarry: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.TextViewCustom)
        try {
            title = tarry.getString(R.styleable.TextViewCustom_setTitle)
            if (title == null)
                setText("Custom Message")
            else
                setText("Hello")
            color = tarry.getBoolean(R.styleable.TextViewCustom_setColor, false)
            if (color)
                setTextColor(Color.MAGENTA)
        } finally {
            tarry.recycle()
        }
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

}