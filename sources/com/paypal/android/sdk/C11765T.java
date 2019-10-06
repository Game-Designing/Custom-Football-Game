package com.paypal.android.sdk;

import android.os.Message;

/* renamed from: com.paypal.android.sdk.T */
public class C11765T implements C11707Ba {

    /* renamed from: a */
    private static final String f37027a = C11765T.class.getSimpleName();

    /* renamed from: b */
    private final C11788a f37028b;

    /* renamed from: c */
    private final C11762S f37029c;

    /* renamed from: d */
    private final C11777X f37030d = new C11777X();

    /* renamed from: e */
    private final C11768U f37031e = new C11768U(this);

    /* renamed from: f */
    private C12019wa f37032f;

    public C11765T(C11788a aVar, C11762S s, C11706B b) {
        this.f37028b = aVar;
        this.f37029c = s;
    }

    /* renamed from: a */
    public final String mo38528a(C12027ya yaVar) {
        StringBuilder sb = new StringBuilder("mEnvironment:");
        sb.append(this.f37029c);
        sb.append(" mEnvironment.getEndpoints():");
        sb.append(this.f37029c.mo38624c());
        C11762S s = this.f37029c;
        if (s == null || s.mo38624c() == null) {
            return null;
        }
        String str = (String) this.f37029c.mo38624c().get(yaVar.mo38569a());
        new StringBuilder("returning:").append(str);
        return str;
    }

    /* renamed from: a */
    public final void mo38626a() {
        this.f37032f.mo39206a();
    }

    /* renamed from: a */
    public final void mo38529a(C11703Aa aa) {
        aa.mo38514l();
        C12010u.m39718a().mo39197f();
        if (!aa.mo38502a()) {
            Message message = new Message();
            message.what = 2;
            message.obj = aa;
            this.f37031e.sendMessage(message);
        }
    }

    /* renamed from: a */
    public final void mo38627a(C11783Z z) {
        this.f37030d.mo38649a(z);
    }

    /* renamed from: a */
    public final void mo38628a(C12019wa waVar) {
        if (this.f37032f == null) {
            this.f37032f = waVar;
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    public final void mo38629b() {
        this.f37030d.mo38647a();
    }

    /* renamed from: b */
    public final void mo38630b(C11703Aa aa) {
        this.f37032f.mo39207a(aa);
    }

    /* renamed from: c */
    public final String mo38530c() {
        return this.f37029c.mo38622a();
    }

    /* renamed from: d */
    public final C11788a mo38531d() {
        return this.f37028b;
    }

    /* renamed from: e */
    public final String mo38532e() {
        return this.f37029c.mo38623b();
    }
}
