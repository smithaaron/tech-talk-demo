package com.marinosoftware.talkdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.marinosoftware.talkdemo.images.ImageLoader;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LovelyGirlsActivity extends AppCompatActivity {

    @Bind(R.id.imageView)
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lovely_girls);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String imageName = ImageLoader.getImageName();

        mImageView.setImageDrawable(getResources().getDrawable(getResources().getIdentifier(imageName, "drawable", getPackageName())));

    }

}
