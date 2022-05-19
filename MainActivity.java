package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int count;
    int secondCount;
    public void openActivity2(int n1, int n2) {
        Intent intent = new Intent(this, MainActivity3.class);
        intent.putExtra("count", n1);
        intent.putExtra("secondCount", n2);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view) {
        TextView firstTerm = findViewById(R.id.editTextTextPersonName2);
        TextView secondTerm = findViewById(R.id.editTextTextPersonName3);
        try {
            count = Integer.parseInt(String.valueOf(firstTerm.getText()));
            secondCount = Integer.parseInt(String.valueOf(secondTerm.getText()));
            openActivity2(count, secondCount);
        } catch (Exception ex) {
            AlertDialog.Builder message = new AlertDialog.Builder(this);
            message.setTitle("Ошибка");
            message.setMessage("Неверные входные данные, введите еще раз");
            message.setPositiveButton("Ок", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    dialog.cancel();
                }
            });
            message.show();
        }
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Count", count);
        outState.putInt("secondCount", secondCount);
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("Count")) {
            count = savedInstanceState.getInt("Count");
        }
        if (savedInstanceState != null && savedInstanceState.containsKey("secondCount")) {
            secondCount = savedInstanceState.getInt("secondCount");
        }
    }
    protected void resetUI() {
        TextView countScore = findViewById(R.id.editTextTextPersonName2);
        countScore.setText(String.valueOf(count));
        TextView secondScore = findViewById(R.id.editTextTextPersonName3);
        secondScore.setText(String.valueOf(secondCount));
    }
    public void onResume() {
        super.onResume();
        resetUI();
    }
}