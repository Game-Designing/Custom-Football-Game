package com.facebook.p127a.p130b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import com.facebook.C6787r;

/* renamed from: com.facebook.a.b.w */
/* compiled from: SourceApplicationInfo */
class C6619w {

    /* renamed from: a */
    private String f12037a;

    /* renamed from: b */
    private boolean f12038b;

    private C6619w(String callingApplicationPackage, boolean openedByAppLink) {
        this.f12037a = callingApplicationPackage;
        this.f12038b = openedByAppLink;
    }

    /* renamed from: b */
    public static C6619w m13169b() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(C6787r.m13815e());
        String str = "com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage";
        if (!sharedPreferences.contains(str)) {
            return null;
        }
        return new C6619w(sharedPreferences.getString(str, null), sharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false));
    }

    /* renamed from: a */
    public static void m13168a() {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(C6787r.m13815e()).edit();
        editor.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
        editor.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
        editor.apply();
    }

    public String toString() {
        String openType = "Unclassified";
        if (this.f12038b) {
            openType = "Applink";
        }
        if (this.f12037a == null) {
            return openType;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(openType);
        sb.append("(");
        sb.append(this.f12037a);
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: c */
    public void mo19814c() {
        Editor editor = PreferenceManager.getDefaultSharedPreferences(C6787r.m13815e()).edit();
        editor.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.f12037a);
        editor.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.f12038b);
        editor.apply();
    }
}
