package com.example.app2semester2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private EditText nameInput,surnameInput,phoneInput,addressInput;
    private Button confirmButton,changePictureButton;
    private String name,surname,phone,address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nameInput = findViewById(R.id.editName);
        surnameInput = findViewById(R.id.editSurName);
        phoneInput = findViewById(R.id.editNum);
        addressInput = findViewById(R.id.editAdd);
        confirmButton = findViewById(R.id.buttonConfirm);


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nameInput.getText().toString();
                surname = surnameInput.getText().toString();
                phone = phoneInput.getText().toString();
                address = addressInput.getText().toString();

                Intent intent = new Intent(MainActivity.this, secondActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("surname", surname);
                intent.putExtra("phone", phone);
                intent.putExtra("address", address);

                startActivity(intent);
            }
        });

    }

}