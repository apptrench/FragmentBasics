package com.example.android.nofragments;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class ListPresenter {
    private final Container container;
    private final Context context;
    private final ListView listView;

    public ListPresenter(Container container, Context context) {
        this.container = container;
        this.listView = container.getListView();
        this.context = context;
    }

    public void bind() {
        this.container.setAdapter(context, Ipsum.Headlines);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                container.showItem(Ipsum.Articles[position]);
            }
        });
    }
}
