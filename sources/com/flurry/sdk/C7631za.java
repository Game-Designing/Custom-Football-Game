package com.flurry.sdk;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.flurry.sdk.za */
public class C7631za {

    /* renamed from: a */
    private static final String f15145a = C7631za.class.getSimpleName();

    /* renamed from: b */
    byte[] f15146b;

    /* renamed from: com.flurry.sdk.za$a */
    public static class C7632a implements C7493ad<C7631za> {
        /* renamed from: a */
        public final /* synthetic */ Object mo23855a(InputStream inputStream) throws IOException {
            if (inputStream == null) {
                return null;
            }
            C7626ya yaVar = new C7626ya(this, inputStream);
            C7631za zaVar = new C7631za(0);
            int readUnsignedShort = yaVar.readUnsignedShort();
            if (readUnsignedShort > 0) {
                byte[] bArr = new byte[readUnsignedShort];
                yaVar.readFully(bArr);
                zaVar.f15146b = bArr;
            }
            return zaVar;
        }

        /* renamed from: a */
        public final /* synthetic */ void mo23856a(OutputStream outputStream, Object obj) throws IOException {
            C7631za zaVar = (C7631za) obj;
            if (outputStream != null && zaVar != null) {
                C7621xa xaVar = new C7621xa(this, outputStream);
                int i = 0;
                byte[] bArr = zaVar.f15146b;
                if (bArr != null) {
                    i = bArr.length;
                }
                xaVar.writeShort(i);
                if (i > 0) {
                    xaVar.write(zaVar.f15146b);
                }
                xaVar.flush();
            }
        }
    }

    /* synthetic */ C7631za(byte b) {
        this();
    }

    private C7631za() {
    }

    public C7631za(byte[] bArr) {
        this.f15146b = bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x01b4 A[Catch:{ IOException -> 0x0321, all -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01b8 A[Catch:{ IOException -> 0x0321, all -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01cb A[Catch:{ IOException -> 0x0321, all -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01cf A[Catch:{ IOException -> 0x0321, all -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0205 A[Catch:{ IOException -> 0x0321, all -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0209 A[Catch:{ IOException -> 0x0321, all -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0236 A[Catch:{ IOException -> 0x0321, all -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0269 A[Catch:{ IOException -> 0x0321, all -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0276 A[Catch:{ IOException -> 0x0321, all -> 0x031f }, LOOP:5: B:82:0x0274->B:83:0x0276, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x02a8 A[Catch:{ IOException -> 0x0321, all -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02d4 A[Catch:{ IOException -> 0x0321, all -> 0x031f }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02d8 A[Catch:{ IOException -> 0x0321, all -> 0x031f }] */
    @android.annotation.SuppressLint({"NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C7631za(com.flurry.sdk.C7351Aa r13) throws java.io.IOException {
        /*
            r12 = this;
            java.lang.String r0 = ""
            r12.<init>()
            r1 = 6
            r2 = 0
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0327 }
            r3.<init>()     // Catch:{ IOException -> 0x0327 }
            java.io.DataOutputStream r4 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0327 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0327 }
            r2 = 14
            r4.writeShort(r2)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r2 = r13.f14337a     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r2)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r0)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r2 = "11060000"
            r4.writeUTF(r2)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            long r5 = r13.f14338b     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeLong(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            long r5 = r13.f14339c     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeLong(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            long r5 = r13.f14340d     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeLong(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r2 = 1
            r4.writeBoolean(r2)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            byte r5 = r13.f14354r     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeByte(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            boolean r5 = r13.f14355s     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeBoolean(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r5 = r13.f14342f     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r6 = 0
            if (r5 != 0) goto L_0x005b
            r4.writeBoolean(r2)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r5 = r13.f14342f     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x005e
        L_0x005b:
            r4.writeBoolean(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x005e:
            java.lang.String r5 = r13.f14343g     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r5 != 0) goto L_0x0071
            r4.writeBoolean(r2)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r5 = r13.f14343g     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x0074
        L_0x0071:
            r4.writeBoolean(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x0074:
            java.util.Map<java.lang.String, java.lang.String> r5 = r13.f14344h     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r5 != 0) goto L_0x007e
            r4.writeShort(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x00ac
        L_0x007e:
            int r7 = r5.size()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeShort(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x008d:
            boolean r7 = r5.hasNext()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r7 == 0) goto L_0x00ac
            java.lang.Object r7 = r5.next()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.Object r8 = r7.getKey()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r8)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.Object r7 = r7.getValue()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x008d
        L_0x00ac:
            java.util.Map<java.lang.String, java.lang.String> r5 = r13.f14341e     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r5 != 0) goto L_0x00b6
            r4.writeShort(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x00e7
        L_0x00b6:
            int r7 = r5.size()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeShort(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x00c5:
            boolean r7 = r5.hasNext()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r7 == 0) goto L_0x00e7
            java.lang.Object r7 = r5.next()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.Object r8 = r7.getKey()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r8)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.Object r7 = r7.getValue()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeByte(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x00c5
        L_0x00e7:
            java.lang.String r5 = r13.f14345i     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r5 = r13.f14346j     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r5 = r13.f14347k     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeByte(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r5 = r13.f14348l     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeByte(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r5 = r13.f14349m     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            android.location.Location r5 = r13.f14350n     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r7 = -1
            if (r5 != 0) goto L_0x010d
            goto L_0x0193
        L_0x010d:
            int r5 = com.flurry.sdk.C7547kb.m16714b()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeBoolean(r2)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            android.location.Location r8 = r13.f14350n     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            double r9 = r8.getLatitude()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            double r9 = com.flurry.sdk.C7354Ad.m16256a(r9, r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeDouble(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            double r9 = r8.getLongitude()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            double r9 = com.flurry.sdk.C7354Ad.m16256a(r9, r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeDouble(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            float r9 = r8.getAccuracy()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeFloat(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            long r9 = r8.getTime()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeLong(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            double r9 = r8.getAltitude()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeDouble(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r10 = 26
            if (r9 < r10) goto L_0x0153
            float r9 = r8.getVerticalAccuracyMeters()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeFloat(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x0157
        L_0x0153:
            r9 = 0
            r4.writeFloat(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x0157:
            float r9 = r8.getBearing()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeFloat(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            float r9 = r8.getSpeed()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeFloat(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r9 = android.os.Build.VERSION.SDK_INT     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r9 < r10) goto L_0x018c
            boolean r9 = r8.hasBearingAccuracy()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r9 == 0) goto L_0x0177
            boolean r9 = r8.hasSpeedAccuracy()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r9 == 0) goto L_0x0177
            r9 = 1
            goto L_0x0178
        L_0x0177:
            r9 = 0
        L_0x0178:
            r4.writeBoolean(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r9 == 0) goto L_0x018b
            float r9 = r8.getBearingAccuracyDegrees()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeFloat(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            float r8 = r8.getSpeedAccuracyMetersPerSecond()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeFloat(r8)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x018b:
            goto L_0x018f
        L_0x018c:
            r4.writeBoolean(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x018f:
            if (r5 == r7) goto L_0x0193
            r5 = 1
            goto L_0x0194
        L_0x0193:
            r5 = 0
        L_0x0194:
            r4.writeBoolean(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r5 = r13.f14351o     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeInt(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r5 = r13.f14360x     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeByte(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeByte(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeByte(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            byte r5 = r13.f14352p     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeByte(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.Long r5 = r13.f14353q     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r5 != 0) goto L_0x01b8
            r4.writeBoolean(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x01c5
        L_0x01b8:
            r4.writeBoolean(r2)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.Long r5 = r13.f14353q     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            long r7 = r5.longValue()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeLong(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x01c5:
            java.util.Map<java.lang.String, com.flurry.sdk.qa> r5 = r13.f14356t     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r5 != 0) goto L_0x01cf
            r4.writeShort(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x01ff
        L_0x01cf:
            int r7 = r5.size()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeShort(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.Set r5 = r5.entrySet()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x01de:
            boolean r7 = r5.hasNext()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r7 == 0) goto L_0x01ff
            java.lang.Object r7 = r5.next()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.Object r8 = r7.getKey()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeUTF(r8)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.Object r7 = r7.getValue()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            com.flurry.sdk.qa r7 = (com.flurry.sdk.C7582qa) r7     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r7 = r7.f15029a     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeInt(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x01de
        L_0x01ff:
            java.util.List<com.flurry.sdk.ra> r5 = r13.f14357u     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r5 != 0) goto L_0x0209
            r4.writeShort(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x0228
        L_0x0209:
            int r7 = r5.size()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeShort(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x0214:
            boolean r7 = r5.hasNext()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r7 == 0) goto L_0x0228
            java.lang.Object r7 = r5.next()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            com.flurry.sdk.ra r7 = (com.flurry.sdk.C7587ra) r7     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            byte[] r7 = r7.mo24013b()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.write(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x0214
        L_0x0228:
            boolean r5 = r13.f14359w     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeBoolean(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.List<com.flurry.sdk.pa> r5 = r13.f14362z     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r5 == 0) goto L_0x0269
            java.util.Iterator r7 = r5.iterator()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r8 = 0
            r9 = 0
        L_0x023c:
            boolean r10 = r7.hasNext()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r10 == 0) goto L_0x026a
            java.lang.Object r10 = r7.next()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            com.flurry.sdk.pa r10 = (com.flurry.sdk.C7575pa) r10     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            boolean r11 = r10.mo23986b()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r11 == 0) goto L_0x0251
            int r9 = r9 + 1
            goto L_0x023c
        L_0x0251:
            byte[] r10 = r10.mo23985a()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r10 = r10.length     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r8 = r8 + r10
            r10 = 160000(0x27100, float:2.24208E-40)
            if (r8 <= r10) goto L_0x0266
            r7 = 5
            java.lang.String r8 = f15145a     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r10 = "Error Log size exceeded. No more event details logged."
            com.flurry.sdk.C7513ec.m16639a(r7, r8, r10)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x026a
        L_0x0266:
            int r9 = r9 + 1
            goto L_0x023c
        L_0x0269:
            r9 = 0
        L_0x026a:
            int r7 = r13.f14361y     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeInt(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeShort(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r7 = 0
        L_0x0274:
            if (r7 >= r9) goto L_0x0286
            java.lang.Object r8 = r5.get(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            com.flurry.sdk.pa r8 = (com.flurry.sdk.C7575pa) r8     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            byte[] r8 = r8.mo23985a()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.write(r8)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r7 = r7 + 1
            goto L_0x0274
        L_0x0286:
            r4.writeInt(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeShort(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeShort(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeShort(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.List<java.lang.String> r5 = r13.f14358v     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r7 = r5.size()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeShort(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x02a1:
            boolean r7 = r5.hasNext()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r8 = 2
            if (r7 == 0) goto L_0x02ca
            java.lang.Object r7 = r5.next()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            byte[] r9 = new byte[r6]     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r10 = "UTF8"
            byte[] r9 = r7.getBytes(r10)     // Catch:{ UnsupportedEncodingException -> 0x02b7 }
            goto L_0x02bf
        L_0x02b7:
            r7 = move-exception
            java.lang.String r7 = f15145a     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r10 = "Error encoding purchase receipt."
            com.flurry.sdk.C7513ec.m16639a(r1, r7, r10)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x02bf:
            r4.writeByte(r8)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r7 = r9.length     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeInt(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.write(r9)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x02a1
        L_0x02ca:
            java.lang.String r13 = r13.f14336A     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            boolean r5 = android.text.TextUtils.isEmpty(r13)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            if (r5 == 0) goto L_0x02d8
            r4.writeShort(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            goto L_0x0315
        L_0x02d8:
            java.lang.String r5 = ","
            java.lang.String[] r13 = r13.split(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r5 = r13.length     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r5 = r5 % r8
            if (r5 != r2) goto L_0x030b
            r5 = r13[r6]     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            short r5 = java.lang.Short.parseShort(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeShort(r5)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r5 = r13.length     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r5 = r5 - r2
            r6 = 1
        L_0x02ee:
            if (r6 >= r5) goto L_0x030a
            r4.writeShort(r2)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r7 = r13[r6]     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            long r7 = java.lang.Long.parseLong(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeLong(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r6 = r6 + 1
            r7 = r13[r6]     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r7 = java.lang.Integer.parseInt(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeInt(r7)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            int r6 = r6 + 1
            goto L_0x02ee
        L_0x030a:
            goto L_0x0315
        L_0x030b:
            java.lang.String r13 = f15145a     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            java.lang.String r2 = "Error variant IDs."
            com.flurry.sdk.C7513ec.m16639a(r1, r13, r2)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r4.writeShort(r6)     // Catch:{ IOException -> 0x0321, all -> 0x031f }
        L_0x0315:
            byte[] r13 = r3.toByteArray()     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            r12.f15146b = r13     // Catch:{ IOException -> 0x0321, all -> 0x031f }
            com.flurry.sdk.C7354Ad.m16261a(r4)
            return
        L_0x031f:
            r13 = move-exception
            goto L_0x032e
        L_0x0321:
            r13 = move-exception
            r2 = r4
            goto L_0x0328
        L_0x0324:
            r13 = move-exception
            r4 = r2
            goto L_0x032e
        L_0x0327:
            r13 = move-exception
        L_0x0328:
            java.lang.String r3 = f15145a     // Catch:{ all -> 0x0324 }
            com.flurry.sdk.C7513ec.m16640a(r1, r3, r0, r13)     // Catch:{ all -> 0x0324 }
            throw r13     // Catch:{ all -> 0x0324 }
        L_0x032e:
            com.flurry.sdk.C7354Ad.m16261a(r4)
            goto L_0x0333
        L_0x0332:
            throw r13
        L_0x0333:
            goto L_0x0332
        */
        throw new UnsupportedOperationException("Method not decompiled: com.flurry.sdk.C7631za.<init>(com.flurry.sdk.Aa):void");
    }
}
