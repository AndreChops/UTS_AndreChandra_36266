package umn.ac.uts_00000036266;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button profileButton;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        profileButton = findViewById(R.id.profile_button);
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProfileActivity();
            }
        });

        nextButton = findViewById(R.id.library_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openInputForm();
            }
        });

    }

    public void openProfileActivity(){
        Intent intent1 = new Intent(this, ProfileActivity.class);
        startActivity(intent1);
    }

    public void openInputForm(){
        Intent intent = new Intent(this, InputForm.class);
        startActivity(intent);
    }
}