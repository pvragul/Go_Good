package com.pvrcommunication.gogood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;

public class HomeScreen extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> userName = new ArrayList<>();
    ArrayList<String> email = new ArrayList<>();
    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> phone = new ArrayList<>();
    ArrayList<String> website = new ArrayList<>();
    ArrayList<String> address = new ArrayList<>();
    ArrayList<String> street = new ArrayList<>();
    ArrayList<String> suite = new ArrayList<>();
    ArrayList<String> city = new ArrayList<>();
    ArrayList<String> zipcode = new ArrayList<>();
    ArrayList<String> companyname = new ArrayList<>();
    ArrayList<String> companycp = new ArrayList<>();
    ArrayList<String> companybs = new ArrayList<>();
    ArrayList<String> geolat = new ArrayList<>();
    ArrayList<String> geolng = new ArrayList<>();

    //ImageButton geo_btn = findViewById(R.id.receivedgeoLocation);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);


        try {
            JSONObject jsonObject = new JSONObject(Objects.requireNonNull(JsonDataFromAsset()));
            JSONArray jsonArray = jsonObject.getJSONArray("users");
            for (int i=0; i<jsonArray.length();i++){
                JSONObject userData = jsonArray.getJSONObject(i);
                id.add(userData.getString("id"));
                name.add(userData.getString("name"));
                userName.add(userData.getString("username"));
                email.add(userData.getString("email"));
                phone.add(userData.getString("phone"));
                website.add(userData.getString("website"));
                JSONObject addressObj = userData.getJSONObject("address");
                street.add(addressObj.getString("street"));
                suite.add(addressObj.getString("suite"));
                city.add(addressObj.getString("city"));
                zipcode.add(addressObj.getString("zipcode"));
                JSONObject comp = userData.getJSONObject("company");
                companyname.add(comp.getString("name"));
                companycp.add(comp.getString("catchPhrase"));
                companybs.add(comp.getString("bs"));
                JSONObject geoloc = addressObj.getJSONObject("geo");
                geolat.add(geoloc.getString("lat"));
                geolng.add(geoloc.getString("lng"));

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        HelperAdapter helperAdapter = new HelperAdapter(id, name, userName, email, phone, website, street,suite,
                city,zipcode, companyname, companycp,companybs, /*geolat, geolng,*/ HomeScreen.this);
        recyclerView.setAdapter(helperAdapter);

        /*geo_btn.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("google.streetview:cbll="+geolat+","+geolng));
            intent.setPackage("com.google.android.apps.maps");
            startActivity(intent);
        });*/

    }




    private String JsonDataFromAsset() {


        String json;
        try {
            InputStream inputStream = getAssets().open("users.json");
            int sizeoffile = inputStream.available();
            byte[] bufferData = new byte[sizeoffile];
            //noinspection ResultOfMethodCallIgnored
            inputStream.read(bufferData);
            inputStream.close();
            json = new String(bufferData, StandardCharsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}