package com.devandroid.clucle.mvp_pattern_tutor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import com.devandroid.clucle.mvp_pattern_tutor.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainPresenter.View{

    private MainPresenter mainPresenter;

    private TextView userInfoTextView;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter = new MainPresenter(this);

        userInfoTextView = (TextView) findViewById(R.id.userInfo);
        name = (EditText) findViewById(R.id.name);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mainPresenter.updateName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public void updateUserInfoTextView(String info) {
        userInfoTextView.setText(info);
    }
}
