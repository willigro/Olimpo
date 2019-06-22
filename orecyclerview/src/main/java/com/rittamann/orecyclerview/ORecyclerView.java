package com.rittamann.orecyclerview;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class ORecyclerView {

    public static RecyclerView createLinear(View view, RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    public static RecyclerView createLinear(View view, RecyclerView.Adapter adapter, int orientation) {
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), orientation, false));
        recyclerView.setAdapter(adapter);
        return recyclerView;
    }

    public static RecyclerView createLinearDecor(View view, RecyclerView.Adapter adapter) {
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);
        addDecorator(recyclerView);
        return recyclerView;
    }

    public static RecyclerView createLinearDecor(View view, RecyclerView.Adapter adapter, int orientation) {
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), orientation, false));
        recyclerView.setAdapter(adapter);
        addDecorator(recyclerView);
        return recyclerView;
    }

    public static RecyclerView createGrid(View view, RecyclerView.Adapter adapter, int grid) {
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

    public static void update(RecyclerView.Adapter adapter, List<Object> listManipulated, Object objectManipulated) {
        for (int index = 0; index < listManipulated.size(); index++)
            if (listManipulated.get(index).equals(objectManipulated)) {
                listManipulated.set(index, objectManipulated);
                adapter.notifyItemChanged(index);
                break;
            }
    }

    public static void delete(IRecyclerAdapter adapter, List<Object> listManipulated, Object objectManipulated) {
        for (Object objectInList : listManipulated) {
            if (objectInList.equals(objectManipulated)) {
                listManipulated.remove(objectInList);
                break;
            }
        }
        adapter.getList().clear();
        adapter.getList().addAll(listManipulated);
        ((RecyclerView.Adapter) adapter).notifyDataSetChanged();
    }

    public interface IRecyclerAdapter {
        List<Object> getList();
    }
}
