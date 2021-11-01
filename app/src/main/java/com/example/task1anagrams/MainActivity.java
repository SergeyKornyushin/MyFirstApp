package com.example.task1anagrams;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnConvert;
    private EditText inputEdt, exceptionEdt;
    private TextView reverseTextV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConvert = findViewById(R.id.btn_convert);
        inputEdt = findViewById(R.id.edt_input_text);
        exceptionEdt = findViewById(R.id.edt_exception_symbols);
        reverseTextV = findViewById(R.id.txt_reverse);

        btnConvert.setOnClickListener(view -> {
            reverseTextV.setText(ReverseText.reverseString(inputEdt.getText().toString(),
                    exceptionEdt.getText().toString())
            );
        });

    }
}
