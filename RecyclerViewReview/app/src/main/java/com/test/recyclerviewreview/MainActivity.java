package com.test.recyclerviewreview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycle;
    private List<String> strs;
    private QuickAdapter adapter;
    private RecyclerView.LayoutManager manager;
    private RecyclerView mRecycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDdata();
        initView();
    }

    private void initView() {
        recycle = (RecyclerView) findViewById(R.id.recycle);
        manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recycle.setHasFixedSize(true);
        recycle.setLayoutManager(manager);
        adapter = new QuickAdapter(strs);
        recycle.setAdapter(adapter);
        recycle.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void SimpleOnItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i) {
                Toast.makeText(MainActivity.this, "i:" + i, Toast.LENGTH_SHORT).show();
            }
        });
   /*     adapter.openLoadAnimation(new BaseAnimation() {
            @Override
            public Animator[] getAnimators(View view) {
                return new Animator[]{
                        ObjectAnimator.ofFloat(view, "scaleY", 1, 2.2f, 1),
                        ObjectAnimator.ofFloat(view, "scaleX", 1, 2.2f, 1)
                };
            }
        });*/

        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        adapter.isFirstOnly(false);


    }

    private void initDdata() {
        strs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            strs.add("ha" + i);
        }
    }
}
