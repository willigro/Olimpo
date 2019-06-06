package com.rgames.olimpo;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class ZeusRecyclerView {

    public static RecyclerView createLinearFixed(View view, RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    public static RecyclerView createLinearFixed(View view, RecyclerView.Adapter adapter, int orientation) {
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), orientation, false));
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    public static RecyclerView createGridFixed(View view, RecyclerView.Adapter adapter, int grid) {
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), grid));
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    public static void addDecorator(RecyclerView recyclerView) {
        if (recyclerView == null) return;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
