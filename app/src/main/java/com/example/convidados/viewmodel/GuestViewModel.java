package com.example.convidados.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;


import com.example.convidados.model.Feedback;
import com.example.convidados.model.GuestModel;
import com.example.convidados.repository.GuestRepository;

public class GuestViewModel extends AndroidViewModel {

    private GuestRepository mRepository;
    private MutableLiveData<GuestModel> mGuest = new MutableLiveData<>();
    public LiveData<GuestModel> guest = this.mGuest;

    private MutableLiveData<Feedback> mFeedback = new MutableLiveData<>();
    public LiveData<Feedback> feedback = this.mFeedback;


    public GuestViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = GuestRepository.getInstance(application.getApplicationContext());//Isso tudo é para ter acesso a repository, que não pode ser instanciada.
    }


    //Aqui trata as regras de negócios
    public void save(GuestModel guest) {

        if ("".equals(guest.getName())){
            this.mFeedback.setValue(new Feedback("O campo nome é obrigatório o preenchimento"));
            return;
        }

        if (guest.getId() == 0) {
            if (this.mRepository.insert(guest)) {
                this.mFeedback.setValue(new Feedback("Convidado inserido com sucesso!!!"));
            } else {
                this.mFeedback.setValue(new Feedback("Erro inesperado!!!", false));
            }
        } else {
            if (this.mRepository.update(guest)) {
                this.mFeedback.setValue(new Feedback("Convidado atualizado com sucesso!!!"));
            } else {
                this.mFeedback.setValue(new Feedback("Erro inesperado!!!", false));
            }
        }
    }

    public void load(int id) {
        // GuestModel guestModel = this.mRepository.load(id);
        this.mGuest.setValue(this.mRepository.load(id));


    }
}
