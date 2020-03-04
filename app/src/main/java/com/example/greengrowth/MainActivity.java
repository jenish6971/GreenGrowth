package com.example.greengrowth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    MeowBottomNavigation meo;

    private final static int ID_HOME = 1;
    private final static int ID_SOILCARD = 2;
    private final static int ID_SHARE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar_j = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar_j);
        toolbar_j.setTitle("Green Growth");

        meo = (MeowBottomNavigation) findViewById(R.id.bottom_nav);
        meo.add(new MeowBottomNavigation.Model(1, R.drawable.icon_home));
        meo.add(new MeowBottomNavigation.Model(2, R.drawable.icon_soilcard));
        meo.add(new MeowBottomNavigation.Model(3, R.drawable.icon_soilcard));

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,  new FragmentHome()).commit();

        meo.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
                //Toast.makeText(getApplicationContext(), "Clicked item " + item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        meo.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment select_fragment = null;
                switch (item.getId()){
                    case ID_HOME:
                        select_fragment = new FragmentHome();
                        break;
                    case ID_SOILCARD:
                        select_fragment = new FragmentSoilCard();
                        break;
                    case ID_SHARE:
                        select_fragment = new FragmentSettings();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, select_fragment).commit();
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
