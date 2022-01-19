package com.example.propertyanimation

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateInterpolator

class MyView(context: Context): View(context) {
    private val RADIUS = 100f
    private var mX:Float = RADIUS
    private var mY:Float = RADIUS

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.YELLOW)

        val paint = Paint()
        paint.color = Color.RED
        //원 그리기. y는 고정되어 있다. mX=RADIUS=100f
        canvas?.drawCircle((width/2).toFloat(), mY, RADIUS, paint) //원의 중심 좌표.
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            //변동 '범위'를 지정.
            val valueAnim = ValueAnimator.ofFloat(RADIUS, height-RADIUS) //가로폭(맨 오른쪽 끝에서 반지름만큼 뺀 곳)

            valueAnim.duration = 2000
            valueAnim.interpolator = AccelerateInterpolator()
            valueAnim.start()

            //반복으로 돌게 되는 루프.
            valueAnim.addUpdateListener (object: ValueAnimator.AnimatorUpdateListener {
                override fun onAnimationUpdate(animation: ValueAnimator?) {
                    mY = animation?.animatedValue as Float
                    invalidate()
                }
            })
            return true
        }
        return false
    }
}
