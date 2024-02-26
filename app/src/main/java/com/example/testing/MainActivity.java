package com.example.testing;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);

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
