package com.example.greengrowth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class crop_rabi extends AppCompatActivity {

    FloatingActionButton back_rabi_crop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_rabi);

        Toolbar toolbar_j = (Toolbar) findViewById(R.id.toolbar);
        back_rabi_crop = (FloatingActionButton) findViewById(R.id.back_rabi_crop);


        setSupportActionBar(toolbar_j);
        toolbar_j.setTitle("Rabi Crop");

        back_rabi_crop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(crop_rabi.this, MainActivity.class));
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.call:
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:18001801551"));
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
