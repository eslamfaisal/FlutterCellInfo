package com.airfore.cell_info_example

import android.Manifest
import android.util.Log
import androidx.core.app.ActivityCompat
import com.airfore.cell_info.NetMonster
import io.flutter.embedding.android.FlutterActivity

class MainActivity : FlutterActivity() {
    override fun onStart() {
        super.onStart()

        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            ),
            33
        )

        val netMonster = NetMonster()
        netMonster.simsInfo(this).forEach {
            Log.d("simsInfo", "onStart: ${it}")
        }
        netMonster.requestData(this).cellDataList.forEach {
            Log.d("cellDataList", "onStart: ${it.type}")
        }
    }

}
