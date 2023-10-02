package com.example.dateandtimepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private TextView txtDate,txtTime;
    private ImageView imgTime,imgDate;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        //date
        imgDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moManHinhDate();
            }
        });
        //time
        imgTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moManHinhTime();
            }
        });
    }

    private void moManHinhTime() {
        Calendar calendarTime = Calendar.getInstance();
        SimpleDateFormat simpleTimeFormat=new SimpleDateFormat("HH:mm");
       TimePickerDialog.OnTimeSetListener callback1 = new TimePickerDialog.OnTimeSetListener() {
           @Override
               public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
               calendarTime.set(Calendar.HOUR,hourOfDay);
               calendarTime.set(Calendar.MINUTE,minute);
               txtTime.setText(simpleTimeFormat.format(calendarTime.getTime()));
           }
       };
        TimePickerDialog dialog1=new TimePickerDialog(
                MainActivity.this,
                callback1,
                calendarTime.get(Calendar.HOUR),
                calendarTime.get(Calendar.MINUTE),
                true //đồng hồ hiển thị 24h , còn false thì 12 giờ
        );
        dialog1.show();
    }

    private void moManHinhDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

        DatePickerDialog.OnDateSetListener callback = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                //hien thi len giao dien
                 txtDate.setText(simpleDateFormat.format(calendar.getTime()));
            }
        };
        DatePickerDialog dialog=new DatePickerDialog(
                MainActivity.this,
                callback,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        dialog.show();
    }

    private void addControls() {
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtTime = (TextView) findViewById(R.id.txtTime);
        imgDate = (ImageView) findViewById(R.id.imgDate);
        imgTime = (ImageView) findViewById(R.id.imgTime);

    }
}