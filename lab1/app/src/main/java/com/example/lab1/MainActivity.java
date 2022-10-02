package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup, radioGroup1;
    RadioButton radioButton, radioButton1;
    TextView textView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.selection);
        editText = findViewById(R.id.user_field);
        radioGroup1 = findViewById(R.id.radioGroup1);

        int radioId = radioGroup.getCheckedRadioButtonId();
        int radioIdOne = radioGroup1.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);
        radioButton1 = findViewById(radioIdOne);



        if(editText.getText().toString().equals("")){
            textView.setText("Please, enter user field.");
        }
        else if(radioId==-1){
            textView.setText("Choose type.");
        }
        else if(radioIdOne==-1){
            textView.setText("Choose complexity.");
        }
        else {
            textView.setText("Your information: "  + editText.getText().toString() + " is a " + radioButton.getText() + " with " + radioButton1.getText() + " complexity.");
        }

    }

};
