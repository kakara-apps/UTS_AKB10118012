package com.mrizkimn.uts_akb10118012;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.mrizkimn.uts_akb10118012.friendlist.Friend;
import com.mrizkimn.uts_akb10118012.friendlist.FriendData;
import com.mrizkimn.uts_akb10118012.friendlist.ListDailyAdapter;
import com.mrizkimn.uts_akb10118012.friendlist.ListFriendAdapter;
import com.mrizkimn.uts_akb10118012.gallery.GalleryAdapter;
import com.mrizkimn.uts_akb10118012.gallery.GalleryItem;
import com.mrizkimn.uts_akb10118012.music.ListMusicAdapter;

import java.util.ArrayList;
import java.util.List;
//Moch Rizki Maulana N
//10118012
//IF-1
//28-05-2021

public class HomeActivity extends AppCompatActivity {

    LinearLayout home,daily,music,profile;
    ConstraintLayout gallery;
    MaterialToolbar title;
    VideoView videoView;
    Dialog dialog;
    Button about;

    //Menu Prifile
    ImageButton WA,IG,GHub;
    Button temukan;

    //Daily Activity FriendList
    private RecyclerView rvFriend;
    private ArrayList<Friend> list = new ArrayList<>();

    //Daily Activity DailyList
    private RecyclerView rvDaily;
    private ArrayList<Friend> listD = new ArrayList<>();

    //Daily Activity DailyList
    private RecyclerView rvMusic;
    private ArrayList<Friend> listMusic = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //custom dialog
        dialog = new Dialog(HomeActivity.this);
        dialog.setContentView(R.layout.about_dialog);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background_dialog));
        }

        dialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);

        Button kembali = dialog.findViewById(R.id.btn_kembali);
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        about = findViewById(R.id.btn_about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
            }
        });

        //menu profile
        WA = findViewById(R.id.ib_whatsapp);
        IG = findViewById(R.id.ib_instagram);
        GHub = findViewById(R.id.ib_github);
        temukan = findViewById(R.id.btn_temukan);


        GHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/kakara-apps"));
                startActivity(i);
                finish();
            }
        });

        IG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/maulanarizki1999/"));
                startActivity(i);
                finish();
            }
        });

        temukan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Dago+Bangbayang+Residence/@-6.880111,107.6159103,17z/data=!3m1!4b1!4m5!3m4!1s0x2e68e6fc16f292f1:0xa07e37aa34b7153d!8m2!3d-6.8801189!4d107.618132?hl=id"));
                startActivity(i);
                finish();
            }
        });



        //Video Preview
        videoView = findViewById(R.id.video_preview);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vide0));
        videoView.start();

        //RecyclerView Gallery
        RecyclerView galleryRecyclerView = findViewById(R.id.rv_gallery);
        galleryRecyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );

        //here i'm preparing list of images from the Drawable,
        //you can get it from API as well....

        List<GalleryItem> listItems = new ArrayList<>();
        listItems.add(new GalleryItem(R.drawable.g1));
        listItems.add(new GalleryItem(R.drawable.g2));
        listItems.add(new GalleryItem(R.drawable.g3));
        listItems.add(new GalleryItem(R.drawable.g4));
        listItems.add(new GalleryItem(R.drawable.g5));
        listItems.add(new GalleryItem(R.drawable.g6));
        listItems.add(new GalleryItem(R.drawable.g7));
        galleryRecyclerView.setAdapter(new GalleryAdapter(listItems));

        MaterialToolbar toolbar = findViewById(R.id.topAppbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView =  findViewById(R.id.navigation_view);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        navigationView.getMenu().getItem(0).setChecked(true);

        home = findViewById(R.id.home_layout);
        daily = findViewById(R.id.daily_layout);
        title = findViewById(R.id.topAppbar);
        music = findViewById(R.id.music_video__layout);
        gallery = findViewById(R.id.gallery_layout);
        profile = findViewById(R.id.profile_layout);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);

                switch (id){

                    case R.id.nav_home :
                        home.setVisibility(View.VISIBLE);
                        daily.setVisibility(View.GONE);
                        gallery.setVisibility(View.GONE);
                        music.setVisibility(View.GONE);
                        profile.setVisibility(View.GONE);
                        title.setTitle("Home");
                        break;
                    case R.id.nav_daily :
                        home.setVisibility(View.GONE);
                        daily.setVisibility(View.VISIBLE);
                        gallery.setVisibility(View.GONE);
                        music.setVisibility(View.GONE);
                        profile.setVisibility(View.GONE);
                        title.setTitle("Daily Activity");
                        break;
                    case R.id.nav_gallery:
                        home.setVisibility(View.GONE);
                        daily.setVisibility(View.GONE);
                        gallery.setVisibility(View.VISIBLE);
                        music.setVisibility(View.GONE);
                        profile.setVisibility(View.GONE);
                        title.setTitle("Gallery");
                        break;
                    case R.id.nav_music_video:
                        home.setVisibility(View.GONE);
                        daily.setVisibility(View.GONE);
                        gallery.setVisibility(View.GONE);
                        music.setVisibility(View.VISIBLE);
                        profile.setVisibility(View.GONE);
                        title.setTitle("Music and Video");
                        break;
                    case R.id.nav_person:
                        home.setVisibility(View.GONE);
                        daily.setVisibility(View.GONE);
                        gallery.setVisibility(View.GONE);
                        music.setVisibility(View.GONE);
                        profile.setVisibility(View.VISIBLE);
                        title.setTitle("Profile");
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });

        //FriendList
        rvFriend = findViewById(R.id.rv_friend);
        rvFriend.setHasFixedSize(true);
        list.addAll(FriendData.getListData());
        showRecyclerList();

        //DailyList
        rvDaily = findViewById(R.id.rv_daily);
        rvDaily.setHasFixedSize(true);
        listD.addAll(FriendData.getListDataDaily());
        showRecyclerListDaily();

        //DailyList
        rvMusic = findViewById(R.id.rv_music);
        rvMusic.setHasFixedSize(true);
        listMusic.addAll(FriendData.getListDataMusic());
        showRecyclerListMusic();

    }

    private void showRecyclerList(){

        rvFriend.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ListFriendAdapter listFriendAdapter = new ListFriendAdapter(list);
        rvFriend.setAdapter(listFriendAdapter);
    }

    private void showRecyclerListDaily(){

        rvDaily.setLayoutManager(new LinearLayoutManager(this));
        ListDailyAdapter listDailyAdapter = new ListDailyAdapter(listD);
        rvDaily.setAdapter(listDailyAdapter);
    }

    private void showRecyclerListMusic(){

        rvMusic.setLayoutManager(new LinearLayoutManager(this));
        ListMusicAdapter listMusicAdapter = new ListMusicAdapter(listMusic);
        rvMusic.setAdapter(listMusicAdapter);
    }

}