package android.support.p000v4.app;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.p000v4.app.C0453b.C0007a;

/* renamed from: android.support.v4.app.a */
/* compiled from: ActivityCompat */
class C0447a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String[] f1500a;

    /* renamed from: b */
    final /* synthetic */ Activity f1501b;

    /* renamed from: c */
    final /* synthetic */ int f1502c;

    C0447a(String[] strArr, Activity activity, int i) {
        this.f1500a = strArr;
        this.f1501b = activity;
        this.f1502c = i;
    }

    public void run() {
        int[] grantResults = new int[this.f1500a.length];
        PackageManager packageManager = this.f1501b.getPackageManager();
        String packageName = this.f1501b.getPackageName();
        int permissionCount = this.f1500a.length;
        for (int i = 0; i < permissionCount; i++) {
            grantResults[i] = packageManager.checkPermission(this.f1500a[i], packageName);
        }
        ((C0007a) this.f1501b).onRequestPermissionsResult(this.f1502c, this.f1500a, grantResults);
    }
}
