package com.devandroid.clucle.recyclerview_tutor.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.devandroid.clucle.recyclerview_tutor.R;
import com.devandroid.clucle.recyclerview_tutor.view.presenter.MainPresenter;


public class MainActivity extends AppCompatActivity implements MainPresenter.View{

    RecyclerView recyclerView;
    MainPresenter mainPresenter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        mainPresenter = new MainPresenter(this);
        mainPresenter.setContext(getApplicationContext());
        mainPresenter.initMain();
        mainPresenter.showItem();
    }

    @Override
    public void showItem() {
        recyclerView.setLayoutManager(mainPresenter.getLayoutManger());
        recyclerView.setAdapter(mainPresenter.getAdapter());
    }
}
