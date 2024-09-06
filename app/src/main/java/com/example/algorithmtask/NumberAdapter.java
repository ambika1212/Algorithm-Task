package com.example.algorithmtask;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolder> {

    private ArrayList<Integer> numbers;
    private String rule;

    public NumberAdapter(ArrayList<Integer> numbers, String rule) {
        this.numbers = numbers;
        this.rule = rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int number = numbers.get(position);
        holder.textView.setText(String.valueOf(number));

        // Highlight based on the selected rule
        if (rule.equals("Even") && isEven(number)) {
            holder.textView.setBackgroundColor(Color.BLUE);
        } else if (rule.equals("Odd") && isOdd(number)) {
            holder.textView.setBackgroundColor(Color.GREEN);
        } else if (rule.equals("Prime") && isPrime(number)) {
            holder.textView.setBackgroundColor(Color.YELLOW);
        } else if (rule.equals("Fibonacci") && isFibonacci(number)) {
            holder.textView.setBackgroundColor(Color.RED);
        } else {
            holder.textView.setBackgroundColor(Color.WHITE);
        }
    }

    @Override
    public int getItemCount() {
        return numbers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }

    // Algorithms for rules

    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public boolean isFibonacci(int number) {
        int x1 = 5 * number * number + 4;
        int x2 = 5 * number * number - 4;
        return isPerfectSquare(x1) || isPerfectSquare(x2);
    }

    private boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return s * s == x;
    }
}


