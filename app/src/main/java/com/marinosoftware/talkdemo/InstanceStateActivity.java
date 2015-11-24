package com.marinosoftware.talkdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InstanceStateActivity extends AppCompatActivity {

    static final String STATE_FIRST_NAME_LABEL = "fname_label";
    static final String STATE_FIRST_NAME_VALUE = "fname_value";
    static final String STATE_SURNAME_LABEL = "sname_label";
    static final String STATE_SURNAME_VALUE = "sname_value";

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

    String mFirstNameLabel;
    String mFirstNameValue;
    String mSurnameLabel;
    String mSurnameValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instance_state);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            fetchData();
        } else {
            mFirstNameLabel = savedInstanceState.getString(STATE_FIRST_NAME_LABEL);
            mFirstNameValue = savedInstanceState.getString(STATE_FIRST_NAME_VALUE);
            mSurnameLabel = savedInstanceState.getString(STATE_SURNAME_LABEL);
            mSurnameValue = savedInstanceState.getString(STATE_SURNAME_VALUE);
            initFields();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        //Save downloaded data
        outState.putString(STATE_FIRST_NAME_LABEL, mFirstNameLabel);
        outState.putString(STATE_FIRST_NAME_VALUE, mFirstNameValue);
        outState.putString(STATE_SURNAME_LABEL, mSurnameLabel);
        outState.putString(STATE_SURNAME_VALUE, mSurnameValue);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
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
