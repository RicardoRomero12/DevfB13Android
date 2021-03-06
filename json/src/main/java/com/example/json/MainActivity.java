package com.example.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HashMap<String,String> map = new HashMap<>();
        map.put("name","Ricardo");
        map.put("lastName","Romero");
        map.put("age","24");


        JSONObject jsonObject = new JSONObject(map);
        try{
            String name = jsonObject.getString("name");
            Log.d("name",name);
        }catch (JSONException e){
            e.printStackTrace();
        }




        Log.d("json", jsonObject.toString());

    }
}
