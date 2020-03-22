package com.dataentropia.room_viewmodel.data.local.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.dataentropia.room_viewmodel.data.local.entity.Address;

import java.util.List;

@Dao
public interface AddressDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertAddress(Address address);

    @Update
    public void updateAddress(Address address);

    @Delete
    public void deleteAddress(Address address);

    @Query("SELECT * FROM address")
    public LiveData<List<Address>> getAllAddress();

    @Query("SELECT * FROM address where id = :mobileIn")
    public LiveData<Address> getAddressByMobile(String mobileIn);

    @Query("SELECT * FROM address where city In (:cityIn)")
    public List<Address> getAddressByCities(List<String> cityIn);
}
