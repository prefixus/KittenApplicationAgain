package com.example.rpraczyk.kittenapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean scared = false;
    static final String LOG_TAG = MainActivity.class.getName();
    Context mainActivityContext = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "onCreate");
        setContentView(R.layout.activity_main);

        TextView txView = (TextView) findViewById(R.id.textView);
        final ImageView kittenImg = (ImageView) findViewById(R.id.kitten_image);
        final Button kittenButt = (Button) findViewById(R.id.kitten_button);
        final Button activityButton = (Button) findViewById(R.id.lifecycle_button);

        txView.setText(R.string.app_hello_text);

        kittenButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!scared) {
                    kittenImg.setImageResource(R.drawable.scared_kitten);
                    kittenButt.setText(R.string.button_text_calm_down);
                    scared = true;
                } else {
                    kittenImg.setImageResource(R.drawable.lovely_kitten);
                    kittenButt.setText(R.string.button_text);
                    scared = false;
                }
            }
        });

        activityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mainActivityContext, LifecycleActivity.class);
                startActivity(intent);
            }
        });

        kittenImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent catDefinitionViewIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://pl.wikipedia.org/wiki/Kot_domowy"));
                startActivity(catDefinitionViewIntent);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "onStart");
    }

    @Override
    protected void onStop() {
        Log.i(LOG_TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(LOG_TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.i(LOG_TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LOG_TAG, "onRestart");
    }
}
