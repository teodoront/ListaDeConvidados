package com.example.convidados.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.convidados.R;
import com.example.convidados.viewmodel.PresentViewModel;

public class PresentFragment extends Fragment {

    private PresentViewModel presentViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        presentViewModel =
                new ViewModelProvider(this).get(PresentViewModel.class);

        View root = inflater.inflate(R.layout.fragment_presents, container, false);

        return root;
    }
}