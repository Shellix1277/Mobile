package com.example.prak5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;

public class Apple extends AppCompatActivity {
    private ArrayList<String> apples = new ArrayList<>();
    private ArrayList<String> selectedApples = new ArrayList<>();
    private ArrayAdapter<String> applesAdapter;
    private ListView applesListView;
    private EditText editText;
    private Button addButton;
    private Button removeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apple);

        // Получаем ресурсы массива строк из strings.xml
        String[] appleNames = getResources().getStringArray(R.array.apples_array);

        // Добавляем элементы массива в список
        Collections.addAll(apples, appleNames);

        applesListView = findViewById(R.id.apple_view);

        // Создаем адаптер для списка с мультивыбором
        applesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, apples);

        // Устанавливаем адаптер для списка
        applesListView.setAdapter(applesAdapter);

        // Разрешаем мультивыбор в ListView
        applesListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        // Находим EditText и кнопки
        editText = findViewById(R.id.adder);
        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.deleteButton);

        // Обработчик события для кнопки добавления
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newApple = editText.getText().toString();
                if (!newApple.isEmpty()) {
                    apples.add(newApple);
                    applesAdapter.notifyDataSetChanged();
                    editText.setText("");
                }
            }
        });

        // Обработчик события для кнопки удаления
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получаем индексы выбранных элементов
                for (int i = apples.size() - 1; i >= 0; i--) {
                    if (applesListView.isItemChecked(i)) {
                        selectedApples.add(apples.get(i));
                        apples.remove(i);
                    }
                }
                // Очищаем выбранные элементы в ListView
                applesListView.clearChoices();
                applesAdapter.notifyDataSetChanged();
            }
        });
    }
}


