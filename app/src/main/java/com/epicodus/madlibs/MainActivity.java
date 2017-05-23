package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.makeStoryButton) Button mMakeStoryButton;
    @Bind(R.id.personNameInput) EditText mPersonNameInput;
    @Bind(R.id.locationInput) EditText mLocationInput;
    @Bind(R.id.verbInput) EditText mVerbInput;
    @Bind(R.id.nounInput) EditText mNounInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mMakeStoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mMakeStoryButton) {
            String properNoun = mPersonNameInput.getText().toString();
            String location = mLocationInput.getText().toString();
            String verb = mVerbInput.getText().toString();
            String noun = mNounInput.getText().toString();
            Bundle extras = new Bundle();
            extras.putString("properNoun", properNoun);
            extras.putString("location", location);
            extras.putString("verb", verb);
            extras.putString("noun", noun);
            Intent intent = new Intent(MainActivity.this, StoryActivity.class);
            intent.putExtras(extras);
            startActivity(intent);
        }
    }
}
