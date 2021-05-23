package be.stefan.food;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

import be.stefan.food.R;

public class MainActivity extends AppCompatActivity {

    private ActionBar actionBar;
    private ArrayList foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buildActionBar();
        buildSpinner(findViewById(R.id.sp_type));

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