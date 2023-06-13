package com.example.myapp.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapp.R;
import com.example.myapp.entities.Menza;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;


public class MensaMapsActivity  extends AppCompatActivity implements OnMapReadyCallback{
    private GoogleMap mMap;
    private List<Menza> menzat;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mensa_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
        menzat = new ArrayList<>();
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
        readData(new MensaMapsActivity.FirestoreCallback() {

            @Override
            public void onCallback(List<Menza> list) {
                for (int i = 0; i < list.size();++i){
                    double lat = Double.parseDouble(list.get(i).getLatitude());
                    double lon = Double.parseDouble(list.get(i).getLongitude());
                    LatLng sydney = new LatLng(lat, lon);
                    mMap.addMarker(new MarkerOptions().position(sydney).title(list.get(i).getEmri()));
                }
            }
        });
    }

    private void readData(MensaMapsActivity.FirestoreCallback firestoreCallback) {
        CollectionReference collectionRef = db.collection("menza");
        collectionRef.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (DocumentSnapshot doc : task.getResult()) {
                        menzat.add(doc.toObject(Menza.class));
                    }
                    firestoreCallback.onCallback(menzat);
                }
            }
        });
    }

    private interface FirestoreCallback {
        void onCallback(List<Menza> list);
    }
}

