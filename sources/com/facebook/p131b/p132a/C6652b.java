package com.facebook.p131b.p132a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.C6787r;
import com.facebook.internal.C6670D;
import com.facebook.internal.C6691O;
import com.facebook.internal.C6694S;
import com.google.zxing.C10197a;
import com.google.zxing.C10211c;
import com.google.zxing.C10252e;
import com.google.zxing.WriterException;
import com.google.zxing.p198b.C10209b;
import com.mopub.mobileads.resource.DrawableConstants.CtaButton;
import java.util.EnumMap;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.b.a.b */
/* compiled from: DeviceRequestsHelper */
public class C6652b {

    /* renamed from: a */
    private static final String f12121a = C6652b.class.getCanonicalName();

    /* renamed from: b */
    private static HashMap<String, RegistrationListener> f12122b = new HashMap<>();

    /* renamed from: a */
    public static String m13273a() {
        JSONObject deviceInfo = new JSONObject();
        try {
            deviceInfo.put("device", Build.DEVICE);
            deviceInfo.put("model", Build.MODEL);
        } catch (JSONException e) {
        }
        return deviceInfo.toString();
    }

    /* renamed from: c */
    public static boolean m13277c(String userCode) {
        if (m13276b()) {
            return m13279e(userCode);
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m13276b() {
        return VERSION.SDK_INT >= 16 && C6670D.m13306b(C6787r.m13816f()).mo19981i().contains(C6691O.Enabled);
    }

    /* renamed from: b */
    public static Bitmap m13275b(String url) {
        EnumMap enumMap = new EnumMap(C10211c.class);
        enumMap.put(C10211c.MARGIN, Integer.valueOf(2));
        try {
            C10209b matrix = new C10252e().mo33488a(url, C10197a.QR_CODE, 200, 200, enumMap);
            int h = matrix.mo33535b();
            int w = matrix.mo33537c();
            int[] pixels = new int[(h * w)];
            for (int i = 0; i < h; i++) {
                int offset = i * w;
                for (int j = 0; j < w; j++) {
                    pixels[offset + j] = matrix.mo33534a(j, i) ? CtaButton.BACKGROUND_COLOR : -1;
                }
            }
            Bitmap qrCode = Bitmap.createBitmap(w, h, Config.ARGB_8888);
            try {
                qrCode.setPixels(pixels, 0, w, 0, 0, w, h);
                return qrCode;
            } catch (WriterException e) {
                return qrCode;
            }
        } catch (WriterException e2) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m13274a(String userCode) {
        m13278d(userCode);
    }

    @TargetApi(16)
    /* renamed from: e */
    private static boolean m13279e(String userCode) {
        if (f12122b.containsKey(userCode)) {
            return true;
        }
        String nsdServiceName = String.format("%s_%s_%s", new Object[]{"fbsdk", String.format("%s-%s", new Object[]{"android", C6787r.m13826p().replace('.', '|')}), userCode});
        NsdServiceInfo nsdLoginAdvertisementService = new NsdServiceInfo();
        nsdLoginAdvertisementService.setServiceType("_fb._tcp.");
        nsdLoginAdvertisementService.setServiceName(nsdServiceName);
        nsdLoginAdvertisementService.setPort(80);
        NsdManager nsdManager = (NsdManager) C6787r.m13815e().getSystemService("servicediscovery");
        RegistrationListener nsdRegistrationListener = new C6651a(nsdServiceName, userCode);
        f12122b.put(userCode, nsdRegistrationListener);
        nsdManager.registerService(nsdLoginAdvertisementService, 1, nsdRegistrationListener);
        return true;
    }

    @TargetApi(16)
    /* renamed from: d */
    private static void m13278d(String userCode) {
        RegistrationListener nsdRegistrationListener = (RegistrationListener) f12122b.get(userCode);
        if (nsdRegistrationListener != null) {
            try {
                ((NsdManager) C6787r.m13815e().getSystemService("servicediscovery")).unregisterService(nsdRegistrationListener);
            } catch (IllegalArgumentException e) {
                C6694S.m13422a(f12121a, (Exception) e);
            }
            f12122b.remove(userCode);
        }
    }
}
