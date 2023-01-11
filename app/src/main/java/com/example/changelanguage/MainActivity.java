package com.example.changelanguage;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    //Initialize Variable
    TextView tvSelect, tvOutput;
    RadioGroup rgLanguage;
    RadioButton rbEnglish, rbHindi, rbMalay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asign variable
        tvSelect = findViewById(R.id.tv_select);
        rgLanguage = findViewById(R.id.rg_language);
        rbEnglish = findViewById(R.id.rb_english);
        rbHindi = findViewById(R.id.rb_hindi);
        rbMalay = findViewById(R.id.rb_melayu);

        //Set listener on radio group
        rgLanguage.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //Check condition
                switch (i) {
                    case R.id.rb_english:
                        //When english select
                        //Initialize string
                        String language = "en";
                        //Set locale
                        setLocale(language);
                        break;

                    case R.id.rb_hindi:
                        //When hindi select
                        //Set locale
                        setLocale("hi");
                        break;

                    case R.id.rb_melayu:
                        //When malay select
                        //Set locale
                        setLocale("ms");
                        break;


                }
            }
        });

    }

    private void setLocale(String language) {
        //Initialize resources
        Resources resource = getResources();
        //Initialize metrics
        DisplayMetrics metrics = resource.getDisplayMetrics();
        //Iniatialize configuration
        Configuration configuration = resource.getConfiguration();
        //Initialize licale
        configuration.locale = new Locale(language);
        //Update configuration
        resource.updateConfiguration(configuration, metrics);
        //Notify configuration
        onConfigurationChanged(configuration);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        //Set string from resources
        tvSelect.setText(R.string.select_language);
        rbEnglish.setText(R.string.english);
        rbHindi.setText(R.string.hindi);
    }
}