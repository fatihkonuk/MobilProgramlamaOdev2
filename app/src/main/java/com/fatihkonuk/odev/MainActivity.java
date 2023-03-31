package com.fatihkonuk.odev;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView fk_txt1,fk_txt2,fk_txt3;
    Button fk_textColorBtn,fk_fontBtn,fk_bgColorBtn,fk_changeBtn,fk_randomBtn;
    Spinner fk_colorSpinner,fk_bgSpinner;
    EditText fk_fontSizeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fk_txt1 = findViewById(R.id.txt1);
        fk_txt2 = findViewById(R.id.txt2);
        fk_txt3 = findViewById(R.id.txt3);
        //Buttons
        fk_textColorBtn = findViewById(R.id.btnTextColor);
        fk_bgColorBtn = findViewById(R.id.btnBgColor);
        fk_fontBtn = findViewById(R.id.btnFont);
        fk_changeBtn = findViewById(R.id.btnChange);
        fk_randomBtn = findViewById(R.id.btnRandom);
        //Spinner
        fk_colorSpinner = findViewById(R.id.colorSpinner);
        fk_bgSpinner = findViewById(R.id.bgSpinner);
        fk_fontSizeView = findViewById(R.id.fontSizeView);


        // Color Spinner
        ArrayAdapter<CharSequence> fk_colorAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.colorNameList,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        fk_colorSpinner.setAdapter(fk_colorAdapter);

        // BG Spinner
        ArrayAdapter<CharSequence> fk_bgAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.colorNameList,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item
        );
        fk_bgSpinner.setAdapter(fk_bgAdapter);

        //Text Color Change
        fk_textColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] fk_colorCodes = getResources().getStringArray(R.array.colorCodeList);
                int fk_index = fk_colorSpinner.getSelectedItemPosition();
                String fk_code = "#"+fk_colorCodes[fk_index];
                int fk_color = Color.parseColor(fk_code);
                fk_txt1.setTextColor(fk_color);
                fk_txt2.setTextColor(fk_color);
                fk_txt3.setTextColor(fk_color);
            }
        });

        // Background Color Change
        fk_bgColorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] fk_colorCodes = getResources().getStringArray(R.array.colorCodeList);
                int fk_index = fk_bgSpinner.getSelectedItemPosition();
                String fk_code = "#"+fk_colorCodes[fk_index];
                int fk_color = Color.parseColor(fk_code);
                fk_txt1.setBackgroundColor(fk_color);
                fk_txt2.setBackgroundColor(fk_color);
                fk_txt3.setBackgroundColor(fk_color);
            }
        });

        // Font Size Change
        fk_fontBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fk_value = fk_fontSizeView.getText().toString();
                if (fk_value.isEmpty()) {
                    Context fk_context = getApplicationContext();
                    CharSequence fk_text = "Bir Değer Girin!";
                    int fk_duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(fk_context, fk_text, fk_duration);
                    toast.show();
                }else {
                    int fk_fontSize = Integer.parseInt(fk_value);
                    fk_txt1.setTextSize(fk_fontSize);
                    fk_txt2.setTextSize(fk_fontSize);
                    fk_txt3.setTextSize(fk_fontSize);
                }
            }
        });

        // Change All
        fk_changeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fk_textColorBtn.callOnClick();
                fk_bgColorBtn.callOnClick();
                fk_fontBtn.callOnClick();
            }
        });

        // Random Change
        fk_randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fk_txt1.setTextColor(fk_GetRandomColor());
                fk_txt1.setBackgroundColor(fk_GetRandomColor());
                fk_txt1.setTextSize(fk_GetRandomFontSize());

                fk_txt2.setTextColor(fk_GetRandomColor());
                fk_txt2.setBackgroundColor(fk_GetRandomColor());
                fk_txt2.setTextSize(fk_GetRandomFontSize());

                fk_txt3.setTextColor(fk_GetRandomColor());
                fk_txt3.setBackgroundColor(fk_GetRandomColor());
                fk_txt3.setTextSize(fk_GetRandomFontSize());
            }
        });
    }

    public int fk_GetRandomColor() {
        String[] fk_colorList = getResources().getStringArray(R.array.colorCodeList);
        Random fk_random = new Random();
        int fk_index = fk_random.nextInt(fk_colorList.length);
        String fk_code = "#"+fk_colorList[fk_index];
        int color = Color.parseColor(fk_code);
        return color;
    }
    public int fk_GetRandomFontSize() {
        Random fk_random = new Random();
        int fk_size = fk_random.nextInt(30)+10;
        return fk_size;
    }
}