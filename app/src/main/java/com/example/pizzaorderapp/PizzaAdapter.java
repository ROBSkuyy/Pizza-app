package com.example.pizzaorderapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.PizzaViewHolder> {

    private List<Pizza> pizzaList;

    public PizzaAdapter(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    @NonNull
    @Override
    public PizzaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pizza, parent, false);
        return new PizzaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaViewHolder holder, int position) {
        Pizza pizza = pizzaList.get(position);
        holder.pizzaNameTextView.setText(pizza.getName());
        holder.pizzaDetailsTextView.setText(pizza.getDetails());
        holder.ratingTextView.setText(pizza.getRating());
        holder.deliveryFeeTextView.setText(pizza.getDeliveryFee());
        holder.deliveryTimeTextView.setText(pizza.getDeliveryTime());
        holder.pizzaImageView.setImageResource(pizza.getImageResId());
    }

    @Override
    public int getItemCount() {
        return pizzaList.size();
    }

    static class PizzaViewHolder extends RecyclerView.ViewHolder {
        ImageView pizzaImageView;
        TextView pizzaNameTextView;
        TextView pizzaDetailsTextView;
        TextView ratingTextView;
        TextView deliveryFeeTextView;
        TextView deliveryTimeTextView;

        PizzaViewHolder(@NonNull View itemView) {
            super(itemView);
            pizzaImageView = itemView.findViewById(R.id.pizzaImageView);
            pizzaNameTextView = itemView.findViewById(R.id.pizzaNameTextView);
            pizzaDetailsTextView = itemView.findViewById(R.id.pizzaDetailsTextView);
            ratingTextView = itemView.findViewById(R.id.ratingTextView);
            deliveryFeeTextView = itemView.findViewById(R.id.deliveryFeeTextView);
            deliveryTimeTextView = itemView.findViewById(R.id.deliveryTimeTextView);
        }
    }
}
