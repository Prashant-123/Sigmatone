package com.sigmatone.Subscriptions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sigmatone.Groups.GroupsTabAdapter;
import com.sigmatone.R;

/**
 * Created by PRASHANT on 7/16/2017.
 */

public class Subscriptions extends Fragment {

    public RecyclerView recyclerView;
    public GroupsSubsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscriptions, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        adapter = new GroupsSubsAdapter(view.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        return view;
    }
}