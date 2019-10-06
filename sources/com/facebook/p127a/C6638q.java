package com.facebook.p127a;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.C6787r;
import com.facebook.GraphRequest.C6545b;

/* renamed from: com.facebook.a.q */
/* compiled from: AppEventsLogger */
public class C6638q {

    /* renamed from: a */
    private static final String f12082a = C6638q.class.getCanonicalName();

    /* renamed from: b */
    private C6643u f12083b;

    /* renamed from: com.facebook.a.q$a */
    /* compiled from: AppEventsLogger */
    public enum C6639a {
        AUTO,
        EXPLICIT_ONLY
    }

    /* renamed from: a */
    public static void m13214a(Application application) {
        C6643u.m13231a(application, (String) null);
    }

    /* renamed from: a */
    public static void m13215a(Application application, String applicationId) {
        C6643u.m13231a(application, applicationId);
    }

    /* renamed from: a */
    public static void m13216a(Context context, String applicationId) {
        C6643u.m13232a(context, applicationId);
    }

    /* renamed from: b */
    public static C6638q m13220b(Context context) {
        return new C6638q(context, null, null);
    }

    private C6638q(Context context, String applicationId, AccessToken accessToken) {
        this.f12083b = new C6643u(context, applicationId, accessToken);
    }

    /* renamed from: b */
    public static C6639a m13219b() {
        return C6643u.m13239e();
    }

    /* renamed from: a */
    public void mo19835a(String eventName) {
        this.f12083b.mo19840a(eventName);
    }

    /* renamed from: a */
    public void mo19836a(String eventName, Bundle parameters) {
        this.f12083b.mo19842a(eventName, parameters);
    }

    /* renamed from: a */
    public void mo19834a() {
        this.f12083b.mo19848c();
    }

    /* renamed from: e */
    public static void m13225e() {
        C6643u.m13242h();
    }

    /* renamed from: c */
    public static void m13223c(String userID) {
        C6623e.m13174b(userID);
    }

    /* renamed from: d */
    public static String m13224d() {
        return C6623e.m13176d();
    }

    /* renamed from: c */
    public static String m13222c() {
        return C6563C.m12997a();
    }

    /* renamed from: a */
    public static void m13217a(Bundle parameters, C6545b callback) {
        m13218a(parameters, C6787r.m13816f(), callback);
    }

    /* renamed from: a */
    public static void m13218a(Bundle parameters, String applicationID, C6545b callback) {
        C6643u.m13233a(parameters, applicationID, callback);
    }

    /* renamed from: a */
    public static String m13213a(Context context) {
        return C6643u.m13230a(context);
    }

    /* renamed from: b */
    public static void m13221b(String referrer) {
        C6643u.m13236b(referrer);
    }
}
