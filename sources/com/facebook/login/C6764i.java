package com.facebook.login;

import com.facebook.C6787r;
import com.facebook.C6817z;
import com.facebook.FacebookException;
import com.facebook.GraphRequest.C6545b;
import com.facebook.internal.C6670D;
import com.facebook.internal.C6691O;
import com.facebook.internal.C6694S;
import com.facebook.internal.C6694S.C6696b;
import com.facebook.p131b.p132a.C6652b;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.login.i */
/* compiled from: DeviceAuthDialog */
class C6764i implements C6545b {

    /* renamed from: a */
    final /* synthetic */ String f12430a;

    /* renamed from: b */
    final /* synthetic */ Date f12431b;

    /* renamed from: c */
    final /* synthetic */ Date f12432c;

    /* renamed from: d */
    final /* synthetic */ DeviceAuthDialog f12433d;

    C6764i(DeviceAuthDialog this$0, String str, Date date, Date date2) {
        this.f12433d = this$0;
        this.f12430a = str;
        this.f12431b = date;
        this.f12432c = date2;
    }

    /* renamed from: a */
    public void mo9460a(C6817z response) {
        if (!this.f12433d.f12357e.get()) {
            if (response.mo20227a() != null) {
                this.f12433d.mo20008a(response.mo20227a().mo19665e());
                return;
            }
            try {
                JSONObject jsonObject = response.mo20228b();
                String userId = jsonObject.getString("id");
                C6696b permissions = C6694S.m13398a(jsonObject);
                String name = jsonObject.getString("name");
                C6652b.m13274a(this.f12433d.f12360h.mo20019d());
                if (!C6670D.m13306b(C6787r.m13816f()).mo19981i().contains(C6691O.RequireConfirm) || this.f12433d.f12363k) {
                    this.f12433d.m13635a(userId, permissions, this.f12430a, this.f12431b, this.f12432c);
                    return;
                }
                this.f12433d.f12363k = true;
                this.f12433d.m13634a(userId, permissions, this.f12430a, name, this.f12431b, this.f12432c);
            } catch (JSONException ex) {
                this.f12433d.mo20008a(new FacebookException((Throwable) ex));
            }
        }
    }
}
