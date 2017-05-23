package com.epicodus.madlibs;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

public class InputFieldAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mFields;
    private Typeface mTypeface;

    @Override
    public int getCount() {
        return mFields.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if(convertView == null){
            gridView = inflater.inflate(R.layout.input_grid_item, null);

            TextView fieldView = (TextView) gridView
                    .findViewById(R.id.grid_item_field);

            fieldView.setText(mFields[position]);
            fieldView.setTypeface(mTypeface);
        }else{
            gridView = (View) convertView;
        }
        return gridView;
    }

    public InputFieldAdapter(Context context, String[] fields, Typeface typeface){
        this.mContext = context;
        this.mFields = fields;
        this.mTypeface = typeface;
    }
}
