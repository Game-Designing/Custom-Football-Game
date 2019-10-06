package com.ironsource.sdk.data;

/* renamed from: com.ironsource.sdk.data.i */
/* compiled from: SSAFile */
public class C10896i extends C10897j {

    /* renamed from: b */
    private String f33274b = "file";

    /* renamed from: c */
    private String f33275c = "path";

    /* renamed from: d */
    private String f33276d = "lastUpdateTime";

    /* renamed from: e */
    private String f33277e;

    /* renamed from: f */
    private String f33278f;

    /* renamed from: g */
    private String f33279g;

    /* renamed from: h */
    private String f33280h;

    public C10896i(String value) {
        super(value);
        if (mo35670a(this.f33274b)) {
            m35660h(mo35673d(this.f33274b));
        }
        if (mo35670a(this.f33275c)) {
            m35661i(mo35673d(this.f33275c));
        }
        if (mo35670a(this.f33276d)) {
            mo35665g(mo35673d(this.f33276d));
        }
    }

    public C10896i(String file, String path) {
        m35660h(file);
        m35661i(path);
    }

    /* renamed from: c */
    public String mo35662c() {
        return this.f33277e;
    }

    /* renamed from: h */
    private void m35660h(String file) {
        this.f33277e = file;
    }

    /* renamed from: i */
    private void m35661i(String path) {
        this.f33278f = path;
    }

    /* renamed from: e */
    public String mo35664e() {
        return this.f33278f;
    }

    /* renamed from: f */
    public void mo35640f(String errMsg) {
        this.f33279g = errMsg;
    }

    /* renamed from: b */
    public String mo35661b() {
        return this.f33279g;
    }

    /* renamed from: g */
    public void mo35665g(String lastUpdateTime) {
        this.f33280h = lastUpdateTime;
    }

    /* renamed from: d */
    public String mo35663d() {
        return this.f33280h;
    }
}
