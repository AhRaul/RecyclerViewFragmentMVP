package com.example.recyclerviewfragmentmvp.view;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerviewfragmentmvp.R;
import com.example.recyclerviewfragmentmvp.model.RecyclerViewModel;
import com.example.recyclerviewfragmentmvp.presenter.IRecyclerPresenter;
import com.example.recyclerviewfragmentmvp.presenter.Presenter;

public class RecyclerFragment extends Fragment implements AdapterRecycler.OnNoteListener {

    private static final String TAG = "RecyclerFragment";
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
        // TODO: Use the ViewModel
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = root.findViewById(R.id.recycler_view_fragment);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        AdapterRecycler myAdapterRecycler = new AdapterRecycler(presenter.getRecyclerPresenter(), this);
        recyclerView.setAdapter(myAdapterRecycler);
    }

    //OnClickListener
    @Override
    public void onNoteClick(int position) {
        Log.d(TAG, "onNoteClick: clicked" + position);
//        String item = presenter.getRecyclerPresenter().getItemByPosition(position);
//        Intent intent = new Intent(this, NewActivity.class);
//        startActivity(intent);
    }
}
