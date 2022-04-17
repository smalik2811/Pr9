package com.du.pr9;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class Fore extends Fragment {

    private Button switchToBack, changeFore;
    private TextView textView;

    public Fore() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_fore, container, false);

        textView = getActivity().findViewById(R.id.sampleText);

        switchToBack = view.findViewById(R.id.switchToBack);
        switchToBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getParentFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, new Back());
                fragmentTransaction.commit();
            }
        });

        changeFore = view.findViewById(R.id.changeFore);
        changeFore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int color = Color.rgb(random.nextInt(256),random.nextInt(256),random.nextInt(256));
                textView.setTextColor(color);
            }
        });
        return view;
    }
}