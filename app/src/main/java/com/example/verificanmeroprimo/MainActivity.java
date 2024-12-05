package com.example.verificanmeroprimo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private TextView txtTitulo;
    private EditText txtN1;
    private Button btnCalcular;
    private TextView txtRes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtTitulo = findViewById(R.id.txtTitulo);
        txtN1 = findViewById(R.id.txtN1);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtRes = findViewById(R.id.txtRes);

        btnCalcular.setOnClickListener(x -> Calcular());

    }

    private void Calcular(){
        int n = Integer.parseInt(txtN1.getText().toString());
        if(n < 0 || n == 0){
            txtRes.setText("O número deve ser um inteiro positivo!");
            txtN1.setText("");
            return;
        } else{
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    txtRes.setText("O número não é primo.");
                    return;
                }
            }
            txtRes.setText("O número é primo.");
        }
    }
}