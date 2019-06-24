package com.tatitati.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

public class UserDataPageActivity extends AppCompatActivity {
    User user = User.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_user_data);

        TextInputEditText firstName = findViewById(R.id.Text_FirstName);
        TextInputEditText middleName = findViewById(R.id.Text_MiddleName);
        TextInputEditText lastName = findViewById(R.id.Text_LastName);
        TextInputEditText fullAddress = findViewById(R.id.Text_FullAddress);

        if (user.getFirstName() != null) firstName.append(user.getFirstName());
        if (user.getMiddleName() != null) middleName.append(user.getMiddleName());
        if (user.getLastName() != null) lastName.append(user.getLastName());
        if (user.getAddress() != null) fullAddress.append(user.getAddress());

        Button backToMain = findViewById(R.id.btn_back_to_main_user_data);
        backToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserDataPageActivity.this, MainActivity.class));
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
