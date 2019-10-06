package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.n */
final class C9594n extends zzacj<Long> {
    C9594n(int i, String str, Long l) {
        super(i, str, l, null);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29054a(Bundle bundle) {
        String valueOf = String.valueOf(mo29590a());
        String str = "com.google.android.gms.ads.flag.";
        if (!bundle.containsKey(valueOf.length() != 0 ? str.concat(valueOf) : new String(str))) {
            return (Long) mo29592c();
        }
        String valueOf2 = String.valueOf(mo29590a());
        return Long.valueOf(bundle.getLong(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str)));
    }

    /* renamed from: a */
    public final /* synthetic */ void mo29056a(Editor editor, Object obj) {
        editor.putLong(mo29590a(), ((Long) obj).longValue());
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29055a(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(mo29590a(), ((Long) mo29592c()).longValue()));
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29053a(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(mo29590a(), ((Long) mo29592c()).longValue()));
    }
}
