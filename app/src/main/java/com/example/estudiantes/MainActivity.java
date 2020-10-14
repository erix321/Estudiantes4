package com.example.estudiantes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import Clases.*;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.textView_f);
    }
    public void onClick(View v){
        Intent intent=new Intent(this,Registro.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){
            if(resultCode==RESULT_OK){

                int cui=(int) data.getIntExtra("cui",0);
                String nombres=data.getStringExtra("nombres");
                String apellidos=data.getStringExtra("apellidos");

                tv.setText(""+cui);//Si pones solo cui te da error pero si lo captura como entero
            }else if(resultCode==RESULT_CANCELED){
                tv.setText("El Registro se Cancelo");
            }
        }
    }
}
