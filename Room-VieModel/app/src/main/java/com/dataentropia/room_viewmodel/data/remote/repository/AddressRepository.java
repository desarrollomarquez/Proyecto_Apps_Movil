package com.dataentropia.room_viewmodel.data.remote.repository;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;

import com.dataentropia.room_viewmodel.data.local.AppDatabase;
import com.dataentropia.room_viewmodel.data.local.dao.AddressDAO;
import com.dataentropia.room_viewmodel.data.local.entity.Address;


import java.util.List;

public class AddressRepository {

    private AddressDAO addressDAO;

    public AddressRepository(Context context) {
        addressDAO =  AppDatabase.getAppDatabase(context).AddressDatabase();
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
