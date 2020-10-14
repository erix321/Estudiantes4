package com.example.estudiantes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import Clases.Student;

public class Registro extends AppCompatActivity {

    private EditText nombres;
    private EditText apellidos;
    private EditText cui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        setTitle("Registro");

        nombres = findViewById(R.id.edit_nombres);
        apellidos = findViewById(R.id.edit_apellidos);
        cui = findViewById(R.id.edit_cui);

        Button aceptar = findViewById(R.id.aceptar);
        Button cancelar = findViewById(R.id.cancelar);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cui_n=Integer.parseInt(cui.getText().toString());
                String nombres_d=nombres.getText().toString();
                String apellidos_d=apellidos.getText().toString();

                Intent datosIntent = new Intent();
                datosIntent.putExtra("cui",cui_n);
                datosIntent.putExtra("nombres",nombres_d);
                datosIntent.putExtra("apellidos",apellidos_d);

                setResult(RESULT_OK,datosIntent);
                finish();
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent datosIntent = new Intent();
                setResult(RESULT_CANCELED,datosIntent);
                finish();
            }
        });
    }


}
