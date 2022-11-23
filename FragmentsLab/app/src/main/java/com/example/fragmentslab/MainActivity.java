package com.example.fragmentslab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button buttonOk;
    RadioButton radioEasy, radioAverage, radioHard, radioTheoretical, radioPractical;
    ConstraintLayout container;

    String currentLevel, currentType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        radioEasy.setOnClickListener(v -> onLevelEasyChosen());
        radioAverage.setOnClickListener(v -> onLevelAverageChosen());
        radioHard.setOnClickListener(v -> onLevelHardChosen());

        radioTheoretical.setOnClickListener(v -> onTypeTheoreticalChosen());
        radioPractical.setOnClickListener(v -> onTypePracticalChosen());

        buttonOk.setOnClickListener(v -> {
            if (editText.getText().length() == 0) {
                Toast.makeText(this, "Помилка. Введіть текст завдання", Toast.LENGTH_LONG).show();
                return;
            }

            if (currentLevel == null) {
                Toast.makeText(this, "Помилка. Оберіть рівень", Toast.LENGTH_LONG).show();
                return;
            }

            if (currentType == null) {
                Toast.makeText(this, "Помилка. Оберіть тип завдання", Toast.LENGTH_LONG).show();
                return;
            }

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(
                    R.id.container,
                    ResultFragment.newInstance(editText.getText().toString(), currentLevel, currentType)
            );
            transaction.addToBackStack("default");
            transaction.commit();
        });
    }

    private void initViews() {
        editText = findViewById(R.id.editText);
        buttonOk = findViewById(R.id.buttonOk);
        radioEasy = findViewById(R.id.radioButtonEasy);
        radioAverage = findViewById(R.id.radioButtonAverage);
        radioHard = findViewById(R.id.radioButtonHard);
        radioTheoretical = findViewById(R.id.radioButtonTheoretical);
        radioPractical = findViewById(R.id.radioButtonPractical);
        container = findViewById(R.id.container);
    }

    private void onLevelEasyChosen() {
        radioAverage.setChecked(false);
        radioHard.setChecked(false);
        currentLevel = "easy";
    }

    private void onLevelAverageChosen() {
        radioEasy.setChecked(false);
        radioHard.setChecked(false);
        currentLevel = "average";
    }

    private void onLevelHardChosen() {
        radioEasy.setChecked(false);
        radioAverage.setChecked(false);
        currentLevel = "hard";
    }

    private void onTypeTheoreticalChosen() {
        radioPractical.setChecked(false);
        currentType = "theoretical";
    }

    private void onTypePracticalChosen() {
        radioTheoretical.setChecked(false);
        currentType = "practical";
    }

}