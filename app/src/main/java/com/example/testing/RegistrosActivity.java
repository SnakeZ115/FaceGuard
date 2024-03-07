package com.example.testing;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class RegistrosActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registros);

        // Obtener la referencia del TableLayout
        TableLayout tableLayout = findViewById(R.id.table_layout);

        // Crea una nueva fila para tus datos
        TableRow row = new TableRow(this);

        // Agrega la fecha
        TextView fechaTextView = new TextView(this);
        fechaTextView.setText("2024-02-28");
        fechaTextView.setPadding(8, 8, 8, 8);
        row.addView(fechaTextView);

        // Agrega la hora
        TextView horaTextView = new TextView(this);
        horaTextView.setText("14:00");
        horaTextView.setPadding(8, 8, 8, 8);
        row.addView(horaTextView);

        // Agrega el lugar
        TextView lugarTextView = new TextView(this);
        lugarTextView.setText("Lugar A");
        lugarTextView.setPadding(8, 8, 8, 8);
        row.addView(lugarTextView);

        // Agrega la fila al TableLayout
        tableLayout.addView(row);

        // Obtener referencia del BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);

        // Obtener el menú
        Menu menu = bottomNavigationView.getMenu();

        // Ocultar la opción "Perfil" eliminándola del menú
        menu.removeItem(R.id.navigation_registros);
        menu.removeItem(R.id.navigation_user);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(RegistrosActivity.this, MainActivity.class));
                    finish();
                    break;
            }
            return false;
        });
    }
}
