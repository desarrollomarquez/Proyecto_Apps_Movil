package com.dataentropia.room_viewmodel;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PersonViewModel personViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personViewModel = ViewModelProviders.of(this).get(PersonViewModel.class);

        //observe LiveData
        //this LiveData instance is not recreated after every db call, so registering observer in onCreate
        //corresponding DAO method returns List of Person objects, not LiveData
        observerPersonListResults(personViewModel.getPersonsByCityLive());

        observerAddressListResults(personViewModel.getAllAddress());

        //corresponding DAO method call returns LiveData
        //Transformations makes it possible to add observer only once to LiveData returned by room DAO
        observePersonByMobile(personViewModel.getPersonsByMobile());
    }

    private void observerPersonListResults(LiveData<List<Person>> personsLive) {
        //observer LiveData
        personsLive.observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(@Nullable List<Person> person) {
                if(person == null){
                    return;
                }
                else{
                    Toast.makeText(MainActivity.this, "Number of person objects in the response: "+person.get(0).getName()+"- "+person.get(1).getName(), Toast.LENGTH_LONG).show();
                }
                /*String cadena = " ";
                Iterator iter = person.iterator();
                while (iter.hasNext())
                    cadena = cadena + iter.next().toString();
                System.out.print(person);*/

            }
        });
    }

    private void observerAddressListResults(LiveData<List<Address>> addressLive) {
        //observer LiveData
        addressLive.observe(this, new Observer<List<Address>>() {
            @Override
            public void onChanged(@Nullable List<Address> addresses) {
                if(addresses == null){
                    return;
                }
                else {

                    Toast.makeText(MainActivity.this, "Number of address objects in the response: "+addresses.get(0).getAddressone()+" "+addresses.get(1).getAddressone(), Toast.LENGTH_LONG).show();
                }
                /*String cadena = " ";
                Iterator iter = person.iterator();
                while (iter.hasNext())
                    cadena = cadena + iter.next().toString();
                System.out.print(person);*/

            }
        });
    }

    private void observePersonByMobile(LiveData<Person> personByMob){
        personByMob.observe(this, new Observer<Person>() {
            @Override
            public void onChanged(@Nullable Person person) {
                if(person == null){
                    return;
                }
                ((TextView)findViewById(R.id.name)).setText(person.getName());
                ((TextView)findViewById(R.id.email)).setText(person.getEmail());
                ((TextView)findViewById(R.id.mobile)).setText(person.getMobile());
                //((TextView)findViewById(R.id.lineOne)).setText(person.getAddress().getLineOne());
                /*((TextView)findViewById(R.id.city)).setText(person.getAddress().getCity());
                ((TextView)findViewById(R.id.country)).setText(person.getAddress().getCountry());
                ((TextView)findViewById(R.id.zip)).setText(person.getAddress().getZip());*/
            }
        });
    }

    public void getAllPerson(View view){
        LiveData<List<Person>> allPersons = personViewModel.getAllPersons();
        observerPersonListResults(allPersons);
    }

    public void getAllAddress(View view){
        LiveData<List<Address>> allAddress = personViewModel.getAllAddress();
        observerAddressListResults(allAddress);
    }

    public void getPersonByMobile(View view){
        if((TextView)findViewById(R.id.mobile) == null){
            Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_LONG);
            return;
        }
        personViewModel.setMobile(((TextView)findViewById(R.id.mobile)).getText().toString());
    }

    public void getPersonByCities(View view){
        if((TextView)findViewById(R.id.mobile) == null){
            Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_LONG);
            return;
        }
        List<String> cityLst = new ArrayList<>();
        cityLst.add(((TextView)findViewById(R.id.city)).getText().toString());
        personViewModel.getPersonsByCity(cityLst);
    }

    public void addPerson(View view){
        if((TextView)findViewById(R.id.mobile) == null){
            Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_LONG);
            return;
        }
        personViewModel.addAddress(createAddress());
        personViewModel.addPerson(createPerson());
    }


    public void updatePerson(View view){
        if((TextView)findViewById(R.id.mobile) == null){
            Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_LONG);
            return;
        }
        personViewModel.updatePerson(createPerson());
    }

    public void deletePerson(View view){
        if((TextView)findViewById(R.id.mobile) == null){
            Toast.makeText(this, "Please enter mobile number", Toast.LENGTH_LONG);
            return;
        }
        personViewModel.deletePerson(createPerson());
    }

    private Person createPerson(){
        Person p = new Person();
        p.setName(((TextView)findViewById(R.id.name)).getText().toString());
        p.setEmail(((TextView)findViewById(R.id.email)).getText().toString());
        p.setMobile(((TextView)findViewById(R.id.mobile)).getText().toString());
        p.setId_address(1);
        return p;
    }

    private Address createAddress(){

        Address a = new Address();
        a.setAddressone(((TextView)findViewById(R.id.addressOne)).getText().toString());
        a.setCity(((TextView)findViewById(R.id.city)).getText().toString());
        a.setCountry(((TextView)findViewById(R.id.country)).getText().toString());
        a.setZip(((TextView)findViewById(R.id.zip)).getText().toString());
        return a;
    }
}
