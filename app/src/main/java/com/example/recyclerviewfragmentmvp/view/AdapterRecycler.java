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
    //OnClickListener
    private OnNoteListener mOnNoteListener;

    public AdapterRecycler(IRecyclerPresenter iRecyclerPresenter, OnNoteListener onNoteListener) {
        this.iRecyclerPresenter = iRecyclerPresenter;
        //OnClickListener
        this.mOnNoteListener = onNoteListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_recycler, parent, false);
        return new MyViewHolder(view, mOnNoteListener);
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

    public class MyViewHolder extends RecyclerView.ViewHolder implements IViewHolder, View.OnClickListener {

        private TextView textView;
        private int position = 0;
        //OnClickListener
        OnNoteListener onNoteListener;

        public MyViewHolder(@NonNull View itemView, OnNoteListener onNoteListener) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);

            //OnClickListener
            this.onNoteListener = onNoteListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void setText(String text) {
            textView.setText(text);
        }

        @Override
        public int getPos() {
            return position;
        }

        //OnClickListener
        @Override
        public void onClick(View v) {
            onNoteListener.onNoteClick(getAdapterPosition());
        }
    }

    //OnClickListener
    public interface OnNoteListener{
        void onNoteClick(int position);
    }
}
