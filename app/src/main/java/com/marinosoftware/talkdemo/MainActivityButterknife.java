package com.marinosoftware.talkdemo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivityButterknife extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_butterknife);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
    }

    @OnClick(R.id.button)
    public void onButtonClicked() {
        Toast.makeText(this, "Button pressed", Toast.LENGTH_SHORT).show();
    }

    /**** 45% less characters in this example using butterknife!! ****/
}
