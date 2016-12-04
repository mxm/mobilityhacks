package com.zipyatrip.zipyatrip.zipyatrip;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class riddleOneAct extends Activity {
    Button btnToRiddle2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle1);
        btnToRiddle2 = (Button)findViewById(R.id.btnGo2);
        btnToRiddle2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), riddle2.class);
                startActivity(intent);
            }
        });
    }
}
