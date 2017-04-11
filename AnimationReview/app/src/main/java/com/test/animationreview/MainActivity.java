package com.test.animationreview;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private AnimationDrawable anim;
    private Animation animation;
    private AnimatorSet animatorSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        imageView = (ImageView) findViewById(R.id.iv);
//        anim = new AnimationDrawable();
//        for (int i = 1; i <= 5; i++) {
//            int drawableId = getResources().getIdentifier("img"+i, "drawable", getPackageName());
//			Drawable drawable = getResources().getDrawable(drawableId);
//            anim.addFrame(drawable,800);
//        }
//        imageView.setImageDrawable(anim);
//        anim.setOneShot(false);
//        anim.start();
//        animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
//        imageView.startAnimation(animation);
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                Toast.makeText(MainActivity.this, "end", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
//        animatorSet = new AnimatorSet();
//        AnimatorInflater.loadAnimator(this, R.animator.animator_set_scale);
//        animatorSet.setTarget(imageView);
//        animatorSet.start();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView,
                "scaleX",
                0);
        animator.setDuration(1000);
        animator.setRepeatCount(-1);
        animator.start();


    }
}
