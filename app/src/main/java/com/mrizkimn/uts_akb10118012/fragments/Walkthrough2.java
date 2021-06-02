package com.mrizkimn.uts_akb10118012.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.mrizkimn.uts_akb10118012.R;
//Moch Rizki Maulana N
//10118012
//IF-1
//26-05-2021

public class Walkthrough2 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup)inflater.
                inflate(R.layout.activity_walkthrough2,container,false);

        return rootView;
    }
}
