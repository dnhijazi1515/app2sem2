package com.example.app2semester2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

public class secondActivity extends AppCompatActivity {
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private Button goBackButton,changePictureButton;
    private TextView detailsView;
    private ImageView imageView;
    private Bitmap imageBitmap;
    private Bundle extras;
    private String name,surname,phone,address,details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        changePictureButton = findViewById(R.id.buttonChangePicture);
        changePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

            }
        });
        detailsView = findViewById(R.id.textViewDetails);
        goBackButton = findViewById(R.id.buttonGoBack);
        imageView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        surname = intent.getStringExtra("surname");
        phone = intent.getStringExtra("phone");
        address = intent.getStringExtra("address");


        details = "Name: " + name + "\nSurname: " + surname + "\nPhone: " + phone + "\nAddress: " + address;
        detailsView.setText(details);
        imageBitmap = (Bitmap) intent.getParcelableExtra("image");
        if (imageBitmap != null) {
            imageView.setImageBitmap(imageBitmap);
        }
    }
    public void back(View view) {
        finish();

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            extras=data.getExtras();
            imageBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }


}