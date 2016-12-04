package zipyatrip.travel;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends Activity {
    EditText editTextFrom,editTextTo,editTime,editDate;
    Button btnChooseYaMood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        btnChooseYaMood = (Button)findViewById(R.id.btnChooseYaMood);
        editTime = (EditText)findViewById(R.id.etTime);
        editDate = (EditText)findViewById(R.id.etDate);

        Date d = new Date();

        String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        String currentTime = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        editTime.setText(currentTime);
        editDate.setText(currentDate);

        btnChooseYaMood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), ChooseMoodActivity.class);
                startActivity(intent);
            }
        });
/*
        editTextFrom = (EditText)findViewById(R.id.editTextFrom);
        editTextTo = (EditText)findViewById(R.id.editTextTo);

        editTextFrom.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View v) {
                                               // editTextFrom.setText("");
                                            }
        });*/




    }

}
