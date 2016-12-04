package zipyatrip.travel;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CarPoolActivity extends Activity {
    Button btnToRiddle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_pool);
        btnToRiddle = (Button)findViewById(R.id.btnOpenApp);
        btnToRiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), riddleOneAct.class);
                startActivity(intent);
            }
        });
    }
}
