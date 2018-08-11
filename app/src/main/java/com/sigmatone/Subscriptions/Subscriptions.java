package com.sigmatone.Subscriptions;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sigmatone.Groups.AllGroupDataClass;
import com.sigmatone.Groups.Groups;
import com.sigmatone.Groups.GroupsTabAdapter;
import com.sigmatone.Groups.UserGroup;
import com.sigmatone.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sigmatone.Homepage.TAG;

/**
 * Created by PRASHANT on 7/16/2017.
 */

public class Subscriptions extends Fragment {

    public RecyclerView recyclerView;
    public static GroupsSubsAdapter adapter;
    public static int total_subscribed_group = 0;
    public ArrayList<String> subscribed_groups_list = new ArrayList<>();
    public static ArrayList<UserGroup> subscribed_groups = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subscriptions, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        adapter = new GroupsSubsAdapter(view.getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        load_subs();

        return view;
    }

    public void load_subs() {
        subscribed_groups.clear();
        DatabaseReference groups_subs = FirebaseDatabase.getInstance().
                getReference("users/prashant/groups_subscribed");

        groups_subs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> ug = Arrays.asList(String.valueOf(dataSnapshot.getValue()).split("\\s*,\\s*"));
                for (int i=0; i<ug.size(); i++) {
                    subscribed_groups_list.add(ug.get(i));
                    Log.i(TAG, ug.get(i));
                }

                final DatabaseReference all_group = FirebaseDatabase.getInstance().getReference("groups");
                all_group.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        AllGroupDataClass grp = dataSnapshot.getValue(AllGroupDataClass.class);
                        if (subscribed_groups_list.toString().contains(grp.getId())) {
                            UserGroup userGroup = new UserGroup(grp.getId(), grp.getName(), true);
                            subscribed_groups.add(userGroup);
                            total_subscribed_group++;
                            adapter.notifyDataSetChanged();
                        }
                    }
                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    }
                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {
                    }
                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}