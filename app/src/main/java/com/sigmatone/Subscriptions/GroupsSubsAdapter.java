package com.sigmatone.Subscriptions;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sigmatone.R;


public class GroupsSubsAdapter extends RecyclerView.Adapter<GroupsSubsAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private Context _context;

    public GroupsSubsAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
        this._context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.group_subs_model, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GroupsSubsAdapter.ViewHolder holder, int position) {
        holder.mute.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View view) {
                holder.mute_btn.setImageResource(R.drawable.ic_volume_mute_black_24dp);
                holder.mute_btn.setColorFilter(ContextCompat.getColor(_context, R.color.colorAccent), PorterDuff.Mode.SRC_ATOP);
                holder.mute_text.setText("Muted");
            }
        });

        holder.alert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        holder.monitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView groupName, mute_text, alert_text, monitor_text;
        CheckBox subsBox;
        ImageView mute_btn, alert_btn;
        LinearLayout mute, alert, monitor;

        public ViewHolder(View view) {
            super(view);
            groupName = view.findViewById(R.id.group_name_list);
            subsBox = view.findViewById(R.id.checkBoxGroup);
            mute = view.findViewById(R.id.mute);
            alert = view.findViewById(R.id.create_alert);
            monitor = view.findViewById(R.id.monitor);

            mute_btn = view.findViewById(R.id.mute_btn);
            alert_btn = view.findViewById(R.id.alert_btn);

            mute_text = view.findViewById(R.id.mute_text);
            alert_text = view.findViewById(R.id.create_alert_text);
            monitor_text = view.findViewById(R.id.monitor_text);
        }
    }
}
