package com.dataentropia.room_viewmodel;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AddressRepository {

    private  AddressDAO addressDAO;


    public AddressRepository(Context context) {
        addressDAO = DatabaseCreator.getAppDatabase(context).AddressDatabase();
    }


    public void addAddress(Address a) {
           long rec =  addressDAO.insertAddress(a);
        Log.d("db insert ","added "+rec);
    }

    public void updateAddress(Address a) {
        addressDAO.updateAddress(a);
    }

    public void deleteAddress(Address a) {
        addressDAO.deleteAddress(a);
    }

    public LiveData<List<Address>> getAllAddress() {
        return addressDAO.getAllAddress();
    }

    /*public List<Person> getPersonsByCity(List<String> cities) {

        return personDAO.getPersonByCities(cities);
    }*/

    public LiveData<Address> getAddressByMobile(String mobile) {
        return addressDAO.getAddressByMobile(mobile);
    }
}
