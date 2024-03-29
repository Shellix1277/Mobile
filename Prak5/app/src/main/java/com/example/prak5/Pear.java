package com.example.prak5;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;

public class Pear extends AppCompatActivity {
    private ArrayList<String> pears = new ArrayList<>();
    private RecyclerView pearRecyclerView;
    private PearView pearAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pear);

        // Получаем ресурсы массива строк из strings.xml
        String[] pearNames = getResources().getStringArray(R.array.pears_array);

        // Добавляем элементы массива в список
        Collections.addAll(pears, pearNames);

        pearRecyclerView = findViewById(R.id.recycleview);
        pearRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        pearAdapter = new PearView(this, pears);
        pearRecyclerView.setAdapter(pearAdapter);
    }
}










