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

import java.util.ArrayList;
import java.util.List;

import in.goodiebag.carouselpicker.CarouselPicker;

public class ProdutoInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto_info);

        Toolbar mTopToolbar = (Toolbar) findViewById(R.id.IncludeToolbarProduto);
        setSupportActionBar(mTopToolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_viewProd);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layoutProd);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, mTopToolbar, R.string.Drawer_open, R.string.Drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

        List<CarouselPicker.PickerItem> imgsBanner = new ArrayList<>();
        imgsBanner.add(new CarouselPicker.DrawableItem(R.drawable.banner_cyber));
        imgsBanner.add(new CarouselPicker.DrawableItem(R.drawable.bookbg));
        imgsBanner.add(new CarouselPicker.DrawableItem(R.drawable.book_true_icon));
        CarouselPicker.CarouselViewAdapter imgAdapter = new CarouselPicker.CarouselViewAdapter(this, imgsBanner, 0);
        CarouselPicker crr = (CarouselPicker) findViewById(R.id.CarrskyProd);
        crr.setAdapter(imgAdapter);
    }
}