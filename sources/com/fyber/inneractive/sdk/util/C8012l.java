package com.fyber.inneractive.sdk.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.fyber.inneractive.sdk.p166g.p167a.C7756a;

/* renamed from: com.fyber.inneractive.sdk.util.l */
public final class C8012l extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a */
    Context f16343a;

    /* renamed from: b */
    C8013a f16344b;

    /* renamed from: c */
    String f16345c;

    /* renamed from: d */
    String f16346d;

    /* renamed from: e */
    int f16347e;

    /* renamed from: f */
    private C7756a f16348f;

    /* renamed from: com.fyber.inneractive.sdk.util.l$a */
    public interface C8013a {
        /* renamed from: a */
        void mo24354a();

        /* renamed from: a */
        void mo24355a(Bitmap bitmap);
    }

    /* access modifiers changed from: protected */
    @TargetApi(10)
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        return m18084b();
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        C8013a aVar = this.f16344b;
        if (aVar != null) {
            if (bitmap != null) {
                aVar.mo24355a(bitmap);
            } else {
                aVar.mo24354a();
            }
            this.f16344b = null;
        }
    }

    private C8012l(Context context, C8013a aVar, String str) {
        this.f16348f = null;
        this.f16343a = context;
        this.f16344b = aVar;
        this.f16345c = str;
        this.f16346d = null;
        this.f16347e = 81920;
    }

    public C8012l(Context context, C8013a aVar, String str, byte b) {
        this(context, aVar, str);
    }

    /* JADX WARNING: type inference failed for: r2v0 */
    /* JADX WARNING: type inference failed for: r2v1, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r2v2 */
    /* JADX WARNING: type inference failed for: r2v3, types: [android.graphics.Bitmap] */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r6v1 */
    /* JADX WARNING: type inference failed for: r5v3 */
    /* JADX WARNING: type inference failed for: r4v2 */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r6v2 */
    /* JADX WARNING: type inference failed for: r5v4 */
    /* JADX WARNING: type inference failed for: r4v3 */
    /* JADX WARNING: type inference failed for: r6v3, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v5, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r4v4, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r4v5 */
    /* JADX WARNING: type inference failed for: r6v4 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r4v7 */
    /* JADX WARNING: type inference failed for: r6v5, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r5v8, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v9 */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r6v6 */
    /* JADX WARNING: type inference failed for: r4v10 */
    /* JADX WARNING: type inference failed for: r5v10 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: type inference failed for: r6v7 */
    /* JADX WARNING: type inference failed for: r4v13 */
    /* JADX WARNING: type inference failed for: r4v16 */
    /* JADX WARNING: type inference failed for: r4v17 */
    /* JADX WARNING: type inference failed for: r4v18 */
    /* JADX WARNING: type inference failed for: r4v19, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r5v14 */
    /* JADX WARNING: type inference failed for: r5v15 */
    /* JADX WARNING: type inference failed for: r6v8 */
    /* JADX WARNING: type inference failed for: r5v18, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r6v11 */
    /* JADX WARNING: type inference failed for: r6v12 */
    /* JADX WARNING: type inference failed for: r6v13, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: type inference failed for: r2v10 */
    /* JADX WARNING: type inference failed for: r2v11 */
    /* JADX WARNING: type inference failed for: r2v12 */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: type inference failed for: r2v14 */
    /* JADX WARNING: type inference failed for: r6v17 */
    /* JADX WARNING: type inference failed for: r4v20 */
    /* JADX WARNING: type inference failed for: r6v18 */
    /* JADX WARNING: type inference failed for: r5v22 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r6v19 */
    /* JADX WARNING: type inference failed for: r6v20 */
    /* JADX WARNING: type inference failed for: r5v23 */
    /* JADX WARNING: type inference failed for: r5v24 */
    /* JADX WARNING: type inference failed for: r4v22 */
    /* JADX WARNING: type inference failed for: r4v23 */
    /* JADX WARNING: type inference failed for: r5v25 */
    /* JADX WARNING: type inference failed for: r4v24 */
    /* JADX WARNING: type inference failed for: r4v25 */
    /* JADX WARNING: type inference failed for: r6v21 */
    /* JADX WARNING: type inference failed for: r6v22 */
    /* JADX WARNING: type inference failed for: r5v26 */
    /* JADX WARNING: type inference failed for: r5v27 */
    /* JADX WARNING: type inference failed for: r4v26 */
    /* JADX WARNING: type inference failed for: r4v27 */
    /* JADX WARNING: type inference failed for: r5v28 */
    /* JADX WARNING: type inference failed for: r4v28 */
    /* JADX WARNING: type inference failed for: r4v29 */
    /* JADX WARNING: type inference failed for: r4v30 */
    /* JADX WARNING: type inference failed for: r4v31 */
    /* JADX WARNING: type inference failed for: r4v32 */
    /* JADX WARNING: type inference failed for: r4v33 */
    /* JADX WARNING: type inference failed for: r4v34 */
    /* JADX WARNING: type inference failed for: r4v35 */
    /* JADX WARNING: type inference failed for: r4v36 */
    /* JADX WARNING: type inference failed for: r4v37 */
    /* JADX WARNING: type inference failed for: r4v38 */
    /* JADX WARNING: type inference failed for: r5v29 */
    /* JADX WARNING: type inference failed for: r5v30 */
    /* JADX WARNING: type inference failed for: r5v31 */
    /* JADX WARNING: type inference failed for: r5v32 */
    /* JADX WARNING: type inference failed for: r5v33 */
    /* JADX WARNING: type inference failed for: r6v23 */
    /* JADX WARNING: type inference failed for: r6v24 */
    /* JADX WARNING: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: No candidate types for var: r2v2
      assigns: []
      uses: []
      mth insns count: 206
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
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00c1 A[SYNTHETIC, Splitter:B:61:0x00c1] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9 A[Catch:{ IOException -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00ce A[Catch:{ IOException -> 0x00c5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00f7 A[SYNTHETIC, Splitter:B:78:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x00ff A[Catch:{ IOException -> 0x00fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0104 A[Catch:{ IOException -> 0x00fb }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0112 A[SYNTHETIC, Splitter:B:91:0x0112] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011a A[Catch:{ IOException -> 0x0116 }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x011f A[Catch:{ IOException -> 0x0116 }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:58:0x00a7=Splitter:B:58:0x00a7, B:75:0x00dd=Splitter:B:75:0x00dd} */
    /* JADX WARNING: Unknown variable types count: 34 */
    @android.annotation.TargetApi(10)
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap m18084b() {
        /*
            r10 = this;
            com.fyber.inneractive.sdk.g.a.a r0 = r10.f16348f
            r1 = 8192(0x2000, float:1.14794E-41)
            r2 = 0
            if (r0 != 0) goto L_0x0129
            byte[] r0 = new byte[r1]
            java.io.File r3 = new java.io.File     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            android.content.Context r4 = r10.f16343a     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            java.io.File r4 = r4.getFilesDir()     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            java.lang.String r5 = r10.f16346d     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            boolean r5 = android.text.TextUtils.isEmpty(r5)     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            if (r5 == 0) goto L_0x0037
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            r5.<init>()     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            java.util.UUID r6 = java.util.UUID.randomUUID()     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            java.lang.String r6 = r6.toString()     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            java.lang.String r6 = ".mp4"
            r5.append(r6)     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            java.lang.String r5 = r5.toString()     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            goto L_0x0039
        L_0x0037:
            java.lang.String r5 = r10.f16346d     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
        L_0x0039:
            r3.<init>(r4, r5)     // Catch:{ MalformedURLException -> 0x00d8, IOException -> 0x00a2, all -> 0x009c }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ MalformedURLException -> 0x0099, IOException -> 0x0096, all -> 0x0093 }
            r4.<init>(r3)     // Catch:{ MalformedURLException -> 0x0099, IOException -> 0x0096, all -> 0x0093 }
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0090, IOException -> 0x008d, all -> 0x0089 }
            java.lang.String r6 = r10.f16345c     // Catch:{ MalformedURLException -> 0x0090, IOException -> 0x008d, all -> 0x0089 }
            r5.<init>(r6)     // Catch:{ MalformedURLException -> 0x0090, IOException -> 0x008d, all -> 0x0089 }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ MalformedURLException -> 0x0090, IOException -> 0x008d, all -> 0x0089 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ MalformedURLException -> 0x0090, IOException -> 0x008d, all -> 0x0089 }
            java.io.InputStream r6 = r5.getInputStream()     // Catch:{ MalformedURLException -> 0x0085, IOException -> 0x0082, all -> 0x007e }
            r7 = 0
            r8 = 0
        L_0x0054:
            int r9 = r10.f16347e     // Catch:{ MalformedURLException -> 0x007b, IOException -> 0x0079 }
            int r9 = r9 - r1
            if (r8 >= r9) goto L_0x0064
            int r9 = r6.read(r0, r7, r1)     // Catch:{ MalformedURLException -> 0x007b, IOException -> 0x0079 }
            if (r9 < 0) goto L_0x0063
            r4.write(r0, r7, r9)     // Catch:{ MalformedURLException -> 0x007b, IOException -> 0x0079 }
            int r8 = r8 + r9
        L_0x0063:
            goto L_0x0054
        L_0x0064:
            if (r5 == 0) goto L_0x0069
            r5.disconnect()     // Catch:{ IOException -> 0x0073 }
        L_0x0069:
            r4.close()     // Catch:{ IOException -> 0x0073 }
            if (r6 == 0) goto L_0x0071
            r6.close()     // Catch:{ IOException -> 0x0073 }
        L_0x0071:
            goto L_0x012d
        L_0x0073:
            r0 = move-exception
            r3.delete()
            goto L_0x012d
        L_0x0079:
            r0 = move-exception
            goto L_0x00a7
        L_0x007b:
            r0 = move-exception
            goto L_0x00dd
        L_0x007e:
            r0 = move-exception
            r6 = r2
            goto L_0x010f
        L_0x0082:
            r0 = move-exception
            r6 = r2
            goto L_0x00a7
        L_0x0085:
            r0 = move-exception
            r6 = r2
            goto L_0x00dd
        L_0x0089:
            r0 = move-exception
            r6 = r2
            goto L_0x0110
        L_0x008d:
            r0 = move-exception
            r5 = r2
            goto L_0x00a6
        L_0x0090:
            r0 = move-exception
            r5 = r2
            goto L_0x00dc
        L_0x0093:
            r0 = move-exception
            r4 = r2
            goto L_0x009f
        L_0x0096:
            r0 = move-exception
            r4 = r2
            goto L_0x00a5
        L_0x0099:
            r0 = move-exception
            r4 = r2
            goto L_0x00db
        L_0x009c:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x009f:
            r6 = r4
            goto L_0x0110
        L_0x00a2:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x00a5:
            r5 = r4
        L_0x00a6:
            r6 = r5
        L_0x00a7:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            java.lang.String r7 = "Failed getting frame from video file"
            r1.<init>(r7)     // Catch:{ all -> 0x010e }
            java.lang.String r0 = com.fyber.inneractive.sdk.util.C8017o.m18096a(r0)     // Catch:{ all -> 0x010e }
            r1.append(r0)     // Catch:{ all -> 0x010e }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x010e }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r0)     // Catch:{ all -> 0x010e }
            r3.delete()     // Catch:{ all -> 0x010e }
            if (r5 == 0) goto L_0x00c7
            r5.disconnect()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00c7
        L_0x00c5:
            r0 = move-exception
            goto L_0x00d2
        L_0x00c7:
            if (r4 == 0) goto L_0x00cc
            r4.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x00cc:
            if (r6 == 0) goto L_0x00d6
            r6.close()     // Catch:{ IOException -> 0x00c5 }
            goto L_0x00d6
        L_0x00d2:
            r3.delete()
            goto L_0x00d7
        L_0x00d6:
        L_0x00d7:
            return r2
        L_0x00d8:
            r0 = move-exception
            r3 = r2
            r4 = r3
        L_0x00db:
            r5 = r4
        L_0x00dc:
            r6 = r5
        L_0x00dd:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x010e }
            java.lang.String r7 = "Failed getting frame from video file"
            r1.<init>(r7)     // Catch:{ all -> 0x010e }
            java.lang.String r0 = com.fyber.inneractive.sdk.util.C8017o.m18096a(r0)     // Catch:{ all -> 0x010e }
            r1.append(r0)     // Catch:{ all -> 0x010e }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x010e }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r0)     // Catch:{ all -> 0x010e }
            r3.delete()     // Catch:{ all -> 0x010e }
            if (r5 == 0) goto L_0x00fd
            r5.disconnect()     // Catch:{ IOException -> 0x00fb }
            goto L_0x00fd
        L_0x00fb:
            r0 = move-exception
            goto L_0x0108
        L_0x00fd:
            if (r4 == 0) goto L_0x0102
            r4.close()     // Catch:{ IOException -> 0x00fb }
        L_0x0102:
            if (r6 == 0) goto L_0x010c
            r6.close()     // Catch:{ IOException -> 0x00fb }
            goto L_0x010c
        L_0x0108:
            r3.delete()
            goto L_0x010d
        L_0x010c:
        L_0x010d:
            return r2
        L_0x010e:
            r0 = move-exception
        L_0x010f:
            r2 = r5
        L_0x0110:
            if (r2 == 0) goto L_0x0118
            r2.disconnect()     // Catch:{ IOException -> 0x0116 }
            goto L_0x0118
        L_0x0116:
            r1 = move-exception
            goto L_0x0123
        L_0x0118:
            if (r4 == 0) goto L_0x011d
            r4.close()     // Catch:{ IOException -> 0x0116 }
        L_0x011d:
            if (r6 == 0) goto L_0x0127
            r6.close()     // Catch:{ IOException -> 0x0116 }
            goto L_0x0127
        L_0x0123:
            r3.delete()
            goto L_0x0128
        L_0x0127:
        L_0x0128:
            throw r0
        L_0x0129:
            java.io.File r3 = r0.mo24359a()
        L_0x012d:
            com.fyber.inneractive.sdk.g.a.a r0 = r10.f16348f
            if (r0 != 0) goto L_0x0137
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            goto L_0x0139
        L_0x0137:
            java.lang.Object r0 = r0.f15556e
        L_0x0139:
            android.media.MediaMetadataRetriever r4 = new android.media.MediaMetadataRetriever
            r4.<init>()
            monitor-enter(r0)     // Catch:{ Exception -> 0x015d }
            java.lang.String r5 = r3.getPath()     // Catch:{ all -> 0x0158 }
            r4.setDataSource(r5)     // Catch:{ all -> 0x0158 }
            r4.extractMetadata(r1)     // Catch:{ all -> 0x0158 }
            r5 = 1
            android.graphics.Bitmap r2 = r4.getFrameAtTime(r5)     // Catch:{ all -> 0x0158 }
            monitor-exit(r0)     // Catch:{ all -> 0x0158 }
            r4.release()     // Catch:{ Throwable -> 0x0156 }
        L_0x0155:
            goto L_0x0177
        L_0x0156:
            r0 = move-exception
            goto L_0x0155
        L_0x0158:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0158 }
            throw r1     // Catch:{ Exception -> 0x015d }
        L_0x015b:
            r0 = move-exception
            goto L_0x0181
        L_0x015d:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x015b }
            java.lang.String r5 = "Failed getting frame from video file"
            r1.<init>(r5)     // Catch:{ all -> 0x015b }
            java.lang.String r0 = com.fyber.inneractive.sdk.util.C8017o.m18096a(r0)     // Catch:{ all -> 0x015b }
            r1.append(r0)     // Catch:{ all -> 0x015b }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x015b }
            com.fyber.inneractive.sdk.util.IAlog.m18021b(r0)     // Catch:{ all -> 0x015b }
            r4.release()     // Catch:{ Throwable -> 0x0156 }
            goto L_0x0155
        L_0x0177:
            com.fyber.inneractive.sdk.g.a.a r0 = r10.f16348f
            if (r0 != 0) goto L_0x0180
            if (r3 == 0) goto L_0x0180
            r3.delete()
        L_0x0180:
            return r2
        L_0x0181:
            r4.release()     // Catch:{ Throwable -> 0x0185 }
        L_0x0184:
            goto L_0x0187
        L_0x0185:
            r1 = move-exception
            goto L_0x0184
        L_0x0187:
            goto L_0x0189
        L_0x0188:
            throw r0
        L_0x0189:
            goto L_0x0188
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.C8012l.m18084b():android.graphics.Bitmap");
    }

    /* renamed from: a */
    public final void mo24847a() {
        super.cancel(true);
        this.f16344b = null;
    }
}
