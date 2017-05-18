package com.android_dev.clucle.retrofittutor.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android_dev.clucle.retrofittutor.R;
import com.android_dev.clucle.retrofittutor.presenter.RetrofitPresenter;


public class RetrofitTutor extends AppCompatActivity implements RetrofitPresenter.View {

    private RetrofitPresenter retrofitPresenter;

    private TextView textShowUser;
    private EditText editSearchName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_tutor);

        retrofitPresenter = new RetrofitPresenter(this);

        textShowUser = (TextView) findViewById(R.id.text_show_user);
        editSearchName = (EditText) findViewById(R.id.edit_search_name);

        findViewById(R.id.btn_search_one).setOnClickListener(mClickListener);
        findViewById(R.id.btn_search_list).setOnClickListener(mClickListener);
    }

    @Override
    public void updateTextView(String text) {
        textShowUser.setText(text);
    }

    Button.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_search_one:
                    retrofitPresenter.updateUser(editSearchName.getText().toString());
                    break;
                case R.id.btn_search_list:
                    retrofitPresenter.updateUserList();
                    break;
            }
        }
    };
}
