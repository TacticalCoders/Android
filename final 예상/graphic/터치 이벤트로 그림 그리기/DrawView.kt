package com.example.draw

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateInterpolator

class DrawView(context: Context): View(context) {

    private var posx: Float = 0F
    private var posy: Float = 0F

    private var path:Path = Path()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.WHITE)

        val paint = Paint()
        paint.setColor(Color.BLACK)
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 10f

        canvas?.drawPath(path,paint)

    }

    override fun onTouchEvent(event: MotionEvent): Boolean {

        posx = event.getX()
        posy = event.getY()

        when(event.action){
            MotionEvent.ACTION_DOWN->path.moveTo(posx,posy)
            MotionEvent.ACTION_MOVE->{
                posx = event.getX()
                posy = event.getY()
                path.lineTo(posx,posy)
            }
            else-> {}
        }
        invalidate()
        return true
    }
}
