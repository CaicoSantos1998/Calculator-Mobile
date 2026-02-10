package com.github.caicosantos1998.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText number1EditText;
    EditText number2EditText;
    Button additionButton;
    Button subtractionButton;
    Button multiplicationButton;
    Button divisionButton;
    TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bindComponent();
        createListeners();
    }

    private void bindComponent() {
        number1EditText = findViewById(R.id.number1EditText);
        number2EditText = findViewById(R.id.number2EditText);
        additionButton = findViewById(R.id.additionButton);
        subtractionButton = findViewById(R.id.subtractionButton);
        multiplicationButton = findViewById(R.id.multiplicationButton);
        divisionButton = findViewById(R.id.divisionButton);
        resultTextView = findViewById(R.id.resultTextView);
    }

    private void createListeners() {
        additionButton.setOnClickListener(event -> sum());
        subtractionButton.setOnClickListener(event -> subtract());
        multiplicationButton.setOnClickListener(event -> multiply());
        divisionButton.setOnClickListener(event -> divide());
    }

    private void sum() {
        String n1S = number1EditText.getText().toString();
        String n2S = number2EditText.getText().toString();
        if(n1S.isEmpty() || n2S.isEmpty()) {
            Toast.makeText(this, "Field Required!", Toast.LENGTH_LONG).show();
            return;
        }
        double n1 = Double.parseDouble(n1S);
        double n2 = Double.parseDouble(n2S);
        double result = n1 + n2;
        resultTextView.setText(String.valueOf(result));
    }
    private void subtract() {
        String n1S = number1EditText.getText().toString();
        String n2S = number2EditText.getText().toString();
        if(n1S.isEmpty() || n2S.isEmpty()) {
            Toast.makeText(this, "Field Required!", Toast.LENGTH_LONG).show();
            return;
        }
        double n1 = Double.parseDouble(n1S);
        double n2 = Double.parseDouble(n2S);
        double result = n1-n2;
        resultTextView.setText(String.valueOf(result));
    }
    private void multiply() {
        String n1S = number1EditText.getText().toString();
        String n2S = number2EditText.getText().toString();
        if(n1S.isEmpty() || n2S.isEmpty()) {
            Toast.makeText(this, "Field Required!", Toast.LENGTH_LONG).show();
            return;
        }
        double n1 = Double.parseDouble(n1S);
        double n2 = Double.parseDouble(n2S);
        double result = n1*n2;
        resultTextView.setText(String.valueOf(result));
    }
    private void divide() {
        String n1S = number1EditText.getText().toString();
        String n2S = number2EditText.getText().toString();
        if(n1S.isEmpty() || n2S.isEmpty()) {
            Toast.makeText(this, "Field Required!", Toast.LENGTH_LONG).show();
            return;
        }
        double n1 = Double.parseDouble(n1S);
        double n2 = Double.parseDouble(n2S);
        if(n1==0 || n2==0) {
            Toast.makeText(this, "It's not possible to divide by 0", Toast.LENGTH_LONG).show();
            return;
        }
        double result = n1/n2;
        resultTextView.setText(String.valueOf(result));
    }

}