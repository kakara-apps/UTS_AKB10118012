package com.mrizkimn.uts_akb10118012.gallery;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.mrizkimn.uts_akb10118012.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;
//Moch Rizki Maulana N
//10118012
//IF-1
//31-05-2021

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>{

    private List<GalleryItem> listItems;

    public GalleryAdapter(List<GalleryItem> listItems) {
        this.listItems = listItems;
    }


    @NonNull
    @NotNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        return new GalleryViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_photo_gallery,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GalleryAdapter.GalleryViewHolder holder, int position) {
        holder.setGalleryImg(listItems.get(position));
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder{

        RoundedImageView img_gallery;

        GalleryViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            img_gallery = itemView.findViewById(R.id.image_rounded_gallery);
        }

        void setGalleryImg(GalleryItem galleryItem){

            //if you wantto display image fromthe internet,
            //here you can put code for loading image using glide or picasso...
            img_gallery.setImageResource(galleryItem.getImage());
        }
    }
}
