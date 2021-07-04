package com.example.jokesjsonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jokesjsonapp.model.Jokes;
import com.wenchao.cardstack.CardStack;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CardStack.CardEventListener {

    CardStack mCardStack;
    CardsDataAdapter mCardAdapter;
    private final List<Jokes> alljokes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mCardStack = findViewById(R.id.container);

        mCardStack.setContentResource(R.layout.card_layout);
        mCardStack.setStackMargin(20);

        mCardAdapter = new CardsDataAdapter(getApplicationContext(), 0);

        try {
            JSONObject jsonObject = new JSONObject(loadJSONFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("fat");
            addJokesToArrayList(jsonArray, alljokes);
            JSONArray jsonArray1 = jsonObject.getJSONArray("stupid");
            addJokesToArrayList(jsonArray1, alljokes);
            JSONArray jsonArray2 = jsonObject.getJSONArray("ugly");
            addJokesToArrayList(jsonArray2, alljokes);
            JSONArray jsonArray3 = jsonObject.getJSONArray("nasty");
            addJokesToArrayList(jsonArray3, alljokes);
            JSONArray jsonArray4 = jsonObject.getJSONArray("odor");
            addJokesToArrayList(jsonArray4, alljokes);
            JSONArray jsonArray5 = jsonObject.getJSONArray("hairy");
            addJokesToArrayList(jsonArray5, alljokes);
            JSONArray jsonArray6 = jsonObject.getJSONArray("bald");
            addJokesToArrayList(jsonArray6, alljokes);
            JSONArray jsonArray7 = jsonObject.getJSONArray("old");
            addJokesToArrayList(jsonArray7, alljokes);
            JSONArray jsonArray8 = jsonObject.getJSONArray("poor");
            addJokesToArrayList(jsonArray8, alljokes);
            JSONArray jsonArray9 = jsonObject.getJSONArray("short");
            addJokesToArrayList(jsonArray9, alljokes);
            JSONArray jsonArray10 = jsonObject.getJSONArray("skinny");
            addJokesToArrayList(jsonArray10, alljokes);
            JSONArray jsonArray11 = jsonObject.getJSONArray("tall");
            addJokesToArrayList(jsonArray11, alljokes);
            JSONArray jsonArray12 = jsonObject.getJSONArray("got");
            addJokesToArrayList(jsonArray12, alljokes);
            JSONArray jsonArray13 = jsonObject.getJSONArray("like");
            addJokesToArrayList(jsonArray13, alljokes);
            JSONArray jsonArray14 = jsonObject.getJSONArray("misc");
            addJokesToArrayList(jsonArray14, alljokes);


        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }

        for (Jokes jokes : alljokes) {
            mCardAdapter.add(jokes.getJokesText());
        }


        mCardStack.setAdapter(mCardAdapter);
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = this.getAssets().open("jokes.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    private void addJokesToArrayList(JSONArray jsonArray, List<Jokes> arrayList) {
        try {
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    arrayList.add(new Jokes(jsonArray.getString(i), false));
                }
            }
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
    }

    @Override
    public boolean swipeEnd(int section, float distance) {
        return (distance > 300) ? true : false;
    }

    @Override
    public boolean swipeStart(int section, float distance) {
        return true;
    }

    @Override
    public boolean swipeContinue(int section, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void discarded(int mIndex, int direction) {

    }

    @Override
    public void topCardTapped() {

    }
}