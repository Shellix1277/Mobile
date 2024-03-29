package com.example.prak5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> users = new ArrayList<String>();
    ArrayList<String> selectedUsers = new ArrayList<String>();
    ArrayAdapter<String> usersAdapter;
    ListView usersListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] userNames = getResources().getStringArray(R.array.fruit_array);
        // добавляем начальные элементы
        Collections.addAll(users, userNames);

        usersListView = findViewById(R.id.my_list_view);
        usersAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, // Используем простой макет для элемента списка
                users);
        usersListView.setAdapter(usersAdapter);

        usersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        // Переход к первой активности
                        startActivity(new Intent(MainActivity.this, Apple.class));
                        break;
                    case 1:
                        // Переход ко второй активности
                        startActivity(new Intent(MainActivity.this, Pear.class));
                        break;
                    case 2:
                        // Переход к третьей активности
                        startActivity(new Intent(MainActivity.this, Orange.class));
                        break;
                    // Добавьте другие кейсы по мере необходимости
                    case 3:
                        // Переход к третьей активности
                        startActivity(new Intent(MainActivity.this, melon.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
