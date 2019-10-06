package com.inmobi.p207a.p209b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.inmobi.commons.core.p218a.C10621a;
import com.inmobi.commons.core.p222e.C10658a;
import com.inmobi.commons.core.utilities.C10701e;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.p207a.C10300o;
import com.inmobi.p207a.C10301p.C10303b;

/* renamed from: com.inmobi.a.b.b */
/* compiled from: WifiInfoUtil */
public final class C10282b {
    /* renamed from: a */
    private static C10281a m33531a(boolean z, boolean z2) {
        C10281a aVar;
        NoSuchMethodError e;
        Exception e2;
        String str;
        String str2 = "\"";
        Context b = C10619a.m34839b();
        if (b == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = ((WifiManager) b.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                String bssid = connectionInfo.getBSSID();
                String ssid = connectionInfo.getSSID();
                if (bssid != null) {
                    if (!(z && ssid != null && ssid.endsWith("_nomap"))) {
                        aVar = new C10281a();
                        try {
                            aVar.f31152a = m33529a(bssid);
                            if (ssid == null || !ssid.startsWith(str2) || !ssid.endsWith(str2)) {
                                str = ssid;
                            } else {
                                str = ssid.substring(1, ssid.length() - 1);
                            }
                            if (z2) {
                                str = null;
                            }
                            aVar.f31153b = str;
                            aVar.f31154c = connectionInfo.getRssi();
                            aVar.f31155d = connectionInfo.getIpAddress();
                        } catch (NoSuchMethodError e3) {
                            e = e3;
                            C10621a.m34854a().mo34423a(new C10658a(e));
                            return aVar;
                        } catch (Exception e4) {
                            e2 = e4;
                            C10621a.m34854a().mo34423a(new C10658a(e2));
                            return aVar;
                        }
                        return aVar;
                    }
                }
            }
            aVar = null;
        } catch (NoSuchMethodError e5) {
            e = e5;
            aVar = null;
            C10621a.m34854a().mo34423a(new C10658a(e));
            return aVar;
        } catch (Exception e6) {
            e2 = e6;
            aVar = null;
            C10621a.m34854a().mo34423a(new C10658a(e2));
            return aVar;
        }
        return aVar;
    }

    /* renamed from: a */
    private static long m33529a(String str) {
        String[] split = str.split("\\:");
        byte[] bArr = new byte[6];
        int i = 0;
        while (i < 6) {
            try {
                bArr[i] = (byte) Integer.parseInt(split[i], 16);
                i++;
            } catch (NumberFormatException e) {
                return 0;
            }
        }
        return ((((long) bArr[0]) & 255) << 40) | ((((long) bArr[3]) & 255) << 16) | (((long) bArr[5]) & 255) | ((((long) bArr[4]) & 255) << 8) | ((((long) bArr[2]) & 255) << 24) | ((((long) bArr[1]) & 255) << 32);
    }

    /* renamed from: a */
    private static boolean m33532a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: a */
    public static C10281a m33530a() {
        boolean z = false;
        if (C10619a.m34838a() && C10701e.m35150a(C10619a.m34839b(), "signals", "android.permission.ACCESS_WIFI_STATE")) {
            C10303b bVar = C10300o.m33571a().f31217a.f31222a;
            if (bVar.f31244l && bVar.f31233a) {
                z = true;
            }
            if (z) {
                int i = C10300o.m33571a().f31217a.f31222a.f31242j;
                return m33531a(!m33532a(i, 2), m33532a(i, 1));
            }
        }
        return null;
    }
}
