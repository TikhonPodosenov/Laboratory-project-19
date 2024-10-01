package com.example.lab15_podosenov_tikhon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.lab15_podosenov_tikhon.R;
import com.example.lab15_podosenov_tikhon.adapters.MyAdapter;
import com.example.lab15_podosenov_tikhon.adapters.MyApp;

import java.util.List;

public class Main extends MyBaseActivity implements AdapterView.OnItemClickListener {
    private ListView listView;
    private Button button;
    protected MyApp myApp;
    public List<String> notes;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);
        listView = (ListView) findViewById(R.id.lv);
        button = (Button) findViewById(R.id.btn1);
        myAdapter = new MyAdapter(this);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);
        myApp= (MyApp)getApplicationContext();
        notes = myApp.getList();
    }

    public void toSecond(View view) {
        Intent intent = new Intent(this, Second.class);
        startActivityForResult(intent, CREATE_ACTION);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String txt = myAdapter.getItem(i).toString();
        Intent intent = new Intent(this, Second.class);
        intent.putExtra(EXTRA_TEXT, txt);
        intent.putExtra(EXTRA_ID, i);
        startActivityForResult(intent, EDIT_ACTION);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            String txt = extras.getString(EXTRA_TEXT);

            switch (requestCode) {
                case CREATE_ACTION:
                    notes.add(txt);
                    listView.invalidateViews();
                    break;
                case EDIT_ACTION:
                    int id = extras.getInt(EXTRA_ID);
                    notes.remove(myAdapter.getItem(id));
                    notes.add(id, txt);
                    listView.invalidateViews();
                    break;
            }
        }
    }
}
