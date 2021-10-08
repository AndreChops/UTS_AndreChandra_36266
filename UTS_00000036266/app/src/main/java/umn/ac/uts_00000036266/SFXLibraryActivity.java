package umn.ac.uts_00000036266;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import umn.ac.uts_00000036266.databinding.ActivitySfxlibraryBinding;

public class SFXLibraryActivity extends AppCompatActivity {

    ActivitySfxlibraryBinding bind;
    MediaPlayer media;
    Library item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivitySfxlibraryBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        item = getIntent().getExtras().getParcelable("library");

        Objects.requireNonNull(getSupportActionBar()).setTitle(item.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bind.dSFXTitle.setText(item.getTitle());
        bind.dSFXCategory.setText(item.getCategory());
        media = new MediaPlayer();
        bind.dPlaySFX.setOnClickListener( v -> {
            media = MediaPlayer.create(this,this.getResources().
                    getIdentifier(item.getSoundURI(),"raw",this.getPackageName()));
            media.start();
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(media.isPlaying()){
            media.release();
            media.release();
            media = null;
        }
    }
}