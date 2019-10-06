package p019d.p143b.p144a.p147c;

/* renamed from: d.b.a.c.Fa */
class C7061Fa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C7235za f13205a;

    /* renamed from: b */
    final /* synthetic */ C7085La f13206b;

    /* renamed from: c */
    final /* synthetic */ C7053Da f13207c;

    C7061Fa(C7053Da da, C7235za zaVar, C7085La la) {
        this.f13207c = da;
        this.f13205a = zaVar;
        this.f13206b = la;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r7 = this;
            d.b.a.c.Da r0 = r7.f13207c
            d.b.a.c.za r1 = r7.f13205a
            r0.m14647b(r1)
            d.b.a.c.Ga r0 = new d.b.a.c.Ga
            r0.<init>(r7)
            d.b.a.c.za r1 = r7.f13205a
            d.b.d.h r1 = r1.mo22759d()
            d.b.d.h r2 = p019d.p143b.p150d.C7258h.f14102a
            java.lang.String r3 = ": "
            java.lang.String r4 = "Failed to load "
            java.lang.String r5 = "MediationAdapterWrapper"
            if (r1 != r2) goto L_0x0071
            d.b.a.c.za r1 = r7.f13205a
            d.b.d.g r1 = r1.mo22756a()
            d.b.d.g r2 = p019d.p143b.p150d.C7257g.f14096c
            if (r1 != r2) goto L_0x0041
            d.b.a.c.Da r1 = r7.f13207c
            d.b.b.b r1 = r1.f13179b
            d.b.a.c.Da r2 = r7.f13207c
            d.b.a.c.Aa r2 = r2.f13182e
            d.b.a.c.Da r3 = r7.f13207c
            d.b.a.c.c r3 = r3.f13180c
            android.content.Context r3 = r3.mo23068m()
            r1.mo23461b(r2, r3, r0)
            goto L_0x00cd
        L_0x0041:
            d.b.a.c.Da r0 = r7.f13207c
            d.b.d.l r0 = r0.f13181d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            d.b.a.c.za r2 = r7.f13205a
            r1.append(r2)
            r1.append(r3)
            d.b.a.c.za r2 = r7.f13205a
            d.b.d.g r2 = r2.mo22756a()
            r1.append(r2)
            java.lang.String r2 = "> is not a supported ad size"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.mo22916b(r5, r1)
            d.b.a.c.Da r0 = r7.f13207c
            d.b.b.h r1 = p019d.p143b.p148b.C7245h.INTERNAL_AD_SIZE_NOT_SUPPORTED
            goto L_0x00c4
        L_0x0071:
            d.b.a.c.za r1 = r7.f13205a
            d.b.d.h r1 = r1.mo22759d()
            d.b.d.h r2 = p019d.p143b.p150d.C7258h.f14103b
            if (r1 != r2) goto L_0x0095
            d.b.a.c.Da r1 = r7.f13207c
            d.b.b.b r1 = r1.f13179b
            d.b.a.c.Da r2 = r7.f13207c
            d.b.a.c.Aa r2 = r2.f13182e
            d.b.a.c.Da r3 = r7.f13207c
            d.b.a.c.c r3 = r3.f13180c
            android.content.Context r3 = r3.mo23068m()
            r1.mo23456a(r2, r3, r0)
            goto L_0x00cd
        L_0x0095:
            d.b.a.c.Da r0 = r7.f13207c
            d.b.d.l r0 = r0.f13181d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            d.b.a.c.za r2 = r7.f13205a
            r1.append(r2)
            r1.append(r3)
            d.b.a.c.za r2 = r7.f13205a
            d.b.d.h r2 = r2.mo22759d()
            r1.append(r2)
            java.lang.String r2 = " is not a supported ad type"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.mo22916b(r5, r1)
            d.b.a.c.Da r0 = r7.f13207c
            d.b.b.h r1 = p019d.p143b.p148b.C7245h.INTERNAL_AD_TYPE_NOT_SUPPORTED
        L_0x00c4:
            int r1 = r1.mo23471e()
            d.b.a.c.La r2 = r7.f13206b
            r0.m14642a(r1, r2)
        L_0x00cd:
            d.b.a.c.La r0 = r7.f13206b
            java.util.concurrent.atomic.AtomicBoolean r0 = r0.f13286c
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0187
            d.b.a.c.za r0 = r7.f13205a
            int r0 = r0.mo23449v()
            if (r0 != 0) goto L_0x010d
            d.b.a.c.Da r0 = r7.f13207c
            d.b.d.l r0 = r0.f13181d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failing ad "
            r1.append(r2)
            d.b.a.c.za r2 = r7.f13205a
            r1.append(r2)
            java.lang.String r2 = " since it has 0 timeout"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.mo22918c(r5, r1)
            d.b.a.c.Da r0 = r7.f13207c
            r1 = -5102(0xffffffffffffec12, float:NaN)
            d.b.a.c.La r2 = r7.f13206b
            r0.m14642a(r1, r2)
            goto L_0x0187
        L_0x010d:
            d.b.a.c.za r0 = r7.f13205a
            int r0 = r0.mo23449v()
            if (r0 <= 0) goto L_0x0166
            d.b.a.c.Da r0 = r7.f13207c
            d.b.d.l r0 = r0.f13181d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Setting timeout "
            r1.append(r2)
            d.b.a.c.za r2 = r7.f13205a
            int r2 = r2.mo23449v()
            r1.append(r2)
            java.lang.String r2 = " sec. for "
            r1.append(r2)
            d.b.a.c.za r2 = r7.f13205a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.mo22918c(r5, r1)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            d.b.a.c.za r1 = r7.f13205a
            int r1 = r1.mo23449v()
            long r1 = (long) r1
            long r0 = r0.toMillis(r1)
            d.b.a.c.Da r2 = r7.f13207c
            d.b.a.c.c r2 = r2.f13180c
            d.b.a.c.Sb r2 = r2.mo23027C()
            d.b.a.c.Ma r3 = new d.b.a.c.Ma
            d.b.a.c.Da r4 = r7.f13207c
            d.b.a.c.La r5 = r7.f13206b
            r6 = 0
            r3.<init>(r4, r5, r6)
            d.b.a.c.Tb r4 = p019d.p143b.p144a.p147c.C7113Tb.MAIN
            r2.mo22971a(r3, r4, r0)
            goto L_0x0187
        L_0x0166:
            d.b.a.c.Da r0 = r7.f13207c
            d.b.d.l r0 = r0.f13181d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Negative timeout set for "
            r1.append(r2)
            d.b.a.c.za r2 = r7.f13205a
            r1.append(r2)
            java.lang.String r2 = ", not scheduling a timeout"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.mo22918c(r5, r1)
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p019d.p143b.p144a.p147c.C7061Fa.run():void");
    }
}
