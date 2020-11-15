package com.juansosa.ingresardatos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    //Creo objetos de lo que estoy utilizando

    private EditText etNombre, etDescripcion, etEmail, etTelefono;

    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //En OnCreate se crea la relacion para que se comunique la parte logica
        //con la parte grafica

        etNombre        = (EditText) findViewById(R.id.editTextNombre);
        etTelefono      = (EditText) findViewById(R.id.editTextTelefono);
        etEmail         = (EditText) findViewById(R.id.editTextEmail);
        etDescripcion   = (EditText) findViewById(R.id.editTextDescripcionContacto);

        mDisplayDate    = (EditText) findViewById(R.id.etIngresarFecha);



        mDisplayDate.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                Calendar calendario = Calendar.getInstance();
                int anio = calendario.get(Calendar.YEAR);
                int mes = calendario.get(Calendar.MONTH);
                int dia = calendario.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this ,
                        android.R.style.Theme_Material_Dialog_MinWidth,
                        mDateSetListener,
                        anio, mes, dia );

                dialog.show();

            }

        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                String fecha = dayOfMonth + "/" + month + "/" + year ;
                mDisplayDate.setText(fecha);

            }


        };




        //Tomo los datos de MainActivity

        String string_nombre = getIntent().getStringExtra("string_etNombre");
        etNombre.setText(string_nombre);

        String string_fecha = getIntent().getStringExtra("string_etFecha");
        mDisplayDate.setText(string_fecha);

        String string_telefono = getIntent().getStringExtra("string_etTelefono");
        etTelefono.setText(string_telefono);

        String string_email = getIntent().getStringExtra("string_etEmail");
        etEmail.setText(string_email);

        String string_descripcion = getIntent().getStringExtra("string_etDescripcion");
        etDescripcion.setText(string_descripcion);




    }

    //Metodo para el boton siguiente

    public void siguiente(View view ){

        //Objeto Intent permite pasar de un Activity a otro
        Intent siguiente = new Intent(this, confirmarDatos.class );

        //Obtencion de parametros

        //Asigna al string "etNombre"  el texto del objeto de tipo Edit Text
        siguiente.putExtra("string_etNombre", etNombre.getText().toString());
        siguiente.putExtra("string_etTelefono", etTelefono.getText().toString());
        siguiente.putExtra("string_etEmail", etEmail.getText().toString());
        siguiente.putExtra("string_etDescripcion", etDescripcion.getText().toString());
        siguiente.putExtra("string_etIngresarFecha", mDisplayDate.getText().toString() );


        String nombre = etNombre.getText().toString();
        String telefono = etTelefono.getText().toString();
        String email = etEmail.getText().toString();

        if( nombre.length() == 0 ){
            Toast.makeText(this, "Debes ingresar un Nombre", Toast.LENGTH_LONG).show();
        }

        if( telefono.length() == 0 ){
            Toast.makeText(this, "Debes ingresar un Telefono", Toast.LENGTH_LONG).show();
        }

        if( email.length() == 0 ){
            Toast.makeText(this, "Debes ingresar un Email", Toast.LENGTH_LONG).show();
        }


        if( nombre.length() != 0 && telefono.length() != 0 && email.length() != 0 ){
            Toast.makeText(this, "Enviando solicitud", Toast.LENGTH_LONG).show();
            startActivity(siguiente);
        }

    }


}