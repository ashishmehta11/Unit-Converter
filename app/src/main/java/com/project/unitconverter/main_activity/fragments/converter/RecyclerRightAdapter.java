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
import com.project.unitconverter.data.Data;
import com.project.unitconverter.databinding.ConverterRowItemBinding;

public class RecyclerRightAdapter extends RecyclerView.Adapter<RecyclerRightAdapter.ViewHolder> {
    private Data data;

    public RecyclerRightAdapter(Data data) {
        this.data = data;
    }

    @NonNull

    @Override
    public RecyclerRightAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConverterRowItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.converter_row_item, parent, false);
        binding.setData(new ConverterRowItem());
        return new RecyclerRightAdapter.ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerRightAdapter.ViewHolder holder, int position) {
        Log.d("Unit Converter", "onBindViewHolder right:  !!! " + position);
        String name = "", value = "";
        if (Data.getUnitRange().get(data.getSelectedUnitIndex()).get(position + 1).length > 0) {
            name = Data.getUnitRange().get(data.getSelectedUnitIndex()).get(position + 1)[0].toString();
            value = Data.getUnitRange().get(data.getSelectedUnitIndex()).get(position + 1)[1].toString();
        }
        holder.binding.getData().setName(name);
        holder.binding.getData().setValue(value);
    }

    @Override
    public int getItemCount() {
        return Data.getUnitRange().get(data.getSelectedUnitIndex()).size() - 1;
    }

    protected static class ViewHolder extends RecyclerView.ViewHolder {
        ConverterRowItemBinding binding;

        public ViewHolder(@NonNull ConverterRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.getData().setGravity(Gravity.START | Gravity.CENTER);
        }
    }
}
