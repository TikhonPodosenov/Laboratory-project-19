package com.example.lab15_podosenov_tikhon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab15_podosenov_tikhon.R;

public class Second extends MyBaseActivity implements TextWatcher {
    private EditText editText;
    private Button button1;
    private Button button2;
    private String txt;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_act);
        editText=(EditText)findViewById(R.id.et);
        button1=(Button)findViewById(R.id.btn2);
        button2=(Button)findViewById(R.id.btn3);
        button1.setEnabled(false);
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            txt = extras.getString(EXTRA_TEXT);
            id = extras.getInt(EXTRA_ID);
        }
        editText.addTextChangedListener(this);
        editText.setText(txt);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        if(editText.getText().toString().trim().length() != 0){
            button1.setEnabled(true);
        }
        else button1.setEnabled(false);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    public void bOK(View view){
        Intent intent=getIntent();
        intent.putExtra(EXTRA_TEXT,editText.getText().toString());
        intent.putExtra(EXTRA_ID, id);
        setResult(RESULT_OK,intent);
        finish();
    }

    public void bCancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
}
