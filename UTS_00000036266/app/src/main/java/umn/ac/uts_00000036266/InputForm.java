package umn.ac.uts_00000036266;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import umn.ac.uts_00000036266.databinding.ActivityInputFormBinding;

public class InputForm extends AppCompatActivity {

    private ActivityInputFormBinding bind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityInputFormBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        bind.nextButton.setOnClickListener(v -> {
            String name = bind.InputForm.getText().toString();
            if(name.isEmpty())
                bind.InputForm.setError("This field is required");
            else{
                Intent intent = new Intent(this, LibraryActivity.class);
                intent.putExtra("name", bind.InputForm.getText().toString());
                startActivity(intent);
            }
        });
    }
}