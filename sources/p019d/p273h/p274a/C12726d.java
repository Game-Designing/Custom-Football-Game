package p019d.p273h.p274a;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import p019d.p273h.p274a.C12727e.C12728a;

/* renamed from: d.h.a.d */
/* compiled from: LocationService */
class C12726d implements LocationListener {

    /* renamed from: a */
    final /* synthetic */ C12728a f39048a;

    C12726d(C12728a aVar) {
        this.f39048a = aVar;
    }

    public void onLocationChanged(Location location) {
        StringBuilder sb = new StringBuilder();
        sb.append("onLocationChanged ");
        sb.append(location.getProvider());
        Log.d("LocationService", sb.toString());
        C12728a aVar = this.f39048a;
        if (aVar != null) {
            aVar.onLocationChanged(location);
        }
    }

    public void onStatusChanged(String provider, int status, Bundle extras) {
        StringBuilder sb = new StringBuilder();
        sb.append("onStatusChanged ");
        sb.append(provider);
        Log.d("LocationService", sb.toString());
    }

    public void onProviderEnabled(String provider) {
        StringBuilder sb = new StringBuilder();
        sb.append("onProviderEnabled ");
        sb.append(provider);
        Log.d("LocationService", sb.toString());
    }

    public void onProviderDisabled(String provider) {
        StringBuilder sb = new StringBuilder();
        sb.append("onProviderDisabled ");
        sb.append(provider);
        Log.d("LocationService", sb.toString());
    }
}
