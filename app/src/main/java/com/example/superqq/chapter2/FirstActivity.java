package com.example.superqq.chapter2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

//AppCompatActivity can not work with <requestWindowFeature(Window.FEATURE_NO_TITLE);>
//must change to Activity
public class FirstActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.first_layout);
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(FirstActivity.this, "you clicked Button 1", Toast.LENGTH_SHORT).show();
//            }

//            @Override
//            public void onClick(View v) {
//               finish();
//            }
//            @Override
//            public void onClick(View v) {
//                Intent indent = new Intent("com.example.superqq.chapter2.ACTION_START");
//                indent.addCategory("com.example.suprqq.chapter2.MY_CATEGORY");
//                startActivity(indent);
//            }

//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);

//            @Override
//            public  void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));
//                startActivity(intent);

//            @Override
//            public void onClick(View v) {
//                String data = "hello secondActivity";
//                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
//                intent.putExtra("extra_data", data);
//                startActivity(intent);

            @Override
            public void onClick(View v) {
               Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivityForResult(intent, 1);
            }

        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return  true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//       switch (item.getItemId()){
//           case R.id.add_item:
//               Toast.makeText(this, "You clicked add", Toast.LENGTH_SHORT).show();
//               break;
//           case R.id.remove_item:
//               Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
//               break;
//           default:
//               break;
//       }
//        return true;
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        String MENU_TAG = "LogDemo";
        Log.d(MENU_TAG , "before onCreateOptionsMenu ");
        getMenuInflater().inflate(R.menu.main, menu);
        Log.d(MENU_TAG , "after onCreateOptionsMenu ");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String MENUITEM_TAG = "LogDemo";
        Log.d(MENUITEM_TAG , "onOptionsItemSelected: ");
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("FirstActivity", "lll1");
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                }
                break;
            default:
        }
    }
}
