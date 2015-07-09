package com.example.android.nofragments;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.fragments.R;


public class MyDetailView extends LinearLayout {
    TextView textView;
    DetailPresenter presenter;

    public MyDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        presenter = new DetailPresenter();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        presenter.setView(this);
        textView = (TextView) findViewById(R.id.article);
//        findViewById(R.id.button).setOnClickListener(new OnClickListener() {
//            @Override public void onClick(View v) {
//                presenter.buttonClicked();
//            }
//        });
    }

    public void setItem(String item) {
        textView.setText(item);
    }
}
