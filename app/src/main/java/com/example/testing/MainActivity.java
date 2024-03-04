package com.example.testing;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_registros:
                    startActivity(new Intent(MainActivity.this, RegistrosActivity.class));
                    finish();
                    break;
                case R.id.navigation_home:
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                    break;
            }
            return false;
        });

        // Generar el código QR
        String data = "Hola, este es un código QR de ejemplo.";
        int width = 500;
        int height = 500;
        Bitmap qrCodeBitmap = QRCodeGenerator.generateQRCode(data, width, height);

        // Mostrar el código QR en un ImageView
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap(qrCodeBitmap);
    }
}
