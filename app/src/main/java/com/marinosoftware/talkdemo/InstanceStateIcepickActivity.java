package com.marinosoftware.talkdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import icepick.Icepick;
import icepick.State;

public class InstanceStateIcepickActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.textView)
    TextView mTextView;
    @Bind(R.id.editText)
    EditText mEditText;
    @Bind(R.id.textView2)
    TextView mTextView2;
    @Bind(R.id.editText2)
    EditText mEditText2;
    @Bind(R.id.button)
    Button mButton;


    @State
    String mFirstNameLabel;
    @State
    String mFirstNameValue;
    @State
    String mSurnameLabel;
    @State
    String mSurnameValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Icepick.restoreInstanceState(this, savedInstanceState);
        setContentView(R.layout.activity_instance_state_icepick);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            fetchData();
        } else {
            initFields();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Icepick.saveInstanceState(this, outState);
    }



    //method that takes a long time to fetch data from a server or whatever
    private void fetchData() {
        mFirstNameLabel = "First name:";
        mFirstNameValue = "Taylor";
        mSurnameLabel = "Surname:";
        mSurnameValue = "Swift";

        initFields();
    }

    private void initFields() {
        mTextView.setText(mFirstNameLabel);
        mEditText.setText(mFirstNameValue);
        mTextView2.setText(mSurnameLabel);
        mEditText2.setText(mSurnameValue);
    }

}
