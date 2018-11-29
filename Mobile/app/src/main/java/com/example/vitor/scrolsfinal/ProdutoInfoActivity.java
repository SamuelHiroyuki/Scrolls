package com.example.vitor.scrolsfinal;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;
import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class ProdutoInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_info);

        Toolbar mTopToolbar = (Toolbar) findViewById(R.id.IncludeToolbarProduto);
        setSupportActionBar(mTopToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        FlipperLayout flipper = (FlipperLayout) findViewById(R.id.FliperProd);

        Button btn1 = (Button) mTopToolbar.findViewById(R.id.btnPreto);
        btn1.setText("Carrinho");

        Button btn2 = (Button) mTopToolbar.findViewById(R.id.btnBlue);
        btn2.setText("Adicionar ao carrinho");

        FlipperView fv = new FlipperView(this);
        fv.setImageDrawable(R.drawable.program_banner);
        flipper.addFlipperView(fv);

        fv = new FlipperView(this);
        fv.setImageDrawable(R.drawable.lovecraft_banner);
        flipper.addFlipperView(fv);

        fv = new FlipperView(this);
        fv.setImageDrawable(R.drawable.dragon_banner);
        flipper.addFlipperView(fv);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }
}