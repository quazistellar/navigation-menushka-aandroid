package com.example.a29_10_para;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Third extends Fragment {

    @Nullable
    @NonNull
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanseState){
        View view = inflater.inflate(R.layout.fragment_third, container, false);
        view.setBackgroundResource(R.color.blue);
        return view;
    }
}
