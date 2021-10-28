package com.example.task1anagrams;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button btnConvert;
    public EditText inputEdt, exceptionEdt;
    public TextView reverseTextV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConvert = findViewById(R.id.btn_convert);
        inputEdt = findViewById(R.id.edt_input_text);
        exceptionEdt = findViewById(R.id.edt_exception_symbols);
        reverseTextV = findViewById(R.id.txt_reverse);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reverseTextV.setText("");
                reverseTextV.setText(ReverseText.reverseText(inputEdt.getText().toString(),
                        exceptionEdt.getText().toString().toCharArray())
                );
            }
        });

    }
}
