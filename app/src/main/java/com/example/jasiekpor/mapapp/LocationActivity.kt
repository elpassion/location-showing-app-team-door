package com.example.jasiekpor.mapapp

import android.app.Activity
import android.content.Context
import android.location.Criteria
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide


class LocationActivity : Activity() {

    val locationManager by lazy { this.getSystemService(Context.LOCATION_SERVICE) as LocationManager }
    val locationProvider by lazy { LocationManager.GPS_PROVIDER }
    val noPermissionMessage by lazy { findViewById(R.id.no_permission_message) as TextView }
    val mapView by lazy { findViewById(R.id.map_view) as ImageView }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.location_layout)
        getSystemService(Context.LOCATION_SERVICE)

        val locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                val longitude = location.longitude
                val latitude = location.latitude
                Log.d("location x", longitude.toString())
                Log.d("location y", latitude.toString())
                setMapView(longitude, latitude)
            }

            override fun onProviderDisabled(provider: String?) {
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            }

            override fun onProviderEnabled(provider: String?) {
            }

        }

        locationManager.requestLocationUpdates(locationProvider, 0, 0f, locationListener)
    }

    fun setMapView(longitude: Double, latitude: Double) {
        Glide.with(this).load("https://maps.googleapis.com/maps/api/staticmap?center=$longitude,$latitude&zoom=10&size=600x300&key=AIzaSyC8Cl3TYbzkZ6bb8_fwKeMhFvx_Be6B0CY").into(mapView)
    }
}