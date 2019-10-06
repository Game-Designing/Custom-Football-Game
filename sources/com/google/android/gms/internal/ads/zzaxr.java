package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings.Global;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.SharedPreferencesUtils;

@TargetApi(17)
public class zzaxr extends zzaxt {
    /* renamed from: a */
    public final boolean mo30254a(Context context, WebSettings webSettings) {
        super.mo30254a(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    /* renamed from: a */
    public final String mo30249a(Context context) {
        String str;
        zzazm a = zzazm.m26286a();
        if (TextUtils.isEmpty(a.f25026b)) {
            if (ClientLibraryUtils.m22073a()) {
                str = (String) zzazl.m26284a(context, new C8763Bc(a, context));
            } else {
                str = (String) zzazl.m26284a(context, new C8784Cc(a, GooglePlayServicesUtilLight.getRemoteContext(context), context));
            }
            a.f25026b = str;
        }
        return a.f25026b;
    }

    /* renamed from: b */
    public final void mo30258b(Context context) {
        zzazm a = zzazm.m26286a();
        zzawz.m26003f("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(a.f25026b)) {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (ClientLibraryUtils.m22073a() || remoteContext == null) {
                String str = "admob_user_agent";
                Editor putString = context.getSharedPreferences(str, 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (remoteContext == null) {
                    putString.apply();
                } else {
                    SharedPreferencesUtils.m22119a(context, putString, str);
                }
            }
            a.f25026b = defaultUserAgent;
        }
        zzawz.m26003f("User agent is updated.");
    }

    /* renamed from: a */
    public final Drawable mo30245a(Context context, Bitmap bitmap, boolean z, float f) {
        if (!z || f <= 0.0f || f > 25.0f) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        try {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap createBitmap = Bitmap.createBitmap(createScaledBitmap);
            RenderScript create = RenderScript.create(context);
            ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
            Allocation createFromBitmap = Allocation.createFromBitmap(create, createScaledBitmap);
            Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
            create2.setRadius(f);
            create2.setInput(createFromBitmap);
            create2.forEach(createFromBitmap2);
            createFromBitmap2.copyTo(createBitmap);
            return new BitmapDrawable(context.getResources(), createBitmap);
        } catch (RuntimeException e) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
    }

    /* renamed from: a */
    public final int mo30244a(ContentResolver contentResolver) {
        return Global.getInt(contentResolver, "wifi_on", 0);
    }

    /* renamed from: b */
    public final int mo30256b(ContentResolver contentResolver) {
        return Global.getInt(contentResolver, "airplane_mode_on", 0);
    }
}
