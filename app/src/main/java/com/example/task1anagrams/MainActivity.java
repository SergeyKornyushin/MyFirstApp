package com.example.task1anagrams;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button btnConvert, btnException, btnClearExceptionList;
    public EditText inputEdt, exceptionEdt;
    public TextView exceptionTextV, reverseTextV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConvert = findViewById(R.id.btn_convert);
        inputEdt = findViewById(R.id.edt_input_text);
        exceptionEdt = findViewById(R.id.edt_exception_symbols);
        reverseTextV = findViewById(R.id.txt_reverse);
        btnException = findViewById(R.id.btn_add_symbol);
        exceptionTextV = findViewById(R.id.txt_exceptions);
        btnClearExceptionList = findViewById(R.id.btn_clear);

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reverseTextV.setText("");
                ReverseText revText = new ReverseText();
                reverseTextV.setText(revText.reverseText(inputEdt.getText().toString()));
            }
        });

        btnException.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReverseText excList = new ReverseText();
                exceptionTextV.setText(excList.addExceptionSymbol(exceptionEdt.getText()
                        .toString().toCharArray()));
            }
        });

        btnClearExceptionList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReverseText clearExcList = new ReverseText();
                clearExcList.clearExceptions();
                exceptionTextV.setText("");
            }
        });
    }
}
