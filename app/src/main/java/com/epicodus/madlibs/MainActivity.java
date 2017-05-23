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
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.makeStoryButton) Button mMakeStoryButton;
    @Bind(R.id.baseGridView) GridView gridView;
    @Bind(R.id.rg) RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/scififont.TTF");
        Resources res = getResources();
        String [] userPrompts = res.getStringArray(R.array.user_input);
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
            for(int i = 0; i<userPrompts.length; i++){
                LinearLayout listLayout = (LinearLayout) gridView.getChildAt(i);
                EditText editField = (EditText) listLayout.getChildAt(0);
                allFields.add(editField.getText().toString());
            }
            int selectedRadioButtonID = radioGroup.getCheckedRadioButtonId();

            if(selectedRadioButtonID !=-1){
                RadioButton selectedRadioButton = (RadioButton) findViewById(selectedRadioButtonID);
                String selectedRadioButtonText = selectedRadioButton.getText().toString();
                Log.d("Radio text", selectedRadioButtonText);
            }

            Intent intent = new Intent(MainActivity.this, StoryActivity.class);
            intent.putStringArrayListExtra("allFields", allFields);
            startActivity(intent);
        }
    }

    public void onRadioButtonClicked(View view) {
        //Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_no:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }
}
