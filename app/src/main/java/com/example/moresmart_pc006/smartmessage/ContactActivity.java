package com.example.moresmart_pc006.smartmessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class ContactActivity extends Activity implements AdapterView.OnItemClickListener{

    private String []objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lv = (ListView) findViewById(R.id.lv);

        lv.setOnItemClickListener(this);

        objects = new String[50];
        for( int i = 0; i<50; i++ )
        {
            objects[i]=""+(5050+i);
        }

        lv.setAdapter( new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,objects));
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent();

        intent.putExtra("num",objects[i]);

        setResult(RESULT_OK,intent);

        finish();

    }

}