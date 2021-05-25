package be.stefan.food;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Field;
import java.util.ArrayList;

import be.stefan.food.models.Food;
import be.stefan.food.adapters.FoodRecycleViewAdapter;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private ArrayList<Food> foods;
    private Button bt_add;
    private EditText foodName, foodCal;
    private Spinner foodType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foods = new ArrayList<>();

        buildActionBar();
        buildSpinner(findViewById(R.id.sp_type));
        buildRecyclerView();


        bt_add = findViewById(R.id.bt_add);
        bt_add.setOnClickListener(v -> { addFood(); });
    }

    private void addFood() {
        foodName = (EditText) findViewById(R.id.txt_food);
        foodCal = (EditText) findViewById(R.id.text_kcal);
        foodType = (Spinner) findViewById(R.id.sp_type);

        Log.d("value -------> ", String.valueOf(foodType.getSelectedItemId()));



//        foods.add(new Food(foodName.getText().toString(),
//                Integer.parseInt(foodCal.getText().toString()),
//                (Food.CatFood) foodType.getSelectedItem()));
    }

    private void buildRecyclerView() {

        foods.add(new Food("oignon", 10, Food.CatFood.VEGETABLE));
        foods.add(new Food("steak", 500, Food.CatFood.MEAT));
        foods.add(new Food("apple", 80, Food.CatFood.FRUIT));
        foods.add(new Food("peer", 80, Food.CatFood.FRUIT));

        RecyclerView rv_mainFoods = findViewById(R.id.rv_main_foods);
        rv_mainFoods.setHasFixedSize(false);

        FoodRecycleViewAdapter adapter = new FoodRecycleViewAdapter(foods, getApplicationContext());
        rv_mainFoods.setAdapter(adapter);
        rv_mainFoods.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
    }

    private void buildActionBar() {
        actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.drawable.food);
    }

    private void buildSpinner(Spinner obj) {
        ArrayList<String> catFood = new ArrayList<>();
        for (Food.CatFood type : Food.CatFood.values()) {
            String el = String.valueOf(type).toLowerCase();
            int id = getResources().getIdentifier(el, "string", getPackageName());
            if(id != 0) { catFood.add(getString(id)); }
            else { catFood.add((el)); }
        }

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