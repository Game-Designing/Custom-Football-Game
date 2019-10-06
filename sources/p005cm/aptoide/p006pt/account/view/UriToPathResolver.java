package p005cm.aptoide.p006pt.account.view;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.account.view.UriToPathResolver */
public class UriToPathResolver {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private static final String TAG = UriToPathResolver.class.getName();
    private final ContentResolver contentResolver;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(2071817152551402384L, "cm/aptoide/pt/account/view/UriToPathResolver", 36);
        $jacocoData = probes;
        return probes;
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[35] = true;
    }

    public UriToPathResolver(ContentResolver contentResolver2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.contentResolver = contentResolver2;
        $jacocoInit[0] = true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMediaStoragePath(android.net.Uri r12) {
        /*
            r11 = this;
            java.lang.String r0 = "_data"
            boolean[] r1 = $jacocoInit()
            r2 = 1
            if (r12 == 0) goto L_0x00de
            r3 = 0
            r4 = 3
            r1[r4] = r2     // Catch:{ Exception -> 0x007f, all -> 0x007d }
            r4 = r0
            java.lang.String[] r7 = new java.lang.String[r2]     // Catch:{ Exception -> 0x007b }
            r5 = 0
            r7[r5] = r0     // Catch:{ Exception -> 0x007b }
            r5 = 4
            r1[r5] = r2     // Catch:{ Exception -> 0x007b }
            android.content.ContentResolver r5 = r11.contentResolver     // Catch:{ Exception -> 0x007b }
            r8 = 0
            r9 = 0
            r10 = 0
            r6 = r12
            android.database.Cursor r5 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x007b }
            r3 = r5
            r5 = 5
            r1[r5] = r2     // Catch:{ Exception -> 0x007b }
            int r0 = r3.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x007b }
            if (r3 == 0) goto L_0x005d
            r5 = 6
            r1[r5] = r2     // Catch:{ Exception -> 0x007b }
            r3.moveToFirst()     // Catch:{ Exception -> 0x007b }
            r5 = 7
            r1[r5] = r2     // Catch:{ Exception -> 0x007b }
            java.lang.String r5 = r3.getString(r0)     // Catch:{ Exception -> 0x007b }
            r6 = 8
            r1[r6] = r2     // Catch:{ Exception -> 0x007b }
            if (r3 != 0) goto L_0x0042
            r6 = 9
            r1[r6] = r2
            goto L_0x0058
        L_0x0042:
            boolean r6 = r3.isClosed()
            if (r6 == 0) goto L_0x004d
            r6 = 10
            r1[r6] = r2
            goto L_0x0058
        L_0x004d:
            r6 = 11
            r1[r6] = r2
            r3.close()
            r6 = 12
            r1[r6] = r2
        L_0x0058:
            r6 = 13
            r1[r6] = r2
            return r5
        L_0x005d:
            if (r3 != 0) goto L_0x0064
            r0 = 14
            r1[r0] = r2
            goto L_0x00b2
        L_0x0064:
            boolean r0 = r3.isClosed()
            if (r0 == 0) goto L_0x006f
            r0 = 15
            r1[r0] = r2
            goto L_0x00b2
        L_0x006f:
            r0 = 16
            r1[r0] = r2
            r3.close()
            r0 = 17
            r1[r0] = r2
            goto L_0x00b2
        L_0x007b:
            r0 = move-exception
            goto L_0x0080
        L_0x007d:
            r0 = move-exception
            goto L_0x00bc
        L_0x007f:
            r0 = move-exception
        L_0x0080:
            r4 = 18
            r1[r4] = r2     // Catch:{ all -> 0x00bb }
            cm.aptoide.pt.logger.Logger r4 = p005cm.aptoide.p006pt.logger.Logger.getInstance()     // Catch:{ all -> 0x00bb }
            java.lang.String r5 = TAG     // Catch:{ all -> 0x00bb }
            r6 = 19
            r1[r6] = r2     // Catch:{ all -> 0x00bb }
            r4.mo2142e(r5, r0)     // Catch:{ all -> 0x00bb }
            r4 = 20
            r1[r4] = r2     // Catch:{ all -> 0x00bb }
            if (r3 != 0) goto L_0x009c
            r0 = 21
            r1[r0] = r2
            goto L_0x00b2
        L_0x009c:
            boolean r0 = r3.isClosed()
            if (r0 == 0) goto L_0x00a7
            r0 = 22
            r1[r0] = r2
            goto L_0x00b2
        L_0x00a7:
            r0 = 23
            r1[r0] = r2
            r3.close()
            r0 = 24
            r1[r0] = r2
        L_0x00b2:
            java.lang.String r0 = r12.toString()
            r4 = 30
            r1[r4] = r2
            return r0
        L_0x00bb:
            r0 = move-exception
        L_0x00bc:
            if (r3 == 0) goto L_0x00d5
            boolean r4 = r3.isClosed()
            if (r4 == 0) goto L_0x00c9
            r4 = 26
            r1[r4] = r2
            goto L_0x00d9
        L_0x00c9:
            r4 = 27
            r1[r4] = r2
            r3.close()
            r4 = 28
            r1[r4] = r2
            goto L_0x00d9
        L_0x00d5:
            r4 = 25
            r1[r4] = r2
        L_0x00d9:
            r4 = 29
            r1[r4] = r2
            throw r0
        L_0x00de:
            r1[r2] = r2
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r3 = "content Uri is null"
            r0.<init>(r3)
            r3 = 2
            r1[r3] = r2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p005cm.aptoide.p006pt.account.view.UriToPathResolver.getMediaStoragePath(android.net.Uri):java.lang.String");
    }

    public String getCameraStoragePath(Uri uri) {
        boolean[] $jacocoInit = $jacocoInit();
        Cursor cursor = this.contentResolver.query(uri, null, null, null, null);
        $jacocoInit[31] = true;
        cursor.moveToFirst();
        $jacocoInit[32] = true;
        int idx = cursor.getColumnIndex("_data");
        $jacocoInit[33] = true;
        String string = cursor.getString(idx);
        $jacocoInit[34] = true;
        return string;
    }
}
