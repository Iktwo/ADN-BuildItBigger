package com.iktwo.jokeshow;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    public static final String JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_joke);

        String joke = getIntent().getStringExtra(JOKE);
        TextView textViewJoke = (TextView) findViewById(R.id.text_view_joke);
        textViewJoke.setText(joke);
    }
}
