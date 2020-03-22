package com.dataentropia.room_viewmodel.data.local.dao;



import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.dataentropia.room_viewmodel.data.local.entity.Person;

import java.util.List;

@Dao
public interface PersonDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertPerson(Person person);

    @Update
    public void updatePerson(Person person);

    @Delete
    public void deletePerson(Person person);

    @Query("SELECT * FROM person")
    public LiveData<List<Person>> getAllPersons();

    @Query("SELECT * FROM person where mobile = :mobileIn")
    public LiveData<Person> getPersonByMobile(String mobileIn);

   /* @Query("SELECT * FROM person where city In (:cityIn)")
    public List<Person> getPersonByCities(List<String> cityIn);*/
}
