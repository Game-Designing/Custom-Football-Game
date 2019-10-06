package com.inmobi.p207a.p208a;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import com.mopub.nativeads.MoPubNativeAdPositioning.MoPubClientPositioning;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.inmobi.a.a.b */
/* compiled from: CellTowerInfo */
public class C10278b {

    /* renamed from: d */
    private static final String f31144d = C10278b.class.getSimpleName();

    /* renamed from: a */
    String f31145a;

    /* renamed from: b */
    int f31146b;

    /* renamed from: c */
    int f31147c;

    public C10278b() {
    }

    @TargetApi(18)
    public C10278b(CellInfo cellInfo, String str, String str2, int i) {
        if (cellInfo instanceof CellInfoGsm) {
            this.f31147c = i;
            CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
            this.f31146b = cellInfoGsm.getCellSignalStrength().getDbm();
            CellIdentityGsm cellIdentity = cellInfoGsm.getCellIdentity();
            this.f31145a = m33520a(str, str2, cellIdentity.getLac(), cellIdentity.getCid(), -1, MoPubClientPositioning.NO_REPEAT);
        } else if (cellInfo instanceof CellInfoCdma) {
            this.f31147c = i;
            CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
            this.f31146b = cellInfoCdma.getCellSignalStrength().getDbm();
            CellIdentityCdma cellIdentity2 = cellInfoCdma.getCellIdentity();
            this.f31145a = m33519a(str, cellIdentity2.getSystemId(), cellIdentity2.getNetworkId(), cellIdentity2.getBasestationId());
        } else {
            if (VERSION.SDK_INT >= 18) {
                if (cellInfo instanceof CellInfoWcdma) {
                    this.f31147c = i;
                    CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                    this.f31146b = cellInfoWcdma.getCellSignalStrength().getDbm();
                    CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                    this.f31145a = m33520a(str, str2, cellIdentity3.getLac(), cellIdentity3.getCid(), cellIdentity3.getPsc(), MoPubClientPositioning.NO_REPEAT);
                }
            } else if (cellInfo instanceof CellInfoLte) {
                this.f31147c = i;
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                this.f31146b = cellInfoLte.getCellSignalStrength().getDbm();
                CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                this.f31145a = m33520a(str, str2, cellIdentity4.getTac(), cellIdentity4.getCi(), -1, cellIdentity4.getPci());
            }
        }
    }

    /* renamed from: a */
    public static String m33519a(String str, int i, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = "#";
        sb.append(str2);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    /* renamed from: a */
    public static String m33520a(String str, String str2, int i, int i2, int i3, int i4) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str3 = "#";
        sb.append(str3);
        sb.append(str2);
        sb.append(str3);
        sb.append(i);
        sb.append(str3);
        sb.append(i2);
        sb.append(str3);
        Object obj = "";
        sb.append(i3 == -1 ? obj : Integer.valueOf(i3));
        sb.append(str3);
        if (i4 != Integer.MAX_VALUE) {
            obj = Integer.valueOf(i4);
        }
        sb.append(obj);
        return sb.toString();
    }

    /* renamed from: a */
    public final JSONObject mo33646a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", this.f31145a);
            if (this.f31146b != Integer.MAX_VALUE) {
                jSONObject.put("ss", this.f31146b);
            }
            jSONObject.put("nt", this.f31147c);
        } catch (JSONException e) {
        }
        return jSONObject;
    }
}
