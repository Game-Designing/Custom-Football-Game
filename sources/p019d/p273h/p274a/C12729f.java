package p019d.p273h.p274a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* renamed from: d.h.a.f */
/* compiled from: NetworkStateReceiver */
public class C12729f extends BroadcastReceiver {

    /* renamed from: a */
    private ConnectivityManager f39050a;

    /* renamed from: b */
    private C12730a f39051b;

    /* renamed from: c */
    private boolean f39052c;

    /* renamed from: d.h.a.f$a */
    /* compiled from: NetworkStateReceiver */
    public interface C12730a {
        /* renamed from: a */
        void mo41148a(boolean z);
    }

    public C12729f(Context context, C12730a listener) {
        this.f39051b = listener;
        this.f39050a = (ConnectivityManager) context.getSystemService("connectivity");
        m41111a();
    }

    public void onReceive(Context context, Intent intent) {
        if (!(intent == null || intent.getExtras() == null || !m41111a())) {
            m41112b();
        }
    }

    /* renamed from: a */
    private boolean m41111a() {
        boolean prev = this.f39052c;
        NetworkInfo activeNetwork = this.f39050a.getActiveNetworkInfo();
        this.f39052c = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (prev != this.f39052c) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private void m41112b() {
        C12730a aVar = this.f39051b;
        if (aVar == null) {
            return;
        }
        if (this.f39052c) {
            aVar.mo41148a(true);
        } else {
            aVar.mo41148a(false);
        }
    }
}
