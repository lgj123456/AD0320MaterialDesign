package com.example.yhdj.ad0320materialdesign;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimalActivity extends AppCompatActivity {

    public static final String ANIMAL_NAME = "animal_name";
    public   static final String ANIMAL_IAMGE_ID = "animal_image_id";
    private ImageView mImageView;
    private TextView mTextView;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private String name;
    private int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

        initViews();
    }

    private void initViews() {
        mImageView = (ImageView) findViewById(R.id.iv_animal);
        mTextView = (TextView) findViewById(R.id.content_animal);
        mToolbar = (Toolbar) findViewById(R.id.toobar);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        Intent intent = getIntent();
        if(intent != null){
            name = intent.getStringExtra(ANIMAL_NAME);
            id = intent.getIntExtra(ANIMAL_IAMGE_ID,0);
        }
        setSupportActionBar(mToolbar);
        ActionBar actionBar  = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mCollapsingToolbarLayout.setTitle(name);
        mImageView.setImageResource(id);
        String animalContent = generateAnimalContent(name);
        mTextView.setText(animalContent);
    }

    private String generateAnimalContent(String name) {
        StringBuffer content = new StringBuffer();
        for(int i = 0 ; i < 500; i++){
            content.append(name);
        }
        return content.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
