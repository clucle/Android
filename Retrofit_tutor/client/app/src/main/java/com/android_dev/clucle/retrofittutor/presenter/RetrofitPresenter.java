package com.android_dev.clucle.retrofittutor.presenter;

import android.support.annotation.NonNull;
import android.util.Log;

import com.android_dev.clucle.retrofittutor.model.User;
import com.android_dev.clucle.retrofittutor.model.Users;
import com.android_dev.clucle.retrofittutor.utils.RetrofitHelper;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitPresenter {
    private View view;

    private User user;
    private List<User> userList;

    // Constructor
    public RetrofitPresenter(View view) {
        this.view = view;
    }

    // Search One User and Show View
    public void updateUser(String name) {
        Log.e("[Client]", "Too many request?");
        RetrofitHelper.getInstance().getUser(name).enqueue(new Callback<User>() {
            @Override
            public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                if (response.code() == 200 && response.body() != null) {
                    user = response.body();
                    view.updateTextView(user.toString());
                } else {
                    onFailure(call, new Throwable("may be response something but error"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                Log.e("[Server]", t.getLocalizedMessage());
                view.updateTextView("Error! at Search One");
            }
        });
    }

    // Search User List and Show View
    public void updateUserList() {
        RetrofitHelper.getInstance().getUserList().enqueue(new Callback<Users>() {
            @Override
            public void onResponse(@NonNull Call<Users> call, @NonNull Response<Users> response) {
                if (response.code() == 200 && response.body().users != null) {
                    userList = response.body().users;
                    // 임시로 2번 째 사람의 이름만 출력해보자
                    view.updateTextView(userList.get(1).getName());
                } else {
                    onFailure(call, new Throwable("may be response something but error"));
                }
            }

            @Override
            public void onFailure(@NonNull Call<Users> call, @NonNull Throwable t) {
                Log.e("[Server]", t.getLocalizedMessage());
                view.updateTextView("Error! at Search List");
            }
        });
    }

    public interface View {
        void updateTextView(String text);
    }
}
