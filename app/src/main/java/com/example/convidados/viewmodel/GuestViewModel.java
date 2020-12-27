package com.example.convidados.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;


import com.example.convidados.model.GuestModel;
import com.example.convidados.repository.GuestRepository;

public class GuestViewModel extends AndroidViewModel{

    private GuestRepository mRepository;


    public GuestViewModel(@NonNull Application application) {
        super(application);
        this.mRepository = GuestRepository.getInstance(application.getApplicationContext());//Isso tudo é para ter acesso a repository, que não pode ser instanciada.
    }



    //Aqui trata as regras de negócios
    public void save(GuestModel guest){

      this.mRepository.insert(guest);

    }


}
