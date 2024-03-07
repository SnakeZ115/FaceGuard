package com.example.testing;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_PICK_IMAGE = 1;

    private ImageView imageView;
    private Button loadPhotoButton;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICK_IMAGE && resultCode == RESULT_OK && data != null) {
            // Obtiene la URI de la imagen seleccionada
            Uri imageUri = data.getData();
            // Muestra la imagen seleccionada en el ImageView
            imageView.setImageURI(imageUri);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        imageView = findViewById(R.id.image_view);
        loadPhotoButton = findViewById(R.id.button_load_photo);
        loadPhotoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abre una galería de imágenes para que el usuario seleccione una foto
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_PICK_IMAGE);
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        // Obtener el menú
        Menu menu = bottomNavigationView.getMenu();

        // Ocultar la opción "Perfil" eliminándola del menú
        menu.removeItem(R.id.navigation_registros);
        menu.removeItem(R.id.navigation_user);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(UserActivity.this, MainActivity.class));
                    finish();
                    break;
            }
            return false;
        });
    }
}
