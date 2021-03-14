package com.github.fajaragungpramana.trackingview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.DashPathEffect
import android.graphics.Paint
import android.view.View
import android.view.ViewGroup

internal class Line(context: Context) : View(context) {

    internal var lineWidth: Int = 4
    internal var lineColor: Int = Color.RED

    internal var isDashed: Boolean = false

    private var mPaintLine: Paint
        get() {
            field.let {
                it.color = lineColor
                it.strokeWidth = lineWidth.toFloat()
                if (isDashed) it.pathEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
            }
            return field
        }

    init {
        mPaintLine = Paint(Paint.ANTI_ALIAS_FLAG)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(lineWidth, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawLine(0F, 0F, 0F, height.toFloat(), mPaintLine)
    }

}