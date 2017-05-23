package com.epicodus.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoryActivity extends AppCompatActivity {
    @Bind(R.id.textView) TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        String properNoun = extras.getString("properNoun");
        String location = extras.getString("location");
        String verb = extras.getString("verb");
        String noun = extras.getString("noun");
        String story = String.format("One day, %s went to %s. They %s all over %s.", properNoun, location, verb, noun);
        Log.d("story", story);
        mTextView.setText(story);
    }
}
