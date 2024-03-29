package com.example.prak5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;

public class Orange extends AppCompatActivity {
    ArrayList<String> oranges = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orange);

        // Получаем ресурсы массива строк из strings.xml
        String[] orangeNames = getResources().getStringArray(R.array.oranges_array);

        // Добавляем элементы массива в список
        Collections.addAll(oranges, orangeNames);

        // Находим LinearLayout, в который будем добавлять элементы списка
        LinearLayout orangeListLayout = findViewById(R.id.orange_list);

        // Динамически создаем и добавляем элементы списка
        for (String orange : oranges) {
            TextView textView = new TextView(this);
            textView.setText(orange);
            orangeListLayout.addView(textView);
        }
    }
}
