package com.example.qrwallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.qrwallet.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.UUID;

public class MainActivity3 extends AppCompatActivity {

    private EditText data3;
    private ImageView output3;
    private Button go3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        data3 = findViewById(R.id.QRtext2);
        go3 = findViewById(R.id.generate2);
        output3 = findViewById(R.id.qr_output);

        go3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String qrvalue = data3.getText().toString().trim();

                MultiFormatWriter writer = new MultiFormatWriter();

                try{
                    BitMatrix matrix = writer.encode(qrvalue, BarcodeFormat.QR_CODE, 800, 800);

                    BarcodeEncoder encoder = new BarcodeEncoder();
                    Bitmap bitmap = encoder.createBitmap(matrix);

                    output3.setImageBitmap(bitmap);

                    InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                    manager.hideSoftInputFromWindow(data3.getApplicationWindowToken(),0);
                } catch (WriterException e){
                    e.printStackTrace();
                }
            }
        });
    }
}