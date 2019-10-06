package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbml implements zzalm<zzbmp> {

    /* renamed from: a */
    private final Context f25543a;

    /* renamed from: b */
    private final zzty f25544b;

    /* renamed from: c */
    private final PowerManager f25545c;

    public zzbml(Context context, zzty zzty) {
        this.f25543a = context;
        this.f25544b = zzty;
        this.f25545c = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: a */
    public final JSONObject mo28177a(zzbmp zzbmp) throws JSONException {
        JSONObject jSONObject;
        boolean z;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzud zzud = zzbmp.f25563f;
        if (zzud == null) {
            jSONObject = new JSONObject();
        } else if (this.f25544b.mo32245c() != null) {
            boolean z2 = zzud.f29455c;
            JSONObject jSONObject3 = new JSONObject();
            String str = "activeViewJSON";
            String str2 = "timestamp";
            String str3 = "adFormat";
            String str4 = "hashCode";
            JSONObject put = jSONObject3.put("afmaVersion", this.f25544b.mo32244b()).put(str, this.f25544b.mo32245c()).put(str2, zzbmp.f25561d).put(str3, this.f25544b.mo32243a()).put(str4, this.f25544b.mo32246d());
            zzty zzty = this.f25544b;
            String str5 = "isNative";
            JSONObject put2 = put.put("isMraid", false).put("isStopped", false).put("isPaused", zzbmp.f25559b).put(str5, this.f25544b.mo32247e());
            if (VERSION.SDK_INT >= 20) {
                z = this.f25545c.isInteractive();
            } else {
                z = this.f25545c.isScreenOn();
            }
            String str6 = "appVolume";
            String str7 = "deviceVolume";
            put2.put("isScreenOn", z).put("appMuted", zzk.zzll().mo30265b()).put(str6, (double) zzk.zzll().mo30262a()).put(str7, (double) zzaya.m26209a(this.f25543a.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.f25543a.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            DisplayMetrics displayMetrics = this.f25543a.getResources().getDisplayMetrics();
            String str8 = "top";
            String str9 = "bottom";
            String str10 = "left";
            String str11 = "right";
            String str12 = "globalVisibleBoxVisible";
            String str13 = "localVisibleBoxVisible";
            String str14 = "screenDensity";
            jSONObject3.put("windowVisibility", zzud.f29456d).put("isAttachedToWindow", z2).put("viewBox", new JSONObject().put(str8, zzud.f29457e.top).put(str9, zzud.f29457e.bottom).put(str10, zzud.f29457e.left).put(str11, zzud.f29457e.right)).put("adBox", new JSONObject().put(str8, zzud.f29458f.top).put(str9, zzud.f29458f.bottom).put(str10, zzud.f29458f.left).put(str11, zzud.f29458f.right)).put("globalVisibleBox", new JSONObject().put(str8, zzud.f29459g.top).put(str9, zzud.f29459g.bottom).put(str10, zzud.f29459g.left).put(str11, zzud.f29459g.right)).put(str12, zzud.f29460h).put("localVisibleBox", new JSONObject().put(str8, zzud.f29461i.top).put(str9, zzud.f29461i.bottom).put(str10, zzud.f29461i.left).put(str11, zzud.f29461i.right)).put(str13, zzud.f29462j).put("hitBox", new JSONObject().put(str8, zzud.f29463k.top).put(str9, zzud.f29463k.bottom).put(str10, zzud.f29463k.left).put(str11, zzud.f29463k.right)).put(str14, (double) displayMetrics.density);
            jSONObject3.put("isVisible", zzbmp.f25558a);
            if (((Boolean) zzyt.m31536e().mo29599a(zzacu.f24000Rb)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzud.f29466n;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put(str8, rect2.top).put(str9, rect2.bottom).put(str10, rect2.left).put(str11, rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbmp.f25562e)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
