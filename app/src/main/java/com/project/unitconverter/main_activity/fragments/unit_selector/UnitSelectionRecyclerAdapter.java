package com.project.unitconverter.main_activity.fragments.unit_selector;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.project.unitconverter.R;
import com.project.unitconverter.data.Data;
import com.project.unitconverter.data.UnitSelectorRowItem;
import com.project.unitconverter.databinding.UnitSelectorRowItemBinding;
import com.project.unitconverter.utils.GeneralUtils;

import java.util.List;

public class UnitSelectionRecyclerAdapter extends RecyclerView.Adapter<UnitSelectionRecyclerAdapter.ViewHolder> {
    final private List<Object[]> units;
    private final Data data;

    public UnitSelectionRecyclerAdapter(List<Object[]> units, Data data) {
        this.units = units;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UnitSelectorRowItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext())
                , R.layout.unit_selector_row_item, parent, false);
        binding.setItemData(new UnitSelectorRowItem());
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.getItemData().setUnitName(units.get(position)[0].toString());
        Log.e("Unit Selector", "onBindViewHolder: !!! " + position + "\n" + units.get(position)[0].toString());
        if (data.getSelectedUnitIndex() == position) {
            holder.binding.cardView.setCardBackgroundColor(ColorStateList.valueOf(Color.parseColor("#ffffff")));
            holder.binding.imageView.setImageDrawable((Drawable) units.get(position)[2]);
            holder.binding.getItemData().setItemSelected(true);
            data.setSelectedUnitName(units.get(position)[0].toString());
        } else {
            holder.binding.cardView.setCardBackgroundColor(ColorStateList.valueOf(Color.parseColor(GeneralUtils.bgColorLight)));
            holder.binding.imageView.setImageDrawable((Drawable) units.get(position)[1]);
            holder.binding.getItemData().setItemSelected(false);
        }
        holder.binding.cardView.setOnClickListener(v -> {
            data.setSelectedUnitIndex(position);
            notifyDataSetChanged();
        });
    }

    @Override
    public int getItemCount() {
        return units.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        UnitSelectorRowItemBinding binding;

        public ViewHolder(@NonNull UnitSelectorRowItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.textView.setSelected(true);
        }
    }
}
