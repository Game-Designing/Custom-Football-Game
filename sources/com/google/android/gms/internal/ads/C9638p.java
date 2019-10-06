package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import org.json.JSONObject;

/* renamed from: com.google.android.gms.internal.ads.p */
final class C9638p extends zzacj<String> {
    C9638p(int i, String str, String str2) {
        super(i, str, str2, null);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29054a(Bundle bundle) {
        String valueOf = String.valueOf(mo29590a());
        String str = "com.google.android.gms.ads.flag.";
        if (!bundle.containsKey(valueOf.length() != 0 ? str.concat(valueOf) : new String(str))) {
            return (String) mo29592c();
        }
        String valueOf2 = String.valueOf(mo29590a());
        return bundle.getString(valueOf2.length() != 0 ? str.concat(valueOf2) : new String(str));
    }

    /* renamed from: a */
    public final /* synthetic */ void mo29056a(Editor editor, Object obj) {
        editor.putString(mo29590a(), (String) obj);
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29055a(JSONObject jSONObject) {
        return jSONObject.optString(mo29590a(), (String) mo29592c());
    }

    /* renamed from: a */
    public final /* synthetic */ Object mo29053a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(mo29590a(), (String) mo29592c());
    }
}
