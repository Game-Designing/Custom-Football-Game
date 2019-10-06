package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcpl extends zzaoz {

    /* renamed from: b */
    private final zzcpk f27167b;

    /* renamed from: c */
    private zzbbr<JSONObject> f27168c;

    /* renamed from: d */
    private final JSONObject f27169d = new JSONObject();

    /* renamed from: e */
    private boolean f27170e = false;

    public zzcpl(zzcpk zzcpk, zzbbr<JSONObject> zzbbr) {
        this.f27168c = zzbbr;
        this.f27167b = zzcpk;
        try {
            this.f27169d.put("adapter_version", this.f27167b.f27166d.mo29956_a().toString());
            this.f27169d.put("sdk_version", this.f27167b.f27166d.mo29955Wa().toString());
            this.f27169d.put("name", this.f27167b.f27163a);
        } catch (RemoteException | NullPointerException | JSONException e) {
        }
    }

    /* renamed from: d */
    public final synchronized void mo29967d(String str) throws RemoteException {
        if (!this.f27170e) {
            if (str == null) {
                onFailure("Adapter returned null signals");
                return;
            }
            try {
                this.f27169d.put("signals", str);
            } catch (JSONException e) {
            }
            this.f27168c.mo30338b(this.f27169d);
            this.f27170e = true;
        }
    }

    public final synchronized void onFailure(String str) throws RemoteException {
        if (!this.f27170e) {
            try {
                this.f27169d.put("signal_error", str);
            } catch (JSONException e) {
            }
            this.f27168c.mo30338b(this.f27169d);
            this.f27170e = true;
        }
    }
}
