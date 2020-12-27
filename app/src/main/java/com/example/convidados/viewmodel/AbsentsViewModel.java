package com.example.convidados.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AbsentsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AbsentsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Absents");
    }

    public LiveData<String> getText() {
        return mText;
    }
}