package  com.abc.mytaskapplication.Utiles;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {

    public static String readStringFromAssete(Context context, String filename){

        String  i = "";
        try{
            InputStream inputStream = context.getAssets().open(filename);
             int size = inputStream.available();
             byte[] buffer = new byte[size];
             inputStream.read(buffer);
             inputStream.close();
             i = new String(buffer, "UTF-8");

        }catch (IOException e){
            e.printStackTrace();
        }
        return  i;
    }


    public static String readStringFromAsseteBuffer(Context context, String filename){

        String  i = "";
        try{
            InputStream inputStream = context.getAssets().open(filename);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String result = "";

            StringBuilder stringBuilder = new StringBuilder();
            while ((result = bufferedReader.readLine()) !=null){

                stringBuilder.append(result);
            }
            i = stringBuilder.toString();
            Toast.makeText(context,stringBuilder.toString(), Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            e.printStackTrace();
        }
        return  i;
    }
}
