package com.mrizkimn.uts_akb10118012.friendlist;

import com.mrizkimn.uts_akb10118012.R;

import java.util.ArrayList;
//Moch Rizki Maulana N
//10118012
//IF-1
//30-05-2021

public class FriendData {

    private static String [] namaFriend = {
            "Moch Rifa Maulana N",
            "Moch Rizki Maulana N",
            "Tassyakur Pasya",
            "Azis Komara",
            "Surya FH",
            "Dian RP"
    };

    private static String [] detailFriend = {
            "Suka nonton film, orangnya tidak suka keramaian dan lebih banyak menyendiri, Asli dari Kota Tasikamalaya",
            "Suka nonton film, orangnya tidak suka keramaian dan lebih banyak menyendiri, Asli dari Kota Tasikamalaya",
            "Orangnya kalem, mudah khawatiran terhadap hal baru, kepedulian terhadap oranglain tinggi dan tidak sombong",
            "Suka dengan berita politik dunia maupun pemerintahan negara, suka main game mobile legend dan victory ",
            "Sang ahli dalam perMotoran aplagi kalo masalah-masalah sparepart motor, paling tau dari semua teman dikelas  ",
            "Suka mendesain, orangnya kalem dan berani memulai sesuatu hal yang baru. tidak pernah putus asa"
    };

    private static int [] photoFriend = {

            R.drawable.rifa,
            R.drawable.profile,
            R.drawable.pasya,
            R.drawable.azis,
            R.drawable.surya,
            R.drawable.dian,
    };

    private static String [] dailyActivity = {
            "Main Game",
            "Nonton Film",
            "Shalat",
            "Makan",
            "Ngoding",
            "TIdur"
    };

    private static String [] music ={
            "Killing Me Inside",
            "To the Bone",
            "Amazing Day",
            "Army Of One",
            "Adventure Of A Lifetime",
            "A Head Full Of Dream",
            "Lisa Homura"
    };

    public static ArrayList<Friend> getListData(){

            ArrayList<Friend> list = new ArrayList<>();
            for (int position = 0; position<namaFriend.length; position++){

                Friend friend = new Friend();
                friend.setNama(namaFriend[position]);
                friend.setDetail(detailFriend[position]);
                friend.setPhoto(photoFriend[position]);
                list.add(friend);
            }
            return list;
    }

    public static ArrayList<Friend> getListDataDaily(){

        ArrayList<Friend> listDaily = new ArrayList<>();
        for (int position = 0; position<dailyActivity.length; position++){

            Friend friend = new Friend();
            friend.setDaily(dailyActivity[position]);
            listDaily.add(friend);
        }
        return listDaily;
    }

    public static ArrayList<Friend> getListDataMusic(){

        ArrayList<Friend> listMusic = new ArrayList<>();
        for (int position = 0; position<music.length; position++){

            Friend friend = new Friend();
            friend.setMusic(music[position]);
            listMusic.add(friend);
        }
        return listMusic;
    }

}
