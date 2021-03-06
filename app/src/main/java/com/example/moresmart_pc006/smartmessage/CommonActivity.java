package com.example.moresmart_pc006.smartmessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.moresmart_pc006.smartmessage.R;

public class CommonActivity extends Activity implements AdapterView.OnItemClickListener{

    private String[] objects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView lv = (ListView) findViewById( R.id.lv );

        lv.setOnItemClickListener(this);
        objects = new String[50];
        for( int i = 0; i < 50; i++ )
        {
            objects[i] = "发送的信息："+i;
        }
        lv.setAdapter( new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,objects));






    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Intent intent = new Intent();

        intent.putExtra("sms",objects[i]);

        setResult(RESULT_OK,intent);

        finish();


    }
}