package p019d.p314k.p315a.p317b;

import android.net.Uri;
import com.mopub.common.Constants;
import com.tonyodev.fetch.request.Header;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p002b.p003c.p053g.p061f.C1253b;

/* renamed from: d.k.a.b.b */
/* compiled from: Request */
public final class C13158b {

    /* renamed from: a */
    private final String f40196a;

    /* renamed from: b */
    private final String f40197b;

    /* renamed from: c */
    private final Map<String, String> f40198c = new C1253b();

    /* renamed from: d */
    private int f40199d = 600;

    public C13158b(String url, String dir, String fileName) {
        if (url == null || url.isEmpty()) {
            throw new NullPointerException("Url cannot be null or empty");
        } else if (dir == null || dir.isEmpty()) {
            throw new NullPointerException("directory path cannot be null or empty");
        } else if (fileName == null || fileName.isEmpty()) {
            throw new NullPointerException("File Name cannot be null or empty");
        } else {
            String scheme = Uri.parse(url).getScheme();
            if (scheme == null || (!scheme.equals(Constants.HTTP) && !scheme.equals("https"))) {
                StringBuilder sb = new StringBuilder();
                sb.append("Can only download HTTP/HTTPS URIs: ");
                sb.append(url);
                throw new IllegalArgumentException(sb.toString());
            }
            this.f40196a = url;
            this.f40197b = m42973a(m42974a(dir, fileName));
        }
    }

    /* renamed from: d */
    public String mo42198d() {
        return this.f40196a;
    }

    /* renamed from: a */
    public String mo42195a() {
        return this.f40197b;
    }

    /* renamed from: b */
    public List<C13157a> mo42196b() {
        List<Header> headerList = new ArrayList<>(this.f40198c.size());
        for (String key : this.f40198c.keySet()) {
            headerList.add(new C13157a(key, (String) this.f40198c.get(key)));
        }
        return headerList;
    }

    /* renamed from: c */
    public int mo42197c() {
        return this.f40199d;
    }

    public String toString() {
        StringBuilder headerBuilder = new StringBuilder();
        Iterator it = mo42196b().iterator();
        while (it.hasNext()) {
            headerBuilder.append(((C13157a) it.next()).toString());
            headerBuilder.append(",");
        }
        if (this.f40198c.size() > 0) {
            headerBuilder.deleteCharAt(headerBuilder.length() - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{url:");
        sb.append(this.f40196a);
        sb.append(" ,filePath:");
        sb.append(this.f40197b);
        sb.append(",headers:{");
        sb.append(headerBuilder.toString());
        sb.append("},priority:");
        sb.append(this.f40199d);
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: a */
    private static String m42974a(String parentDir, String fileName) {
        if (Uri.parse(fileName).getPathSegments().size() != 1) {
            return fileName;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(parentDir);
        sb.append("/");
        sb.append(fileName);
        return sb.toString();
    }

    /* renamed from: a */
    private static String m42973a(String string) {
        return string.replace("//", "/");
    }
}
