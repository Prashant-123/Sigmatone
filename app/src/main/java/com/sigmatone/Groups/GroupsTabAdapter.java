package com.sigmatone.Groups;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.sigmatone.Homepage;
import com.sigmatone.R;


public class GroupsTabAdapter extends RecyclerView.Adapter<GroupsTabAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private Context _context;

    public GroupsTabAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this._context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.group_list_model, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroupsTabAdapter.ViewHolder holder, int position) {
        holder.groupName.setText(Homepage.groups.get(position).name);
        if (Homepage.groups.get(position).isSubscribed()) {
            holder.subsBox.setChecked(true);
            holder.subsBox.setText("Subscribed");
        }
    }

    @Override
    public int getItemCount() {
        return Homepage.groups.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView groupName;
        CheckBox subsBox;

        public ViewHolder(View view) {
            super(view);
            groupName = view.findViewById(R.id.group_name_list);
            subsBox = view.findViewById(R.id.checkBoxGroup);
        }
    }
}
