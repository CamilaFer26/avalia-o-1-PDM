package com.unir.cursosunir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private Spinner spinnerCampus;
    private RadioGroup rdbGroup;
    private CheckBox checkbox;
    private String[] campi = {};
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

        btn = findViewById(R.id.button);
        spinnerCampus = findViewById(R.id.spinnerCampus);
        rdbGroup = findViewById(R.id.radioGroup);
        checkbox = findViewById(R.id.checkBox);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String campus = campi[spinnerCampus.getSelectedItemPosition()];
                RadioButton rdb = findViewById(rdbGroup.getCheckedRadioButtonId());
                String grau = rdb.getText().toString();
                boolean noturno = checkbox.isActivated();

                Intent intent = new Intent(MainActivity.this, ListaActivity.class);
                //intent.putExtra("campus", campus);
                intent.putExtra("grau", grau);
                intent.putExtra("noturno", noturno);
                startActivity(intent);
            }
        });
    }
}