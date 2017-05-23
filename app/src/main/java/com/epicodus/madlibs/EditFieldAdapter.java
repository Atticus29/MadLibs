package com.epicodus.madlibs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

/**
 * Created by Guest on 5/23/17.
 */

public class EditFieldAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mFields;


    public EditFieldAdapter(Context context, String [] fields) {
       this.mContext = context;
        this.mFields =fields;
    }

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
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if(convertView == null){
            gridView = inflater.inflate(R.layout.edit_field_layout, null);
            EditText editField = (EditText) gridView.findViewById(R.id.editText);
            editField.setHint(mFields[position]);
        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }
}
