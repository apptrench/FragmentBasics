package com.example.android.nofragments;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;


public class DualPaneContainer extends LinearLayout implements Container {
    private MyDetailView myDetailView;
    private ListView listView;

    public DualPaneContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        listView = (ListView) getChildAt(0);
        myDetailView = (MyDetailView) getChildAt(1);
    }

    @Override
    public void setAdapter(Context context, String[] data) {
        int layout = Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ?
                android.R.layout.simple_list_item_activated_1 : android.R.layout.simple_list_item_1;
        listView.setAdapter(new ArrayAdapter<>(context, layout, data));
    }

    @Override
    public ListView getListView() {
        return listView;
    }


    @Override
    public void showItem(String item) {
        myDetailView.setItem(item);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }
}
