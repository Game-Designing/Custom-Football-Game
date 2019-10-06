package com.bumptech.glide.load.p111b;

import android.text.TextUtils;
import com.bumptech.glide.load.model.LazyHeaderFactory;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.bumptech.glide.load.b.p */
/* compiled from: LazyHeaders */
public final class C6118p implements C6116n {

    /* renamed from: a */
    private final Map<String, List<C6117o>> f10795a;

    /* renamed from: b */
    private volatile Map<String, String> f10796b;

    /* renamed from: com.bumptech.glide.load.b.p$a */
    /* compiled from: LazyHeaders */
    public static final class C6119a {

        /* renamed from: a */
        private static final String f10797a = m11550b();

        /* renamed from: b */
        private static final Map<String, List<C6117o>> f10798b;

        /* renamed from: c */
        private boolean f10799c = true;

        /* renamed from: d */
        private Map<String, List<C6117o>> f10800d = f10798b;

        /* renamed from: e */
        private boolean f10801e = true;

        static {
            Map<String, List<LazyHeaderFactory>> temp = new HashMap<>(2);
            if (!TextUtils.isEmpty(f10797a)) {
                temp.put("User-Agent", Collections.singletonList(new C6120b(f10797a)));
            }
            f10798b = Collections.unmodifiableMap(temp);
        }

        /* renamed from: a */
        public C6118p mo18939a() {
            this.f10799c = true;
            return new C6118p(this.f10800d);
        }

        /* renamed from: b */
        static String m11550b() {
            String defaultUserAgent = System.getProperty("http.agent");
            if (TextUtils.isEmpty(defaultUserAgent)) {
                return defaultUserAgent;
            }
            int length = defaultUserAgent.length();
            StringBuilder sb = new StringBuilder(defaultUserAgent.length());
            for (int i = 0; i < length; i++) {
                char c = defaultUserAgent.charAt(i);
                if ((c > 31 || c == 9) && c < 127) {
                    sb.append(c);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }
    }

    /* renamed from: com.bumptech.glide.load.b.p$b */
    /* compiled from: LazyHeaders */
    static final class C6120b implements C6117o {

        /* renamed from: a */
        private final String f10802a;

        C6120b(String value) {
            this.f10802a = value;
        }

        /* renamed from: a */
        public String mo18935a() {
            return this.f10802a;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StringHeaderFactory{value='");
            sb.append(this.f10802a);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }

        public boolean equals(Object o) {
            if (!(o instanceof C6120b)) {
                return false;
            }
            return this.f10802a.equals(((C6120b) o).f10802a);
        }

        public int hashCode() {
            return this.f10802a.hashCode();
        }
    }

    C6118p(Map<String, List<C6117o>> headers) {
        this.f10795a = Collections.unmodifiableMap(headers);
    }

    /* renamed from: a */
    public Map<String, String> mo18934a() {
        if (this.f10796b == null) {
            synchronized (this) {
                if (this.f10796b == null) {
                    this.f10796b = Collections.unmodifiableMap(m11548b());
                }
            }
        }
        return this.f10796b;
    }

    /* renamed from: b */
    private Map<String, String> m11548b() {
        Map<String, String> combinedHeaders = new HashMap<>();
        for (Entry<String, List<LazyHeaderFactory>> entry : this.f10795a.entrySet()) {
            String values = m11547a((List) entry.getValue());
            if (!TextUtils.isEmpty(values)) {
                combinedHeaders.put(entry.getKey(), values);
            }
        }
        return combinedHeaders;
    }

    /* renamed from: a */
    private String m11547a(List<C6117o> factories) {
        StringBuilder sb = new StringBuilder();
        int size = factories.size();
        for (int i = 0; i < size; i++) {
            String header = ((C6117o) factories.get(i)).mo18935a();
            if (!TextUtils.isEmpty(header)) {
                sb.append(header);
                if (i != factories.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LazyHeaders{headers=");
        sb.append(this.f10795a);
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object o) {
        if (!(o instanceof C6118p)) {
            return false;
        }
        return this.f10795a.equals(((C6118p) o).f10795a);
    }

    public int hashCode() {
        return this.f10795a.hashCode();
    }
}
