package com.mrizkimn.uts_akb10118012.music;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mrizkimn.uts_akb10118012.R;
import com.mrizkimn.uts_akb10118012.friendlist.Friend;
import com.mrizkimn.uts_akb10118012.friendlist.ListDailyAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
//Moch Rizki Maulana N
//10118012
//IF-1
//31-05-2021

public class ListMusicAdapter extends RecyclerView.Adapter<ListMusicAdapter.ListViewHolder> {
    private ArrayList<Friend> listMusic;

    public ListMusicAdapter(ArrayList<Friend> list){
        this.listMusic = list;
    }

    @NonNull
    @NotNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false);

        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ListMusicAdapter.ListViewHolder holder, int position) {
        Friend friend = listMusic.get(position);
        holder.tvMusic.setText(friend.getMusic());
    }

    @Override
    public int getItemCount() {
        return listMusic.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvMusic;
        ListViewHolder(View itemview) {
            super(itemview);

            tvMusic = itemview.findViewById(R.id.tv_music);
        }
    }
}
