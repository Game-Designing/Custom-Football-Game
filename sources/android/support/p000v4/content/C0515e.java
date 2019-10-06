package android.support.p000v4.content;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager.ReceiverRecord;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: android.support.v4.content.e */
/* compiled from: LocalBroadcastManager */
public final class C0515e {

    /* renamed from: a */
    private static final Object f1672a = new Object();

    /* renamed from: b */
    private static C0515e f1673b;

    /* renamed from: c */
    private final Context f1674c;

    /* renamed from: d */
    private final HashMap<BroadcastReceiver, ArrayList<C0517b>> f1675d = new HashMap<>();

    /* renamed from: e */
    private final HashMap<String, ArrayList<C0517b>> f1676e = new HashMap<>();

    /* renamed from: f */
    private final ArrayList<C0516a> f1677f = new ArrayList<>();

    /* renamed from: g */
    private final Handler f1678g;

    /* renamed from: android.support.v4.content.e$a */
    /* compiled from: LocalBroadcastManager */
    private static final class C0516a {

        /* renamed from: a */
        final Intent f1679a;

        /* renamed from: b */
        final ArrayList<C0517b> f1680b;

        C0516a(Intent _intent, ArrayList<C0517b> _receivers) {
            this.f1679a = _intent;
            this.f1680b = _receivers;
        }
    }

    /* renamed from: android.support.v4.content.e$b */
    /* compiled from: LocalBroadcastManager */
    private static final class C0517b {

        /* renamed from: a */
        final IntentFilter f1681a;

        /* renamed from: b */
        final BroadcastReceiver f1682b;

        /* renamed from: c */
        boolean f1683c;

        /* renamed from: d */
        boolean f1684d;

        C0517b(IntentFilter _filter, BroadcastReceiver _receiver) {
            this.f1681a = _filter;
            this.f1682b = _receiver;
        }

        public String toString() {
            StringBuilder builder = new StringBuilder(128);
            builder.append("Receiver{");
            builder.append(this.f1682b);
            builder.append(" filter=");
            builder.append(this.f1681a);
            if (this.f1684d) {
                builder.append(" DEAD");
            }
            builder.append("}");
            return builder.toString();
        }
    }

    /* renamed from: a */
    public static C0515e m2597a(Context context) {
        C0515e eVar;
        synchronized (f1672a) {
            if (f1673b == null) {
                f1673b = new C0515e(context.getApplicationContext());
            }
            eVar = f1673b;
        }
        return eVar;
    }

    private C0515e(Context context) {
        this.f1674c = context;
        this.f1678g = new C0514d(this, context.getMainLooper());
    }

    /* renamed from: a */
    public void mo5313a(BroadcastReceiver receiver, IntentFilter filter) {
        synchronized (this.f1675d) {
            C0517b entry = new C0517b(filter, receiver);
            ArrayList arrayList = (ArrayList) this.f1675d.get(receiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f1675d.put(receiver, arrayList);
            }
            arrayList.add(entry);
            for (int i = 0; i < filter.countActions(); i++) {
                String action = filter.getAction(i);
                ArrayList arrayList2 = (ArrayList) this.f1676e.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f1676e.put(action, arrayList2);
                }
                arrayList2.add(entry);
            }
        }
    }

    /* renamed from: a */
    public void mo5312a(BroadcastReceiver receiver) {
        synchronized (this.f1675d) {
            ArrayList<ReceiverRecord> filters = (ArrayList) this.f1675d.remove(receiver);
            if (filters != null) {
                for (int i = filters.size() - 1; i >= 0; i--) {
                    C0517b filter = (C0517b) filters.get(i);
                    filter.f1684d = true;
                    for (int j = 0; j < filter.f1681a.countActions(); j++) {
                        String action = filter.f1681a.getAction(j);
                        ArrayList<ReceiverRecord> receivers = (ArrayList) this.f1676e.get(action);
                        if (receivers != null) {
                            for (int k = receivers.size() - 1; k >= 0; k--) {
                                C0517b rec = (C0517b) receivers.get(k);
                                if (rec.f1682b == receiver) {
                                    rec.f1684d = true;
                                    receivers.remove(k);
                                }
                            }
                            if (receivers.size() <= 0) {
                                this.f1676e.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0174, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0179, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo5314a(android.content.Intent r19) {
        /*
            r18 = this;
            r1 = r18
            r2 = r19
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.support.v4.content.e$b>> r3 = r1.f1675d
            monitor-enter(r3)
            java.lang.String r5 = r19.getAction()     // Catch:{ all -> 0x017a }
            android.content.Context r0 = r1.f1674c     // Catch:{ all -> 0x017a }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ all -> 0x017a }
            java.lang.String r0 = r2.resolveTypeIfNeeded(r0)     // Catch:{ all -> 0x017a }
            android.net.Uri r8 = r19.getData()     // Catch:{ all -> 0x017a }
            java.lang.String r4 = r19.getScheme()     // Catch:{ all -> 0x017a }
            r11 = r4
            java.util.Set r9 = r19.getCategories()     // Catch:{ all -> 0x017a }
            int r4 = r19.getFlags()     // Catch:{ all -> 0x017a }
            r4 = r4 & 8
            r12 = 0
            if (r4 == 0) goto L_0x002e
            r4 = 1
            goto L_0x002f
        L_0x002e:
            r4 = 0
        L_0x002f:
            r14 = r4
            if (r14 == 0) goto L_0x0058
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x017a }
            r6.<init>()     // Catch:{ all -> 0x017a }
            java.lang.String r7 = "Resolving type "
            r6.append(r7)     // Catch:{ all -> 0x017a }
            r6.append(r0)     // Catch:{ all -> 0x017a }
            java.lang.String r7 = " scheme "
            r6.append(r7)     // Catch:{ all -> 0x017a }
            r6.append(r11)     // Catch:{ all -> 0x017a }
            java.lang.String r7 = " of intent "
            r6.append(r7)     // Catch:{ all -> 0x017a }
            r6.append(r2)     // Catch:{ all -> 0x017a }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x017a }
            android.util.Log.v(r4, r6)     // Catch:{ all -> 0x017a }
        L_0x0058:
            java.util.HashMap<java.lang.String, java.util.ArrayList<android.support.v4.content.e$b>> r4 = r1.f1676e     // Catch:{ all -> 0x017a }
            java.lang.String r6 = r19.getAction()     // Catch:{ all -> 0x017a }
            java.lang.Object r4 = r4.get(r6)     // Catch:{ all -> 0x017a }
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch:{ all -> 0x017a }
            r15 = r4
            if (r15 == 0) goto L_0x0175
            if (r14 == 0) goto L_0x007f
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x017a }
            r6.<init>()     // Catch:{ all -> 0x017a }
            java.lang.String r7 = "Action list: "
            r6.append(r7)     // Catch:{ all -> 0x017a }
            r6.append(r15)     // Catch:{ all -> 0x017a }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x017a }
            android.util.Log.v(r4, r6)     // Catch:{ all -> 0x017a }
        L_0x007f:
            r4 = 0
            r6 = r12
            r7 = r4
            r10 = r6
        L_0x0083:
            int r4 = r15.size()     // Catch:{ all -> 0x017a }
            if (r10 >= r4) goto L_0x013f
            java.lang.Object r4 = r15.get(r10)     // Catch:{ all -> 0x017a }
            android.support.v4.content.e$b r4 = (android.support.p000v4.content.C0515e.C0517b) r4     // Catch:{ all -> 0x017a }
            r6 = r4
            if (r14 == 0) goto L_0x00aa
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x017a }
            r12.<init>()     // Catch:{ all -> 0x017a }
            java.lang.String r13 = "Matching against filter "
            r12.append(r13)     // Catch:{ all -> 0x017a }
            android.content.IntentFilter r13 = r6.f1681a     // Catch:{ all -> 0x017a }
            r12.append(r13)     // Catch:{ all -> 0x017a }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x017a }
            android.util.Log.v(r4, r12)     // Catch:{ all -> 0x017a }
        L_0x00aa:
            boolean r4 = r6.f1683c     // Catch:{ all -> 0x017a }
            if (r4 == 0) goto L_0x00c5
            if (r14 == 0) goto L_0x00be
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.String r12 = "  Filter's target already added"
            android.util.Log.v(r4, r12)     // Catch:{ all -> 0x017a }
            r16 = r0
            r0 = r7
            r17 = r10
            goto L_0x0137
        L_0x00be:
            r16 = r0
            r0 = r7
            r17 = r10
            goto L_0x0137
        L_0x00c5:
            android.content.IntentFilter r4 = r6.f1681a     // Catch:{ all -> 0x017a }
            java.lang.String r12 = "LocalBroadcastManager"
            r13 = r6
            r6 = r0
            r16 = r0
            r0 = r7
            r7 = r11
            r17 = r10
            r10 = r12
            int r4 = r4.match(r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x017a }
            if (r4 < 0) goto L_0x0105
            if (r14 == 0) goto L_0x00f4
            java.lang.String r6 = "LocalBroadcastManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x017a }
            r7.<init>()     // Catch:{ all -> 0x017a }
            java.lang.String r10 = "  Filter matched!  match=0x"
            r7.append(r10)     // Catch:{ all -> 0x017a }
            java.lang.String r10 = java.lang.Integer.toHexString(r4)     // Catch:{ all -> 0x017a }
            r7.append(r10)     // Catch:{ all -> 0x017a }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x017a }
            android.util.Log.v(r6, r7)     // Catch:{ all -> 0x017a }
        L_0x00f4:
            if (r0 != 0) goto L_0x00fd
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x017a }
            r6.<init>()     // Catch:{ all -> 0x017a }
            r7 = r6
            r0 = r7
        L_0x00fd:
            r0.add(r13)     // Catch:{ all -> 0x017a }
            r6 = 1
            r13.f1683c = r6     // Catch:{ all -> 0x017a }
            r7 = r0
            goto L_0x0138
        L_0x0105:
            if (r14 == 0) goto L_0x0137
            r6 = -4
            if (r4 == r6) goto L_0x011f
            r6 = -3
            if (r4 == r6) goto L_0x011c
            r6 = -2
            if (r4 == r6) goto L_0x0119
            r6 = -1
            if (r4 == r6) goto L_0x0116
            java.lang.String r6 = "unknown reason"
            goto L_0x0121
        L_0x0116:
            java.lang.String r6 = "type"
            goto L_0x0121
        L_0x0119:
            java.lang.String r6 = "data"
            goto L_0x0121
        L_0x011c:
            java.lang.String r6 = "action"
            goto L_0x0121
        L_0x011f:
            java.lang.String r6 = "category"
        L_0x0121:
            java.lang.String r7 = "LocalBroadcastManager"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x017a }
            r10.<init>()     // Catch:{ all -> 0x017a }
            java.lang.String r12 = "  Filter did not match: "
            r10.append(r12)     // Catch:{ all -> 0x017a }
            r10.append(r6)     // Catch:{ all -> 0x017a }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x017a }
            android.util.Log.v(r7, r10)     // Catch:{ all -> 0x017a }
        L_0x0137:
            r7 = r0
        L_0x0138:
            int r10 = r17 + 1
            r0 = r16
            r12 = 0
            goto L_0x0083
        L_0x013f:
            r16 = r0
            r0 = r7
            r17 = r10
            if (r0 == 0) goto L_0x0177
            r4 = 0
            r6 = r4
        L_0x0148:
            int r4 = r0.size()     // Catch:{ all -> 0x017a }
            if (r6 >= r4) goto L_0x015a
            java.lang.Object r4 = r0.get(r6)     // Catch:{ all -> 0x017a }
            android.support.v4.content.e$b r4 = (android.support.p000v4.content.C0515e.C0517b) r4     // Catch:{ all -> 0x017a }
            r7 = 0
            r4.f1683c = r7     // Catch:{ all -> 0x017a }
            int r6 = r6 + 1
            goto L_0x0148
        L_0x015a:
            java.util.ArrayList<android.support.v4.content.e$a> r4 = r1.f1677f     // Catch:{ all -> 0x017a }
            android.support.v4.content.e$a r6 = new android.support.v4.content.e$a     // Catch:{ all -> 0x017a }
            r6.<init>(r2, r0)     // Catch:{ all -> 0x017a }
            r4.add(r6)     // Catch:{ all -> 0x017a }
            android.os.Handler r4 = r1.f1678g     // Catch:{ all -> 0x017a }
            r6 = 1
            boolean r4 = r4.hasMessages(r6)     // Catch:{ all -> 0x017a }
            if (r4 != 0) goto L_0x0172
            android.os.Handler r4 = r1.f1678g     // Catch:{ all -> 0x017a }
            r4.sendEmptyMessage(r6)     // Catch:{ all -> 0x017a }
        L_0x0172:
            monitor-exit(r3)     // Catch:{ all -> 0x017a }
            r3 = 1
            return r3
        L_0x0175:
            r16 = r0
        L_0x0177:
            monitor-exit(r3)     // Catch:{ all -> 0x017a }
            r0 = 0
            return r0
        L_0x017a:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x017a }
            goto L_0x017e
        L_0x017d:
            throw r0
        L_0x017e:
            goto L_0x017d
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.content.C0515e.mo5314a(android.content.Intent):boolean");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r1 >= r0.length) goto L_0x0001;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x001f, code lost:
        r2 = r0[r1];
        r3 = r2.f1680b.size();
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r4 >= r3) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        r5 = (android.support.p000v4.content.C0515e.C0517b) r2.f1680b.get(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
        if (r5.f1684d != false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0036, code lost:
        r5.f1682b.onReceive(r9.f1674c, r2.f1679a);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0042, code lost:
        r1 = r1 + 1;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m2598a() {
        /*
            r9 = this;
            r0 = 0
        L_0x0001:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.support.v4.content.e$b>> r1 = r9.f1675d
            monitor-enter(r1)
            java.util.ArrayList<android.support.v4.content.e$a> r2 = r9.f1677f     // Catch:{ all -> 0x0046 }
            int r2 = r2.size()     // Catch:{ all -> 0x0046 }
            if (r2 > 0) goto L_0x000e
            monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            return
        L_0x000e:
            android.support.v4.content.e$a[] r0 = new android.support.p000v4.content.C0515e.C0516a[r2]     // Catch:{ all -> 0x0046 }
            java.util.ArrayList<android.support.v4.content.e$a> r3 = r9.f1677f     // Catch:{ all -> 0x0049 }
            r3.toArray(r0)     // Catch:{ all -> 0x0049 }
            java.util.ArrayList<android.support.v4.content.e$a> r3 = r9.f1677f     // Catch:{ all -> 0x0049 }
            r3.clear()     // Catch:{ all -> 0x0049 }
            monitor-exit(r1)     // Catch:{ all -> 0x0049 }
            r1 = 0
        L_0x001c:
            int r2 = r0.length
            if (r1 >= r2) goto L_0x0045
            r2 = r0[r1]
            java.util.ArrayList<android.support.v4.content.e$b> r3 = r2.f1680b
            int r3 = r3.size()
            r4 = 0
        L_0x0028:
            if (r4 >= r3) goto L_0x0042
            java.util.ArrayList<android.support.v4.content.e$b> r5 = r2.f1680b
            java.lang.Object r5 = r5.get(r4)
            android.support.v4.content.e$b r5 = (android.support.p000v4.content.C0515e.C0517b) r5
            boolean r6 = r5.f1684d
            if (r6 != 0) goto L_0x003f
            android.content.BroadcastReceiver r6 = r5.f1682b
            android.content.Context r7 = r9.f1674c
            android.content.Intent r8 = r2.f1679a
            r6.onReceive(r7, r8)
        L_0x003f:
            int r4 = r4 + 1
            goto L_0x0028
        L_0x0042:
            int r1 = r1 + 1
            goto L_0x001c
        L_0x0045:
            goto L_0x0001
        L_0x0046:
            r2 = move-exception
        L_0x0047:
            monitor-exit(r1)     // Catch:{ all -> 0x0049 }
            throw r2
        L_0x0049:
            r2 = move-exception
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.p000v4.content.C0515e.m2598a():void");
    }
}
