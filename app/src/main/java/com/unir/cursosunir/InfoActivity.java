package com.unir.cursosunir;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.unir.cursosunir.model.Curso;

public class InfoActivity extends AppCompatActivity {
    TextView nome;
    TextView grau;
    TextView campus;
    TextView turno;
    TextView desc;
    ImageView img;
    Button btnlink;
    Button btnshare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nome = findViewById(R.id.txtcurso);
        grau = findViewById(R.id.txtgrau);
        campus = findViewById(R.id.txtcampus);
        turno = findViewById(R.id.txtturno);
        desc = findViewById(R.id.txtdesc);
        img = findViewById(R.id.img);
        btnlink = findViewById(R.id.btnlink);
        btnshare = findViewById(R.id.btnshare);

        Intent intent = getIntent();
        Curso curso = (Curso)intent.getSerializableExtra("curso_data");

        if(curso != null){
            nome.setText(curso.getNome());
            grau.setText(curso.getGrau());
            campus.setText(curso.getCampus());
            turno.setText(curso.getTurno());
            desc.setText(curso.getDescricao());

            Glide.with(this).load(curso.getImagem()).into(img);
        }
    }
}