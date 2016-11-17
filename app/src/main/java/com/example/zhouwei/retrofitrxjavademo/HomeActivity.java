package com.example.zhouwei.retrofitrxjavademo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.zhouwei.retrofitrxjavademo.gank.GankActivity;
import com.example.zhouwei.retrofitrxjavademo.movie.MovieActivity;

/**
 * Created by zhouwei on 16/11/17.
 */

public class HomeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity_layout);

        findViewById(R.id.movie_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MovieActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.award_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, GankActivity.class);
                startActivity(intent);
            }
        });
    }
}
