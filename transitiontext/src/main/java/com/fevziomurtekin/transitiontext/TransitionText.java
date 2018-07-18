package com.fevziomurtekin.transitiontext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class TransitionText extends TextView {

    private int start_transition_time;

    private int finish_transition_time;

    private int transition__delay_time;

    private AlphaAnimation alphaAnimation;

    public TransitionText(Context context) {
        super(context);
    }

    public TransitionText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TransitionText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray typedArray   = context.obtainStyledAttributes(attrs,R.styleable.transtionText);
        start_transition_time   = typedArray.getInteger(R.styleable.transtionText_start_transition_time,300);
        finish_transition_time  = typedArray.getInteger(R.styleable.transtionText_finish_transition_time,5000);
        transition__delay_time  = typedArray.getInteger(R.styleable.transtionText_transition_delay_time,200);
        init();
    }

    private void init() {
        String [] words = getText().toString().split(" ");
        for(int i=0;i<words.length;i++){
            alphaAnimation  =new AlphaAnimation(0.0f,1.0f);
            alphaAnimation  .setDuration(start_transition_time+(i+transition__delay_time));
            this            .setAlpha(1f);
            this            .setAnimation(alphaAnimation);
        }
    }

    public void setFinish_transition_time(int finish_transition_time) {
        this.finish_transition_time = finish_transition_time;
    }

    public void setStart_transition_time(int start_transition_time) {
        this.start_transition_time = start_transition_time;
    }

    public void setTransition__delay_time(int transition__delay_time) {
        this.transition__delay_time = transition__delay_time;
    }
}
