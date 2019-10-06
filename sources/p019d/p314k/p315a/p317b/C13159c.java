package p019d.p314k.p315a.p317b;

import java.util.List;

/* renamed from: d.k.a.b.c */
/* compiled from: RequestInfo */
public final class C13159c {

    /* renamed from: a */
    private final long f40200a;

    /* renamed from: b */
    private final int f40201b;

    /* renamed from: c */
    private final String f40202c;

    /* renamed from: d */
    private final String f40203d;

    /* renamed from: e */
    private final int f40204e;

    /* renamed from: f */
    private final long f40205f;

    /* renamed from: g */
    private final long f40206g;

    /* renamed from: h */
    private final int f40207h;

    /* renamed from: i */
    private final List<C13157a> f40208i;

    /* renamed from: j */
    private final int f40209j;

    public C13159c(long id, int status, String url, String filePath, int progress, long downloadedBytes, long fileSize, int error, List<C13157a> headers, int priority) {
        if (url == null) {
            throw new NullPointerException("Url cannot be null");
        } else if (filePath == null) {
            throw new NullPointerException("FilePath cannot be null");
        } else if (headers != null) {
            this.f40200a = id;
            this.f40201b = status;
            this.f40202c = url;
            this.f40203d = filePath;
            this.f40204e = progress;
            this.f40205f = downloadedBytes;
            this.f40206g = fileSize;
            this.f40207h = error;
            this.f40208i = headers;
            this.f40209j = priority;
        } else {
            throw new NullPointerException("Headers cannot be null");
        }
    }

    /* renamed from: f */
    public long mo42205f() {
        return this.f40200a;
    }

    /* renamed from: h */
    public int mo42207h() {
        return this.f40201b;
    }

    /* renamed from: i */
    public String mo42208i() {
        return this.f40202c;
    }

    /* renamed from: c */
    public String mo42202c() {
        return this.f40203d;
    }

    /* renamed from: g */
    public int mo42206g() {
        return this.f40204e;
    }

    /* renamed from: a */
    public long mo42200a() {
        return this.f40205f;
    }

    /* renamed from: d */
    public long mo42203d() {
        return this.f40206g;
    }

    /* renamed from: b */
    public int mo42201b() {
        return this.f40207h;
    }

    /* renamed from: e */
    public List<C13157a> mo42204e() {
        return this.f40208i;
    }

    public String toString() {
        StringBuilder headerBuilder = new StringBuilder();
        for (C13157a header : this.f40208i) {
            headerBuilder.append(header.toString());
            headerBuilder.append(",");
        }
        if (this.f40208i.size() > 0) {
            headerBuilder.deleteCharAt(headerBuilder.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{id:");
        sb.append(this.f40200a);
        sb.append(",status:");
        sb.append(this.f40201b);
        sb.append(",url:");
        sb.append(this.f40202c);
        sb.append(",filePath:");
        sb.append(this.f40203d);
        sb.append(",progress:");
        sb.append(this.f40204e);
        sb.append(",fileSize:");
        sb.append(this.f40206g);
        sb.append(",error:");
        sb.append(this.f40207h);
        sb.append(",headers:{");
        sb.append(headerBuilder.toString());
        sb.append("},priority:");
        sb.append(this.f40209j);
        sb.append("}");
        return sb.toString();
    }
}
