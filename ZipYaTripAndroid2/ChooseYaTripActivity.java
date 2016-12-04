package com.zipyatrip.zipyatrip.zipyatrip;



import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChooseYaTripActivity extends Activity {
    Button btnTripOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_ya_trip);
        btnTripOne = (Button)findViewById(R.id.btnTrip1);
        btnTripOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), CarPoolActivity.class);
                startActivity(intent);
            }
        });
    }
}
