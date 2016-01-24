package com.example.phonecall;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {
	private EditText et_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//���ز����ļ�
        //���ҵ���ť
        Button bt_dail = (Button) this.findViewById(R.id.bt_dail);
        //�����ı���
		et_number = (EditText) MainActivity.this.findViewById(R.id.et_number);

        bt_dail.setOnClickListener(new MyListener());//ע�����¼�
        
    }
    
    private class MyListener implements View.OnClickListener {
    	
    	@Override
    	public void onClick(View v) {
    		String number = et_number.getText().toString().trim();
    		if(number.isEmpty()){
    			Toast.makeText(MainActivity.this, "���벻��Ϊ�գ�", Toast.LENGTH_SHORT).show();
    			return;
    		}
    		else {
	    		Intent intent = new Intent();
	    		intent.setAction(Intent.ACTION_CALL);
	    		intent.setData(Uri.parse("tel:"+number));
	    		startActivity(intent);
	    		Log.d("MainActivity", "diaosi");
    		}
    	}
    	
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
