package com.example.owner.styleeditor;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText UsernameInput;
    EditText PasswordInput;
    EditText BornInput;
    EditText AddressInput;
    TextView UserStatus;
    TextView PassStatus;
    TextView BornStatus;
    TextView AddressStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsernameInput = (EditText) findViewById(R.id.UsernameInput);
        PasswordInput = (EditText) findViewById(R.id.PasswordInput);
        BornInput = (EditText) findViewById(R.id.BornInput);
        AddressInput = (EditText) findViewById(R.id.AddressInput);
        UserStatus = (TextView) findViewById(R.id.UserStatus);
        PassStatus = (TextView) findViewById(R.id.PassStatus);
        BornStatus = (TextView) findViewById(R.id.BornStatus);
        AddressStatus = (TextView) findViewById(R.id.AddressStatus);
    }
    // Save the file into Sharedprefrences
    public void SaveInfo(View view)
    {
        //Only can be accessed through this app
        //User info is the name of the sharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("userinfo", ContextThemeWrapper.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("UserInput", UsernameInput.getText().toString());
        editor.putString("PassInput", PasswordInput.getText().toString());
        editor.putString("BornInput", BornInput.getText().toString());
        editor.putString("AddressInput", AddressInput.getText().toString());
        editor.apply();
        Toast.makeText(this, "Saved!", Toast.LENGTH_LONG).show();

    }

    public void DisplayInfo(View view)
    {
        SharedPreferences sharedPref = getSharedPreferences("userinfo", ContextThemeWrapper.MODE_PRIVATE);
        //input the data from shared preferences
        String Username = sharedPref.getString("UserInput", "");
        String Password = sharedPref.getString("PassInput", "");
        String BornDate = sharedPref.getString("BornInput", "");
        String Address = sharedPref.getString("AddressInput", "");
        UserStatus.setText(Username);
        PassStatus.setText(Password);
        BornStatus.setText(BornDate);
        AddressStatus.setText(Address);
    }

}
