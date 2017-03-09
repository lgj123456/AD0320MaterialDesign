package com.example.yhdj.ad0320materialdesign;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private NavigationView navigation_view;
   private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setTitle("toolbar");
mToolbar.setLogo(R.mipmap.ic_launcher);
        initViews();
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.a);
        }
    }

    private void initViews() {
//        mBtn_snackbar = (Button) findViewById(R.id.snackbar);
//        mBtn_snackbar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(mBtn_snackbar,"SnackbarClicked",Snackbar.LENGTH_LONG).setAction("Action", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        mBtn_snackbar.setTextColor(Color.RED);
//                    }
//                }).setActionTextColor(Color.RED).show();
//            }
//        });
//
//        fab_search = (FloatingActionButton) findViewById(R.id.fab_search);
//        fab_search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mBtn_snackbar.setTextColor(Color.BLUE);
//            }
//        });


mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigation_view = (NavigationView) findViewById(R.id.navigation_view);
        navigation_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item_home:
                        Toast.makeText(MainActivity.this, "首页", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item_blog:
                        Toast.makeText(MainActivity.this, "博客", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.navigation_item_about:
                        Toast.makeText(MainActivity.this, "关于", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                item.setChecked(true);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }
}
