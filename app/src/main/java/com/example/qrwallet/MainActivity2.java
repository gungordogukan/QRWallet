package com.example.qrwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity2 extends AppCompatActivity {

    private EditText data, data2;
    private ImageView output;
    private Button go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        data = findViewById(R.id.QRtext);
        data2 = findViewById(R.id.editTextTextPersonName2);
        go = findViewById(R.id.generate);
        output = findViewById(R.id.qr_output2);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String qrvalue = data.getText().toString().trim();

                MultiFormatWriter writer = new MultiFormatWriter();

                String ssid = data.getText().toString().trim();
                String password = data2.getText().toString().trim();

                String wifiString = "WIFI:S:%s;T:WPA;P:%s;;";
                wifiString = String.format(wifiString, ssid, password);

                try{
                    BitMatrix matrix = writer.encode(wifiString, BarcodeFormat.QR_CODE, 800, 800);

                    BarcodeEncoder encoder = new BarcodeEncoder();
                    Bitmap bitmap = encoder.createBitmap(matrix);

                    output.setImageBitmap(bitmap);

                    InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

                    manager.hideSoftInputFromWindow(data.getApplicationWindowToken(),0);
                } catch (WriterException e){
                    e.printStackTrace();
                }

            }
        });
    }
}