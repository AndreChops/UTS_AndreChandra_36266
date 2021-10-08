package umn.ac.uts_00000036266;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.LinkedList;
import java.util.Objects;

import umn.ac.uts_00000036266.databinding.ActivityLibraryBinding;

public class LibraryActivity extends AppCompatActivity {

    ActivityLibraryBinding bind;
    static String username;
    static LinkedList<Library> listLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = ActivityLibraryBinding.inflate(getLayoutInflater());
        setContentView(bind.getRoot());

        String toolbar = getIntent().getStringExtra("name");
        if(toolbar != null) {
            listLibrary = new LinkedList<>();
            listLibrary.add(new Library("Tuturu", "Anime", "tuturu_sfx"));
            listLibrary.add(new Library("Bruh", "Meme", "bruh_sfx"));
            listLibrary.add(new Library("Ara ara", "Anime", "araara_sfx"));
            listLibrary.add(new Library("Roblox OOF", "Game", "roblox_sfx"));
            listLibrary.add(new Library("Spongebob Fail", "Cartoon", "spongebobfail_sfx"));
            username = toolbar;
            Objects.requireNonNull(getSupportActionBar()).setTitle(username);
            Toast.makeText(this,"Welcome, "+ toolbar,Toast.LENGTH_SHORT).show();
        } else
            Objects.requireNonNull(getSupportActionBar()).setTitle(username);

        ItemClickListener listener = new ItemClickListener() {
            @Override
            public void deleteLibrary(int position) {
                listLibrary.remove(position);
                Objects.requireNonNull(bind.listLibrary.getAdapter()).notifyItemRemoved(position);
                bind.listLibrary.smoothScrollToPosition(position+1);
            }
        };

        AdapterLibrary adapter = new AdapterLibrary(this, listLibrary, listener);
        bind.listLibrary.setAdapter(adapter);
        bind.listLibrary.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_home){
            this.finish();
            Intent intent = new Intent(this, MainActivity.class);
            this.startActivity(intent);
        }
        if (item.getItemId() == R.id.menu_profile) {
            Intent intent = new Intent(this , ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            this.startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
interface ItemClickListener{
    void deleteLibrary(int position);
}