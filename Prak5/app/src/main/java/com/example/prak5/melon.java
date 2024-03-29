package com.example.prak5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.ArrayList;
import java.util.Collections;

public class melon extends AppCompatActivity {
    private ArrayList<String> melons = new ArrayList<>();
    private ArrayAdapter<String> melonAdapter;
    private Spinner melonSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_melon);

        // Получаем ресурсы массива строк из strings.xml
        String[] melonNames = getResources().getStringArray(R.array.mellon_array);

        // Добавляем элементы массива в список
        Collections.addAll(melons, melonNames);

        melonSpinner = findViewById(R.id.melon_spinner);

        // Создаем адаптер для списка выпадающего списка
        melonAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, melons);

        // Устанавливаем стиль для выпадающего списка (если необходимо)
        melonAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Устанавливаем адаптер для выпадающего списка
        melonSpinner.setAdapter(melonAdapter);
    }
}
