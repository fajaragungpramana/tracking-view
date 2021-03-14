package com.github.fajaragungpramana.trackingview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

internal class Indicator(context: Context) : View(context) {

    internal var lineSize: Int = 4
    internal var indicatorSize: Int = 32
    internal var indicatorColor: Int = Color.RED

    internal var isDestination: Boolean = false

    private var mPaintLine: Paint
        get() {
            field.let {
                it.color = indicatorColor
                it.strokeWidth = lineSize.toFloat()
                it.style = Paint.Style.STROKE
            }
            return field
        }

    private var mPaintIndicator: Paint
        get() {
            field.color = indicatorColor
            return field
        }

    init {
        mPaintLine = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaintIndicator = Paint(Paint.ANTI_ALIAS_FLAG)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        setMeasuredDimension(indicatorSize + lineSize, indicatorSize + lineSize)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.drawCircle(
            (indicatorSize + lineSize) / 2F,
            (indicatorSize + lineSize) / 2F,
            indicatorSize / 2F,
            mPaintLine
        )

        if (isDestination)
            canvas?.drawCircle(
                (indicatorSize + lineSize) / 2F,
                (indicatorSize + lineSize) / 2F,
                (60 * (indicatorSize / 2F)) / 100,
                mPaintIndicator
            )

    }

}