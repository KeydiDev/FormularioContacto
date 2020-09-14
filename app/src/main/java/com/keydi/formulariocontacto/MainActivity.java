package com.keydi.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText etPlannedDate;
    TextInputEditText nombre;
    TextInputEditText telefono;
    TextInputEditText email;
    TextInputEditText descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPlannedDate = findViewById(R.id.etPlannedDate);

        nombre = findViewById(R.id.ti_nombre);
        telefono = findViewById(R.id.ti_telefono);
        email = findViewById(R.id.ti_email);
        descripcion = findViewById(R.id.ti_descripcion);

        button = findViewById(R.id.next);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                Bundle bundle = new Bundle();
                bundle.putString(getResources().getString(R.string.pnombre), String.valueOf(nombre.getText()));
                bundle.putString(getResources().getString(R.string.ptel), String.valueOf(telefono.getText()));
                bundle.putString(getResources().getString(R.string.pemail), String.valueOf(email.getText()));
                bundle.putString(getResources().getString(R.string.pdescripcion), String.valueOf(descripcion.getText()));
                bundle.putString(getResources().getString(R.string.pdate), String.valueOf(etPlannedDate.getText()));
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        EditText etPlannedDate = (EditText) findViewById(R.id.etPlannedDate);
        etPlannedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                // +1 because January is zero
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                etPlannedDate.setText(selectedDate);
            }
        });

        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}