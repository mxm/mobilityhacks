package com.zipyatrip.zipyatrip.zipyatrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseMoodActivity extends Activity {
    Button btnMood1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_mood);

        btnMood1 = (Button)findViewById(R.id.btnMood1);
        btnMood1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ChooseYaTripActivity.class);
                startActivity(intent);
            }
        });
    }

}
