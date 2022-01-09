package com.example.meterconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInches;
    private EditText editTextCentimeters;
    private EditText editTextFeet;
    private EditText editTextYards;
    private EditText editTextKilometers;
    private EditText editTextMiles;
    private Button buttonToMeters;
    private TextView resultText;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        calculateMetersButtonClickListener();
    }


    private void findViews() {
        editTextInches = findViewById(R.id.inches_to_convert);
        editTextCentimeters = findViewById(R.id.centimeters_to_convert);
        editTextFeet = findViewById(R.id.feet_to_convert);
        editTextYards = findViewById(R.id.yards_to_convert);
        editTextKilometers = findViewById(R.id.kilometers_to_convert);
        editTextMiles = findViewById(R.id.miles_to_convert);
        buttonToMeters = findViewById(R.id.calculate_button);
        resultText = findViewById(R.id.result_text);

    }

    private String validate() {
        EditText[] values = new EditText[]{
                editTextInches,
                editTextCentimeters,
                editTextFeet,
                editTextYards,
                editTextKilometers,
                editTextMiles
        };

        for (EditText editTextValue : values) {
            boolean output = checkTextInput(editTextValue);
            if (output == false) {
                    //clear all the fields
                    Toast.makeText(MainActivity.this, "Too many values added to input", Toast.LENGTH_SHORT).show();
                    editTextValue.getText().clear();
            }
        }
        return "Valid";
    }



    private void calculateMetersButtonClickListener() {
        buttonToMeters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inchesInputText = editTextInches.getText().toString();
                String centimetersInputText = editTextCentimeters.getText().toString();
                String feetInputText = editTextFeet.getText().toString();
                String yardsInputText = editTextYards.getText().toString();
                String kilometersInputText = editTextKilometers.getText().toString();
                String milesInputText = editTextMiles.getText().toString();

                validate();

                //aim to refactor code - perhaps to switch?
                if (!inchesInputText.isEmpty()) {
                    try {
                        Integer.parseInt(inchesInputText);
                        double metersResult = calculateInchesToMeters(inchesInputText);
                        displayMetersResult(metersResult);
                        count = 0;
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else if (!centimetersInputText.isEmpty()) {
                    try {
                        Integer.parseInt(centimetersInputText);
                        double metersResult = calculateCentimetersToMeters(centimetersInputText);
                        displayMetersResult(metersResult);
                        count = 0;
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else if (!feetInputText.isEmpty()) {
                    try {
                        Integer.parseInt(feetInputText);
                        double metersResult = calculateFeetToMeters(feetInputText);
                        displayMetersResult(metersResult);
                        count = 0;
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else if (!yardsInputText.isEmpty()) {
                    try {
                        Integer.parseInt(yardsInputText);
                        double metersResult = calculateYardsToMeters(yardsInputText);
                        displayMetersResult(metersResult);
                        count = 0;
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else if (!kilometersInputText.isEmpty()) {
                    try {
                        Integer.parseInt(kilometersInputText);
                        double metersResult = calculateKilometersToMeters(kilometersInputText);
                        displayMetersResult(metersResult);
                        count = 0;
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else if (!milesInputText.isEmpty()) {
                    try {
                        Integer.parseInt(milesInputText);
                        double meterResult = calculateMilesToMeters(milesInputText);
                        displayMetersResult(meterResult);
                        count = 0;
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter measurements to convert", Toast.LENGTH_LONG).show();
                }
            }

        });
    }


    private boolean checkTextInput(EditText input) {

        String inputValue = input.getText().toString();

        if (inputValue.length() > 0) {
            count++;
            if (count > 1) {
                return false;
            }
        }
        return true;

    }


    private double calculateInchesToMeters(String inchesInputText) {

        int inches = Integer.parseInt(inchesInputText);
        double meters = inches * 0.0254;
        return meters;
    }

    private double calculateCentimetersToMeters(String centimetersInputText) {

        int centimeters = Integer.parseInt(centimetersInputText);
        double meters = centimeters / 100.00;
        return meters;
    }

    private double calculateFeetToMeters(String feetInputText) {

        int feet = Integer.parseInt(feetInputText);
        double meters = feet * 0.3048;
        return meters;
    }

    private double calculateYardsToMeters(String yardsInputText) {

        int yards = Integer.parseInt(yardsInputText);
        double meters = yards * 0.9144;
        return meters;
    }

    private double calculateKilometersToMeters(String kilometersInputText) {

        int kilometers = Integer.parseInt(kilometersInputText);
        double meters = kilometers * 1000.00;
        return meters;
    }

    private double calculateMilesToMeters(String milesInputText) {

        int miles = Integer.parseInt(milesInputText);
        double meters = miles * 1609.344;
        return meters;
    }


    private void displayMetersResult(double meters) {

        DecimalFormat meterDecimalFormat = new DecimalFormat("0.00");

        String metersTextResult = meterDecimalFormat.format(meters);
        String metersResult = metersTextResult + " meters";
        resultText.setText(metersResult);
    }

    private void errorMessage() {
        Toast.makeText(MainActivity.this, "The input is invalid", Toast.LENGTH_SHORT).show();
    }


}