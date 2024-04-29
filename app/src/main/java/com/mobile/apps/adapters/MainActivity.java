package com.mobile.apps.adapters;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mobile.apps.adapters.Adapters.UserAdapter;
import com.mobile.apps.adapters.Classes.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvUser;
    Button btnAddUser;
    List<User> usersList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvUser = findViewById(R.id.rcvUsers);
        btnAddUser = findViewById(R.id.btnAddUser);

        for (int i = 0; i < 4; i++) {
            String userName = "";
            String imageUrl = "";
            String subject = "";
            switch (i) {
                case 0:
                    userName = "David";
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/72.jpeg";
                    subject = "Aplicaciones moviles";
                    break;
                case 1:
                    userName = "Anderson";
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/120.jpeg";
                    subject = "Aplicaciones moviles";
                    break;
                case 2:
                    userName = "Miguel";
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/190.jpeg";
                    subject = "Aplicaciones moviles";
                    break;
                case 3:
                    userName = "Camilo";
                    imageUrl = "https://rickandmortyapi.com/api/character/avatar/241.jpeg";
                    subject = "Aplicaciones moviles";
                    break;
            }
            usersList.add(new User(imageUrl, userName, subject));
        }

        rcvUser.setLayoutManager(new LinearLayoutManager(this));
        rcvUser.setAdapter(new UserAdapter(usersList));
    }
}