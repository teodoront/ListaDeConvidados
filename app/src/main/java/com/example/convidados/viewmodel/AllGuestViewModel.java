package com.example.convidados.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.convidados.constants.GuestsConstants;
import com.example.convidados.model.Feedback;
import com.example.convidados.model.GuestModel;
import com.example.convidados.repository.GuestRepository;

import java.util.List;

public class AllGuestViewModel extends AndroidViewModel {

    private GuestRepository mRepository;

    //para o observer poder observar
    private MutableLiveData<List<GuestModel>> mGuestList = new MutableLiveData<>();
    public LiveData<List<GuestModel>> guestList = this.mGuestList;

    private MutableLiveData<Feedback> mFeedback = new MutableLiveData<>();
    public LiveData<Feedback> feedback = this.mFeedback;


    public AllGuestViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = GuestRepository.getInstance(application.getApplicationContext());
    }

    public void getList(int filter) {
        // List<GuestModel> list = this.mRepository.guestList();
        if (filter == GuestsConstants.CONFIRMATION.ALL){
            this.mGuestList.setValue(this.mRepository.getAll());//Lista dos convidados;
        }else if (filter == GuestsConstants.CONFIRMATION.PRESENT){
            this.mGuestList.setValue(this.mRepository.getPresents());
        }else if (filter == GuestsConstants.CONFIRMATION.ABSENT){
            this.mGuestList.setValue(this.mRepository.getAbsents());
        }

    }

    public void delete(int id) {
        if (this.mRepository.delete(id)) {
            this.mFeedback.setValue(new Feedback("Convidado removido com sucesso!!!!"));
        } else {
            this.mFeedback.setValue(new Feedback("Erro ao remover convidado!!!!"));
        }
    }
}