package com.sigmatone;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void _login(View view) {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        String user = username.getText().toString();
        String pass = password.getText().toString();

        if (user.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Empty Fields", Toast.LENGTH_SHORT).show();
        } else {
            if (user.equals("user") && pass.equals("pass"))
                startActivity(new Intent(this, Homepage.class));
        }
    }
}
