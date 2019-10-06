package com.facebook.p127a;

import android.content.Context;
import android.util.Log;
import com.facebook.C6787r;
import com.facebook.internal.C6694S;
import com.facebook.p127a.p130b.C6603i;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;

/* renamed from: com.facebook.a.p */
/* compiled from: AppEventStore */
class C6636p {

    /* renamed from: a */
    private static final String f12081a = C6636p.class.getName();

    /* renamed from: com.facebook.a.p$a */
    /* compiled from: AppEventStore */
    private static class C6637a extends ObjectInputStream {
        public C6637a(InputStream in) throws IOException {
            super(in);
        }

        /* access modifiers changed from: protected */
        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass resultClassDescriptor = super.readClassDescriptor();
            if (resultClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1")) {
                return ObjectStreamClass.lookup(C6594a.class);
            }
            if (resultClassDescriptor.getName().equals("com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV1")) {
                return ObjectStreamClass.lookup(C6626a.class);
            }
            return resultClassDescriptor;
        }
    }

    C6636p() {
    }

    /* renamed from: a */
    public static synchronized void m13211a(C6593b accessTokenAppIdPair, C6562B appEvents) {
        synchronized (C6636p.class) {
            C6603i.m13110b();
            C6560A persistedEvents = m13209a();
            if (persistedEvents.mo19740a(accessTokenAppIdPair)) {
                persistedEvents.mo19741b(accessTokenAppIdPair).addAll(appEvents.mo19746b());
            } else {
                persistedEvents.mo19739a(accessTokenAppIdPair, appEvents.mo19746b());
            }
            m13210a(persistedEvents);
        }
    }

    /* renamed from: a */
    public static synchronized void m13212a(C6628h eventsToPersist) {
        synchronized (C6636p.class) {
            C6603i.m13110b();
            C6560A persistedEvents = m13209a();
            for (C6593b accessTokenAppIdPair : eventsToPersist.mo19827b()) {
                persistedEvents.mo19739a(accessTokenAppIdPair, eventsToPersist.mo19824a(accessTokenAppIdPair).mo19746b());
            }
            m13210a(persistedEvents);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        r4 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        r5 = f12081a;
        r6 = "Got unexpected exception when removing events file: ";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0059, code lost:
        com.facebook.internal.C6694S.m13420a((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r3.getFileStreamPath("AppEventsLogger.persistedevents").delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0066, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        android.util.Log.w(f12081a, "Got unexpected exception when removing events file: ", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x006e, code lost:
        throw r4;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:11:0x0029, B:19:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0085 A[Catch:{ all -> 0x003b, Exception -> 0x0031 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized com.facebook.p127a.C6560A m13209a() {
        /*
            java.lang.Class<com.facebook.a.p> r0 = com.facebook.p127a.C6636p.class
            monitor-enter(r0)
            com.facebook.p127a.p130b.C6603i.m13110b()     // Catch:{ all -> 0x008d }
            r1 = 0
            r2 = 0
            android.content.Context r3 = com.facebook.C6787r.m13815e()     // Catch:{ all -> 0x008d }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r4 = r3.openFileInput(r4)     // Catch:{ FileNotFoundException -> 0x006f, Exception -> 0x003d }
            com.facebook.a.p$a r5 = new com.facebook.a.p$a     // Catch:{ FileNotFoundException -> 0x006f, Exception -> 0x003d }
            java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x006f, Exception -> 0x003d }
            r6.<init>(r4)     // Catch:{ FileNotFoundException -> 0x006f, Exception -> 0x003d }
            r5.<init>(r6)     // Catch:{ FileNotFoundException -> 0x006f, Exception -> 0x003d }
            r1 = r5
            java.lang.Object r5 = r1.readObject()     // Catch:{ FileNotFoundException -> 0x006f, Exception -> 0x003d }
            com.facebook.a.A r5 = (com.facebook.p127a.C6560A) r5     // Catch:{ FileNotFoundException -> 0x006f, Exception -> 0x003d }
            r2 = r5
            com.facebook.internal.C6694S.m13420a(r1)     // Catch:{ all -> 0x008d }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r4 = r3.getFileStreamPath(r4)     // Catch:{ Exception -> 0x0031 }
            r4.delete()     // Catch:{ Exception -> 0x0031 }
        L_0x0030:
            goto L_0x0083
        L_0x0031:
            r4 = move-exception
            java.lang.String r5 = f12081a     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "Got unexpected exception when removing events file: "
        L_0x0036:
            android.util.Log.w(r5, r6, r4)     // Catch:{ all -> 0x008d }
            goto L_0x0083
        L_0x003b:
            r4 = move-exception
            goto L_0x0059
        L_0x003d:
            r4 = move-exception
            java.lang.String r5 = f12081a     // Catch:{ all -> 0x003b }
            java.lang.String r6 = "Got unexpected exception while reading events: "
            android.util.Log.w(r5, r6, r4)     // Catch:{ all -> 0x003b }
            com.facebook.internal.C6694S.m13420a(r1)     // Catch:{ all -> 0x008d }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r4 = r3.getFileStreamPath(r4)     // Catch:{ Exception -> 0x0053 }
            r4.delete()     // Catch:{ Exception -> 0x0053 }
            goto L_0x0030
        L_0x0053:
            r4 = move-exception
            java.lang.String r5 = f12081a     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "Got unexpected exception when removing events file: "
            goto L_0x0036
        L_0x0059:
            com.facebook.internal.C6694S.m13420a(r1)     // Catch:{ all -> 0x008d }
            java.lang.String r5 = "AppEventsLogger.persistedevents"
            java.io.File r5 = r3.getFileStreamPath(r5)     // Catch:{ Exception -> 0x0066 }
            r5.delete()     // Catch:{ Exception -> 0x0066 }
            goto L_0x006e
        L_0x0066:
            r5 = move-exception
            java.lang.String r6 = f12081a     // Catch:{ all -> 0x008d }
            java.lang.String r7 = "Got unexpected exception when removing events file: "
            android.util.Log.w(r6, r7, r5)     // Catch:{ all -> 0x008d }
        L_0x006e:
            throw r4     // Catch:{ all -> 0x008d }
        L_0x006f:
            r4 = move-exception
            com.facebook.internal.C6694S.m13420a(r1)     // Catch:{ all -> 0x008d }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r4 = r3.getFileStreamPath(r4)     // Catch:{ Exception -> 0x007d }
            r4.delete()     // Catch:{ Exception -> 0x007d }
            goto L_0x0030
        L_0x007d:
            r4 = move-exception
            java.lang.String r5 = f12081a     // Catch:{ all -> 0x008d }
            java.lang.String r6 = "Got unexpected exception when removing events file: "
            goto L_0x0036
        L_0x0083:
            if (r2 != 0) goto L_0x008b
            com.facebook.a.A r4 = new com.facebook.a.A     // Catch:{ all -> 0x008d }
            r4.<init>()     // Catch:{ all -> 0x008d }
            r2 = r4
        L_0x008b:
            monitor-exit(r0)
            return r2
        L_0x008d:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x0091
        L_0x0090:
            throw r1
        L_0x0091:
            goto L_0x0090
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.p127a.C6636p.m13209a():com.facebook.a.A");
    }

    /* renamed from: a */
    private static void m13210a(C6560A eventsToPersist) {
        String str = "AppEventsLogger.persistedevents";
        ObjectOutputStream oos = null;
        Context context = C6787r.m13815e();
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(context.openFileOutput(str, 0)));
            oos.writeObject(eventsToPersist);
        } catch (Exception e) {
            Log.w(f12081a, "Got unexpected exception while persisting events: ", e);
            try {
                context.getFileStreamPath(str).delete();
            } catch (Exception e2) {
            }
        } catch (Throwable th) {
            C6694S.m13420a((Closeable) oos);
            throw th;
        }
        C6694S.m13420a((Closeable) oos);
    }
}
