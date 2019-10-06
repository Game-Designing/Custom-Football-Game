package com.google.android.gms.safetynet;

import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;

public class SafeBrowsingData extends AbstractSafeParcelable {
    public static final Creator<SafeBrowsingData> CREATOR = new zzj();

    /* renamed from: a */
    private static final String f30559a = SafeBrowsingData.class.getSimpleName();

    /* renamed from: b */
    private String f30560b;

    /* renamed from: c */
    private DataHolder f30561c;

    /* renamed from: d */
    private ParcelFileDescriptor f30562d;

    /* renamed from: e */
    private long f30563e;

    /* renamed from: f */
    private byte[] f30564f;

    /* renamed from: g */
    private byte[] f30565g;

    /* renamed from: h */
    private File f30566h;

    public SafeBrowsingData() {
        this(null, null, null, 0, null);
    }

    @Constructor
    public SafeBrowsingData(@Param(id = 2) String str, @Param(id = 3) DataHolder dataHolder, @Param(id = 4) ParcelFileDescriptor parcelFileDescriptor, @Param(id = 5) long j, @Param(id = 6) byte[] bArr) {
        this.f30560b = str;
        this.f30561c = dataHolder;
        this.f30562d = parcelFileDescriptor;
        this.f30563e = j;
        this.f30564f = bArr;
    }

    /* renamed from: a */
    private static void m32719a(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0033  */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.io.FileOutputStream m32720g() {
        /*
            r5 = this;
            java.io.File r0 = r5.f30566h
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.String r2 = "xlb"
            java.lang.String r3 = ".tmp"
            java.io.File r0 = java.io.File.createTempFile(r2, r3, r0)     // Catch:{ IOException -> 0x002f, all -> 0x0025 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            android.os.ParcelFileDescriptor r3 = android.os.ParcelFileDescriptor.open(r0, r3)     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            r5.f30562d = r3     // Catch:{ IOException -> 0x0023, all -> 0x0021 }
            if (r0 == 0) goto L_0x0020
            r0.delete()
        L_0x0020:
            return r2
        L_0x0021:
            r1 = move-exception
            goto L_0x0029
        L_0x0023:
            r2 = move-exception
            goto L_0x0031
        L_0x0025:
            r0 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L_0x0029:
            if (r0 == 0) goto L_0x002e
            r0.delete()
        L_0x002e:
            throw r1
        L_0x002f:
            r0 = move-exception
            r0 = r1
        L_0x0031:
            if (r0 == 0) goto L_0x0036
            r0.delete()
        L_0x0036:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.safetynet.SafeBrowsingData.m32720g():java.io.FileOutputStream");
    }

    /* renamed from: a */
    public DataHolder mo33119a() {
        return this.f30561c;
    }

    /* renamed from: c */
    public ParcelFileDescriptor mo33120c() {
        return this.f30562d;
    }

    /* renamed from: d */
    public long mo33121d() {
        return this.f30563e;
    }

    /* renamed from: e */
    public String mo33122e() {
        return this.f30560b;
    }

    /* renamed from: f */
    public byte[] mo33123f() {
        return this.f30564f;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(android.os.Parcel r4, int r5) {
        /*
            r3 = this;
            android.os.ParcelFileDescriptor r0 = r3.f30562d
            r1 = 1
            if (r0 != 0) goto L_0x0032
            byte[] r0 = r3.f30565g
            if (r0 == 0) goto L_0x0032
            java.io.FileOutputStream r0 = r3.m32720g()
            if (r0 == 0) goto L_0x0032
            java.io.BufferedOutputStream r2 = new java.io.BufferedOutputStream
            r2.<init>(r0)
            java.io.DataOutputStream r0 = new java.io.DataOutputStream
            r0.<init>(r2)
            byte[] r2 = r3.f30565g     // Catch:{ IOException -> 0x002e, all -> 0x0029 }
            int r2 = r2.length     // Catch:{ IOException -> 0x002e, all -> 0x0029 }
            r0.writeInt(r2)     // Catch:{ IOException -> 0x002e, all -> 0x0029 }
            byte[] r2 = r3.f30565g     // Catch:{ IOException -> 0x002e, all -> 0x0029 }
            r0.write(r2)     // Catch:{ IOException -> 0x002e, all -> 0x0029 }
            m32719a(r0)
            r0 = 1
            goto L_0x0033
        L_0x0029:
            r4 = move-exception
            m32719a(r0)
            throw r4
        L_0x002e:
            r2 = move-exception
            m32719a(r0)
        L_0x0032:
            r0 = 0
        L_0x0033:
            if (r0 != 0) goto L_0x0036
            goto L_0x0037
        L_0x0036:
            r5 = r5 | r1
        L_0x0037:
            com.google.android.gms.safetynet.zzj.m32732a(r3, r4, r5)
            r4 = 0
            r3.f30562d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.safetynet.SafeBrowsingData.writeToParcel(android.os.Parcel, int):void");
    }
}
