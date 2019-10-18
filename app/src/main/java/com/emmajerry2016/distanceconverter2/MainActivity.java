    package com.emmajerry2016.distanceconverter2;

    import androidx.appcompat.app.AppCompatActivity;
    import android.os.Bundle;
    import android.text.Editable;
    import android.text.TextWatcher;
    import android.view.View;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.TextView;

    public class MainActivity extends AppCompatActivity {

        /****Below code is creative an xml element variables****/
        private EditText kmToMlEditText, mlToKmEditText;
        private TextView kmToMlViewText, mlToKmViewText;
        private String getKmInputedNumber, getMlInputedNumber;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            /****The below code is getting the ids of km to ml in order to have access to the element field****/
            kmToMlEditText = findViewById(R.id.inputKmValue);
            kmToMlViewText = findViewById(R.id.viewKmToMlValue);

            /****The below code is getting the ids of ml to km in order to have access to the element field****/
            mlToKmEditText = findViewById(R.id.inputMilesToKm);
            mlToKmViewText = findViewById(R.id.viewMlToKmValue);



                    //From Kilometer to miles
            kmToMlEditText.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {//This method executes ones the text changes

                }

                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    //this method executes before the actual character changes
                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //This method executes on the text change itself.so this is the method i need!
                    getKmInputedNumber = kmToMlEditText.getText().toString();

                    if (getKmInputedNumber.isEmpty()) {
                        mlToKmEditText.setError("Insert a number to be converted!");
                    }

                    //Converting String to double
                    else {
                        double getKmInputedNumberToDouble = Double.parseDouble(getKmInputedNumber);
                        final double calculateFromKmToMiles = getKmInputedNumberToDouble / 1.6;
                        final double roundingToMl = (Math.round(getKmInputedNumberToDouble * 100.0) / 100.0);

                        if (roundingToMl > 1) {
                            kmToMlViewText.setText(calculateFromKmToMiles + "mls");

                        } else if (roundingToMl <= 1) {
                            kmToMlViewText.setText(calculateFromKmToMiles + "ml");

                        }
                    }
                }

            });//end of addTextChangedListener method for kmToMlEditText

            /*******************====Creative====*********************/
            /********************====Emma====************************/
                 /*****************====Onah====******************/

            mlToKmEditText.addTextChangedListener(new TextWatcher() {

                @Override
                public void afterTextChanged(Editable s) {

                }
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    //For Miles to Kilometer
                    getMlInputedNumber = mlToKmEditText.getText().toString();

                    if (getMlInputedNumber.isEmpty()) {
                        mlToKmEditText.setError("Insert a number to be converted!");
                    }
                    else { //Converting String to double
                        double getMlInputedNumberToDouble = Double.parseDouble(getMlInputedNumber);
                        final double calculateFromMilesToKm = getMlInputedNumberToDouble * 1.6;
                        final double roundingKm = (Math.round(calculateFromMilesToKm * 100.0) / 100.0);

                        if (roundingKm > 1) {
                            mlToKmViewText.setText((calculateFromMilesToKm) + "kms");

                        } else if (roundingKm <= 1) {
                            mlToKmViewText.setText((roundingKm) + "km");

                        }
                    }
                }
            });//end of addTextChangedListener method for mlToKmEditText

    }

    }
