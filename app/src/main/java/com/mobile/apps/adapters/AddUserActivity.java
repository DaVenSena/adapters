package com.mobile.apps.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.apps.adapters.Classes.User;

public class AddUserActivity extends AppCompatActivity {

    Spinner spnImage;
    Button btnAddUser;

    RecyclerView rcvUsers;

    EditText edtUserName, edtSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        spnImage = findViewById(R.id.spnImage);
        btnAddUser = findViewById(R.id.btnAddUser);
        edtUserName = findViewById(R.id.edtUserName);
        edtSubject = findViewById(R.id.edtSubject);

        String images[] = {"Rick", "Summer", "Keara", "Mr Marklovitz"};

        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, images);

        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        spnImage.setAdapter(adapter);

        btnAddUser.setOnClickListener(view -> addUser());
    }

    public void addUser() {
        final String userName = edtUserName.getText() + "";
        final String subject = edtSubject.getText() + "";
        final String imgChoice = spnImage.getSelectedItem() + "";
        String img = "https://rickandmortyapi.com/api/character/avatar/72.jpeg";
        switch (imgChoice) {
            case "Summer":
                img = "https://rickandmortyapi.com/api/character/avatar/120.jpeg";
                break;
            case "Keara":
                img = "https://rickandmortyapi.com/api/character/avatar/190.jpeg";
                break;
            case "Mr Marklovitz":
                img = "https://rickandmortyapi.com/api/character/avatar/241.jpeg";
                break;
            default:
        }
        User user = new User(img, userName, subject);

        Intent resultIntent = new Intent();
        resultIntent.putExtra("result", user); // Asegúrate de que MyObject sea Serializable o Parcelable
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}