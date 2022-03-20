package com.example.cse225_android_kotlin_2022

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.contentValuesOf
import androidx.core.content.res.ResourcesCompat
import java.security.KeyStore

class EditTextCustom(context: Context, attrs: AttributeSet?) : AppCompatEditText(context, attrs) {
    private var sethint:String? = null
    private var setcolor = false

    var darkButton: Drawable?=null
    var lightButton:Drawable ?= null
    fun init(){
        darkButton = ResourcesCompat.getDrawable(resources, R.drawable.ic_clear_black_24dp,null)
        lightButton = ResourcesCompat.getDrawable(resources, R.drawable.ic_clear_black_22dp,null)

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                showButton()
                show()
            }

            override fun afterTextChanged(p0: Editable?){
            }

        })
    }
    fun show(){
        setOnTouchListener { view, motionEvent->
            var isclicked:Boolean = false
            var clearButtonStart = (width - paddingEnd -darkButton!!.intrinsicWidth).toFloat()
            if(motionEvent.x > clearButtonStart){
                isclicked = true
            }

            if(isclicked){
                when(motionEvent.action){
                    MotionEvent.ACTION_DOWN -> text!!.clear()
                    MotionEvent.ACTION_UP -> hideButton()
                }
            }
            true

        }
    }
    fun showButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, darkButton, null)
    }
    fun hideButton(){
        setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, lightButton, null)
    }
    init {
        var tarry1:TypedArray = context.obtainStyledAttributes(attrs, R.styleable.EditTextCustom)
        try {
            sethint = tarry1.getString(R.styleable.EditTextCustom_setHint)

            if(sethint == null)
                setHint("Enter Your Message")
            else
                setHint("Why to Enter the message")
            setcolor = tarry1.getBoolean(R.styleable.EditTextCustom_setColor1,false)

            if(setcolor == true)
                setTextColor(Color.RED)
        }
        finally {
            tarry1.recycle()
            init()
        }
    }

}