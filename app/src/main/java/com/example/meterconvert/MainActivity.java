package com.example.meterconvert;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInches;
    private EditText editTextCentimeters;
    private EditText editTextFeet;
    private EditText editTextYards;
    private EditText editTextKilometers;
    private EditText editTextMiles;
    private Button buttonToMeters;
    private TextView resultText;

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


                if (!inchesInputText.isEmpty()) {
                    try {
                        Integer.parseInt(inchesInputText);
                        double metersResult = calculateInchesToMeters(inchesInputText);
                        displayMetersResult(metersResult);
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else if (!centimetersInputText.isEmpty()) {
                    try {
                        Integer.parseInt(centimetersInputText);
                        double metersResult = calculateCentimetersToMeters(centimetersInputText);
                        displayMetersResult(metersResult);
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else if (!feetInputText.isEmpty()) {
                    try {
                        Integer.parseInt(feetInputText);
                        double metersResult = calculateFeetToMeters(feetInputText);
                        displayMetersResult(metersResult);
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else if (!yardsInputText.isEmpty()) {
                    try {
                        Integer.parseInt(yardsInputText);
                        double metersResult = calculateYardsToMeters(yardsInputText);
                        displayMetersResult(metersResult);
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else if (!kilometersInputText.isEmpty()) {
                    try {
                        Integer.parseInt(kilometersInputText);
                        double metersResult = calculateKilometersToMeters(kilometersInputText);
                        displayMetersResult(metersResult);
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else if (!milesInputText.isEmpty()) {
                    try {
                        Integer.parseInt(milesInputText);
                        double meterResult = calculateMilesToMeters(milesInputText);
                        displayMetersResult(meterResult);
                    } catch (NumberFormatException e) {
                        errorMessage();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Please enter measurements to convert", Toast.LENGTH_LONG).show();
                }
            }
        });
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

    private void errorMessage(){
        Toast.makeText(MainActivity.this, "The input is invalid", Toast.LENGTH_SHORT).show();
    }


}