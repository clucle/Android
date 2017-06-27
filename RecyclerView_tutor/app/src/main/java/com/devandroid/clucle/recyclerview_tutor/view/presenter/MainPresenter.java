package com.devandroid.clucle.recyclerview_tutor.view.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.devandroid.clucle.recyclerview_tutor.R;
import com.devandroid.clucle.recyclerview_tutor.view.adapter.SanaAdapter;
import com.devandroid.clucle.recyclerview_tutor.view.item.Item;

import java.util.ArrayList;

public class MainPresenter {

    private View view;

    private Context mContext;

    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Item> items = new ArrayList<>();

    public interface View {
        void showItem();
    }

    public MainPresenter(View view) {
        this.view = view;
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    private void loadItem() {
        items.add(new Item(R.drawable.a, "사나사랑 1"));
        items.add(new Item(R.drawable.b, "사나사랑 2"));
        items.add(new Item(R.drawable.c, "사나사랑 3"));
        items.add(new Item(R.drawable.d, "사나사랑 4"));
        items.add(new Item(R.drawable.e, "사나사랑 5"));
    }

    private void setLayoutManager() {
        layoutManager = new LinearLayoutManager(mContext);
    }

    private void setAdapter() {
        adapter = new SanaAdapter(items, mContext);
    }

    public void initMain() {
        loadItem();
        setLayoutManager();
        setAdapter();
    }

    public RecyclerView.LayoutManager getLayoutManger() {
        return layoutManager;
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public void showItem() {
        view.showItem();
    }
}
