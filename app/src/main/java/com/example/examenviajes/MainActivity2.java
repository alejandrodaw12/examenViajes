package com.example.examenviajes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private int num_pasajeros = 0;
    private double precio_billete = 0.0;
    private double ingresos = 0.0;
    private double gastos = 0.0;
    private double total = 0.0;

    //--------------------------------------------------------------------------------------

    private TextView txt_valor_numpasajero2 = null;
    private TextView txt_precio_viaje2 = null;
    private TextView txt_precio_ingresos2 = null;
    private TextView txt_precio_gastos2 = null;
    private TextView txt_precio_final = null;
    private EditText edt_precio_autubus2 = null;

    //--------------------------------------------------------------------------------------

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt_valor_numpasajero2 = (TextView) findViewById(R.id.txt_num_pasajeros2);
        txt_precio_viaje2 = (TextView) findViewById(R.id.txt_precio_viaje2);
        txt_precio_ingresos2 = (TextView) findViewById(R.id.txt_precio_ingresos2);
        txt_precio_gastos2 = (TextView) findViewById(R.id.txt_precio_gastos2);
        txt_precio_final = (TextView) findViewById(R.id.txt_precio_total2);
        edt_precio_autubus2 = (EditText) findViewById(R.id.edt_precio_autobus);

        //--------------------------------------------------------------------------------------

        Intent intent = getIntent();
        if(intent != null){
            num_pasajeros = intent.getIntExtra(MainActivity.EXTRA_NUM_PASAJEROS, 0);
            txt_valor_numpasajero2.setText(String.valueOf(num_pasajeros) + "€");

            //--------------------------------------------------------------------------------------

            precio_billete = intent.getDoubleExtra(MainActivity.EXTRA_PRECIO_BILLETE, 0.0);
            txt_precio_viaje2.setText(String.valueOf(precio_billete) + "€");

            //--------------------------------------------------------------------------------------

            ingresos = intent.getDoubleExtra(MainActivity.EXTRA_INGRESOS, 0.0);
            txt_precio_ingresos2.setText(String.valueOf(ingresos) + "€");

            //--------------------------------------------------------------------------------------

            total = ingresos - gastos;
            txt_precio_gastos2.setText(String.valueOf(gastos)+ "€");
            txt_precio_final.setText(String.valueOf(total)+ "€");

            //--------------------------------------------------------------------------------------
            Toast.makeText(this, "Numero de pasajeros ->" + String.valueOf(num_pasajeros),Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Precio del billete ->" + String.valueOf(precio_billete),Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Ingresos  ->" + String.valueOf(ingresos),Toast.LENGTH_SHORT).show();
        }
    }

    public void aplicar(View view) {
        String texto_precio_autubus = String.valueOf(edt_precio_autubus2.getText());
        if(!texto_precio_autubus.isEmpty()) {
            gastos = Double.valueOf(texto_precio_autubus);
            total = ingresos - gastos;
            txt_precio_gastos2.setText(String.valueOf(gastos) + "€");
            txt_precio_final.setText(String.valueOf(total) + "€");
        }
        else{
            edt_precio_autubus2.setError("Introduce el precio del autobus");
        }
    }
}