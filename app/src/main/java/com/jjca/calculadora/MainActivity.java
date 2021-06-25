package com.jjca.calculadora;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    static int num1,num2;
    TextView res;
    EditText n1,n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = (EditText) findViewById(R.id.num1);
        n2 = (EditText) findViewById(R.id.num2);
        res = findViewById(R.id.restxt);

        Button sumbtn = (Button) findViewById(R.id.sumbtn);
        sumbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue();
                Sumar(num1, num2);
            }
        });

        Button resbtn = (Button) findViewById(R.id.resbtn);
        resbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue();
                Restar(num1, num2);
            }
        });

        Button mulbtn = (Button) findViewById(R.id.mulbtn);
        mulbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue();
                Multiplicar(num1, num2);
            }
        });

        Button divbtn = (Button) findViewById(R.id.divbtn);
        divbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getValue();
                Dividir(num1, num2);
            }
        });


    }

    public void getValue()
    {

        if(n1.getText().toString().equals("") || n2.getText().toString().equals(""))
        {
            Error();
        }
        else
        {
            try {
                num1 = Integer.parseInt(n1.getText().toString());
                num2 = Integer.parseInt(n2.getText().toString());
            }
            catch(Exception e)
            {
                Error();
            }
        }



    }

    private void Sumar(int a, int b) {

        if(n1.getText().toString().equals("") || n2.getText().toString().equals("")){
            return;
        }

        int resultado = a+b;
        String imp = Integer.toString(resultado);
        res.setText(imp);
    }

    private void Restar(int a, int b) {

        if(n1.getText().toString().equals("") || n2.getText().toString().equals("")){
            return;
        }

        int resultado = a-b;
        String imp = Integer.toString(resultado);
        res.setText(imp);
    }

    private void Multiplicar(int a, int b) {

        if(n1.getText().toString().equals("") || n2.getText().toString().equals("")){
            return;
        }

        int resultado = a*b;
        String imp = Integer.toString(resultado);
        res.setText(imp);
    }

    private void Dividir(int a, int b) {

        if(n1.getText().toString().equals("") || n2.getText().toString().equals("")){
            return;
        }

        if(b==0)
        {
            Error();
        }
        else
        {
            float resultado = (float) a/b;
            DecimalFormat formato = new DecimalFormat("#.##");
            String imp = formato.format(resultado);
            res.setText(imp);
        }
    }

    public void Error()
    {
        res.setText(R.string.blank);
        Toast message = Toast.makeText(this, "Se encontraron valores no válidos", Toast.LENGTH_LONG);
        message.show();
    }

}