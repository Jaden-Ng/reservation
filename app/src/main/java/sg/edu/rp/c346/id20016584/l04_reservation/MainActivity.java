package sg.edu.rp.c346.id20016584.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity {
    EditText name, phone, pax;
    DatePicker dp;
    TimePicker tp;
    RadioButton smoking, nonsmoking;
    TextView tvDisplay;
    Button cfm, reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.editTextTextPersonName);
        phone=findViewById(R.id.editTextPhone);
        pax=findViewById(R.id.editTextPax);
        dp=findViewById(R.id.datePicker);
        tp=findViewById(R.id.timePicker);
        smoking=findViewById(R.id.radioButtonSmoke);
        nonsmoking=findViewById(R.id.radioButtonNoSmoke);
        tvDisplay=findViewById(R.id.textViewDisplay);
        cfm=findViewById(R.id.buttonConfrim);
        reset=findViewById(R.id.buttonReset);

        cfm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String timeis="Time is "+ tp.getCurrentHour() +":"+ tp.getCurrentMinute();
                int day=dp.getDayOfMonth();
                int month=dp.getMonth() +1;
                int year=dp.getYear();
                String dateis="Date is "+day+"/"+month+"/"+year;
                String area="";
                if(smoking.isChecked()){
                    area="Smoking area";
                }else{
                    area="Non-smoking area";
                }
                String text="Name: "+name.getText()+"\nPhone: "+phone.getText()+"\nPax: "+pax.getText()+"\nTime: "+timeis+"\nDate: "+dateis
                +"\nArea: "+area;
                tvDisplay.setText(text);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 5, 1);
                name.setText("");
                phone.setText("");
                pax.setText("");
                smoking.setChecked(false);
                nonsmoking.setChecked(false);
                tvDisplay.setText("");
            }
        });

    }
}