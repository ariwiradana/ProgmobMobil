package com.example.progmobmobil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String title = "Mode List";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mDesc = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mImageDet = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate:started.");
        initImageBitmaps();
    }

    private void initImageBitmaps() {
        mImageUrls.add("https://images.hgmsites.net/hug/2015-porsche-918-spyder_100462275_h.jpg");
        mNames.add("2015 Porsche 918 Spyder");
        mDesc.add("Porsche");
        mImageDet.add("Mobil Porsche 918 Spyder 2015 adalah mobil sport hybrid yang diproduksi oleh produsen mobil Jerman, Porsche. Mobil ini ditenagai oleh mesin V8 4,6 L (4.593 cc) yang disedot secara alami, mengembangkan 608 PS (447 kW; 600 bhp) pada 8500 rpm, dengan dua motor listrik menghasilkan tambahan 210 kW (286 PS; 282 bhp).");

        mImageUrls.add("https://www.quattrodaily.com/wp-content/uploads/2015/10/large-5785mclaren-570s-portimao-5725.jpg");
        mNames.add("McLaren 570s");
        mDesc.add("McLaren");
        mImageDet.add("McLaren 570S adalah mobil sport yang dirancang dan diproduksi oleh pabrikan mobil Inggris McLaren Automotive. Itu diresmikan di New York International Auto Show 2015. McLaren memperkirakan bahwa model ini akan membantu melipatgandakan volume penjualan perusahaan pada tahun 2020.");

        mImageUrls.add("https://www.automobilesreview.com/gallery/lamborghini-veneno-geneva-2013/lamborghini-veneno-geneva-2013-04.jpg");
        mNames.add("Lamborghini Veneno Ganeva 2013");
        mDesc.add("Lamborghini");
        mImageDet.add("Lamborghini Veneno adalah mobil sport performa tinggi produksi terbatas yang diproduksi oleh produsen mobil Italia Lamborghini. Mobil ini memiliki harga US $ 4.500.000, yang menjadikannya salah satu mobil produksi termahal di dunia.");

        mImageUrls.add("https://i.pinimg.com/originals/f4/fe/d8/f4fed81484d0ce198f5240a3577947b6.jpg");
        mNames.add("Nissan GTR");
        mDesc.add("Nissan");
        mImageDet.add("Nissan GT-R adalah kendaraan performa tinggi 2-pintu yang diproduksi oleh Nissan, diluncurkan pada tahun 2007. Mobil ini adalah penerus Nissan Skyline GT-R, meskipun tidak lagi menjadi bagian dari jajaran Skyline itu sendiri, nama itu sekarang digunakan untuk pasar sport mewah Nissan.");

        mImageUrls.add("https://icdn2.digitaltrends.com/image/lamborghini_huracan_evo_track_7-720x720.jpg");
        mNames.add("Lamborghini Huracan");
        mDesc.add("Lamborghini");
        mImageDet.add("Lamborghini Huracán adalah mobil sport yang diproduksi oleh produsen otomotif Italia Lamborghini menggantikan V10 sebelumnya, Gallardo. Huracan melakukan debutnya di seluruh dunia di Geneva Auto Show 2014, dan dirilis di pasar pada kuartal kedua 2014. Mobil ini memiliki 610 metric horsepower dan 4 wheel drive.");


        initRecyclerView();

    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, mDesc, mImageDet);
        recyclerView.setAdapter(adapter);
    }

    private void showRecyleList() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListActivity adapter = new ListActivity(this, mNames, mImageUrls, mDesc, mImageDet);
        recyclerView.setAdapter(adapter);

    }

    private void showRecyclerGrid() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        GridActivity adapter = new GridActivity(this, mImageUrls);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list:
                setActionBarTitle("Auto Car");
                showRecyleList();
                break;
            case R.id.action_grid:
                setActionBarTitle("Auto Car");
                showRecyclerGrid();
                break;
            case R.id.action_cardview:
                setActionBarTitle("Auto Car");
                initRecyclerView();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);

    }
}