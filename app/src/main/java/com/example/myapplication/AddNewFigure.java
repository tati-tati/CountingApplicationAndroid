package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentText;
import com.google.firebase.ml.vision.document.FirebaseVisionDocumentTextRecognizer;

public class AddNewFigure extends AppCompatActivity {
    private static final int CAMERA_REQUEST = 0;
    private ImageView imageView;
    private Button openCamera;
    private EditText newFigure;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_figure);

        imageView = (ImageView) findViewById(R.id.image_cameraSource);

        newFigure = (EditText) findViewById(R.id.editText_add_new_figure);
        newFigure.setText("0");

        openCamera = (Button) findViewById(R.id.btn_open_camera);
        openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(imageBitmap);
            //firebase
            FirebaseVisionImage imageFirebase = FirebaseVisionImage.fromBitmap(imageBitmap);
            FirebaseVisionDocumentTextRecognizer detector = FirebaseVision.getInstance()
                    .getCloudDocumentTextRecognizer();
            //recognizer
            detector.processImage(imageFirebase)
                    .addOnSuccessListener(new OnSuccessListener<FirebaseVisionDocumentText>() {
                        @Override
                        public void onSuccess(FirebaseVisionDocumentText result) {
                            String resultText = result.getText();

                            newFigure.setText(resultText);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            newFigure.setText("-1");

                        }
                    });
        }
    }
}
