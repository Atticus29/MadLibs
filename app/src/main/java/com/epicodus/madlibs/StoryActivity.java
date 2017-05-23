package com.epicodus.madlibs;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StoryActivity extends AppCompatActivity {
    @Bind(R.id.textView) TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        ArrayList<String> allFields = intent.getStringArrayListExtra("allFields");
        Resources res = getResources();
        String storyString = res.getString(R.string.story_string);
        String story = String.format(storyString, allFields.toArray());
        Log.d("story", story);
        mTextView.setText(story);
    }
}
