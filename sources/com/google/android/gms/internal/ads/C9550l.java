package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.l */
final class C9550l extends zzacj<Boolean> {
    C9550l(int i, String str, Boolean bool) {
        super(i, str, bool, null);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29054a(Bundle bundle) {
        String valueOf = String.valueOf(mo29590a());
        String str = "com.google.android.gms.ads.flag.";
        if (!bundle.containsKey(valueOf.length() != 0 ? str.concat(valueOf) : new String(str))) {
            return (Boolean) mo29592c();
        }
        String valueOf2 = String.valueOf(mo29590a());
        return Boolean.valueOf(bundle.getBoolean(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str)));
    }

    /* renamed from: a */
    public final /* synthetic */ void mo29056a(Editor editor, Object obj) {
        editor.putBoolean(mo29590a(), ((Boolean) obj).booleanValue());
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29055a(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(mo29590a(), ((Boolean) mo29592c()).booleanValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29053a(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(mo29590a(), ((Boolean) mo29592c()).booleanValue()));
    }
}
