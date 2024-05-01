package com.mobile.apps.adapters;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
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
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            if (data != null) {
                                User user = (User) data.getSerializableExtra("result");
                                UserAdapter adapter = (UserAdapter) rcvUser.getAdapter();
                                adapter.addUser(user);
                                adapter.notifyDataSetChanged();
                            }
                        }
                    }
                }
        );

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

        btnAddUser.setOnClickListener(view -> {
            Intent intent = new Intent(this, AddUserActivity.class);
            activityResultLauncher.launch(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}