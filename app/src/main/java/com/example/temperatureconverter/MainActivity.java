
package com.example.temperatureconverter;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText celsiusInput;
    Button convertButton;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        celsiusInput = findViewById(R.id.celsiusInput);
        convertButton = findViewById(R.id.convertButton);
        resultText = findViewById(R.id.resultText);

        convertButton.setOnClickListener(v -> {

            String input = celsiusInput.getText()
                    .toString().trim();

            if (input.isEmpty()) {
                celsiusInput.setError("Enter Celsius value");
                return;
            }

            try {
                double celsius = Double.parseDouble(input);

                double fahrenheit =
                        (celsius * 9 / 5) + 32;

                resultText.setText(String.format(
                        Locale.getDefault(),
                        "%.2f °F",
                        fahrenheit
                ));

            } catch (NumberFormatException e) {
                celsiusInput.setError("Enter a valid number");
            }
        });
    }
}
