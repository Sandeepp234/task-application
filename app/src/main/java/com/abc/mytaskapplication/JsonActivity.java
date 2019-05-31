package com.abc.mytaskapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.abc.mytaskapplication.Utiles.Utils;

import java.io.File;
import java.io.FileOutputStream;

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);

//        String s = Utils.readStringFromAssete(this, "task.json");
//
//        Toast.makeText(JsonActivity.this, s, Toast.LENGTH_SHORT).show();

        Utils.readStringFromAsseteBuffer(this, "task.json");

        try {
            File sdcard = Environment.getExternalStorageDirectory();
            File file = new File(Environment.getExternalStorageDirectory() + "/hell");
            file.mkdir();
            if (!file.exists()) {
                file.exists();
            }

            File dir = new File(sdcard.getAbsolutePath() + "/myfolder/");

            File file1 = new File(dir, "hello.txt");

            FileOutputStream outputStream = new FileOutputStream(file1);
            String data = "hekfsdklfslkdfd sfdskfsd,f";
            outputStream.write(data.getBytes()
            );
        }catch (Exception e){
            e.printStackTrace();
        }




    }



}
