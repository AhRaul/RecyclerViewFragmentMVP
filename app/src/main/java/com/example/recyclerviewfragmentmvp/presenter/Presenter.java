package com.example.recyclerviewfragmentmvp.presenter;

import com.example.recyclerviewfragmentmvp.model.RecyclerViewModel;
import com.example.recyclerviewfragmentmvp.view.IViewHolder;

import java.util.List;

public class Presenter {

    //часть логики ViewHolder вынесенная из адаптера RecyclerView в основной Presenter,
    // для возможности работать с паттерном MVP и RecyclerView
    RecyclerPresenter recyclerPresenter = new RecyclerPresenter();

    private class RecyclerPresenter implements IRecyclerPresenter {

        private RecyclerViewModel recyclerModel= new RecyclerViewModel();
        private List<String> list = recyclerModel.getList();


        @Override
        public void bindView(IViewHolder iViewHolder) {
            iViewHolder.setText(list.get(iViewHolder.getPos()));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        @Override
        public String getItemByPosition(int position) {
            return list.get(position);
        }
    }

    public RecyclerPresenter getRecyclerPresenter() {
        return recyclerPresenter;
    }
}
