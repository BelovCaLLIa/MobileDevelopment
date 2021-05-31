package ru.mirea.belov.assignment5_42;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myTextView = (TextView) findViewById(R.id.textView);
        myTextView.setText("New Text in MIREA");

        Button button = findViewById(R.id.button13);
        button.setText("Mirea Button");

        CheckBox checkBox = findViewById(R.id.check_Box);
        checkBox.setChecked(true);
    }
}