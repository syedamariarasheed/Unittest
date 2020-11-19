package com.example.unittestsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText et;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=findViewById(R.id.et);
        btn=findViewById(R.id.btn);
        tv=findViewById(R.id.tv);
        initState();
        // when button is clicked
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(et.getText().toString());
                et.getText().clear();
                btn.setEnabled(false);
            }
        });
    }

    private void initState() {
        et.setText("");
        tv.setText("HelloWorld");
        btn.setEnabled(true);
    }

}