package com.inmobi.commons.core.configs;

import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.commons.core.configs.g */
/* compiled from: PkConfig */
public final class C10651g extends C10639a {

    /* renamed from: a */
    public String f32466a = "010001";

    /* renamed from: b */
    public String f32467b = "E72409364B865B757E1D6B8DB73011BBB1D20C1A9F931ADD3C4C09E2794CE102F8AA7F2D50EB88F9880A576E6C7B0E95712CAE9416F7BACB798564627846E93B";

    /* renamed from: c */
    public String f32468c = "1";

    /* renamed from: d */
    private String f32469d = "rsa";

    /* renamed from: a */
    public final String mo33671a() {
        return "pk";
    }

    /* renamed from: a */
    public final void mo33672a(JSONObject jSONObject) throws JSONException {
        super.mo33672a(jSONObject);
        this.f32466a = jSONObject.getString("e");
        this.f32467b = jSONObject.getString(InneractiveMediationDefs.GENDER_MALE);
        this.f32469d = jSONObject.getString("alg");
        this.f32468c = jSONObject.getString("ver");
    }

    /* renamed from: b */
    public final JSONObject mo33673b() throws JSONException {
        JSONObject b = super.mo33673b();
        b.put("e", this.f32466a);
        b.put(InneractiveMediationDefs.GENDER_MALE, this.f32467b);
        b.put("alg", this.f32469d);
        b.put("ver", this.f32468c);
        return b;
    }

    /* renamed from: c */
    public final boolean mo33674c() {
        return (this.f32466a.trim().length() == 0 || this.f32467b.trim().length() == 0 || this.f32469d.trim().length() == 0 || this.f32468c.trim().length() == 0) ? false : true;
    }

    /* renamed from: d */
    public final C10639a mo33675d() {
        return new C10651g();
    }
}
