package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.makeStoryButton) Button mMakeStoryButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMakeStoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mMakeStoryButton){
            Intent intent = new Intent(MainActivity.this, StoryActivity.class);
            startActivity(intent);
        }
    }
}
