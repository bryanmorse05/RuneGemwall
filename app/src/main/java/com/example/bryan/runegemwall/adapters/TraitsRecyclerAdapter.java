package com.example.bryan.runegemwall.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bryan.runegemwall.R;
import com.example.bryan.runegemwall.models.TraitsModel;

import java.util.ArrayList;

public class TraitsRecyclerAdapter extends RecyclerView.Adapter<TraitsRecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<TraitsModel> traitsModelArrayList;

    public TraitsRecyclerAdapter(ArrayList<TraitsModel> traitsModelArrayList) {
        super();
        this.traitsModelArrayList = traitsModelArrayList;
    }

    @Override
    public TraitsRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.traits_list_row, parent, false);
        TraitsRecyclerAdapter.ViewHolder viewHolder = new TraitsRecyclerAdapter.ViewHolder(view);

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final TraitsRecyclerAdapter.ViewHolder holder, int position) {

        final TraitsModel traitsModel = traitsModelArrayList.get(position);

        TextView nameDisplay = holder.nameDisplay;
        nameDisplay.setText(traitsModel.getName());

        TextView ownerDisplay = holder.descriptionDisplay;
        ownerDisplay.setText(traitsModel.getDescription());

    }

    @Override
    public int getItemCount() {
        return traitsModelArrayList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nameDisplay;
        public TextView descriptionDisplay;

        public ViewHolder(View itemView) {

            super(itemView);

            nameDisplay = itemView.findViewById(R.id.traitName);
            descriptionDisplay = itemView.findViewById(R.id.traitDescription);

            context = itemView.getContext();
        }
    }
}
