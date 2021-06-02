package com.mrizkimn.uts_akb10118012.friendlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrizkimn.uts_akb10118012.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
//Moch Rizki Maulana N
//10118012
//IF-1
//30-05-2021

public class ListDailyAdapter extends RecyclerView.Adapter<ListDailyAdapter.ListViewHolder> {

    private ArrayList<Friend> listDaily;

    public ListDailyAdapter(ArrayList<Friend> list){
        this.listDaily = list;
    }
    
    @NonNull
    @NotNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dailylist, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListDailyAdapter.ListViewHolder holder, int position) {
        Friend friend = listDaily.get(position);
        holder.tvDaily.setText(friend.getDaily());
    }

    @Override
    public int getItemCount() {
        return listDaily.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvDaily;
        ListViewHolder(View itemview) {
            super(itemview);

            tvDaily = itemview.findViewById(R.id.tv_daily);
        }
    }
}
