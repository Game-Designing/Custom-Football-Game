package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.m */
final class C9572m extends zzacj<Integer> {
    C9572m(int i, String str, Integer num) {
        super(i, str, num, null);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29054a(Bundle bundle) {
        String valueOf = String.valueOf(mo29590a());
        String str = "com.google.android.gms.ads.flag.";
        if (!bundle.containsKey(valueOf.length() != 0 ? str.concat(valueOf) : new String(str))) {
            return (Integer) mo29592c();
        }
        String valueOf2 = String.valueOf(mo29590a());
        return Integer.valueOf(bundle.getInt(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str)));
    }

    /* renamed from: a */
    public final /* synthetic */ void mo29056a(Editor editor, Object obj) {
        editor.putInt(mo29590a(), ((Integer) obj).intValue());
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29055a(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(mo29590a(), ((Integer) mo29592c()).intValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29053a(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(mo29590a(), ((Integer) mo29592c()).intValue()));
    }
}
