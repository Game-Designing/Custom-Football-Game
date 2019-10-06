package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

@zzard
/* renamed from: com.google.android.gms.internal.ads.Ad */
final class C8743Ad implements SensorEventListener {

    /* renamed from: a */
    private final SensorManager f20368a;

    /* renamed from: b */
    private final Object f20369b = new Object();

    /* renamed from: c */
    private final Display f20370c;

    /* renamed from: d */
    private final float[] f20371d = new float[9];

    /* renamed from: e */
    private final float[] f20372e = new float[9];

    /* renamed from: f */
    private float[] f20373f;

    /* renamed from: g */
    private Handler f20374g;

    /* renamed from: h */
    private C8785Cd f20375h;

    C8743Ad(Context context) {
        this.f20368a = (SensorManager) context.getSystemService("sensor");
        this.f20370c = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28000a() {
        if (this.f20374g == null) {
            Sensor defaultSensor = this.f20368a.getDefaultSensor(11);
            if (defaultSensor == null) {
                zzbad.m26355b("No Sensor of TYPE_ROTATION_VECTOR");
                return;
            }
            HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
            handlerThread.start();
            this.f20374g = new zzdbh(handlerThread.getLooper());
            if (!this.f20368a.registerListener(this, defaultSensor, 0, this.f20374g)) {
                zzbad.m26355b("SensorManager.registerListener failed.");
                mo28003b();
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public final void mo28003b() {
        if (this.f20374g != null) {
            this.f20368a.unregisterListener(this);
            this.f20374g.post(new C8764Bd(this));
            this.f20374g = null;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo28001a(C8785Cd cd) {
        this.f20375h = cd;
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] != 0.0f || fArr[1] != 0.0f || fArr[2] != 0.0f) {
            synchronized (this.f20369b) {
                if (this.f20373f == null) {
                    this.f20373f = new float[9];
                }
            }
            SensorManager.getRotationMatrixFromVector(this.f20371d, fArr);
            int rotation = this.f20370c.getRotation();
            if (rotation == 1) {
                SensorManager.remapCoordinateSystem(this.f20371d, 2, Opcodes.LOR, this.f20372e);
            } else if (rotation == 2) {
                SensorManager.remapCoordinateSystem(this.f20371d, Opcodes.LOR, Opcodes.IXOR, this.f20372e);
            } else if (rotation != 3) {
                System.arraycopy(this.f20371d, 0, this.f20372e, 0, 9);
            } else {
                SensorManager.remapCoordinateSystem(this.f20371d, Opcodes.IXOR, 1, this.f20372e);
            }
            m22258a(1, 3);
            m22258a(2, 6);
            m22258a(5, 7);
            synchronized (this.f20369b) {
                System.arraycopy(this.f20372e, 0, this.f20373f, 0, 9);
            }
            C8785Cd cd = this.f20375h;
            if (cd != null) {
                cd.mo28071a();
            }
        }
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final boolean mo28002a(float[] fArr) {
        synchronized (this.f20369b) {
            if (this.f20373f == null) {
                return false;
            }
            System.arraycopy(this.f20373f, 0, fArr, 0, this.f20373f.length);
            return true;
        }
    }

    /* renamed from: a */
    private final void m22258a(int i, int i2) {
        float[] fArr = this.f20372e;
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
    }
}
