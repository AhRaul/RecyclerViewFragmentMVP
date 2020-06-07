package com.example.recyclerviewfragmentmvp.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewfragmentmvp.R;
import com.example.recyclerviewfragmentmvp.presenter.IRecyclerPresenter;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder>{

    private IRecyclerPresenter iRecyclerPresenter;

    public AdapterRecycler(IRecyclerPresenter iRecyclerPresenter) {
        this.iRecyclerPresenter = iRecyclerPresenter;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.position = position;
        iRecyclerPresenter.bindView(holder);
    }

    @Override
    public int getItemCount() {
        return iRecyclerPresenter.getItemCount();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements IViewHolder {

        private TextView textView;
        private int position = 0;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }

        @Override
        public void setText(String text) {
            textView.setText(text);
        }

        @Override
        public int getPos() {
            return position;
        }
    }
}
