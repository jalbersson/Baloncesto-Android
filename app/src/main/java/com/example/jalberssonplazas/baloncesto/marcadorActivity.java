package com.example.jalberssonplazas.baloncesto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class marcadorActivity extends AppCompatActivity implements View.OnClickListener
{

    Button btnSubir2, btnSubir3, btnBajar2, btnBajar3;
    TextView txtMarcador, txtNombreEquipo, txtResultado;
    int marcador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcador);

        Bundle datos= getIntent().getExtras();

        btnBajar2=(Button) findViewById(R.id.btnBajar2);
        btnBajar3=(Button) findViewById(R.id.btnBajar3);
        btnSubir2=(Button) findViewById(R.id.btnMas2);
        btnSubir3=(Button) findViewById(R.id.btnMas3);
        txtMarcador=(TextView) findViewById(R.id.txtMarcador);
        txtNombreEquipo=(TextView) findViewById(R.id.txtNombreEquipo);
        txtResultado=(TextView) findViewById(R.id.txtResultado);


        btnBajar2.setOnClickListener(this);
        btnBajar3.setOnClickListener(this);
        btnSubir2.setOnClickListener(this);
        btnSubir3.setOnClickListener(this);

        txtNombreEquipo.setText(datos.getString("nombreEquipo"));

        TimerTask tarea=new TimerTask()
        {
            @Override
            public void run()
            {
                calcularResultado();
                //finish();
            }
        } ;
        Timer timer=new Timer();
        timer.schedule(tarea, 6000);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btnBajar2:
                if((marcador-2)>=0)
                {
                    marcador=marcador-2;
                    txtMarcador.setText(marcador+"");
                }
                break;

            case R.id.btnBajar3:
                if((marcador-3)>=0)
                {
                    marcador=marcador-3;
                    txtMarcador.setText(marcador+"");
                }
                break;

            case R.id.btnMas2:
                marcador=marcador+2;
                txtMarcador.setText(marcador+"");
                break;

            case R.id.btnMas3:
                marcador=marcador+3;
                txtMarcador.setText(marcador+"");
                break;

        }
    }
    public  void calcularResultado()
    {
        runOnUiThread(new Runnable()
        {
            @Override
            public void run()
            {
                txtResultado.setText("El resultado final es: "+txtMarcador.getText());
            }
        });
    }
}
