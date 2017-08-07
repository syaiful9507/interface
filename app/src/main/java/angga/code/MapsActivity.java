package angga.code;

/**
 * Created by syaiful9508 on 02/08/17.
 */
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap, mMap1,mMap2,mMap3, mMap4, mMap5, mMap6, mMap7, mMap8, mMap9;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap1 = googleMap;
        mMap2 = googleMap;
        mMap3= googleMap;
        mMap4 = googleMap;
        mMap5 = googleMap;
        mMap6 = googleMap;
        mMap7 = googleMap;
        mMap8 = googleMap;
        mMap9 = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng Musdalifa = new LatLng(-7.0272637,	113.851620317);
        mMap.addMarker(new MarkerOptions().position(Musdalifa).title("Hotel Musdalifah"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Musdalifa));
        LatLng C1 = new LatLng(-7.0166163,	113.86305617);
        mMap1.addMarker(new MarkerOptions().position(C1).title("Hotel C 1"));
        mMap1.moveCamera(CameraUpdateFactory.newLatLng(C1));
        LatLng Wijaya = new LatLng(-7.012688,	113.856692817);
        mMap2.addMarker(new MarkerOptions().position(Wijaya).title("Hotel Wijaya 1"));
        mMap2.moveCamera(CameraUpdateFactory.newLatLng(Wijaya));
        LatLng Wijaya2 = new LatLng(-6.9599863, 113.861145);
        mMap3.addMarker(new MarkerOptions().position(Wijaya2).title("Hotel Wijaya 2"));
        mMap3.moveCamera(CameraUpdateFactory.newLatLng(Wijaya2));
        LatLng Utami_sumekar = new LatLng(-7.0135736,	113.857065717);
        mMap4.addMarker(new MarkerOptions().position(Utami_sumekar).title("Hotel Utami Sumekar"));
        mMap4.moveCamera(CameraUpdateFactory.newLatLng(Utami_sumekar));
        LatLng Suramadu = new LatLng(-7.0220305,	113.854891317);
        mMap5.addMarker(new MarkerOptions().position(Suramadu).title("Hotel Suramadu"));
        mMap5.moveCamera(CameraUpdateFactory.newLatLng(Suramadu));
        LatLng Dream_land = new LatLng(-7.0200977,	113.847668317);
        mMap6.addMarker(new MarkerOptions().position(Dream_land).title("Hotel Dream Land"));
        mMap6.moveCamera(CameraUpdateFactory.newLatLng(Dream_land));
        LatLng Famili_nur = new LatLng(-7.0159627,	113.863478117);
        mMap7.addMarker(new MarkerOptions().position(Famili_nur).title("Hotel Famili Nur"));
        mMap7.moveCamera(CameraUpdateFactory.newLatLng(Famili_nur));
        LatLng Safari_jaya = new LatLng(-7.0227057,	113.854100317);
        mMap8.addMarker(new MarkerOptions().position(Safari_jaya).title("Hotel Safary Jaya"));
        mMap8.moveCamera(CameraUpdateFactory.newLatLng(Safari_jaya));
        LatLng Mitra_land = new LatLng(-7.0318697,	113.849457317);
        mMap9.addMarker(new MarkerOptions().position(Mitra_land).title("Hotel Mitra Land"));
        mMap9.moveCamera(CameraUpdateFactory.newLatLng(Mitra_land));

        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

    }


}
