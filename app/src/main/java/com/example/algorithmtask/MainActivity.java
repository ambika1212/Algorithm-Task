package com.example.algorithmtask;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NumberAdapter adapter;
    private String currentRule = "Even"; // Default rule

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 10)); // 10 columns

        // Set up number grid (1 to 100)
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }

        // Set up the adapter
        adapter = new NumberAdapter(numbers, currentRule);
        recyclerView.setAdapter(adapter);

        // Spinner to select rules
        Spinner ruleSpinner = findViewById(R.id.ruleSpinner);
        ruleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                currentRule = parent.getItemAtPosition(position).toString();
                adapter.setRule(currentRule);
                adapter.notifyDataSetChanged(); // Refresh grid with new rule
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
