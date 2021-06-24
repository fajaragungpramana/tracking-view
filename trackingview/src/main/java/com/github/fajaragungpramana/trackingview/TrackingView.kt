package com.github.fajaragungpramana.trackingview

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.Gravity
import android.widget.LinearLayout

class TrackingView(context: Context, attrs: AttributeSet?) : LinearLayout(context, attrs) {

    private val mIndicator: Indicator
    private val mLine: Line

    var isDashedEnabled: Boolean = false
        get() = mLine.isDashed
        set(value) {
            field = value

            mLine.isDashed = field
        }

    var lineWidth: Int = 2
        get() = mLine.width
        set(value) {
            field = value

            mIndicator.lineSize = field
            mLine.lineWidth = field
        }

    var indicatorColor: Int = Color.RED
        get() = mLine.lineColor
        set(value) {
            field = value

            mIndicator.indicatorColor = field
            mLine.lineColor = field
        }

    var indicatorSize: Int = 32
        get() = mIndicator.indicatorSize
        set(value) {
            field = value

            mIndicator.indicatorSize = field
        }

    var isDestinationEnabled: Boolean = false
        get() = mIndicator.isDestination
        set(value) {
            field = value

            mIndicator.isDestination = field
        }

    init {

        orientation = VERTICAL
        gravity = Gravity.CENTER_HORIZONTAL

        mIndicator = Indicator(context)
        mLine = Line(context)

        addView(mIndicator)
        addView(mLine)

        context.obtainStyledAttributes(attrs, R.styleable.TrackingView).also {
            isDashedEnabled = it.getBoolean(R.styleable.TrackingView_dashed, false)
            lineWidth = it.getDimension(R.styleable.TrackingView_lineWidth, 4F).toInt()
            indicatorColor = it.getColor(R.styleable.TrackingView_indicatorColor, Color.RED)
            indicatorSize = it.getDimension(R.styleable.TrackingView_indicatorSize, 32F).toInt()
        }.recycle()

    }

    fun set(position: Int, itemCount: Int) {
        if (position == (itemCount - 1)) {
            mLine.visibility = GONE
            mIndicator.isDestination = true
        }
    }

}