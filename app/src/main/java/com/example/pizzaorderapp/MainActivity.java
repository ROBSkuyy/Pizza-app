package com.example.pizzaorderapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView pizzasRecyclerView;
    private PizzaAdapter pizzaAdapter;
    private List<Pizza> pizzaList;
    private List<Pizza> filteredPizzaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        TextView greetingTextView = findViewById(R.id.greetingTextView);
        EditText searchEditText = findViewById(R.id.searchEditText);
        TextView openPizzasTextView = findViewById(R.id.openPizzasTextView);
        pizzasRecyclerView = findViewById(R.id.pizzasRecyclerView);

        // Initialize pizza list
        pizzaList = new ArrayList<>();
        pizzaList.add(new Pizza("Pepperoni", "Pepperoni, Mozzarella, Tomato", "4.7", "Free", "20 min", R.drawable.pep_pizza));
        pizzaList.add(new Pizza("Mushroom Pizza", "Mushrooms, Mozzarella, Tomato", "4.7", "Free", "20 min", R.drawable.mush_pizza));
        pizzaList.add(new Pizza("Bacon Pizza", "Bacon, Mozzarella, Tomato", "4.7", "Free", "20 min", R.drawable.bacon_pizza));

        // Initialize filtered pizza list
        filteredPizzaList = new ArrayList<>(pizzaList);

        // Set up RecyclerView
        pizzasRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        pizzaAdapter = new PizzaAdapter(pizzaList);
        pizzasRecyclerView.setAdapter(pizzaAdapter);

        // Add TextWatcher to search bar
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filterPizzaList(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Not used
            }
        });
    }

    private void filterPizzaList(String query) {
        filteredPizzaList.clear();
        if (query.isEmpty()) {
            filteredPizzaList.addAll(pizzaList);
        } else {
            for (Pizza pizza : pizzaList) {
                if (pizza.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredPizzaList.add(pizza);
                }
            }
        }
        pizzaAdapter.notifyDataSetChanged();
    }
}