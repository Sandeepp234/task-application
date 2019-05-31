package com.abc.mytaskapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
  Button btnTaskList;
  Button btnJson;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btnTaskList = findViewById(R.id.btn_viewtask);
       btnJson = findViewById(R.id.btn_Json);

       btnTaskList.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, ListActivity.class);
            startActivity(intent);
           }
       });



       btnJson.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this, JsonActivity.class);
               startActivity(intent);
           }
       });
    }
}
