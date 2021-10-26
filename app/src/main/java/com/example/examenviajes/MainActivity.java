package com.example.examenviajes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_NUM_PASAJEROS = "hola";
    public static final String EXTRA_PRECIO_BILLETE = "adios";
    public static final String EXTRA_INGRESOS = "buenas";
    private EditText edt_numero_viajeros = null;
    private EditText edt_precio_viaje = null;
    private TextView txt_monstrar_precio = null;
    //--------------------------------------------------------------------------------------
    private int num_pasajeros = 0;
    private double precio_pasjeros = 0.0;
    private double ingresos = 0.0;

    //--------------------------------------------------------------------------------------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_numero_viajeros = (EditText) findViewById(R.id.edt_numero_personas);
        edt_precio_viaje = (EditText) findViewById(R.id.edt_precio_viaje);
        txt_monstrar_precio = (TextView) findViewById(R.id.txt_monstrar_ingresos);
    }

    public void ingresos(View view) {
        boolean errores = false;
        //--------------------------------------------------------------------------------------
        String texto = String.valueOf(edt_numero_viajeros.getText());

        if(!texto.isEmpty()){
            num_pasajeros = Integer.valueOf(texto);


        }
        else{
            edt_numero_viajeros.setError("Debes introducir el numero de pasajeros");
            errores = true;
        }
        //--------------------------------------------------------------------------------------
        String texto_precio = String.valueOf(edt_precio_viaje.getText());

        if(!texto_precio.isEmpty()){
            precio_pasjeros = Double.valueOf(texto_precio);


        }
        else{
            edt_numero_viajeros.setError("Debes introducir el precio del billete");
            errores = true;
        }
        //--------------------------------------------------------------------------------------
        if(errores == true){
            return;
        }
        //--------------------------------------------------------------------------------------
        double ingresos =  num_pasajeros * precio_pasjeros;
        txt_monstrar_precio.setText(String.valueOf(ingresos) + "€");

    }

    public void siguiente(View view) {
        boolean errores = false;
        //--------------------------------------------------------------------------------------
        String texto = String.valueOf(edt_numero_viajeros.getText());

        if(!texto.isEmpty()){
            num_pasajeros = Integer.valueOf(texto);


        }
        else{
            edt_numero_viajeros.setError("Debes introducir el numero de pasajeros");
            errores = true;
        }
        //--------------------------------------------------------------------------------------
        String texto_precio = String.valueOf(edt_precio_viaje.getText());

        if(!texto_precio.isEmpty()){
            precio_pasjeros = Double.valueOf(texto_precio);


        }
        else{
            edt_numero_viajeros.setError("Debes introducir el precio del billete");
            errores = true;
        }
        //--------------------------------------------------------------------------------------
        if(errores == true){
            return;
        }
        //--------------------------------------------------------------------------------------
        double ingresos =  num_pasajeros * precio_pasjeros;
        txt_monstrar_precio.setText(String.valueOf(ingresos) + "€");

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra(EXTRA_NUM_PASAJEROS, num_pasajeros);
        intent.putExtra(EXTRA_PRECIO_BILLETE, precio_pasjeros);
        intent.putExtra(EXTRA_INGRESOS, ingresos);
        startActivity(intent);
        //--------------------------------------------------------------------------------------
    }
}