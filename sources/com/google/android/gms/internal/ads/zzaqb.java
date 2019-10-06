package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

@zzard
public class zzaqb {

    /* renamed from: a */
    private final zzbgz f24581a;

    /* renamed from: b */
    private final String f24582b;

    public zzaqb(zzbgz zzbgz) {
        this(zzbgz, "");
    }

    public zzaqb(zzbgz zzbgz, String str) {
        this.f24581a = zzbgz;
        this.f24582b = str;
    }

    /* renamed from: a */
    public final void mo29991a(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put("action", this.f24582b);
            if (this.f24581a != null) {
                this.f24581a.mo28730a("onError", put);
            }
        } catch (JSONException e) {
            zzbad.m26356b("Error occurred while dispatching error event.", e);
        }
    }

    /* renamed from: b */
    public final void mo29993b(String str) {
        try {
            this.f24581a.mo28730a("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzbad.m26356b("Error occured while dispatching ready Event.", e);
        }
    }

    /* renamed from: a */
    public final void mo29989a(int i, int i2, int i3, int i4) {
        try {
            this.f24581a.mo28730a("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzbad.m26356b("Error occured while dispatching size change.", e);
        }
    }

    /* renamed from: b */
    public final void mo29992b(int i, int i2, int i3, int i4) {
        try {
            this.f24581a.mo28730a("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzbad.m26356b("Error occured while dispatching default position.", e);
        }
    }

    /* renamed from: c */
    public final void mo29994c(String str) {
        try {
            this.f24581a.mo28730a("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzbad.m26356b("Error occured while dispatching state change.", e);
        }
    }

    /* renamed from: a */
    public final void mo29990a(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.f24581a.mo28730a("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (JSONException e) {
            zzbad.m26356b("Error occured while obtaining screen information.", e);
        }
    }
}
