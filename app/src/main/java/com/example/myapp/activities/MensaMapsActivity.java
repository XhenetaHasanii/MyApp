package com.example.myapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapp.R;
import com.example.myapp.db.AppDatabase;
import com.example.myapp.entities.Menza;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.List;

public class MensaMapsActivity  extends AppCompatActivity implements OnMapReadyCallback{
    private GoogleMap mMap;
    private List<Menza> menzat;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensa_map);

        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());
        menzat = db.menzaDao().getAllMenza();


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
        Button backButton = (Button) findViewById(R.id.back_to_menu_from_menza);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        for (int i = 0; i < menzat.size();++i){
            double lat = Double.parseDouble(menzat.get(i).getLatitude());
            double lon = Double.parseDouble(menzat.get(i).getLongitude());
            LatLng menza = new LatLng(lat, lon);
            mMap.addMarker(new MarkerOptions().position(menza).title(menzat.get(i).getEmri()));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(menza,15));
        }
    }

}

