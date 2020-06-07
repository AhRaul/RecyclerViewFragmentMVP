package com.example.recyclerviewfragmentmvp.view;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewfragmentmvp.R;
import com.example.recyclerviewfragmentmvp.model.RecyclerViewModel;
import com.example.recyclerviewfragmentmvp.presenter.Presenter;

public class RecyclerFragment extends Fragment {

    private RecyclerViewModel mViewModel;
    private Presenter presenter;
    private View root;

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        presenter = new Presenter();
        root = inflater.inflate(R.layout.main_fragment, container, false);
        initRecyclerView();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new RecyclerViewModel();
        // TODO: Use the ViewModel
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view_fragment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        AdapterRecycler myAdapterRecycler = new AdapterRecycler(presenter.getRecyclerPresenter());
        recyclerView.setAdapter(myAdapterRecycler);
    }

}
