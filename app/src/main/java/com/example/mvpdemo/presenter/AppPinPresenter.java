package com.example.mvpdemo.presenter;

import android.view.View;

import com.example.mvpdemo.AppPinContract;
import com.example.mvpdemo.R;
import com.example.mvpdemo.model.AppPinModel;

public class AppPinPresenter implements AppPinContract.Presenter {
    private AppPinContract.View view;
    private AppPinModel appPinModel;

    public AppPinPresenter(AppPinContract.View view) {
        this.view = view;
        appPinModel = new AppPinModel();
    }

    @Override
    public void loadNextScreen() {
        view.navigateNextScreen();
    }

    @Override
    public void defaultSettings() {
        view.setButtonColor(R.color.colorAsh);
        view.showButtonClick(false);
        view.showTickVisibility(View.INVISIBLE);
    }

    @Override
    public void verifyEntries() {
        view.setButtonColor(R.color.colorRed);
        view.showButtonClick(true);
        view.showTickVisibility(View.VISIBLE);
    }

    @Override
    public void savePassword(String password) {
        appPinModel.setPassword(password);
    }

    @Override
    public String appendIndividualPassword(String first, String second, String third, String fourth) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(first).append(second).append(third).append(fourth);
        return stringBuilder.toString();
    }
}
