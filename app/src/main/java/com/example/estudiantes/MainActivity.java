package com.example.estudiantes;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.*;
public class MainActivity extends AppCompatActivity {
    ArrayList<String>datos;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datos=new ArrayList<String>();
        setContentView(R.layout.activity_main);


        //ArrayList<String> datos=new ArrayList<String>();

/*
        File archivo=null;
        archivo=new File("estudiantes.txt");

            try {
                if(!archivo.exists()) {
                    archivo.createNewFile();
                }
            } catch (IOException e) {
                Log.d("CREATION",e.getMessage());
                e.printStackTrace();
            }
        FileReader fr=null;
        BufferedReader br=null;
        try{
            fr=new FileReader(archivo);
            br=new BufferedReader(fr);
            String linea;
            while ((linea=br.readLine())!=null){
                datos.add(linea);
            }
        }catch (Exception e){}
        finally {
            try {
                if(null!=fr){
                    fr.close();
                }
            }catch (Exception e2){}
        }
        */

    }

    @Override
    protected void onResume() {
        super.onResume();
        list=(ListView)findViewById(R.id.lista_id);
        ArrayAdapter adaptador=new ArrayAdapter(this,android.R.layout.simple_list_item_1,datos);
        list.setAdapter(adaptador);
    }

    public void onClick(View v){
        Intent intent=new Intent(this,Registro.class);
        startActivityForResult(intent,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1){
            if (resultCode==RESULT_OK){
                int cui=(int) data.getIntExtra("cui",0);
                String nombres=data.getStringExtra("nombres");
                String apellidos=data.getStringExtra("apellidos");
                datos.add(cui+" : "+nombres+", "+apellidos);
            }else if(resultCode==RESULT_CANCELED){
                Log.d("MESSAGE","El registro ha sido cancelado");
            }
        }
    }
}
