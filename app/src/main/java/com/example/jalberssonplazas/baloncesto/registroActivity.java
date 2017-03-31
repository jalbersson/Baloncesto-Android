package com.example.jalberssonplazas.baloncesto;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registroActivity extends AppCompatActivity
{

    Button btnMarcador, btnFacebook;
    EditText etxtNombre, etxtCiudad, etxtNjugadores;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        btnMarcador= (Button) findViewById(R.id.btnMarcador);
        etxtCiudad= (EditText) findViewById(R.id.etxtCiudad);
        etxtNombre= (EditText) findViewById(R.id.etxtNombre);
        etxtNjugadores= (EditText) findViewById(R.id.etxtNjugadores);
        btnFacebook= (Button) findViewById(R.id.btnFacebook);

        btnFacebook.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://oferta.senasofiaplus.edu.co/sofia-oferta/"));
                startActivity(intent);
            }
        });
        btnMarcador.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent= new Intent(registroActivity.this, marcadorActivity.class);
                intent.putExtra("nombreEquipo", etxtNombre.getText().toString());
                intent.putExtra("ciudad", etxtCiudad.getText().toString());
                intent.putExtra("nJugadores", etxtNjugadores.getText().toString());
                startActivity(intent);
            }
        });
    }
}
