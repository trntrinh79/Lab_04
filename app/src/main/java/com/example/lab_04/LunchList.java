package com.example.lab_04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
public class LunchList extends Activity {
    private final Restaurant r =new Restaurant();
    @Override
    public void onCreate (Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);

        Button save = (Button)findViewById(R.id.save);

        save.setOnClickListener(onSave);
    }
    private  View.OnClickListener onSave = new View.OnClickListener() {
        public void onClick(View v) {
            EditText name = (EditText) findViewById(R.id.name);
            EditText address = (EditText) findViewById(R.id.etAddress);
            String nameString = name.getText().toString();
            String addressString = address.getText().toString();
            r.setName(name.getText().toString());
            r.setAddress(address.getText().toString());
            RadioGroup types = (RadioGroup) findViewById(R.id.types);
            switch (types.getCheckedRadioButtonId()) {
                case R.id.take_out: {
                    r.setType("Take out");
                    Toast.makeText( getApplicationContext(), nameString+" " + addressString+" " + "Take out", Toast.LENGTH_SHORT).show();
                }
                break;
                case R.id.sit_down: {
                    r.setType("Sit down");
                    Toast.makeText(getApplicationContext(), nameString+" " + addressString+" " + "Sit down", Toast.LENGTH_SHORT).show();
                    break;
                }
                case R.id.delivery: {


                    r.setType("Delivery");
                    Toast.makeText(getApplicationContext(), nameString+" " + addressString+" " + "Delivery", Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    };

}


