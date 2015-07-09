package com.example.android.nofragments;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.android.fragments.R;

public class SinglePaneContainer extends FrameLayout implements Container {
    private ListView listView;

    public SinglePaneContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        listView = (ListView) getChildAt(0);
    }

    public boolean onBackPressed() {
        if (!listViewAttached()) {
            removeViewAt(0);
            addView(listView);
            return true;
        }
        return false;
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
        if (listViewAttached()) {
            removeViewAt(0);
            View.inflate(getContext(), R.layout.detail_view, this);
        }

        MyDetailView detailView = (MyDetailView) getChildAt(0);
        detailView.setItem(item);
    }

    private boolean listViewAttached() {
        return listView.getParent() != null;
    }
}