package viafoura.sdk.demo

import android.app.Application
import com.viafourasdk.src.ViafouraSDK

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate();

        ViafouraSDK.initialize(
            applicationContext,
            "00000000-0000-4000-8000-c8cddfd7b365",
            "viafoura-mobile-demo.vercel.app"
        )
    }
}
