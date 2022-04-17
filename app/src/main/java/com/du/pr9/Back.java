package com.du.pr9;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Back extends Fragment {

    private Button switchToFore, changeBack;
    private TextView textView;

    public Back() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_back, container, false);

        textView = getActivity().findViewById(R.id.sampleText);

        // Changing background color of the textview to some random color.
        changeBack = view.findViewById(R.id.changeBack);
        changeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int color = Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256));
                textView.setBackgroundColor(color);
            }
        });

        // Switching the Fragment
        switchToFore = view.findViewById(R.id.switchToFore);
        switchToFore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout,new Fore());
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}