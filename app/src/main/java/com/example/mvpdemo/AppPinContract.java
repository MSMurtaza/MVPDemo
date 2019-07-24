package com.example.mvpdemo;

public interface AppPinContract {
    interface View {
        void showButtonClick(boolean show);
        void setButtonColor(int color);
        void navigateNextScreen();
        void showError(String error);
        void showTickVisibility(int value);
    }

    interface Presenter {
        void loadNextScreen();
        void defaultSettings();
        void verifyEntries();
        void savePassword(String password);
        String appendIndividualPassword(String first, String second, String third, String fourth);
    }
}
