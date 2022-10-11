package com.example.project6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar = findViewById(R.id.seekBar);
        progressBar = findViewById(R.id.progressBar);
        editText = findViewById(R.id.editText);

        seekBar.setProgress(50);
        progressBar.setProgress(50);
        editText.setText("50");


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                editText.setText(String.valueOf(progress));
                progressBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                String input;
                if (i == EditorInfo.IME_ACTION_DONE){
                    input = textView.getText().toString();
                    progressBar.setProgress(Integer.valueOf(input));
                    seekBar.setProgress(Integer.valueOf(input));
                    return true;
                }
                return false;
            }
        });
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                String input;
                if (!hasFocus){
                    input = editText.getText().toString();
                    progressBar.setProgress(Integer.valueOf(input));
                    seekBar.setProgress(Integer.valueOf(input));

                }
            }
        });
    }
}