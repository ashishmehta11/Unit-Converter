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
import com.project.unitconverter.main_activity.MainActivityViewModel;
import com.project.unitconverter.utils.GeneralUtils;

import java.util.ArrayList;
import java.util.HashMap;

public class UnitSelectionRecyclerAdapter extends RecyclerView.Adapter<UnitSelectionRecyclerAdapter.ViewHolder> {
    final private HashMap<Integer, ArrayList<Object[]>> units;
    private final Data data;
    private final MainActivityViewModel viewModel;

    public UnitSelectionRecyclerAdapter(Data data, MainActivityViewModel viewModel) {
        this.units = Data.getUnitRange();
        this.data = data;
        this.viewModel = viewModel;
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
        holder.binding.getItemData().setUnitName(units.get(position).get(0)[0].toString());
        Log.e("Unit Selector", "onBindViewHolder: !!! " + position + "\n" + units.get(position).get(0)[0].toString());
        if (data.getSelectedUnitIndex() == position) {
            holder.binding.cardView.setCardBackgroundColor(ColorStateList.valueOf(Color.parseColor("#ffffff")));
            holder.binding.imageView.setImageDrawable((Drawable) units.get(position).get(0)[2]);
            holder.binding.getItemData().setItemSelected(true);
            data.setSelectedUnitName(units.get(position).get(0)[0].toString());
        } else {
            holder.binding.cardView.setCardBackgroundColor(ColorStateList.valueOf(Color.parseColor(GeneralUtils.bgColorLight)));
            holder.binding.imageView.setImageDrawable((Drawable) units.get(position).get(0)[1]);
            holder.binding.getItemData().setItemSelected(false);
        }
        holder.binding.cardView.setOnClickListener(v -> {
            data.setSelectedUnitIndex(position);
            notifyDataSetChanged();
            viewModel.setUnitFamilyChangedNotifier(position);
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
