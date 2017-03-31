package com.example.jalberssonplazas.baloncesto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Inicio extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        TimerTask tarea= new TimerTask()
        {
            @Override
            public void run()
            {
                Intent intent= new Intent(Inicio.this, registroActivity.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer=new Timer();
        timer.schedule(tarea, 4000);
    }
}
