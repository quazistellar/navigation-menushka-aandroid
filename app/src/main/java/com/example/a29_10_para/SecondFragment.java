package com.example.a29_10_para;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    private TextView countTextView;
    private int count = 0;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanseState){
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        view.setBackgroundResource(R.color.pink);

        countTextView = view.findViewById(R.id.countTextView);
        setHasOptionsMenu(true);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.popupmenu_second, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.plus) {
                count++;
                countTextView.setText(String.valueOf(count));
                return true;
            }
            else if (item.getItemId() == R.id.minus) {
                if (count > 0) {
                    count--;
                    countTextView.setText(String.valueOf(count));
                }
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }

