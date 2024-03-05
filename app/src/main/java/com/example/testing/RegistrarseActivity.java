package com.example.testing;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RegistrarseActivity extends AppCompatActivity {
    private Button registrarse;
    private Button salir;
    private EditText textNombre;
    private EditText textApellidos;
    private EditText textTelefono;
    private EditText textCorreo;

    public void setVentana(String titulo, String desc) {
        AlertDialog.Builder builder = new AlertDialog.Builder(RegistrarseActivity.this);
        builder.setTitle(titulo);
        builder.setMessage(desc);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        registrarse = findViewById(R.id.buttonRegistrarse);
        salir = findViewById(R.id.buttonSalir);

        textNombre = findViewById(R.id.editTextNombre);
        textApellidos = findViewById(R.id.editTextApellidos);
        textTelefono = findViewById(R.id.editTextTelefono);
        textCorreo = findViewById(R.id.editTextEmail);

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = textNombre.getText().toString().trim();
                String apellidos = textApellidos.getText().toString().trim();
                String telefono = textTelefono.getText().toString().trim();
                String correo = textCorreo.getText().toString().trim();

                if(!nombre.isEmpty() && !apellidos.isEmpty() && !telefono.isEmpty() && !correo.isEmpty()) {
                    setVentana("Registro", "Registro Completado");
                    startActivity(new Intent(RegistrarseActivity.this, LoginActivity.class));
                    finish();
                }
                else {
                    setVentana("Error", "Favor de rellenar correctamente los datos");
                }
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrarseActivity.this, LoginActivity.class));
                finish();
            }
        });

    }
}
