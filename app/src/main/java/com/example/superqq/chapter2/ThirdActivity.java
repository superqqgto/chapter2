package com.example.superqq.chapter2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by superqq on 2016/5/31.
 */
public class ThirdActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.third_layout);
    }
}
