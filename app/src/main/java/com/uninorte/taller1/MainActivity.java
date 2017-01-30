package com.uninorte.taller1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    EditText et2;
    EditText et3;
    TextView tv1;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.et1);
        et2 = (EditText) findViewById(R.id.et2);
        et3 = (EditText) findViewById(R.id.et3);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
    }

    public void calculate(View view) {
        String[] data = { et1.getText().toString(),  et2.getText().toString(), et3.getText().toString() };
        if(data[0].isEmpty() || data[1].isEmpty() || data[2].isEmpty()) {
            Toast.makeText(this, "Debe digitar las 3 notas", Toast.LENGTH_SHORT).show();
        }else{
            double nota1 = Double.parseDouble(data[0]);
            double nota2 = Double.parseDouble(data[1]);
            double nota3 = Double.parseDouble(data[2]);
            if (nota1 > 5 || nota2 > 5 || nota3 > 5) {
                Toast.makeText(this, "Las 3 notas deben ser menores o iguales a 5", Toast.LENGTH_SHORT).show();
            } else {
                double nota4 = ((3.5 - (nota1 + nota2 + nota3) / 4) / 0.25);
                if (nota4 > 5) {
                    tv2.setText("Te la mamaste, necesitas: " + nota4);
                } else if (nota4 <= 0) {
                    tv2.setText("Firme, ya la pasaste, si quieres no vallas mas a clase");
                } else {
                    tv2.setText("Necesitas: " + nota4);
                }
            }
        }
    }
}
