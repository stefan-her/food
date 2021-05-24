package be.stefan.food;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import be.stefan.food.R;
import be.stefan.food.models.Food;
import be.stefan.food.models.FoodRecycleViewAdapter;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private ArrayList foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildActionBar();
        buildSpinner(findViewById(R.id.sp_type));
        buildRecyclerView();
    }

    private void buildRecyclerView() {
        ArrayList<Food> listItem = new ArrayList<>();
        listItem.add(new Food("oignon", 10, Food.CatFood.VEGETABLE));
        listItem.add(new Food("steak", 500, Food.CatFood.MEAT));
        listItem.add(new Food("apple", 80, Food.CatFood.FRUIT));
        listItem.add(new Food("peer", 80, Food.CatFood.FRUIT));

        RecyclerView rv_mainFoods = findViewById(R.id.rv_main_foods);
        rv_mainFoods.setHasFixedSize(false);

        FoodRecycleViewAdapter adapter = new FoodRecycleViewAdapter(listItem);
        rv_mainFoods.setAdapter(adapter);
        rv_mainFoods.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    }

    private void buildActionBar() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.food);
    }

    private void buildSpinner(Spinner obj) {
        ArrayList<String> catFood = new ArrayList<>();
        catFood.add(getString(R.string.vegetable));
        catFood.add(getString(R.string.meat));
        catFood.add(getString(R.string.fruit));

        ArrayAdapter<String> spinnerAd = new ArrayAdapter<>(
                getApplicationContext(),
                android.R.layout.simple_spinner_item,
                android.R.id.text1,
                catFood
        );

        spinnerAd.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        obj.setAdapter(spinnerAd);
    }
}