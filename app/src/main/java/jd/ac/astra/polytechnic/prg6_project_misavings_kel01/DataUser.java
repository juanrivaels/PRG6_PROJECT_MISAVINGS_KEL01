package jd.ac.astra.polytechnic.prg6_project_misavings_kel01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import db.DbHelper;
import model.User;

public class DataUser extends AppCompatActivity {

    private EditText namalengkap, uname, pw;
    private Button simpan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daftar);

        namalengkap = findViewById(R.id.nama);
        uname = findViewById(R.id.username);
        pw = findViewById(R.id.password);

        simpan = findViewById(R.id.btnsave);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        TextView login = findViewById(R.id.masuk);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DataUser.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveData() {
        String nama = namalengkap.getText().toString().trim();
        String username = uname.getText().toString().trim();
        String password = pw.getText().toString().trim();

        if (nama.isEmpty() || username.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Harap lengkapi semua data", Toast.LENGTH_SHORT).show();
        } else {
            User user = new User();
            user.setNama(nama);
            user.setUsername(username);
            user.setPassword(password);

            DbHelper dbHelper = new DbHelper(this);
            boolean isInserted = dbHelper.insertUser(user);

            if (isInserted) {
                Toast.makeText(this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                resetInputFields();
            } else {
                Toast.makeText(this, "Gagal menyimpan data", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void resetInputFields() {
        namalengkap.setText("");
        uname.setText("");
        pw.setText("");
    }
}
