package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzard
public final class zzbge extends zzbft {

    /* renamed from: d */
    private static final Set<String> f25294d = Collections.synchronizedSet(new HashSet());

    /* renamed from: e */
    private static final DecimalFormat f25295e = new DecimalFormat("#,###");

    /* renamed from: f */
    private File f25296f;

    /* renamed from: g */
    private boolean f25297g;

    public zzbge(zzbdf zzbdf) {
        super(zzbdf);
        File cacheDir = this.f25277a.getCacheDir();
        if (cacheDir == null) {
            zzbad.m26359d("Context.getCacheDir() returned null");
            return;
        }
        this.f25296f = new File(cacheDir, "admobVideoStreams");
        if (!this.f25296f.isDirectory() && !this.f25296f.mkdirs()) {
            String str = "Could not create preload cache directory at ";
            String valueOf = String.valueOf(this.f25296f.getAbsolutePath());
            zzbad.m26359d(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
            this.f25296f = null;
        } else if (!this.f25296f.setReadable(true, false) || !this.f25296f.setExecutable(true, false)) {
            String str2 = "Could not set cache file permissions at ";
            String valueOf2 = String.valueOf(this.f25296f.getAbsolutePath());
            zzbad.m26359d(valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
            this.f25296f = null;
        }
    }

    /* JADX WARNING: type inference failed for: r14v0, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v7, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: type inference failed for: r1v16 */
    /* JADX WARNING: type inference failed for: r1v23 */
    /* JADX WARNING: type inference failed for: r1v24 */
    /* JADX WARNING: type inference failed for: r1v25 */
    /* JADX WARNING: type inference failed for: r10v5 */
    /* JADX WARNING: type inference failed for: r1v28 */
    /* JADX WARNING: type inference failed for: r10v6 */
    /* JADX WARNING: type inference failed for: r24v0 */
    /* JADX WARNING: type inference failed for: r1v30 */
    /* JADX WARNING: type inference failed for: r1v31 */
    /* JADX WARNING: type inference failed for: r1v35, types: [java.lang.Object] */
    /* JADX WARNING: type inference failed for: r1v42 */
    /* JADX WARNING: type inference failed for: r24v1 */
    /* JADX WARNING: type inference failed for: r1v43 */
    /* JADX WARNING: type inference failed for: r24v2 */
    /* JADX WARNING: type inference failed for: r24v3 */
    /* JADX WARNING: type inference failed for: r24v4 */
    /* JADX WARNING: type inference failed for: r1v44 */
    /* JADX WARNING: type inference failed for: r1v45 */
    /* JADX WARNING: type inference failed for: r1v49 */
    /* JADX WARNING: type inference failed for: r1v52 */
    /* JADX WARNING: type inference failed for: r24v5, types: [int] */
    /* JADX WARNING: type inference failed for: r24v6 */
    /* JADX WARNING: type inference failed for: r1v57 */
    /* JADX WARNING: type inference failed for: r24v7 */
    /* JADX WARNING: type inference failed for: r24v8 */
    /* JADX WARNING: type inference failed for: r24v9 */
    /* JADX WARNING: type inference failed for: r10v10 */
    /* JADX WARNING: type inference failed for: r24v10 */
    /* JADX WARNING: type inference failed for: r1v64 */
    /* JADX WARNING: type inference failed for: r24v11 */
    /* JADX WARNING: type inference failed for: r24v12 */
    /* JADX WARNING: type inference failed for: r1v73 */
    /* JADX WARNING: type inference failed for: r1v76 */
    /* JADX WARNING: type inference failed for: r2v74, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r14v2 */
    /* JADX WARNING: type inference failed for: r1v83, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r14v3 */
    /* JADX WARNING: type inference failed for: r1v93 */
    /* JADX WARNING: type inference failed for: r1v94 */
    /* JADX WARNING: type inference failed for: r1v95 */
    /* JADX WARNING: type inference failed for: r10v12 */
    /* JADX WARNING: type inference failed for: r24v13 */
    /* JADX WARNING: type inference failed for: r24v14 */
    /* JADX WARNING: type inference failed for: r24v15 */
    /* JADX WARNING: type inference failed for: r24v16 */
    /* JADX WARNING: type inference failed for: r24v17 */
    /* JADX WARNING: type inference failed for: r24v18 */
    /* JADX WARNING: type inference failed for: r24v19 */
    /* JADX WARNING: type inference failed for: r24v20 */
    /* JADX WARNING: type inference failed for: r24v21 */
    /* JADX WARNING: type inference failed for: r24v22 */
    /* JADX WARNING: type inference failed for: r1v96 */
    /* JADX WARNING: type inference failed for: r1v97 */
    /* JADX WARNING: type inference failed for: r1v98 */
    /* JADX WARNING: type inference failed for: r24v23 */
    /* JADX WARNING: type inference failed for: r24v24 */
    /* JADX WARNING: type inference failed for: r24v25 */
    /* JADX WARNING: type inference failed for: r1v99 */
    /* JADX WARNING: type inference failed for: r24v26 */
    /* JADX WARNING: type inference failed for: r24v27 */
    /* JADX WARNING: type inference failed for: r24v28 */
    /* JADX WARNING: type inference failed for: r24v29 */
    /* JADX WARNING: type inference failed for: r24v30 */
    /* JADX WARNING: type inference failed for: r24v31 */
    /* JADX WARNING: type inference failed for: r24v32 */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x0200, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:?, code lost:
        r1 = r5.getResponseCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0208, code lost:
        if (r1 < 400) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x020a, code lost:
        r15 = "badUrl";
        r0 = "HTTP request failed. Code: ";
        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x021a, code lost:
        if (r2.length() == 0) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x021c, code lost:
        r2 = r0.concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0222, code lost:
        r2 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);
        r4.append("HTTP status code ");
        r4.append(r1);
        r4.append(" at ");
        r4.append(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x024f, code lost:
        throw new java.io.IOException(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0250, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0253, code lost:
        r3 = r2;
        r1 = r14;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:?, code lost:
        r7 = r5.getContentLength();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x025c, code lost:
        if (r7 >= 0) goto L_0x0287;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x025e, code lost:
        r0 = "Stream cache aborted, missing content-length header at ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        r1 = java.lang.String.valueOf(r31);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0268, code lost:
        if (r1.length() == 0) goto L_0x026f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x026a, code lost:
        r0 = r0.concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x026f, code lost:
        r0 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0275, code lost:
        com.google.android.gms.internal.ads.zzbad.m26359d(r0);
        mo30545a(r9, r12.getAbsolutePath(), "contentLengthMissing", null);
        f25294d.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0286, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        r1 = f25295e.format((long) r7);
        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzyt.m31536e().mo29599a(com.google.android.gms.internal.ads.zzacu.f23908C)).intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x029e, code lost:
        if (r7 <= r3) goto L_0x02f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:?, code lost:
        r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());
        r2.append("Content length ");
        r2.append(r1);
        r2.append(" exceeds limit at ");
        r2.append(r9);
        com.google.android.gms.internal.ads.zzbad.m26359d(r2.toString());
        r0 = "File too big for full file cache. Size: ";
        r1 = java.lang.String.valueOf(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x02d9, code lost:
        if (r1.length() == 0) goto L_0x02e0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x02db, code lost:
        r0 = r0.concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x02e0, code lost:
        r0 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x02e6, code lost:
        mo30545a(r9, r12.getAbsolutePath(), "sizeExceeded", r0);
        f25294d.remove(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x02f4, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:?, code lost:
        r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());
        r4.append("Caching ");
        r4.append(r1);
        r4.append(" bytes from ");
        r4.append(r9);
        com.google.android.gms.internal.ads.zzbad.m26352a(r4.toString());
        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());
        r4 = new java.io.FileOutputStream(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:?, code lost:
        r2 = r4.getChannel();
        r1 = java.nio.ByteBuffer.allocate(p005cm.aptoide.p006pt.file.CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES);
        r16 = com.google.android.gms.ads.internal.zzk.zzln();
        r17 = r16.mo27935b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x034f, code lost:
        r10 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:?, code lost:
        r6 = new com.google.android.gms.internal.ads.zzazj(((java.lang.Long) com.google.android.gms.internal.ads.zzyt.m31536e().mo29599a(com.google.android.gms.internal.ads.zzacu.f23926F)).longValue());
        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzyt.m31536e().mo29599a(com.google.android.gms.internal.ads.zzacu.f23920E)).longValue();
        r10 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x0369, code lost:
        r20 = r5.read(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x036d, code lost:
        if (r20 < 0) goto L_0x04a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x036f, code lost:
        r11 = r11 + r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0371, code lost:
        if (r11 <= r3) goto L_0x03a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0373, code lost:
        r15 = "sizeExceeded";
        r0 = "File too big for full file cache. Size: ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:?, code lost:
        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0383, code lost:
        if (r1.length() == 0) goto L_0x038b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0385, code lost:
        r1 = r0.concat(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x038b, code lost:
        r1 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0397, code lost:
        throw new java.io.IOException("stream cache file size limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0398, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x039b, code lost:
        r2 = r0;
        r3 = r1;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x039f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x03a2, code lost:
        r2 = r0;
        r1 = r10;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x03a5, code lost:
        r10 = r4;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:?, code lost:
        r1.flip();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x03af, code lost:
        if (r2.write(r1) > 0) goto L_0x0481;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x03b1, code lost:
        r1.clear();
        r24 = ((r16.mo27935b() - r17) > (1000 * r13) ? 1 : ((r16.mo27935b() - r17) == (1000 * r13) ? 0 : -1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x03c0, code lost:
        if (r24 > 0) goto L_0x043c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03c2, code lost:
        r20 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x03c6, code lost:
        if (r8.f25297g != false) goto L_0x042c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x03cc, code lost:
        if (r6.mo30301a() == false) goto L_0x0406;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x03d4, code lost:
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x03d6, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x03d8, code lost:
        r24 = r10;
        r10 = com.google.android.gms.internal.ads.zzazt.f25042a;
        r1 = r1;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x03f6, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:?, code lost:
        r1 = new com.google.android.gms.internal.ads.C9790we(r30, r31, r12.getAbsolutePath(), r11, r7, false);
        r10.post(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x03fd, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x03ff, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0400, code lost:
        r27 = r4;
        r2 = r0;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0406, code lost:
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0418, code lost:
        r6 = r19;
        r1 = r20;
        r5 = r21;
        r15 = r22;
        r10 = r24;
        r2 = r25;
        r3 = r26;
        r4 = r27;
        r7 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x042c, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
        r15 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x043b, code lost:
        throw new java.io.IOException("abort requested");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x043c, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
        r15 = "downloadTimeout";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0444, code lost:
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:?, code lost:
        r0 = java.lang.Long.toString(r13);
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);
        r2.append("Timeout exceeded. Limit: ");
        r2.append(r0);
        r2.append(" sec");
        r10 = r2.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x046f, code lost:
        throw new java.io.IOException("stream cache time limit exceeded");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x0470, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x0473, code lost:
        r2 = r0;
        r3 = r10;
        r1 = r24;
        r10 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x047b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x047e, code lost:
        r2 = r0;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0481, code lost:
        r20 = r1;
        r25 = r2;
        r26 = r3;
        r27 = r4;
        r21 = r5;
        r19 = r6;
        r29 = r7;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0497, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x049a, code lost:
        r27 = r4;
        r22 = r15;
        r2 = r0;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x04a2, code lost:
        r27 = r4;
        r24 = r10;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:?, code lost:
        r27.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x04b1, code lost:
        if (com.google.android.gms.internal.ads.zzbad.m26354a(3) == false) goto L_0x04f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x04b3, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:?, code lost:
        r1 = f25295e.format((long) r11);
        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());
        r3.append("Preloaded ");
        r3.append(r1);
        r3.append(" bytes from ");
        r3.append(r9);
        com.google.android.gms.internal.ads.zzbad.m26352a(r3.toString());
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x04ea, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x04ec, code lost:
        r0 = e;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:?, code lost:
        r12.setReadable(true, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x04fd, code lost:
        if (r0.isFile() == false) goto L_0x0507;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x04ff, code lost:
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:?, code lost:
        r0.setLastModified(java.lang.System.currentTimeMillis());
        r24 = r24;
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0507, code lost:
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:?, code lost:
        r0.createNewFile();
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0520, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x0523, code lost:
        r1 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x0529, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x052c, code lost:
        r27 = r4;
        r1 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x0530, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x0533, code lost:
        r27 = r4;
        r1 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x0536, code lost:
        r22 = r15;
        r2 = r0;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x053d, code lost:
        r1 = r14;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x0547, code lost:
        throw new java.io.IOException("Invalid protocol.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0548, code lost:
        r1 = r14;
        r22 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0552, code lost:
        throw new java.io.IOException("Too many redirects (20)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0553, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0556, code lost:
        r2 = r0;
        r15 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x055a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x055d, code lost:
        r1 = r14;
        r22 = r15;
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0561, code lost:
        r3 = null;
        r10 = null;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0567, code lost:
        com.google.android.gms.ads.internal.zzk.zzlk().mo30168a(r2, "VideoStreamFullFileCache.preload");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:256:0x057b, code lost:
        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 26);
        r2.append("Preload aborted for URL \"");
        r2.append(r9);
        r2.append("\"");
        com.google.android.gms.internal.ads.zzbad.m26357c(r2.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x059f, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 25);
        r4.append("Preload failed for URL \"");
        r4.append(r9);
        r4.append("\"");
        com.google.android.gms.internal.ads.zzbad.m26358c(r4.toString(), r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:0x05de, code lost:
        r0 = r0.concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x05e3, code lost:
        r0 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:298:0x0418, code lost:
        r24 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0139, code lost:
        r15 = "error";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:?, code lost:
        com.google.android.gms.ads.internal.zzk.zzls();
        r1 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzyt.m31536e().mo29599a(com.google.android.gms.internal.ads.zzacu.f23932G)).intValue();
        r3 = new java.net.URL(r9);
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0158, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x015b, code lost:
        if (r2 > 20) goto L_0x0548;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x015d, code lost:
        r5 = r3.openConnection();
        r5.setConnectTimeout(r1);
        r5.setReadTimeout(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0169, code lost:
        if ((r5 instanceof java.net.HttpURLConnection) == false) goto L_0x053d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x016b, code lost:
        r5 = (java.net.HttpURLConnection) r5;
        r6 = new com.google.android.gms.internal.ads.zzazx();
        r6.mo30319a(r5, (byte[]) null);
        r5.setInstanceFollowRedirects(false);
        r7 = r5.getResponseCode();
        r6.mo30318a(r5, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x0182, code lost:
        if ((r7 / 100) != 3) goto L_0x01fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r4 = r5.getHeaderField("Location");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x018a, code lost:
        if (r4 == null) goto L_0x01ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x018c, code lost:
        r6 = new java.net.URL(r3, r4);
        r3 = r6.getProtocol();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0195, code lost:
        if (r3 == null) goto L_0x01e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x019d, code lost:
        if (r3.equals(com.mopub.common.Constants.HTTP) != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a5, code lost:
        if (r3.equals("https") != false) goto L_0x01c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01a7, code lost:
        r1 = "Unsupported scheme: ";
        r2 = java.lang.String.valueOf(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01b3, code lost:
        if (r2.length() == 0) goto L_0x01ba;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01b5, code lost:
        r1 = r1.concat(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ba, code lost:
        r1 = new java.lang.String(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01c3, code lost:
        throw new java.io.IOException(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01c4, code lost:
        r3 = "Redirecting to ";
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x01ce, code lost:
        if (r4.length() == 0) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01d0, code lost:
        r3 = r3.concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01d5, code lost:
        r3 = new java.lang.String(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x01db, code lost:
        com.google.android.gms.internal.ads.zzbad.m26352a(r3);
        r5.disconnect();
        r3 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01eb, code lost:
        throw new java.io.IOException("Protocol is null");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01f3, code lost:
        throw new java.io.IOException("Missing Location header in redirect");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01f4, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01f7, code lost:
        r2 = r0;
        r3 = null;
        r1 = r14;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r1v9
      assigns: []
      uses: []
      mth insns count: 600
    	at jadx.core.dex.visitors.typeinference.TypeSearch.fillTypeCandidates(TypeSearch.java:237)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:53)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:99)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:92)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:27)
    	at jadx.core.dex.visitors.DepthTraversal.lambda$visit$1(DepthTraversal.java:14)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
    	at jadx.core.ProcessClass.process(ProcessClass.java:30)
    	at jadx.core.ProcessClass.lambda$processDependencies$0(ProcessClass.java:49)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1540)
    	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:49)
    	at jadx.core.ProcessClass.process(ProcessClass.java:35)
    	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:311)
    	at jadx.api.JavaClass.decompile(JavaClass.java:62)
    	at jadx.api.JadxDecompiler.lambda$appendSourcesSave$0(JadxDecompiler.java:217)
     */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x04ea A[ExcHandler: RuntimeException (e java.lang.RuntimeException), PHI: r22 r24 r27 
      PHI: (r22v8 java.lang.String) = (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v4 java.lang.String), (r22v16 java.lang.String), (r22v16 java.lang.String) binds: [B:216:0x0507, B:217:?, B:214:0x04ff, B:215:?, B:204:0x04b3, B:205:?, B:172:0x03d6, B:175:0x03f6] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r24v4 ?) = (r24v13 ?), (r24v14 ?), (r24v16 ?), (r24v18 ?), (r24v20 ?), (r24v22 ?), (r24v27 ?), (r24v31 ?) binds: [B:216:0x0507, B:217:?, B:214:0x04ff, B:215:?, B:204:0x04b3, B:205:?, B:172:0x03d6, B:175:0x03f6] A[DONT_GENERATE, DONT_INLINE]
      PHI: (r27v10 java.io.FileOutputStream) = (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v5 java.io.FileOutputStream), (r27v12 java.io.FileOutputStream), (r27v19 java.io.FileOutputStream) binds: [B:216:0x0507, B:217:?, B:214:0x04ff, B:215:?, B:204:0x04b3, B:205:?, B:172:0x03d6, B:175:0x03f6] A[DONT_GENERATE, DONT_INLINE], Splitter:B:175:0x03f6] */
    /* JADX WARNING: Removed duplicated region for block: B:250:0x0567  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x057b  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x059f  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x05de  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x05e3  */
    /* JADX WARNING: Unknown variable types count: 26 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean mo30546a(java.lang.String r31) {
        /*
            r30 = this;
            r8 = r30
            r9 = r31
            java.io.File r0 = r8.f25296f
            r10 = 0
            r11 = 0
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "noCacheDir"
            r8.mo30545a(r9, r10, r0, r10)
            return r11
        L_0x0010:
            java.io.File r0 = r8.f25296f
            if (r0 != 0) goto L_0x0017
            r3 = 0
            goto L_0x0035
        L_0x0017:
            java.io.File[] r0 = r0.listFiles()
            int r1 = r0.length
            r2 = 0
            r3 = 0
        L_0x001f:
            if (r2 >= r1) goto L_0x0034
            r4 = r0[r2]
            java.lang.String r4 = r4.getName()
            java.lang.String r5 = ".done"
            boolean r4 = r4.endsWith(r5)
            if (r4 != 0) goto L_0x0031
            int r3 = r3 + 1
        L_0x0031:
            int r2 = r2 + 1
            goto L_0x001f
        L_0x0034:
        L_0x0035:
            com.google.android.gms.internal.ads.zzacj<java.lang.Integer> r0 = com.google.android.gms.internal.ads.zzacu.f23902B
            com.google.android.gms.internal.ads.zzacr r1 = com.google.android.gms.internal.ads.zzyt.m31536e()
            java.lang.Object r0 = r1.mo29599a(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            if (r3 <= r0) goto L_0x00a0
            java.io.File r0 = r8.f25296f
            if (r0 != 0) goto L_0x004e
            r0 = 0
            goto L_0x0093
        L_0x004e:
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            java.io.File[] r0 = r0.listFiles()
            int r3 = r0.length
            r4 = r1
            r2 = r10
            r1 = 0
        L_0x005c:
            if (r1 >= r3) goto L_0x007a
            r6 = r0[r1]
            java.lang.String r7 = r6.getName()
            java.lang.String r12 = ".done"
            boolean r7 = r7.endsWith(r12)
            if (r7 != 0) goto L_0x0077
            long r12 = r6.lastModified()
            int r7 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r7 >= 0) goto L_0x0077
            r2 = r6
            r4 = r12
        L_0x0077:
            int r1 = r1 + 1
            goto L_0x005c
        L_0x007a:
            if (r2 == 0) goto L_0x0091
            boolean r0 = r2.delete()
            java.io.File r1 = r8.m26736a(r2)
            boolean r2 = r1.isFile()
            if (r2 == 0) goto L_0x0092
            boolean r1 = r1.delete()
            r0 = r0 & r1
            goto L_0x0092
        L_0x0091:
            r0 = 0
        L_0x0092:
        L_0x0093:
            if (r0 != 0) goto L_0x0010
            java.lang.String r0 = "Unable to expire stream cache"
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)
            java.lang.String r0 = "expireFailed"
            r8.mo30545a(r9, r10, r0, r10)
            return r11
        L_0x00a0:
            java.lang.String r0 = r30.mo30548b(r31)
            java.io.File r12 = new java.io.File
            java.io.File r1 = r8.f25296f
            r12.<init>(r1, r0)
            java.io.File r0 = r8.m26736a(r12)
            boolean r1 = r12.isFile()
            r13 = 1
            if (r1 == 0) goto L_0x00e3
            boolean r1 = r0.isFile()
            if (r1 == 0) goto L_0x00e3
            long r0 = r12.length()
            int r1 = (int) r0
            java.lang.String r0 = "Stream cache hit at "
            java.lang.String r2 = java.lang.String.valueOf(r31)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00d2
            java.lang.String r0 = r0.concat(r2)
            goto L_0x00d8
        L_0x00d2:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r0)
            r0 = r2
        L_0x00d8:
            com.google.android.gms.internal.ads.zzbad.m26352a(r0)
            java.lang.String r0 = r12.getAbsolutePath()
            r8.mo30539a(r9, r0, r1)
            return r13
        L_0x00e3:
            java.io.File r1 = r8.f25296f
            java.lang.String r1 = r1.getAbsolutePath()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r31)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x00fd
            java.lang.String r1 = r1.concat(r2)
            r14 = r1
            goto L_0x0103
        L_0x00fd:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r1)
            r14 = r2
        L_0x0103:
            java.util.Set<java.lang.String> r1 = f25294d
            monitor-enter(r1)
            java.util.Set<java.lang.String> r2 = f25294d     // Catch:{ all -> 0x05fa }
            boolean r2 = r2.contains(r14)     // Catch:{ all -> 0x05fa }
            if (r2 == 0) goto L_0x0133
            java.lang.String r0 = "Stream cache already in progress at "
            java.lang.String r2 = java.lang.String.valueOf(r31)     // Catch:{ all -> 0x05fa }
            int r3 = r2.length()     // Catch:{ all -> 0x05fa }
            if (r3 == 0) goto L_0x011f
            java.lang.String r0 = r0.concat(r2)     // Catch:{ all -> 0x05fa }
            goto L_0x0125
        L_0x011f:
            java.lang.String r2 = new java.lang.String     // Catch:{ all -> 0x05fa }
            r2.<init>(r0)     // Catch:{ all -> 0x05fa }
            r0 = r2
        L_0x0125:
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)     // Catch:{ all -> 0x05fa }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ all -> 0x05fa }
            java.lang.String r2 = "inProgress"
            r8.mo30545a(r9, r0, r2, r10)     // Catch:{ all -> 0x05fa }
            monitor-exit(r1)     // Catch:{ all -> 0x05fa }
            return r11
        L_0x0133:
            java.util.Set<java.lang.String> r2 = f25294d     // Catch:{ all -> 0x05fa }
            r2.add(r14)     // Catch:{ all -> 0x05fa }
            monitor-exit(r1)     // Catch:{ all -> 0x05fa }
            java.lang.String r15 = "error"
            com.google.android.gms.ads.internal.zzk.zzls()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            com.google.android.gms.internal.ads.zzacj<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzacu.f23932G     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            com.google.android.gms.internal.ads.zzacr r2 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.lang.Object r1 = r2.mo29599a(r1)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r2.<init>(r9)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r3 = r2
            r2 = 0
        L_0x0158:
            int r2 = r2 + r13
            r4 = 20
            if (r2 > r4) goto L_0x0548
            java.net.URLConnection r5 = r3.openConnection()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r5.setConnectTimeout(r1)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r5.setReadTimeout(r1)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            boolean r6 = r5 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            if (r6 == 0) goto L_0x053d
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            com.google.android.gms.internal.ads.zzazx r6 = new com.google.android.gms.internal.ads.zzazx     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r6.<init>()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r6.mo30319a(r5, r10)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r5.setInstanceFollowRedirects(r11)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            int r7 = r5.getResponseCode()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r6.mo30318a(r5, r7)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            int r7 = r7 / 100
            r6 = 3
            if (r7 != r6) goto L_0x01fc
            java.lang.String r4 = "Location"
            java.lang.String r4 = r5.getHeaderField(r4)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            if (r4 == 0) goto L_0x01ec
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r6.<init>(r3, r4)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r3 = r6.getProtocol()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            if (r3 == 0) goto L_0x01e4
            java.lang.String r7 = "http"
            boolean r7 = r3.equals(r7)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            if (r7 != 0) goto L_0x01c4
            java.lang.String r7 = "https"
            boolean r7 = r3.equals(r7)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            if (r7 != 0) goto L_0x01c4
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r1 = "Unsupported scheme: "
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            if (r3 == 0) goto L_0x01ba
            java.lang.String r1 = r1.concat(r2)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            goto L_0x01c0
        L_0x01ba:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r2.<init>(r1)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r1 = r2
        L_0x01c0:
            r0.<init>(r1)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            throw r0     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
        L_0x01c4:
            java.lang.String r3 = "Redirecting to "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            int r7 = r4.length()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            if (r7 == 0) goto L_0x01d5
            java.lang.String r3 = r3.concat(r4)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            goto L_0x01db
        L_0x01d5:
            java.lang.String r4 = new java.lang.String     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r3 = r4
        L_0x01db:
            com.google.android.gms.internal.ads.zzbad.m26352a(r3)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r5.disconnect()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r3 = r6
            goto L_0x0158
        L_0x01e4:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r1 = "Protocol is null"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            throw r0     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
        L_0x01ec:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r1 = "Missing Location header in redirect"
            r0.<init>(r1)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            throw r0     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
        L_0x01f4:
            r0 = move-exception
            goto L_0x01f7
        L_0x01f6:
            r0 = move-exception
        L_0x01f7:
            r2 = r0
            r3 = r10
            r1 = r14
            goto L_0x0563
        L_0x01fc:
            boolean r1 = r5 instanceof java.net.HttpURLConnection     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            if (r1 == 0) goto L_0x0258
            int r1 = r5.getResponseCode()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r2 = 400(0x190, float:5.6E-43)
            if (r1 < r2) goto L_0x0258
            java.lang.String r15 = "badUrl"
            java.lang.String r0 = "HTTP request failed. Code: "
            java.lang.String r2 = java.lang.Integer.toString(r1)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            int r3 = r2.length()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            if (r3 == 0) goto L_0x0222
            java.lang.String r0 = r0.concat(r2)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r2 = r0
            goto L_0x0227
        L_0x0222:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
        L_0x0227:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
            java.lang.String r3 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
            int r3 = r3.length()     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
            int r3 = r3 + 32
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
            java.lang.String r3 = "HTTP status code "
            r4.append(r3)     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
            r4.append(r1)     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
            java.lang.String r1 = " at "
            r4.append(r1)     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
            r4.append(r9)     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
            throw r0     // Catch:{ IOException -> 0x0252, RuntimeException -> 0x0250 }
        L_0x0250:
            r0 = move-exception
            goto L_0x0253
        L_0x0252:
            r0 = move-exception
        L_0x0253:
            r3 = r2
            r1 = r14
            r2 = r0
            goto L_0x0563
        L_0x0258:
            int r7 = r5.getContentLength()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            if (r7 >= 0) goto L_0x0287
            java.lang.String r0 = "Stream cache aborted, missing content-length header at "
            java.lang.String r1 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            if (r2 == 0) goto L_0x026f
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            goto L_0x0275
        L_0x026f:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r0 = r1
        L_0x0275:
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r1 = "contentLengthMissing"
            r8.mo30545a(r9, r0, r1, r10)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.util.Set<java.lang.String> r0 = f25294d     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r0.remove(r14)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            return r11
        L_0x0287:
            java.text.DecimalFormat r1 = f25295e     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            long r2 = (long) r7     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            com.google.android.gms.internal.ads.zzacj<java.lang.Integer> r2 = com.google.android.gms.internal.ads.zzacu.f23908C     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            com.google.android.gms.internal.ads.zzacr r3 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.lang.Object r2 = r3.mo29599a(r2)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            int r3 = r2.intValue()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            if (r7 <= r3) goto L_0x02f5
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            int r0 = r0.length()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            int r0 = r0 + 33
            java.lang.String r2 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            int r2 = r2.length()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            int r0 = r0 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r0 = "Content length "
            r2.append(r0)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r2.append(r1)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r0 = " exceeds limit at "
            r2.append(r0)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r2.append(r9)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            int r2 = r1.length()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            if (r2 == 0) goto L_0x02e0
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            goto L_0x02e6
        L_0x02e0:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r0 = r1
        L_0x02e6:
            java.lang.String r1 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.lang.String r2 = "sizeExceeded"
            r8.mo30545a(r9, r1, r2, r0)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            java.util.Set<java.lang.String> r0 = f25294d     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            r0.remove(r14)     // Catch:{ IOException -> 0x01f6, RuntimeException -> 0x01f4 }
            return r11
        L_0x02f5:
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            int r2 = r2.length()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            int r2 = r2 + r4
            java.lang.String r4 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            int r4 = r4.length()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            int r2 = r2 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r4.<init>(r2)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.lang.String r2 = "Caching "
            r4.append(r2)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r4.append(r1)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.lang.String r1 = " bytes from "
            r4.append(r1)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r4.append(r9)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            com.google.android.gms.internal.ads.zzbad.m26352a(r1)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.io.InputStream r1 = r5.getInputStream()     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.nio.channels.ReadableByteChannel r5 = java.nio.channels.Channels.newChannel(r1)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            r4.<init>(r12)     // Catch:{ IOException -> 0x055c, RuntimeException -> 0x055a }
            java.nio.channels.FileChannel r2 = r4.getChannel()     // Catch:{ IOException -> 0x0532, RuntimeException -> 0x0530 }
            r1 = 1048576(0x100000, float:1.469368E-39)
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)     // Catch:{ IOException -> 0x0532, RuntimeException -> 0x0530 }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzk.zzln()     // Catch:{ IOException -> 0x0532, RuntimeException -> 0x0530 }
            long r17 = r16.mo27935b()     // Catch:{ IOException -> 0x0532, RuntimeException -> 0x0530 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzacu.f23926F     // Catch:{ IOException -> 0x0532, RuntimeException -> 0x0530 }
            com.google.android.gms.internal.ads.zzacr r10 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ IOException -> 0x0532, RuntimeException -> 0x0530 }
            java.lang.Object r6 = r10.mo29599a(r6)     // Catch:{ IOException -> 0x0532, RuntimeException -> 0x0530 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ IOException -> 0x0532, RuntimeException -> 0x0530 }
            r10 = r14
            long r13 = r6.longValue()     // Catch:{ IOException -> 0x052b, RuntimeException -> 0x0529 }
            com.google.android.gms.internal.ads.zzazj r6 = new com.google.android.gms.internal.ads.zzazj     // Catch:{ IOException -> 0x052b, RuntimeException -> 0x0529 }
            r6.<init>(r13)     // Catch:{ IOException -> 0x052b, RuntimeException -> 0x0529 }
            com.google.android.gms.internal.ads.zzacj<java.lang.Long> r13 = com.google.android.gms.internal.ads.zzacu.f23920E     // Catch:{ IOException -> 0x052b, RuntimeException -> 0x0529 }
            com.google.android.gms.internal.ads.zzacr r14 = com.google.android.gms.internal.ads.zzyt.m31536e()     // Catch:{ IOException -> 0x052b, RuntimeException -> 0x0529 }
            java.lang.Object r13 = r14.mo29599a(r13)     // Catch:{ IOException -> 0x052b, RuntimeException -> 0x0529 }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ IOException -> 0x052b, RuntimeException -> 0x0529 }
            long r13 = r13.longValue()     // Catch:{ IOException -> 0x052b, RuntimeException -> 0x0529 }
        L_0x0369:
            int r20 = r5.read(r1)     // Catch:{ IOException -> 0x052b, RuntimeException -> 0x0529 }
            if (r20 < 0) goto L_0x04a2
            int r11 = r11 + r20
            if (r11 <= r3) goto L_0x03a8
            java.lang.String r15 = "sizeExceeded"
            java.lang.String r0 = "File too big for full file cache. Size: "
            java.lang.String r1 = java.lang.Integer.toString(r11)     // Catch:{ IOException -> 0x03a1, RuntimeException -> 0x039f }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x03a1, RuntimeException -> 0x039f }
            int r2 = r1.length()     // Catch:{ IOException -> 0x03a1, RuntimeException -> 0x039f }
            if (r2 == 0) goto L_0x038b
            java.lang.String r0 = r0.concat(r1)     // Catch:{ IOException -> 0x03a1, RuntimeException -> 0x039f }
            r1 = r0
            goto L_0x0390
        L_0x038b:
            java.lang.String r1 = new java.lang.String     // Catch:{ IOException -> 0x03a1, RuntimeException -> 0x039f }
            r1.<init>(r0)     // Catch:{ IOException -> 0x03a1, RuntimeException -> 0x039f }
        L_0x0390:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x039a, RuntimeException -> 0x0398 }
            java.lang.String r2 = "stream cache file size limit exceeded"
            r0.<init>(r2)     // Catch:{ IOException -> 0x039a, RuntimeException -> 0x0398 }
            throw r0     // Catch:{ IOException -> 0x039a, RuntimeException -> 0x0398 }
        L_0x0398:
            r0 = move-exception
            goto L_0x039b
        L_0x039a:
            r0 = move-exception
        L_0x039b:
            r2 = r0
            r3 = r1
            r1 = r10
            goto L_0x03a5
        L_0x039f:
            r0 = move-exception
            goto L_0x03a2
        L_0x03a1:
            r0 = move-exception
        L_0x03a2:
            r2 = r0
            r1 = r10
            r3 = 0
        L_0x03a5:
            r10 = r4
            goto L_0x0563
        L_0x03a8:
            r1.flip()     // Catch:{ IOException -> 0x0499, RuntimeException -> 0x0497 }
        L_0x03ab:
            int r20 = r2.write(r1)     // Catch:{ IOException -> 0x0499, RuntimeException -> 0x0497 }
            if (r20 > 0) goto L_0x0481
            r1.clear()     // Catch:{ IOException -> 0x0499, RuntimeException -> 0x0497 }
            long r20 = r16.mo27935b()     // Catch:{ IOException -> 0x0499, RuntimeException -> 0x0497 }
            long r20 = r20 - r17
            r22 = 1000(0x3e8, double:4.94E-321)
            long r22 = r22 * r13
            int r24 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
            if (r24 > 0) goto L_0x043c
            r20 = r1
            boolean r1 = r8.f25297g     // Catch:{ IOException -> 0x0499, RuntimeException -> 0x0497 }
            if (r1 != 0) goto L_0x042c
            boolean r1 = r6.mo30301a()     // Catch:{ IOException -> 0x0499, RuntimeException -> 0x0497 }
            if (r1 == 0) goto L_0x0406
            java.lang.String r21 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x0499, RuntimeException -> 0x0497 }
            android.os.Handler r1 = com.google.android.gms.internal.ads.zzazt.f25042a     // Catch:{ IOException -> 0x0499, RuntimeException -> 0x0497 }
            r22 = r15
            com.google.android.gms.internal.ads.we r15 = new com.google.android.gms.internal.ads.we     // Catch:{ IOException -> 0x03ff, RuntimeException -> 0x03fd }
            r23 = 0
            r24 = r10
            r10 = r1
            r1 = r15
            r25 = r2
            r2 = r30
            r26 = r3
            r3 = r31
            r27 = r4
            r4 = r21
            r21 = r5
            r5 = r11
            r19 = r6
            r28 = 3
            r6 = r7
            r29 = r7
            r7 = r23
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            r10.post(r15)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            goto L_0x0418
        L_0x03fd:
            r0 = move-exception
            goto L_0x0400
        L_0x03ff:
            r0 = move-exception
        L_0x0400:
            r27 = r4
            r2 = r0
            r1 = r10
            goto L_0x0526
        L_0x0406:
            r25 = r2
            r26 = r3
            r27 = r4
            r21 = r5
            r19 = r6
            r29 = r7
            r24 = r10
            r22 = r15
            r28 = 3
        L_0x0418:
            r6 = r19
            r1 = r20
            r5 = r21
            r15 = r22
            r10 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r7 = r29
            goto L_0x0369
        L_0x042c:
            r27 = r4
            r24 = r10
            r22 = r15
            java.lang.String r15 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
            java.lang.String r1 = "abort requested"
            r0.<init>(r1)     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
            throw r0     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
        L_0x043c:
            r27 = r4
            r24 = r10
            r22 = r15
            java.lang.String r15 = "downloadTimeout"
            java.lang.String r0 = java.lang.Long.toString(r13)     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
            int r1 = r1.length()     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
            int r1 = r1 + 29
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
            r2.<init>(r1)     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
            java.lang.String r1 = "Timeout exceeded. Limit: "
            r2.append(r1)     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
            r2.append(r0)     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
            java.lang.String r0 = " sec"
            r2.append(r0)     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
            java.lang.String r10 = r2.toString()     // Catch:{ IOException -> 0x047d, RuntimeException -> 0x047b }
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0472, RuntimeException -> 0x0470 }
            java.lang.String r1 = "stream cache time limit exceeded"
            r0.<init>(r1)     // Catch:{ IOException -> 0x0472, RuntimeException -> 0x0470 }
            throw r0     // Catch:{ IOException -> 0x0472, RuntimeException -> 0x0470 }
        L_0x0470:
            r0 = move-exception
            goto L_0x0473
        L_0x0472:
            r0 = move-exception
        L_0x0473:
            r2 = r0
            r3 = r10
            r1 = r24
            r10 = r27
            goto L_0x0563
        L_0x047b:
            r0 = move-exception
            goto L_0x047e
        L_0x047d:
            r0 = move-exception
        L_0x047e:
            r2 = r0
            goto L_0x04f0
        L_0x0481:
            r20 = r1
            r25 = r2
            r26 = r3
            r27 = r4
            r21 = r5
            r19 = r6
            r29 = r7
            r24 = r10
            r22 = r15
            r28 = 3
            goto L_0x03ab
        L_0x0497:
            r0 = move-exception
            goto L_0x049a
        L_0x0499:
            r0 = move-exception
        L_0x049a:
            r27 = r4
            r22 = r15
            r2 = r0
            r1 = r10
            goto L_0x0539
        L_0x04a2:
            r27 = r4
            r24 = r10
            r22 = r15
            r28 = 3
            r27.close()     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
            boolean r1 = com.google.android.gms.internal.ads.zzbad.m26354a(r28)     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
            if (r1 == 0) goto L_0x04f3
            java.text.DecimalFormat r1 = f25295e     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            long r2 = (long) r11     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            java.lang.String r1 = r1.format(r2)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            java.lang.String r2 = java.lang.String.valueOf(r1)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            int r2 = r2.length()     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            int r2 = r2 + 22
            java.lang.String r3 = java.lang.String.valueOf(r31)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            int r3 = r3.length()     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            r3.<init>(r2)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            java.lang.String r2 = "Preloaded "
            r3.append(r2)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            r3.append(r1)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            java.lang.String r1 = " bytes from "
            r3.append(r1)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            r3.append(r9)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            java.lang.String r1 = r3.toString()     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            com.google.android.gms.internal.ads.zzbad.m26352a(r1)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            goto L_0x04f3
        L_0x04ea:
            r0 = move-exception
            goto L_0x04ed
        L_0x04ec:
            r0 = move-exception
        L_0x04ed:
            r2 = r0
            r15 = r22
        L_0x04f0:
            r1 = r24
            goto L_0x0539
        L_0x04f3:
            r1 = 1
            r2 = 0
            r12.setReadable(r1, r2)     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
            boolean r1 = r0.isFile()     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
            if (r1 == 0) goto L_0x0507
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            r0.setLastModified(r1)     // Catch:{ IOException -> 0x04ec, RuntimeException -> 0x04ea }
            goto L_0x050c
        L_0x0507:
            r0.createNewFile()     // Catch:{ IOException -> 0x050b, RuntimeException -> 0x04ea }
            goto L_0x050c
        L_0x050b:
            r0 = move-exception
        L_0x050c:
            java.lang.String r0 = r12.getAbsolutePath()     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
            r8.mo30539a(r9, r0, r11)     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
            java.util.Set<java.lang.String> r0 = f25294d     // Catch:{ IOException -> 0x0522, RuntimeException -> 0x0520 }
            r1 = r24
            r0.remove(r1)     // Catch:{ IOException -> 0x051e, RuntimeException -> 0x051c }
            r1 = 1
            return r1
        L_0x051c:
            r0 = move-exception
            goto L_0x0525
        L_0x051e:
            r0 = move-exception
            goto L_0x0525
        L_0x0520:
            r0 = move-exception
            goto L_0x0523
        L_0x0522:
            r0 = move-exception
        L_0x0523:
            r1 = r24
        L_0x0525:
            r2 = r0
        L_0x0526:
            r15 = r22
            goto L_0x0539
        L_0x0529:
            r0 = move-exception
            goto L_0x052c
        L_0x052b:
            r0 = move-exception
        L_0x052c:
            r27 = r4
            r1 = r10
            goto L_0x0536
        L_0x0530:
            r0 = move-exception
            goto L_0x0533
        L_0x0532:
            r0 = move-exception
        L_0x0533:
            r27 = r4
            r1 = r14
        L_0x0536:
            r22 = r15
            r2 = r0
        L_0x0539:
            r10 = r27
            r3 = 0
            goto L_0x0563
        L_0x053d:
            r1 = r14
            r22 = r15
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0555, RuntimeException -> 0x0553 }
            java.lang.String r2 = "Invalid protocol."
            r0.<init>(r2)     // Catch:{ IOException -> 0x0555, RuntimeException -> 0x0553 }
            throw r0     // Catch:{ IOException -> 0x0555, RuntimeException -> 0x0553 }
        L_0x0548:
            r1 = r14
            r22 = r15
            java.io.IOException r0 = new java.io.IOException     // Catch:{ IOException -> 0x0555, RuntimeException -> 0x0553 }
            java.lang.String r2 = "Too many redirects (20)"
            r0.<init>(r2)     // Catch:{ IOException -> 0x0555, RuntimeException -> 0x0553 }
            throw r0     // Catch:{ IOException -> 0x0555, RuntimeException -> 0x0553 }
        L_0x0553:
            r0 = move-exception
            goto L_0x0556
        L_0x0555:
            r0 = move-exception
        L_0x0556:
            r2 = r0
            r15 = r22
            goto L_0x0561
        L_0x055a:
            r0 = move-exception
            goto L_0x055d
        L_0x055c:
            r0 = move-exception
        L_0x055d:
            r1 = r14
            r22 = r15
            r2 = r0
        L_0x0561:
            r3 = 0
            r10 = 0
        L_0x0563:
            boolean r0 = r2 instanceof java.lang.RuntimeException
            if (r0 == 0) goto L_0x0570
            com.google.android.gms.internal.ads.zzawm r0 = com.google.android.gms.ads.internal.zzk.zzlk()
            java.lang.String r4 = "VideoStreamFullFileCache.preload"
            r0.mo30168a(r2, r4)
        L_0x0570:
            r10.close()     // Catch:{ IOException -> 0x0576, NullPointerException -> 0x0574 }
            goto L_0x0577
        L_0x0574:
            r0 = move-exception
            goto L_0x0577
        L_0x0576:
            r0 = move-exception
        L_0x0577:
            boolean r0 = r8.f25297g
            if (r0 == 0) goto L_0x059f
            java.lang.String r0 = java.lang.String.valueOf(r31)
            int r0 = r0.length()
            int r0 = r0 + 26
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r0)
            java.lang.String r0 = "Preload aborted for URL \""
            r2.append(r0)
            r2.append(r9)
            java.lang.String r0 = "\""
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.google.android.gms.internal.ads.zzbad.m26357c(r0)
            goto L_0x05c2
        L_0x059f:
            java.lang.String r0 = java.lang.String.valueOf(r31)
            int r0 = r0.length()
            int r0 = r0 + 25
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r0)
            java.lang.String r0 = "Preload failed for URL \""
            r4.append(r0)
            r4.append(r9)
            java.lang.String r0 = "\""
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            com.google.android.gms.internal.ads.zzbad.m26358c(r0, r2)
        L_0x05c2:
            boolean r0 = r12.exists()
            if (r0 == 0) goto L_0x05ec
            boolean r0 = r12.delete()
            if (r0 != 0) goto L_0x05ec
            java.lang.String r0 = "Could not delete partial cache file at "
            java.lang.String r2 = r12.getAbsolutePath()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r4 = r2.length()
            if (r4 == 0) goto L_0x05e3
            java.lang.String r0 = r0.concat(r2)
            goto L_0x05e9
        L_0x05e3:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r0)
            r0 = r2
        L_0x05e9:
            com.google.android.gms.internal.ads.zzbad.m26359d(r0)
        L_0x05ec:
            java.lang.String r0 = r12.getAbsolutePath()
            r8.mo30545a(r9, r0, r15, r3)
            java.util.Set<java.lang.String> r0 = f25294d
            r0.remove(r1)
            r1 = 0
            return r1
        L_0x05fa:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x05fa }
            goto L_0x05fe
        L_0x05fd:
            throw r0
        L_0x05fe:
            goto L_0x05fd
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbge.mo30546a(java.lang.String):boolean");
    }

    /* renamed from: b */
    public final void mo30549b() {
        this.f25297g = true;
    }

    /* renamed from: a */
    private final File m26736a(File file) {
        return new File(this.f25296f, String.valueOf(file.getName()).concat(".done"));
    }
}
