package com.example.android.nofragments;

import android.content.Context;
import android.widget.ListView;

/**
 * Created by Ganesh on 08-07-2015.
 */
public interface Container {
    void showItem(String item);

    boolean onBackPressed();

    void setAdapter(Context context, String[] data);

    ListView getListView();
}
