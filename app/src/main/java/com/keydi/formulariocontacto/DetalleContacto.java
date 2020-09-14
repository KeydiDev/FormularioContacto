package com.keydi.formulariocontacto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private TextView tvFecha;

    private Button buttonEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        Bundle param = getIntent().getExtras();
        String nombre = param.getString(getResources().getString(R.string.pnombre));
        String telefono = param.getString(getResources().getString(R.string.ptel));
        String email = param.getString(getResources().getString(R.string.pemail));
        String desc = param.getString(getResources().getString(R.string.pdescripcion));
        String date = param.getString(getResources().getString(R.string.pdate));

        tvNombre = findViewById(R.id.tvNombre);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescripcion = findViewById(R.id.tvDescripcion);
        tvFecha = findViewById(R.id.tvFecha);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(desc);
        tvFecha.setText(date);

        buttonEdit = findViewById(R.id.buttonEditar);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



}