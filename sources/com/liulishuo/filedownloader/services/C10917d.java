package com.liulishuo.filedownloader.services;

import p019d.p307j.p308a.p309a.C13085b.C13087b;
import p019d.p307j.p308a.p312d.C13106b.C13107a;
import p019d.p307j.p308a.p313e.C13113c.C13114a;
import p019d.p307j.p308a.p313e.C13113c.C13115b;
import p019d.p307j.p308a.p313e.C13113c.C13116c;
import p019d.p307j.p308a.p313e.C13117d;
import p019d.p307j.p308a.p313e.C13119f;

/* renamed from: com.liulishuo.filedownloader.services.d */
/* compiled from: DownloadMgrInitialParams */
public class C10917d {

    /* renamed from: a */
    private final C10918a f33357a;

    /* renamed from: com.liulishuo.filedownloader.services.d$a */
    /* compiled from: DownloadMgrInitialParams */
    public static class C10918a {

        /* renamed from: a */
        C13115b f33358a;

        /* renamed from: b */
        Integer f33359b;

        /* renamed from: c */
        C13116c f33360c;

        /* renamed from: d */
        C13114a f33361d;

        /* renamed from: a */
        public C10918a mo35775a(C13114a creator) {
            this.f33361d = creator;
            return this;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public void m35830a() {
            C13116c cVar = this.f33360c;
            if (cVar != null && !cVar.mo42091a() && !C13119f.m42785a().f40145f) {
                throw new IllegalArgumentException("Since the provided FileDownloadOutputStream does not support the seek function, if FileDownloader pre-allocates file size at the beginning of the download, it will can not be resumed from the breakpoint. If you need to ensure that the resumption is available, please add and set the value of 'file.non-pre-allocation' field to 'true' in the 'filedownloader.properties' file which is in your application assets folder manually for resolving this problem.");
            }
        }
    }

    public C10917d(C10918a maker) {
        this.f33357a = maker;
        if (maker != null) {
            maker.m35830a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: d */
    public int mo35774d() {
        C10918a aVar = this.f33357a;
        if (aVar == null) {
            return m35825h();
        }
        Integer customizeMaxNetworkThreadCount = aVar.f33359b;
        if (customizeMaxNetworkThreadCount == null) {
            return m35825h();
        }
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "initial FileDownloader manager with the customize maxNetworkThreadCount: %d", customizeMaxNetworkThreadCount);
        }
        return C13119f.m42784a(customizeMaxNetworkThreadCount.intValue());
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public C10922g mo35772b() {
        C10918a aVar = this.f33357a;
        if (aVar != null) {
            C13115b bVar = aVar.f33358a;
            if (bVar != null) {
                C10922g customDatabase = bVar.mo42093a();
                if (customDatabase == null) {
                    return m35823f();
                }
                if (C13117d.f40139a) {
                    C13117d.m42778a(this, "initial FileDownloader manager with the customize database: %s", customDatabase);
                }
                return customDatabase;
            }
        }
        return m35823f();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: c */
    public C13116c mo35773c() {
        C10918a aVar = this.f33357a;
        if (aVar == null) {
            return m35824g();
        }
        C13116c outputStreamCreator = aVar.f33360c;
        if (outputStreamCreator == null) {
            return m35824g();
        }
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "initial FileDownloader manager with the customize output stream: %s", outputStreamCreator);
        }
        return outputStreamCreator;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public C13114a mo35771a() {
        C10918a aVar = this.f33357a;
        if (aVar == null) {
            return m35822e();
        }
        C13114a connectionCreator = aVar.f33361d;
        if (connectionCreator == null) {
            return m35822e();
        }
        if (C13117d.f40139a) {
            C13117d.m42778a(this, "initial FileDownloader manager with the customize connection creator: %s", connectionCreator);
        }
        return connectionCreator;
    }

    /* renamed from: h */
    private int m35825h() {
        return C13119f.m42785a().f40144e;
    }

    /* renamed from: f */
    private C10922g m35823f() {
        return new C10915b();
    }

    /* renamed from: g */
    private C13116c m35824g() {
        return new C13107a();
    }

    /* renamed from: e */
    private C13114a m35822e() {
        return new C13087b();
    }
}
