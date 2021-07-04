package com.example.jokesjsonapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.List;

public class CardsDataAdapter extends ArrayAdapter<String> {

    private Context context;
    private boolean click = true;

    public CardsDataAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position, final View contentView, ViewGroup parent) {
        ImageButton imageButton = contentView.findViewById(R.id.clickLike);

        ImageButton imageButton1 = contentView.findViewById(R.id.shareButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Clicked Like", Toast.LENGTH_LONG).show();
                if (click) {
                    imageButton.setImageResource(R.drawable.thumbup_filled);
                    click = false;
                } else {
                    imageButton.setImageResource(R.drawable.ic_baseline_thumb_up_24);
                    click = true;
                }
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Share it", Toast.LENGTH_LONG).show();
            }
        });
        TextView v = contentView.findViewById(R.id.content);
        v.setText(getItem(position));
        return contentView;
    }

}
