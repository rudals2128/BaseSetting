package dev.lazyrabbit.witch.presentation.util.extension

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView


@SuppressLint("ClickableViewAccessibility")
fun View.setupButton(clickSize: Float = 0.98F) {
    this.setOnTouchListener { _, event ->
        when (event.action) {
            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_CANCEL -> this.setClickAnimation(false, clickSize)
            MotionEvent.ACTION_DOWN -> this.setClickAnimation(true, clickSize)
        }
        false
    }
}

fun View.setClickAnimation(isDown: Boolean, clickSize: Float) {
    val value = if (isDown) clickSize else 1F
    val x = ObjectAnimator.ofFloat(this, "scaleX", value).apply { duration = 50L }
    val y = ObjectAnimator.ofFloat(this, "scaleY", value).apply { duration = 50L }
    AnimatorSet().let { set ->
        set.play(x).with(y)
        set.start()
    }
}

@SuppressLint("ClickableViewAccessibility")
fun View.setupImageButton(view: ImageView, clickSize: Float = 0.9F) {
    this.setOnTouchListener { _, event ->
        when (event.action) {
            MotionEvent.ACTION_UP -> setImageClickAnimation(false, clickSize,view)

            MotionEvent.ACTION_CANCEL -> setImageClickAnimation(false, clickSize,view)

            MotionEvent.ACTION_DOWN -> setImageClickAnimation(true, clickSize,view)
        }
        true
    }
}

// TODO : 해당 Lint 에러 처리 확인 필요.
fun setImageClickAnimation(isDown: Boolean, clickSize: Float, view: View) {
    val value = if (isDown) clickSize else 1F
    val x = ObjectAnimator.ofFloat(view, "scaleX", value).apply { duration = 50L }
    val y = ObjectAnimator.ofFloat(view, "scaleY", value).apply { duration = 50L }
    AnimatorSet().let { set ->
        set.play(x).with(y)
        set.start()
    }
}
