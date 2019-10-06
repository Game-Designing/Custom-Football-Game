package com.facebook.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p000v4.content.C0515e;
import com.facebook.p127a.C6647y;

/* renamed from: com.facebook.internal.c */
/* compiled from: BoltsMeasurementEventListener */
public class C6712c extends BroadcastReceiver {

    /* renamed from: a */
    private static C6712c f12277a;

    /* renamed from: b */
    private Context f12278b;

    private C6712c(Context context) {
        this.f12278b = context.getApplicationContext();
    }

    /* renamed from: b */
    private void m13524b() {
        C0515e.m2597a(this.f12278b).mo5313a(this, new IntentFilter("com.parse.bolts.measurement_event"));
    }

    /* renamed from: a */
    private void m13523a() {
        C0515e.m2597a(this.f12278b).mo5312a((BroadcastReceiver) this);
    }

    /* renamed from: a */
    public static C6712c m13522a(Context context) {
        C6712c cVar = f12277a;
        if (cVar != null) {
            return cVar;
        }
        f12277a = new C6712c(context);
        f12277a.m13524b();
        return f12277a;
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            m13523a();
        } finally {
            super.finalize();
        }
    }

    public void onReceive(Context context, Intent intent) {
        C6647y logger = new C6647y(context);
        StringBuilder sb = new StringBuilder();
        sb.append("bf_");
        sb.append(intent.getStringExtra("event_name"));
        String eventName = sb.toString();
        Bundle eventArgs = intent.getBundleExtra("event_args");
        Bundle logData = new Bundle();
        for (String key : eventArgs.keySet()) {
            String str = "";
            logData.putString(key.replaceAll("[^0-9a-zA-Z _-]", "-").replaceAll("^[ -]*", str).replaceAll("[ -]*$", str), (String) eventArgs.get(key));
        }
        logger.mo19852a(eventName, logData);
    }
}
