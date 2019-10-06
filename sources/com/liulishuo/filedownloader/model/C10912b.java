package com.liulishuo.filedownloader.model;

import android.content.ContentValues;
import p019d.p307j.p308a.p313e.C13121g;

/* renamed from: com.liulishuo.filedownloader.model.b */
/* compiled from: FileDownloadModel */
public class C10912b {

    /* renamed from: a */
    private int f33337a;

    /* renamed from: b */
    private String f33338b;

    /* renamed from: c */
    private String f33339c;

    /* renamed from: d */
    private boolean f33340d;

    /* renamed from: e */
    private String f33341e;

    /* renamed from: f */
    private byte f33342f;

    /* renamed from: g */
    private long f33343g;

    /* renamed from: h */
    private long f33344h;

    /* renamed from: i */
    private String f33345i;

    /* renamed from: j */
    private String f33346j;

    /* renamed from: k */
    private boolean f33347k;

    /* renamed from: a */
    public void mo35721a(int id) {
        this.f33337a = id;
    }

    /* renamed from: d */
    public void mo35731d(String url) {
        this.f33338b = url;
    }

    /* renamed from: a */
    public void mo35724a(String path, boolean pathAsDirectory) {
        this.f33339c = path;
        this.f33340d = pathAsDirectory;
    }

    /* renamed from: a */
    public void mo35720a(byte status) {
        this.f33342f = status;
    }

    /* renamed from: a */
    public void mo35722a(long soFar) {
        this.f33343g = soFar;
    }

    /* renamed from: b */
    public void mo35726b(long total) {
        this.f33347k = total > 2147483647L;
        this.f33344h = total;
    }

    /* renamed from: d */
    public int mo35730d() {
        return this.f33337a;
    }

    /* renamed from: k */
    public String mo35738k() {
        return this.f33338b;
    }

    /* renamed from: e */
    public String mo35732e() {
        return this.f33339c;
    }

    /* renamed from: h */
    public String mo35735h() {
        return C13121g.m42791a(mo35732e(), mo35740m(), mo35728c());
    }

    /* renamed from: i */
    public String mo35736i() {
        if (mo35735h() == null) {
            return null;
        }
        return C13121g.m42808g(mo35735h());
    }

    /* renamed from: g */
    public byte mo35734g() {
        return this.f33342f;
    }

    /* renamed from: f */
    public long mo35733f() {
        return this.f33343g;
    }

    /* renamed from: j */
    public long mo35737j() {
        return this.f33344h;
    }

    /* renamed from: a */
    public String mo35719a() {
        return this.f33346j;
    }

    /* renamed from: a */
    public void mo35723a(String eTag) {
        this.f33346j = eTag;
    }

    /* renamed from: b */
    public String mo35725b() {
        return this.f33345i;
    }

    /* renamed from: b */
    public void mo35727b(String errMsg) {
        this.f33345i = errMsg;
    }

    /* renamed from: c */
    public void mo35729c(String filename) {
        this.f33341e = filename;
    }

    /* renamed from: m */
    public boolean mo35740m() {
        return this.f33340d;
    }

    /* renamed from: c */
    public String mo35728c() {
        return this.f33341e;
    }

    /* renamed from: n */
    public ContentValues mo35741n() {
        ContentValues cv = new ContentValues();
        cv.put("_id", Integer.valueOf(mo35730d()));
        cv.put("url", mo35738k());
        cv.put("path", mo35732e());
        cv.put("status", Byte.valueOf(mo35734g()));
        cv.put("sofar", Long.valueOf(mo35733f()));
        cv.put("total", Long.valueOf(mo35737j()));
        cv.put("errMsg", mo35725b());
        cv.put("etag", mo35719a());
        cv.put("pathAsDirectory", Boolean.valueOf(mo35740m()));
        if (mo35740m() && mo35728c() != null) {
            cv.put("filename", mo35728c());
        }
        return cv;
    }

    /* renamed from: l */
    public boolean mo35739l() {
        return this.f33347k;
    }

    public String toString() {
        return C13121g.m42792a("id[%d], url[%s], path[%s], status[%d], sofar[%d], total[%d], etag[%s], %s", Integer.valueOf(this.f33337a), this.f33338b, this.f33339c, Byte.valueOf(this.f33342f), Long.valueOf(this.f33343g), Long.valueOf(this.f33344h), this.f33346j, super.toString());
    }
}
