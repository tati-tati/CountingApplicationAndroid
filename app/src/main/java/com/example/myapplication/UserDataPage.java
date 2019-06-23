package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UserDataPage extends AppCompatActivity {
    User user = User.getInstance();
    private TextInputEditText firstName;
    private TextInputEditText middleName;
    private TextInputEditText lastName;
    private TextInputEditText fullAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        firstName = (TextInputEditText) findViewById(R.id.Text_FirstName);
        middleName = (TextInputEditText) findViewById(R.id.Text_MiddleName);
        lastName = (TextInputEditText) findViewById(R.id.Text_LastName);
        fullAddress = (TextInputEditText) findViewById(R.id.Text_FullAddress);
        if (user.getFirstName() != null) firstName.append(user.getFirstName());
        if (user.getMiddleName() != null) middleName.append(user.getMiddleName());
        if (user.getLastName() != null) lastName.append(user.getLastName());
        if (user.getAddress() != null) fullAddress.append(user.getAddress());

        Button backToMain = (Button) findViewById(R.id.btn_back_to_main_user_data);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserDataPage.this, Main.class));
            }
        });

        Button saveUserData = (Button) findViewById(R.id.btn_save_user_data);
        saveUserData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setFirstName(firstName.getText().toString());
                user.setMiddleName(middleName.getText().toString());
                user.setLastName(lastName.getText().toString());
                user.setAddress(fullAddress.getText().toString());
            }
        });

    }
}
