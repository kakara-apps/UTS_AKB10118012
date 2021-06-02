package com.mrizkimn.uts_akb10118012.friendlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mrizkimn.uts_akb10118012.R;

import java.util.ArrayList;
//Moch Rizki Maulana N
//10118012
//IF-1
//30-05-2021

public class ListFriendAdapter extends RecyclerView.Adapter<ListFriendAdapter.ListViewHolder>{

    private ArrayList<Friend> lisFriend;

    public ListFriendAdapter(ArrayList<Friend> list){
        this.lisFriend = list;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friendlist, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ListFriendAdapter.ListViewHolder holder, int position) {
        Friend friend = lisFriend.get(position);
        Glide.with(holder.itemView.getContext())
                .load(friend.getPhoto())
                .apply(new RequestOptions().override(80, 80))
                .into(holder.imgFriend);

        holder.tv_nama.setText(friend.getNama());
        holder.tv_detail.setText(friend.getDetail());
    }

    @Override
    public int getItemCount() {
        return lisFriend.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {

        ImageView imgFriend;
        TextView tv_nama, tv_detail;

        ListViewHolder(View itemview) {
            super(itemview);
            imgFriend = itemview.findViewById(R.id.ci_photo);
            tv_nama = itemview.findViewById(R.id.tv_name);
            tv_detail = itemview.findViewById(R.id.tv_detail);
        }
    }
}
