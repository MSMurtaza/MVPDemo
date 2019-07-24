package com.example.mvpdemo.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mvpdemo.AppPinContract;
import com.example.mvpdemo.R;
import com.example.mvpdemo.presenter.AppPinPresenter;

public class MainActivity extends AppCompatActivity implements AppPinContract.View {
    private Button mButton;
    private AppPinContract.Presenter presenter;
    private EditText editText1, editText2, editText3, editText4,
    editText5, editText6, editText7, editText8;
    private String password1, password2;
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        presenter = new AppPinPresenter(this);
        presenter.defaultSettings();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadNextScreen();
            }
        });
    }

    private void init() {
        mButton = findViewById(R.id.btn_choose_pin);

        editText1 = findViewById(R.id.newpin_one);
        editText2 = findViewById(R.id.newpin_two);
        editText3 = findViewById(R.id.newpin_three);
        editText4 = findViewById(R.id.newpin_four);
        editText5 = findViewById(R.id.confirmpin_one);
        editText6 = findViewById(R.id.confirmpin_two);
        editText7 = findViewById(R.id.confirmpin_three);
        editText8 = findViewById(R.id.confirmpin_four);

        editText1.addTextChangedListener(textWatcher);
        editText2.addTextChangedListener(textWatcher);
        editText3.addTextChangedListener(textWatcher);
        editText4.addTextChangedListener(textWatcher);
        editText5.addTextChangedListener(textWatcher);
        editText6.addTextChangedListener(textWatcher);
        editText7.addTextChangedListener(textWatcher);
        editText8.addTextChangedListener(textWatcher);

        imageView1 = findViewById(R.id.positivechecked1);
        imageView2 = findViewById(R.id.positivechecked2);
    }

    TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            EditText editText = (EditText) getCurrentFocus();
            if (editText != null && editText.length() > 0) {
                View next = editText.focusSearch(View.FOCUS_RIGHT);
                if (next != null) {
                    next.requestFocus();
                }
            }
            password1 = presenter.appendIndividualPassword(editText1.getText().toString(), editText2.getText().toString(),
                                                            editText3.getText().toString(), editText4.getText().toString());
            password2 = presenter.appendIndividualPassword(editText5.getText().toString(), editText6.getText().toString(),
                                                            editText7.getText().toString(), editText8.getText().toString());
            if (password1.equals(password2)) {
                presenter.verifyEntries();
                presenter.savePassword(password1);
                return;
            }
            if (!(password1.equals(password2))) {
                presenter.defaultSettings();
                return;
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    @Override
    public void showButtonClick(boolean show) {
        mButton.setEnabled(show);
    }

    @Override
    public void setButtonColor(int color) {
        mButton.setBackgroundColor(color);
    }

    @Override
    public void navigateNextScreen() {
        Toast.makeText(this, "Your intent goes here", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, ""+error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showTickVisibility(int value) {
        imageView1.setVisibility(value);
        imageView2.setVisibility(value);
    }

    // this is my test code
}
