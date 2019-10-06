package com.inmobi.p207a.p208a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.inmobi.commons.p217a.C10619a;
import com.inmobi.p207a.C10300o;
import com.inmobi.p207a.C10301p.C10303b;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@TargetApi(17)
/* renamed from: com.inmobi.a.a.c */
/* compiled from: CellularInfoUtil */
public class C10279c {

    /* renamed from: a */
    private static final String f31148a = C10279c.class.getSimpleName();

    /* renamed from: a */
    public static Map<String, String> m33522a() {
        Object obj;
        HashMap hashMap = new HashMap();
        Context b = C10619a.m34839b();
        if (b == null) {
            return hashMap;
        }
        C10303b bVar = C10300o.m33571a().f31217a.f31222a;
        if (!(bVar.f31246n && bVar.f31233a)) {
            return hashMap;
        }
        int i = C10300o.m33571a().f31217a.f31222a.f31245m;
        boolean a = m33523a(i, 2);
        boolean a2 = m33523a(i, 1);
        C10277a aVar = new C10277a();
        TelephonyManager telephonyManager = (TelephonyManager) b.getSystemService("phone");
        if (!a) {
            int[] a3 = m33524a(telephonyManager.getNetworkOperator());
            aVar.f31139a = a3[0];
            aVar.f31140b = a3[1];
            String networkCountryIso = telephonyManager.getNetworkCountryIso();
            if (networkCountryIso != null) {
                aVar.f31143e = networkCountryIso.toLowerCase(Locale.ENGLISH);
            }
        }
        if (!a2) {
            int[] a4 = m33524a(telephonyManager.getSimOperator());
            aVar.f31141c = a4[0];
            aVar.f31142d = a4[1];
        }
        String str = null;
        String str2 = "_";
        if (aVar.f31141c == -1 && aVar.f31142d == -1) {
            obj = null;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(aVar.f31141c);
            sb.append(str2);
            sb.append(aVar.f31142d);
            obj = sb.toString();
        }
        hashMap.put("s-ho", obj);
        if (!(aVar.f31139a == -1 && aVar.f31140b == -1)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(aVar.f31139a);
            sb2.append(str2);
            sb2.append(aVar.f31140b);
            str = sb2.toString();
        }
        hashMap.put("s-co", str);
        hashMap.put("s-iso", aVar.f31143e);
        return hashMap;
    }

    /* renamed from: a */
    private static boolean m33523a(int i, int i2) {
        return (i & i2) == i2;
    }

    /* renamed from: a */
    private static int[] m33524a(String str) {
        int[] iArr = {-1, -1};
        if (str == null || str.equals("")) {
            return iArr;
        }
        try {
            int parseInt = Integer.parseInt(str.substring(0, 3));
            int parseInt2 = Integer.parseInt(str.substring(3));
            iArr[0] = parseInt;
            iArr[1] = parseInt2;
        } catch (IndexOutOfBoundsException | NumberFormatException e) {
        }
        return iArr;
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    private static boolean m33527d() {
        if (VERSION.SDK_INT < 28) {
            return true;
        }
        LocationManager locationManager = (LocationManager) C10619a.m34839b().getSystemService("location");
        if (locationManager != null) {
            return locationManager.isLocationEnabled();
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0052  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> m33525b() {
        /*
            com.inmobi.a.o r0 = com.inmobi.p207a.C10300o.m33571a()
            com.inmobi.a.p r0 = r0.f31217a
            com.inmobi.a.p$b r0 = r0.f31222a
            boolean r1 = r0.f31248p
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0015
            boolean r0 = r0.f31233a
            if (r0 == 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            r1 = 0
            if (r0 == 0) goto L_0x00f6
            android.content.Context r0 = com.inmobi.commons.p217a.C10619a.m34839b()
            if (r0 == 0) goto L_0x003f
            java.lang.String r4 = "signals"
            java.lang.String r5 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r5 = com.inmobi.commons.core.utilities.C10701e.m35150a(r0, r4, r5)
            if (r5 != 0) goto L_0x002c
            r5 = 0
            goto L_0x002d
        L_0x002c:
            r5 = 1
        L_0x002d:
            java.lang.String r6 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = com.inmobi.commons.core.utilities.C10701e.m35150a(r0, r4, r6)
            if (r0 != 0) goto L_0x0038
            r0 = 0
            goto L_0x0039
        L_0x0038:
            r0 = 1
        L_0x0039:
            if (r5 != 0) goto L_0x003d
            if (r0 == 0) goto L_0x003f
        L_0x003d:
            r0 = 1
            goto L_0x0040
        L_0x003f:
            r0 = 0
        L_0x0040:
            if (r0 == 0) goto L_0x00f6
            boolean r0 = m33527d()
            if (r0 != 0) goto L_0x004a
            goto L_0x00f6
        L_0x004a:
            android.content.Context r0 = com.inmobi.commons.p217a.C10619a.m34839b()
            if (r0 != 0) goto L_0x0052
            goto L_0x00f7
        L_0x0052:
            java.lang.String r4 = "phone"
            java.lang.Object r0 = r0.getSystemService(r4)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r4 = r0.getNetworkOperator()
            int[] r4 = m33524a(r4)
            r5 = r4[r3]
            java.lang.String r6 = java.lang.String.valueOf(r5)
            r2 = r4[r2]
            java.lang.String r7 = java.lang.String.valueOf(r2)
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 17
            if (r2 < r5) goto L_0x009e
            java.util.List r2 = r0.getAllCellInfo()
            if (r2 == 0) goto L_0x009e
            r8 = r1
            r5 = 0
        L_0x007d:
            int r9 = r2.size()
            if (r5 >= r9) goto L_0x0092
            java.lang.Object r8 = r2.get(r5)
            android.telephony.CellInfo r8 = (android.telephony.CellInfo) r8
            boolean r9 = r8.isRegistered()
            if (r9 != 0) goto L_0x0092
            int r5 = r5 + 1
            goto L_0x007d
        L_0x0092:
            if (r8 == 0) goto L_0x009e
            com.inmobi.a.a.b r1 = new com.inmobi.a.a.b
            int r0 = r0.getNetworkType()
            r1.<init>(r8, r6, r7, r0)
            goto L_0x00f7
        L_0x009e:
            android.telephony.CellLocation r2 = r0.getCellLocation()
            if (r2 == 0) goto L_0x00f5
            r3 = r4[r3]
            r4 = -1
            if (r3 != r4) goto L_0x00aa
            goto L_0x00f5
        L_0x00aa:
            com.inmobi.a.a.b r1 = new com.inmobi.a.a.b
            r1.<init>()
            boolean r3 = r2 instanceof android.telephony.cdma.CdmaCellLocation
            r4 = 2147483647(0x7fffffff, float:NaN)
            if (r3 == 0) goto L_0x00d4
            android.telephony.cdma.CdmaCellLocation r2 = (android.telephony.cdma.CdmaCellLocation) r2
            r1.f31146b = r4
            int r0 = r0.getNetworkType()
            r1.f31147c = r0
            int r0 = r2.getSystemId()
            int r3 = r2.getNetworkId()
            int r2 = r2.getBaseStationId()
            java.lang.String r0 = com.inmobi.p207a.p208a.C10278b.m33519a(r6, r0, r3, r2)
            r1.f31145a = r0
            goto L_0x00f4
        L_0x00d4:
            android.telephony.gsm.GsmCellLocation r2 = (android.telephony.gsm.GsmCellLocation) r2
            r1.f31146b = r4
            int r0 = r0.getNetworkType()
            r1.f31147c = r0
            int r8 = r2.getLac()
            int r9 = r2.getCid()
            int r10 = r2.getPsc()
            r11 = 2147483647(0x7fffffff, float:NaN)
            java.lang.String r0 = com.inmobi.p207a.p208a.C10278b.m33520a(r6, r7, r8, r9, r10, r11)
            r1.f31145a = r0
        L_0x00f4:
            goto L_0x00f7
        L_0x00f5:
            goto L_0x00f7
        L_0x00f6:
        L_0x00f7:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            if (r1 == 0) goto L_0x010c
            org.json.JSONObject r1 = r1.mo33646a()
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "c-sc"
            r0.put(r2, r1)
        L_0x010c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.p207a.p208a.C10279c.m33525b():java.util.Map");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x012d  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, java.lang.String> m33526c() {
        /*
            boolean r0 = com.inmobi.commons.p217a.C10619a.m34838a()
            r1 = 1
            if (r0 == 0) goto L_0x011c
            boolean r0 = com.inmobi.commons.p217a.C10619a.m34838a()
            r2 = 0
            if (r0 == 0) goto L_0x001e
            android.content.Context r0 = com.inmobi.commons.p217a.C10619a.m34839b()
            java.lang.String r3 = "signals"
            java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r0 = com.inmobi.commons.core.utilities.C10701e.m35150a(r0, r3, r4)
            if (r0 == 0) goto L_0x001e
            r0 = 1
            goto L_0x001f
        L_0x001e:
            r0 = 0
        L_0x001f:
            if (r0 == 0) goto L_0x011c
            boolean r0 = m33527d()
            if (r0 == 0) goto L_0x011c
            com.inmobi.a.o r0 = com.inmobi.p207a.C10300o.m33571a()
            com.inmobi.a.p r0 = r0.f31217a
            com.inmobi.a.p$b r0 = r0.f31222a
            boolean r3 = r0.f31247o
            if (r3 == 0) goto L_0x003a
            boolean r0 = r0.f31233a
            if (r0 == 0) goto L_0x003a
            r0 = 1
            goto L_0x003b
        L_0x003a:
            r0 = 0
        L_0x003b:
            if (r0 != 0) goto L_0x003f
            goto L_0x011c
        L_0x003f:
            android.content.Context r0 = com.inmobi.commons.p217a.C10619a.m34839b()
            if (r0 != 0) goto L_0x004c
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            goto L_0x0121
        L_0x004c:
            java.lang.String r3 = "phone"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = r0.getNetworkOperator()
            int[] r4 = m33524a(r4)
            r5 = r4[r2]
            java.lang.String r6 = java.lang.String.valueOf(r5)
            r4 = r4[r1]
            java.lang.String r7 = java.lang.String.valueOf(r4)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 17
            if (r4 < r5) goto L_0x009e
            java.util.List r4 = r0.getAllCellInfo()
            if (r4 == 0) goto L_0x009e
            java.util.Iterator r2 = r4.iterator()
        L_0x007d:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x009c
            java.lang.Object r4 = r2.next()
            android.telephony.CellInfo r4 = (android.telephony.CellInfo) r4
            boolean r5 = r4.isRegistered()
            if (r5 != 0) goto L_0x009b
            com.inmobi.a.a.b r5 = new com.inmobi.a.a.b
            int r8 = r0.getNetworkType()
            r5.<init>(r4, r6, r7, r8)
            r3.add(r5)
        L_0x009b:
            goto L_0x007d
        L_0x009c:
            goto L_0x010e
        L_0x009e:
            java.util.List r0 = r0.getNeighboringCellInfo()
            if (r0 == 0) goto L_0x0116
            boolean r4 = r0.isEmpty()
            if (r4 == 0) goto L_0x00ab
            goto L_0x0116
        L_0x00ab:
            java.util.Iterator r0 = r0.iterator()
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x0110
            java.lang.Object r0 = r0.next()
            android.telephony.NeighboringCellInfo r0 = (android.telephony.NeighboringCellInfo) r0
            com.inmobi.a.a.b r4 = new com.inmobi.a.a.b
            r4.<init>()
            int r5 = r0.getNetworkType()
            r4.f31147c = r5
            int r8 = r0.getRssi()
            r9 = 99
            if (r8 != r9) goto L_0x00d6
            r2 = 2147483647(0x7fffffff, float:NaN)
            r4.f31146b = r2
            goto L_0x00f8
        L_0x00d6:
            r8 = 3
            if (r5 == r8) goto L_0x00e2
            r8 = 15
            if (r5 == r8) goto L_0x00e2
            switch(r5) {
                case 8: goto L_0x00e2;
                case 9: goto L_0x00e2;
                case 10: goto L_0x00e2;
                default: goto L_0x00e1;
            }
        L_0x00e1:
            goto L_0x00e3
        L_0x00e2:
            r2 = 1
        L_0x00e3:
            if (r2 == 0) goto L_0x00ee
            int r2 = r0.getRssi()
            int r2 = r2 + -116
            r4.f31146b = r2
            goto L_0x00f8
        L_0x00ee:
            int r2 = r0.getRssi()
            int r2 = r2 * 2
            int r2 = r2 + -113
            r4.f31146b = r2
        L_0x00f8:
            int r8 = r0.getLac()
            int r9 = r0.getCid()
            r10 = -1
            r11 = 2147483647(0x7fffffff, float:NaN)
            java.lang.String r0 = com.inmobi.p207a.p208a.C10278b.m33520a(r6, r7, r8, r9, r10, r11)
            r4.f31145a = r0
            r3.add(r4)
        L_0x010e:
            r0 = r3
            goto L_0x0121
        L_0x0110:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            goto L_0x0121
        L_0x0116:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            goto L_0x0121
        L_0x011c:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0121:
            java.util.HashMap r2 = new java.util.HashMap
            r2.<init>()
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x014d
            org.json.JSONArray r3 = new org.json.JSONArray
            r3.<init>()
            int r4 = r0.size()
            int r4 = r4 - r1
            java.lang.Object r0 = r0.get(r4)
            com.inmobi.a.a.b r0 = (com.inmobi.p207a.p208a.C10278b) r0
            org.json.JSONObject r0 = r0.mo33646a()
            r3.put(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = "v-sc"
            r2.put(r1, r0)
        L_0x014d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.inmobi.p207a.p208a.C10279c.m33526c():java.util.Map");
    }
}
