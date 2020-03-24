package com.dataentropia.room_viewmodel.viewmodel;


import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.dataentropia.room_viewmodel.data.local.entity.Address;
import com.dataentropia.room_viewmodel.data.local.entity.TipoDocumento;
import com.dataentropia.room_viewmodel.data.remote.repository.AddressRepository;
import com.dataentropia.room_viewmodel.data.local.entity.Person;
import com.dataentropia.room_viewmodel.data.remote.repository.PersonRepository;
import com.dataentropia.room_viewmodel.data.remote.repository.TipoDocumentoRepository;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
@SuppressWarnings("unchecked")
public class PersonViewModel extends AndroidViewModel {

    private PersonRepository personRepository = new PersonRepository(this.getApplication());

    private AddressRepository addressRepository = new AddressRepository(this.getApplication());

    private TipoDocumentoRepository tipoDocumentoRepository = new TipoDocumentoRepository(this.getApplication());

    private final Executor executor = Executors.newFixedThreadPool(2);

    private final MutableLiveData<List<Person>> personsByCity = new MutableLiveData<>();

    private final MutableLiveData<String> mobileNo = new MutableLiveData<>();

    //transformation applied so that observer to this LiveData can be added only once
    private final LiveData<Person> personsByMobile = Transformations.switchMap(mobileNo, (mobile) -> {
        return personRepository.getPersonByMobile(mobile);
    });

    public LiveData<List<Person>> getPersonsByCityLive(){
        return personsByCity;
    }

    public PersonViewModel(@NonNull Application application){
        super(application);
    }

    //Room DAO call needs to be run on background thread
    //This example uses Executor
    public void addPerson(Person p){
        executor.execute(() -> {
            personRepository.addPerson(p);
        });
    }

    public void addAddress(Address a){
        executor.execute(() -> {
            addressRepository.addAddress(a);
        });
    }

    public void updatePerson(Person p){
        executor.execute(() -> {
        personRepository.updatePerson(p);
        });
    }

    public void updateAddress(Address a){
        executor.execute(() -> {
            addressRepository.updateAddress(a);
        });
    }

    public void deletePerson(Person p){
        executor.execute(() -> {
        personRepository.deletePerson(p);
        });
    }
    //Since room DAO returns LiveData, it runs on background thread.
    public LiveData<List<Person>> getAllPersons(){
        return personRepository.getAllPersons();
    }

    public LiveData<List<Address>> getAllAddress(){
        return addressRepository.getAllAddress();
    }

    public LiveData<List<TipoDocumento>> getAllTipoDocumentos(){
        return tipoDocumentoRepository.getAllTipoDocumentos();
    }
    //Room DAO call needs to be run on background thread
    //This example uses AsyncTask
    public void getPersonsByCity(List<String> cities){
        new AsyncTask<Void, Void, List<Person>>() {
            @Override
            protected List<Person> doInBackground(Void... params) {
                //return personRepository.getPersonsByCity(cities);
                return (List<Person>) personRepository.getAllPersons();
            }
            @Override
            protected void onPostExecute(List<Person> personLst) {
                Log.d("", "persons by city "+personLst.size());
                personsByCity.setValue(personLst);
            }
        }.execute();

    }
    //sets the mobile number to LiveData object,
    //transformation using switchMap intern calls room DAO method which return LiveData
    public void setMobile(String mobile){
        mobileNo.setValue(mobile);
    }

    public LiveData<Person> getPersonsByMobile(){
        return personsByMobile;
    }
}
