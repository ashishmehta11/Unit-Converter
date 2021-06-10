package com.project.unitconverter.main_activity.fragments.converter;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.unitconverter.R;
import com.project.unitconverter.data.ConverterRowItem;
import com.project.unitconverter.databinding.ConverterRowItemBinding;

public class RecyclerLeftAdapter extends RecyclerView.Adapter<RecyclerLeftAdapter.ViewHolder> {
    @NonNull

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConverterRowItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.converter_row_item, parent, false);
        binding.setData(new ConverterRowItem());
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerLeftAdapter.ViewHolder holder, int position) {
        Log.d("Unit Converter", "onBindViewHolder left:  !!! " + position);
        holder.binding.getData().setGravity(Gravity.END | Gravity.CENTER);
        holder.binding.getData().setName("Inches");
        holder.binding.getData().setValue("In");
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        ConverterRowItemBinding binding;

        public ViewHolder(@NonNull ConverterRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
