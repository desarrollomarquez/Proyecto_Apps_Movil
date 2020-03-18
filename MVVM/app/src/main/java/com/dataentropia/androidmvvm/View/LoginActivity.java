package com.dataentropia.androidmvvm.view;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;

import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.textfield.TextInputLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;


import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


public class LoginActivity extends AppCompatActivity implements View.OnFocusChangeListener{
    private static final String TAG = LoginActivity.class.getSimpleName();

    private EditText fechapickerlogin, NumDoclogin;
    private MaterialSpinner TidLogin;
    private ProgressDialog pDialog;
    private ImageButton obtenerfechalogin, imageButtonLogin, imageButtonRegister;
    private SessionManager session;
    public  DatabaseHandler db;
    private AwesomeValidation awesomeValidation;


    private static final String CERO = "0";
    private static final String migrado = "Existe_Migrado";
    private static final String BARRA = "/";
    public  static int   tid = 1;
    private static String anniouser = "";
    public  static String Parametro_Edad_Usuario = "";
    public  HashMap<String,String> usuario = new HashMap<String,String>();
    public  HashMap<String,String> device = new HashMap<String,String>();


    // Get Current Date
    public final Calendar c = Calendar.getInstance();
    final int anio = c.get(Calendar.YEAR);
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);

    private static final int REQUEST_CODE = 101;
    public  static String IMEINumber = "";
    public  static String PhoneNumber = "";
    public  static String VersionDevice;
    private TextView txtBtnLogin, txtBtnRegister;
    private boolean numDocIsValid = false, fechaNacIsValid = false, tipoDocIsValid = true;
    //private AutoCompleteTextView tipoDocSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        // session manager
        session = new SessionManager(getApplicationContext());

        // check user is already logged in
        if (session.isLoggedIn()) {
            Intent i = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(i);
            finish();
        }

        // create sqlite database
        db = new DatabaseHandler(getApplicationContext());
        db.resetTables();
        Parametro_Edad_Usuario = db.getParameter("PAR_013");

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_CODE);
            return;
        }
        IMEINumber = telephonyManager.getDeviceId();
        VersionDevice = telephonyManager.getDeviceSoftwareVersion();
        PhoneNumber = telephonyManager.getLine1Number();
        device = db.getDeviceDetails();
        if(db.getDeviceRowCount() == 0){
            db.addDevice(IMEINumber,"Android 10 (API 29)",PhoneNumber);
        }

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        TidLogin = findViewById(R.id.TidLogin);
        NumDoclogin = findViewById(R.id.NumDoclogin);
        fechapickerlogin  = findViewById(R.id.fechapickerlogin);
        //obtenerfechalogin  = findViewById(R.id.obtenerfechalogin);
        imageButtonLogin = findViewById(R.id.imageButtonLogin);
        imageButtonRegister = findViewById(R.id.imageButtonRegister);
        txtBtnLogin = findViewById( R.id.txtBtnLogin);
        txtBtnRegister = findViewById( R.id.txtBtnRegister);
        //tipoDocSearch = findViewById( R.id.TidLogin);

        agregarFontsPantalla();
        agregarListenerValidaciones();

        /*List<String> lstTiposDocumento =  db.getListTid();
        ArrayAdapter arrayAdapter= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstTiposDocumento);
        tipoDocSearch.setAdapter(arrayAdapter);
        tipoDocSearch.setText(lstTiposDocumento.get(0), false);
        numDocIsValid = true;
        tipoDocSearch.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String tipoDoc = (String)parent.getItemAtPosition(position);

                switch(tipoDoc) {
                    case "Cedula de Ciudadania":
                        tid = 1;
                        break;
                    case "Tarjeta Identidad":
                        tid = 2;
                        break;
                    case "Cedula de Extranjera":
                        tid = 3;
                        break;
                    default:
                        tid = 1;
                        break;
                }
                NumDoclogin.requestFocus();
            }


        });
        tipoDocSearch.setInputType(0);*/



        fechapickerlogin.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_LEFT = 0;
                final int DRAWABLE_TOP = 1;
                final int DRAWABLE_RIGHT = 2;
                final int DRAWABLE_BOTTOM = 3;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (fechapickerlogin.getRight() - fechapickerlogin.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        // your action here
                        obtenerFechaNacimiento();
                        return true;
                    }
                }
                return false;
            }
        });

        fechapickerlogin.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(fechapickerlogin.getText().length() > 9)
                    imageButtonLogin.requestFocus();
                return false;
            }
        });

        TidLogin.setItems(db.getListTid());
        TidLogin.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                switch(item) {
                    case "Cedula de Ciudadania":
                        tid = 1;
                        break;
                    case "Tarjeta Identidad":
                        tid = 2;
                        break;
                    case "Cedula de Extranjera":
                        tid = 3;
                        break;
                    default:
                        tid = 1;
                        break;
                }
            }
        });

        //addValidation
        awesomeValidation.addValidation(this, R.id.NumDoclogin, Functions.EMPTY_NUMBER, R.string.numerodocoerror);
        awesomeValidation.addValidation(this, R.id.fechapickerlogin, Functions.DD_MM_AAAA, R.string.fechanacerror);

        //imageButtonLogin.setEnabled(false);

        // Progress dialog
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);

        // Hide Keyboard
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);



        init();
    }

    private void init() {

        imageButtonLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {


                if (habilitarBotonContinuar()) {
                    String numdoc = NumDoclogin.getText().toString().trim();
                    String fnacimiento = fechapickerlogin.getText().toString().trim();
                    SimpleDateFormat curFormater = new SimpleDateFormat("dd/MM/yyyy");
                    Date dateObj;
                    try {
                        dateObj = curFormater.parse(fnacimiento);
                        anniouser = Functions.validarEdad(dateObj);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    if(Integer.parseInt(anniouser) >= Integer.parseInt(Parametro_Edad_Usuario) && tid != 2 ){ // Definir edad como parametro de tabla   && tid.equals(usuario.get("id_tid")) && fnacimiento.equals(usuario.get("fnac"))


                        pDialog.setMessage(String.valueOf(tid));
                        showDialog();


                    }
                    else{

                        Toast.makeText(getApplicationContext(), "Tipo de documento no coincide con la edad del usuario. !Por Favor valide la información!", Toast.LENGTH_LONG).show();
                    }

                }


            }


            });

        /*tipoDocSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tipoDocSearch.showDropDown();
            }
        });

        tipoDocSearch.setKeyListener(null);*/


        imageButtonRegister.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });


    }



    public void showDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    public void hideDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }

    private void obtenerFechaNacimiento() {
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el dÃ­a obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? CERO + String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? CERO + String.valueOf(mesActual):String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                fechapickerlogin.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);
                if(!NumDoclogin.getText().toString().trim().isEmpty() && !fechapickerlogin.getText().toString().trim().isEmpty()
                  ){
                    //imageButtonLogin.setEnabled(true);
                    imageButtonLogin.setImageResource(R.drawable.boton_activo);
                }

            }
        },anio, mes, dia);
        recogerFecha.show();
    }


    private void agregarFontsPantalla()
    {
        FontManager fm = new FontManager(this);

        NumDoclogin.setTypeface( fm.Avenir());
        fechapickerlogin.setTypeface( fm.Avenir());
       // tipoDocSearch.setTypeface( fm.Avenir());
        txtBtnLogin.setTypeface( fm.MuktaLight());
        txtBtnRegister.setTypeface(fm.MuktaLight());


    }

    private void agregarListenerValidaciones()
    {
        NumDoclogin.setOnFocusChangeListener(this);
        fechapickerlogin.setOnFocusChangeListener(this);
       // tipoDocSearch.setOnFocusChangeListener(this);
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus)
    {
        switch(v.getId()){

            /*case R.id.TidLogin:

                if(!hasFocus)
                {
                    TextInputLayout til1 = findViewById(R.id.LaytipoDocLogin);
                   // tipoDocIsValid = CustomValidator.ValidacionCampo(tipoDocSearch, til1, Functions.EMPTY_STRING, "El formato del tipo de documento es incorrecto", true,false);
                    tipoDocIsValid = CustomValidator.ValidacionCampo(TidLogin, til1, Functions.EMPTY_STRING, "El formato del tipo de documento es incorrecto", true,false);
                }
                else
                {
                    tipoDocSearch.showDropDown();
                }
                break;*/

            case R.id.NumDoclogin:

               // if(!hasFocus)
               // {
                    TextInputLayout til2 = findViewById(R.id.LayNumDocLogIn);
                    numDocIsValid = CustomValidator.ValidacionCampo(NumDoclogin, til2, Functions.EMPTY_NUMBER, "El formato del número de documento es incorrecto", true, true);
                //}
                break;

            case R.id.fechapickerlogin:

                //if(!hasFocus) {
                    TextInputLayout til3 = findViewById(R.id.LayFechaNacLogin);
                    fechaNacIsValid = CustomValidator.ValidacionCampo(fechapickerlogin, til3, Functions.DD_MM_AAAA, "El formato de la fecha es incorrecto", true, false);
                //}
                break;

            default:

                break;


        }

        habilitarBotonContinuar();

    }

    private boolean habilitarBotonContinuar()
    {

        if(//numDocIsValid && fechaNacIsValid && tipoDocIsValid &&
        !NumDoclogin.getText().toString().trim().isEmpty() &&
        !fechapickerlogin.getText().toString().trim().isEmpty()) //&&
       // !tipoDocSearch.getText().toString().trim().isEmpty())
        {
            imageButtonLogin.setImageResource(R.drawable.boton_activo);
            return true;
        }
        else
        {
            imageButtonLogin.setImageResource(R.drawable.boton_noactivo);
            return false;
        }
    }



}