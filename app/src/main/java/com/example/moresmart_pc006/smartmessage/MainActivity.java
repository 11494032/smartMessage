package com.example.moresmart_pc006.smartmessage;

import android.app.Activity;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import com.example.moresmart_pc006.smartmessage.CommonActivity;
import com.example.moresmart_pc006.smartmessage.ContactActivity;

public class MainActivity extends Activity {



    private static final int REQUESTNUM = 1;
    private static final int REQUESTSMS = 2;

    private EditText et_num;
    private EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_num = (EditText) findViewById( R.id.et_num );
        et_content = (EditText) findViewById( R.id.et_content);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if( data == null )
            return;
        switch (requestCode) {
            case REQUESTNUM: {
                String num = data.getStringExtra("num");
                et_num.setText( num );
            }
            break;
            case REQUESTSMS:
            {
                String sms = data.getStringExtra("sms");
                et_content.setText( sms );
            }
            break;
            default:
                break;
        }
    }

    //启动新的界面
    public void chooseNum( View view )
    {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivityForResult(intent,REQUESTNUM);


    }

    public void send( View view )
    {
        String num = et_num.getText().toString().trim();

        String sms = et_content.getText().toString().trim();

        if( num == null || sms == null )
        {
            Toast.makeText(this, "号码和内容不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        SmsManager smsManager = SmsManager.getDefault();

        ArrayList<String> arrayList =  smsManager.divideMessage(sms);
        //ArrayList<String> parts, ArrayList<PendingIntent> sentIntents, ArrayList<PendingIntent> deliveryIntents
        smsManager.sendMultipartTextMessage(num,null,arrayList,null,null);

        Toast.makeText(this, "短信发送成功", Toast.LENGTH_SHORT).show();

    }

    public void selectSend( View view )
    {
        Intent intent = new Intent( this, CommonActivity.class );
        startActivityForResult( intent,REQUESTSMS );

    }


}
