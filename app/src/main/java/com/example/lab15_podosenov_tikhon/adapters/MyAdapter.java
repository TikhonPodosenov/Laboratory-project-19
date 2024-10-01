package com.example.lab15_podosenov_tikhon.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lab15_podosenov_tikhon.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    protected MyApp myApp;
    public List<String> words;

    public MyAdapter(Context context){
        this.context = context;
        myApp = (MyApp)context.getApplicationContext();
        words = myApp.getList();
    }

    @Override
    public int getCount() {
        return words.size();
    }

    @Override
    public Object getItem(int i) {
        return words.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        Context context = parent.getContext();
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.lv_element, parent, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.tv2);
        textView.setText(words.get(i));
        return view;
    }
}
