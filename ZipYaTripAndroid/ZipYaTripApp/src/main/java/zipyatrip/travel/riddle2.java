package zipyatrip.travel;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class riddle2 extends Activity {
    Button btnToRiddle3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riddle2);
        btnToRiddle3 = (Button)findViewById(R.id.btnGo3);
        btnToRiddle3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), riddle3.class);
                startActivity(intent);
            }
        });
    }
}
