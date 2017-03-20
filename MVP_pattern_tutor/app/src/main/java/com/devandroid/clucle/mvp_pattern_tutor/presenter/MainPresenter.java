package com.devandroid.clucle.mvp_pattern_tutor.presenter;

import com.devandroid.clucle.mvp_pattern_tutor.model.User;

public class MainPresenter {
    private User user;
    private View view;

    public MainPresenter(View view) {
        this.view = view;
        user = new User();
    }

    public void updateName(String name) {
        user.setName(name);
        view.updateUserInfoTextView(user.toString());
    }

    public interface View {
        void updateUserInfoTextView(String info);
    }

}
