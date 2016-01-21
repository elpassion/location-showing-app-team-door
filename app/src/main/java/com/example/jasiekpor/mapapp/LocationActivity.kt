package com.example.jasiekpor.mapapp

import android.app.Activity
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle


class LocationActivity : Activity(){

    val locationManager by lazy { this.getSystemService(Context.LOCATION_SERVICE) as LocationManager }
    val locationProvider by lazy { LocationManager.GPS_PROVIDER }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val locationListener = object:LocationListener {
            override fun onLocationChanged(location: Location?) {
            }

            override fun onProviderDisabled(provider: String?) {
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
            }

            override fun onProviderEnabled(provider: String?) {
            }

        }

    }
}