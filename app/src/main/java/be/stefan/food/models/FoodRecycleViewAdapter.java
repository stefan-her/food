package be.stefan.food.models;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.stefan.food.R;


public class FoodRecycleViewAdapter extends RecyclerView.Adapter<FoodRecycleViewAdapter.ViewHolder> {

    public ArrayList<Food> foodsList;
    private Context context;

    public FoodRecycleViewAdapter(ArrayList<Food> listItem, Context context) {
        this.foodsList = listItem;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView foodName, kcal;
        private View borderTop;

        public ViewHolder(View v) {
            super(v);
            foodName = v.findViewById(R.id.food_name);
            kcal = v.findViewById(R.id.food_kcal);
            borderTop = v.findViewById(R.id.item_color);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(v);
    }

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    @Override
    public void onBindViewHolder(@NonNull FoodRecycleViewAdapter.ViewHolder holder,
                                 int position) {
        Food item = foodsList.get(position);
        holder.foodName.setText(item.getName());

        String text = String.format(context.getString(R.string.kcal), item.getKcal());
        holder.kcal.setText(text);

        switch (item.getCatFood()) {
            case MEAT: holder.borderTop.setBackgroundColor(Color.parseColor(context.getString(R.color.meat)));
                break;
            case FRUIT: holder.borderTop.setBackgroundColor(Color.parseColor(context.getString(R.color.fruit)));
                break;
            case VEGETABLE: holder.borderTop.setBackgroundColor(Color.parseColor(context.getString(R.color.vegetable)));
                break;
        }

    }

    @Override
    public int getItemCount() {
        return foodsList.size();
    }



}
