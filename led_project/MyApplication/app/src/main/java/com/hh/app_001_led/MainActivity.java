package com.hh.app_001_led;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import com.hh.hardlibrary.*;

public class MainActivity extends AppCompatActivity {

    private boolean ledon = false;
    private Button button = null;
    private CheckBox checkBoxled0 = null;
    private CheckBox checkBoxled1 = null;
    private CheckBox checkBoxled2 = null;
    private CheckBox checkBoxled3 = null;

    class MyButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            ledon = !ledon;

            if (ledon) {
                button.setText("ALL OFF");
                checkBoxled0.setChecked(true);
                checkBoxled1.setChecked(true);
                checkBoxled2.setChecked(true);
                checkBoxled3.setChecked(true);

                for(int i = 0; i < 4; i++)
                    HardControl.ledCtrl(i, 1);

            }
            else {
                button.setText("ALL ON");
                checkBoxled0.setChecked(false);
                checkBoxled1.setChecked(false);
                checkBoxled2.setChecked(false);
                checkBoxled3.setChecked(false);

                for(int i = 0; i < 4; i++)
                    HardControl.ledCtrl(i, 0);
            }
        }
    }

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.LED0:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED0 ON", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED0 OFF", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(0, 0);
                }
                break;

            case R.id.LED1:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED1 ON", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED1 OFF", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(1, 0);
                }
                break;

            case R.id.LED2:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED2 ON", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED2 OFF", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(2, 0);
                }
                break;

            case R.id.LED3:
                if (checked) {
                    Toast.makeText(getApplicationContext(), "LED3 ON", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 1);
                }
                else {
                    Toast.makeText(getApplicationContext(), "LED3 OFF", Toast.LENGTH_SHORT).show();
                    HardControl.ledCtrl(3, 0);
                }
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HardControl.ledOpen();

        button = (Button) findViewById(R.id.BUTTON);
        checkBoxled0 = (CheckBox) findViewById(R.id.LED0);
        checkBoxled1 = (CheckBox) findViewById(R.id.LED1);
        checkBoxled2 = (CheckBox) findViewById(R.id.LED2);
        checkBoxled3 = (CheckBox) findViewById(R.id.LED3);

        button.setOnClickListener(new MyButtonListener());


        /*
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ledon = !ledon;

                if (ledon)
                    button.setText("ALL ON");
                else
                    button.setText("ALL OFF");
            }
        }); */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
