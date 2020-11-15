package com.juansosa.ingresardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class confirmarDatos extends AppCompatActivity {


    private TextView tvNombre;
    private TextView tvEmail;
    private TextView tvTelefono;
    private TextView tvFecha;
    private TextView tvDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvEmail  = (TextView) findViewById(R.id.tvEmail);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvFecha = (TextView) findViewById(R.id.tvFecha);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);


        //Tomo los datos de MainActivity

        String string_nombre = getIntent().getStringExtra("string_etNombre");
        tvNombre.setText(string_nombre);

        String string_telefono = getIntent().getStringExtra("string_etTelefono");
        tvTelefono.setText(string_telefono);

        String string_email = getIntent().getStringExtra("string_etEmail");
        tvEmail.setText(string_email);

        String string_fecha = getIntent().getStringExtra("string_etIngresarFecha");
        tvFecha.setText(string_fecha);

        String string_descripcion = getIntent().getStringExtra("string_etDescripcion");
        tvDescripcion.setText(string_descripcion);

    }

    public void editarDatos(View view){
        Intent editarDatos = new Intent(this, MainActivity.class);

        //Asigna al string "etNombre"  el texto del objeto de tipo Text view
        editarDatos.putExtra("string_etNombre", tvNombre.getText().toString());
        editarDatos.putExtra("string_etTelefono", tvTelefono.getText().toString());
        editarDatos.putExtra("string_etEmail", tvEmail.getText().toString());
        editarDatos.putExtra("string_etFecha", tvFecha.getText().toString());
        editarDatos.putExtra("string_etDescripcion", tvDescripcion.getText().toString());

        startActivity(editarDatos);



    }

}