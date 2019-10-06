package com.facebook.p127a.p128a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* renamed from: com.facebook.a.a.m */
/* compiled from: ViewIndexingTrigger */
public class C6591m implements SensorEventListener {

    /* renamed from: a */
    private C6592a f11972a;

    /* renamed from: com.facebook.a.a.m$a */
    /* compiled from: ViewIndexingTrigger */
    public interface C6592a {
        /* renamed from: a */
        void mo19777a();
    }

    /* renamed from: a */
    public void mo19774a(C6592a listener) {
        this.f11972a = listener;
    }

    public void onSensorChanged(SensorEvent event) {
        if (this.f11972a != null) {
            float[] fArr = event.values;
            float x = fArr[0];
            double gX = (double) (x / 9.80665f);
            double gY = (double) (fArr[1] / 9.80665f);
            double gZ = (double) (fArr[2] / 9.80665f);
            Double.isNaN(gX);
            Double.isNaN(gX);
            double d = gX * gX;
            Double.isNaN(gY);
            Double.isNaN(gY);
            double d2 = d + (gY * gY);
            Double.isNaN(gZ);
            Double.isNaN(gZ);
            if (Math.sqrt(d2 + (gZ * gZ)) > 2.299999952316284d) {
                this.f11972a.mo19777a();
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}
