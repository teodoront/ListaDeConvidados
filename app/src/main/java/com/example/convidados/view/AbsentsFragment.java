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
import com.example.convidados.viewmodel.AbsentsViewModel;

public class AbsentsFragment extends Fragment {

    private AbsentsViewModel absentsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        absentsViewModel =
                new ViewModelProvider(this).get(AbsentsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_absents, container, false);
        final TextView textView = root.findViewById(R.id.text_slideshow);
        return root;
    }
}