package com.facebook.p127a;

import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.C6787r;
import com.facebook.p127a.C6638q.C6639a;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.concurrent.Executor;

/* renamed from: com.facebook.a.y */
/* compiled from: InternalAppEventsLogger */
public class C6647y {

    /* renamed from: a */
    private C6643u f12115a;

    public C6647y(Context context) {
        this.f12115a = new C6643u(context, (String) null, (AccessToken) null);
    }

    public C6647y(Context context, String applicationId) {
        this.f12115a = new C6643u(context, applicationId, (AccessToken) null);
    }

    public C6647y(String activityName, String applicationId, AccessToken accessToken) {
        this.f12115a = new C6643u(activityName, applicationId, accessToken);
    }

    /* renamed from: a */
    public void mo19852a(String eventName, Bundle parameters) {
        if (C6787r.m13818h()) {
            this.f12115a.mo19842a(eventName, parameters);
        }
    }

    /* renamed from: a */
    public void mo19851a(String eventName, double valueToSum, Bundle parameters) {
        if (C6787r.m13818h()) {
            this.f12115a.mo19841a(eventName, valueToSum, parameters);
        }
    }

    /* renamed from: a */
    public void mo19855a(BigDecimal purchaseAmount, Currency currency, Bundle parameters) {
        if (C6787r.m13818h()) {
            this.f12115a.mo19846a(purchaseAmount, currency, parameters);
        }
    }

    /* renamed from: a */
    public void mo19854a(String eventName, BigDecimal purchaseAmount, Currency currency, Bundle parameters) {
        if (C6787r.m13818h()) {
            this.f12115a.mo19845a(eventName, purchaseAmount, currency, parameters);
        }
    }

    /* renamed from: a */
    public void mo19850a(String eventName) {
        if (C6787r.m13818h()) {
            this.f12115a.mo19843a(eventName, (Double) null, (Bundle) null);
        }
    }

    /* renamed from: a */
    public void mo19853a(String eventName, Double valueToSum, Bundle parameters) {
        if (C6787r.m13818h()) {
            this.f12115a.mo19843a(eventName, valueToSum, parameters);
        }
    }

    /* renamed from: b */
    public void mo19856b(String eventName, Bundle parameters) {
        if (C6787r.m13818h()) {
            this.f12115a.mo19843a(eventName, (Double) null, parameters);
        }
    }

    /* renamed from: c */
    public static C6639a m13254c() {
        return C6643u.m13239e();
    }

    /* renamed from: a */
    public void mo19849a() {
        this.f12115a.mo19848c();
    }

    /* renamed from: b */
    static Executor m13253b() {
        return C6643u.m13238d();
    }

    /* renamed from: d */
    static String m13255d() {
        return C6643u.m13241g();
    }
}
