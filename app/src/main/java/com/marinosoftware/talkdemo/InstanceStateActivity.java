package com.marinosoftware.talkdemo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InstanceStateActivity extends AppCompatActivity {

    static final String STATE_FIRST_NAME = "fname";
    static final String STATE_SURNAME = "sname";

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

    String mFirstName;
    String mSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instance_state);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            fetchData();
        } else {
            mFirstName = savedInstanceState.getString(STATE_FIRST_NAME);
            mSurname = savedInstanceState.getString(STATE_SURNAME);
            initFields();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        //Save downloaded data
        outState.putString(STATE_FIRST_NAME, mFirstName);
        outState.putString(STATE_SURNAME, mSurname);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(outState);
    }


    //method that takes a long time to fetch data from a server or whatever
    private void fetchData() {
        mFirstName = "Taylor";
        mSurname = "Swift";

        initFields();
    }

    private void initFields() {
        mEditText.setText(mFirstName);
        mEditText2.setText(mSurname);
    }
}
