package com.example.recyclerviewfragmentmvp.presenter;

import com.example.recyclerviewfragmentmvp.view.IViewHolder;

public interface IRecyclerPresenter {
    void bindView(IViewHolder iViewHolder);
    int getItemCount();
    String getItemByPosition(int position);
}
