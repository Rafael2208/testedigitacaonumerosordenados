package com.example.teste1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber;
    private Button addButton;
    private TextView sortedNumbers;
    private List<Integer> numbersList;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.input_number);
        addButton = findViewById(R.id.add_button);
        sortedNumbers = findViewById(R.id.sorted_numbers);

        numbersList = new ArrayList<>();

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNumberToList();
            }
        });
    }

    private void addNumberToList() {
        String input = inputNumber.getText().toString().trim();

        if (!input.isEmpty()) {
            int number = Integer.parseInt(input);
            numbersList.add(number);
            Collections.sort(numbersList);

            displaySortedNumbers();
            inputNumber.setText("");
        }
    }

    private void displaySortedNumbers() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int number : numbersList) {
            stringBuilder.append(number).append(", ");
        }

        sortedNumbers.setText(stringBuilder.toString());
    }
}