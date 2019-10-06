package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.o */
final class C9616o extends zzacj<Float> {
    C9616o(int i, String str, Float f) {
        super(i, str, f, null);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29054a(Bundle bundle) {
        String valueOf = String.valueOf(mo29590a());
        String str = "com.google.android.gms.ads.flag.";
        if (!bundle.containsKey(valueOf.length() != 0 ? str.concat(valueOf) : new String(str))) {
            return (Float) mo29592c();
        }
        String valueOf2 = String.valueOf(mo29590a());
        return Float.valueOf(bundle.getFloat(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str)));
    }

    /* renamed from: a */
    public final /* synthetic */ void mo29056a(Editor editor, Object obj) {
        editor.putFloat(mo29590a(), ((Float) obj).floatValue());
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29055a(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(mo29590a(), (double) ((Float) mo29592c()).floatValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29053a(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(mo29590a(), ((Float) mo29592c()).floatValue()));
    }
}
