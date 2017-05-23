package com.epicodus.madlibs;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.makeStoryButton) Button mMakeStoryButton;
    @Bind(R.id.baseGridView) GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Resources res = getResources();
        String [] userPrompts = res.getStringArray(R.array.user_input);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/scififont.TTF");
//        gridView.setAdapter(new InputFieldAdapter(this, userPrompts, typeface));
        gridView.setAdapter(new EditFieldAdapter(this, userPrompts));

        mMakeStoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mMakeStoryButton) {
            ArrayList<String> allFields = new ArrayList<>();
            Resources res = getResources();
            String [] userPrompts = res.getStringArray(R.array.user_input);
            Log.d("userPrompts?", Arrays.toString(userPrompts));
//            for(int i = 0; i<userPrompts.length; i++)
//            Bundle extras = new Bundle();
//            extras.putString("noun", noun);
//            Intent intent = new Intent(MainActivity.this, StoryActivity.class);
//            intent.putExtras(extras);
//            startActivity(intent);
        }
    }
}
