package p019d.p273h.p276c.p280d;

/* renamed from: d.h.c.d.c */
/* compiled from: IronSourceLogger */
public abstract class C12800c {

    /* renamed from: a */
    int f39407a;

    /* renamed from: b */
    private String f39408b;

    /* renamed from: d.h.c.d.c$a */
    /* compiled from: IronSourceLogger */
    public enum C12801a {
        API,
        ADAPTER_API,
        CALLBACK,
        ADAPTER_CALLBACK,
        NETWORK,
        INTERNAL,
        NATIVE,
        EVENT
    }

    /* renamed from: a */
    public abstract void mo41426a(C12801a aVar, String str, Throwable th);

    /* renamed from: b */
    public abstract void mo41427b(C12801a aVar, String str, int i);

    C12800c(String loggerName) {
        this.f39408b = loggerName;
        this.f39407a = 0;
    }

    C12800c(String loggerName, int debugLevel) {
        this.f39408b = loggerName;
        this.f39407a = debugLevel;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public String mo41433b() {
        return this.f39408b;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public int mo41431a() {
        return this.f39407a;
    }

    /* renamed from: a */
    public void mo41432a(int debugLevel) {
        this.f39407a = debugLevel;
    }

    public boolean equals(Object other) {
        boolean z = false;
        if (other == null || !(other instanceof C12800c)) {
            return false;
        }
        C12800c otherLogger = (C12800c) other;
        String str = this.f39408b;
        if (str != null && str.equals(otherLogger.f39408b)) {
            z = true;
        }
        return z;
    }
}
