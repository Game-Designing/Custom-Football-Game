package com.airbnb.lottie.p089c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.airbnb.lottie.c.e */
/* compiled from: KeyPath */
public class C5776e {

    /* renamed from: a */
    private final List<String> f10062a;

    /* renamed from: b */
    private C5777f f10063b;

    public C5776e(String... keys) {
        this.f10062a = Arrays.asList(keys);
    }

    private C5776e(C5776e keyPath) {
        this.f10062a = new ArrayList(keyPath.f10062a);
        this.f10063b = keyPath.f10063b;
    }

    /* renamed from: a */
    public C5776e mo18119a(String key) {
        C5776e newKeyPath = new C5776e(this);
        newKeyPath.f10062a.add(key);
        return newKeyPath;
    }

    /* renamed from: a */
    public C5776e mo18118a(C5777f element) {
        C5776e keyPath = new C5776e(this);
        keyPath.f10063b = element;
        return keyPath;
    }

    /* renamed from: a */
    public C5777f mo18120a() {
        return this.f10063b;
    }

    /* renamed from: c */
    public boolean mo18123c(String key, int depth) {
        if (m10385b(key)) {
            return true;
        }
        if (depth >= this.f10062a.size()) {
            return false;
        }
        if (((String) this.f10062a.get(depth)).equals(key) || ((String) this.f10062a.get(depth)).equals("**") || ((String) this.f10062a.get(depth)).equals("*")) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public int mo18122b(String key, int depth) {
        if (m10385b(key)) {
            return 0;
        }
        if (!((String) this.f10062a.get(depth)).equals("**")) {
            return 1;
        }
        if (depth != this.f10062a.size() - 1 && ((String) this.f10062a.get(depth + 1)).equals(key)) {
            return 2;
        }
        return 0;
    }

    /* renamed from: a */
    public boolean mo18121a(String key, int depth) {
        boolean z = false;
        if (depth >= this.f10062a.size()) {
            return false;
        }
        boolean isLastDepth = depth == this.f10062a.size() - 1;
        String keyAtDepth = (String) this.f10062a.get(depth);
        if (!keyAtDepth.equals("**")) {
            boolean matches = keyAtDepth.equals(key) || keyAtDepth.equals("*");
            if ((isLastDepth || (depth == this.f10062a.size() - 2 && m10384b())) && matches) {
                z = true;
            }
            return z;
        }
        if (!isLastDepth && ((String) this.f10062a.get(depth + 1)).equals(key)) {
            if (depth == this.f10062a.size() - 2 || (depth == this.f10062a.size() - 3 && m10384b())) {
                z = true;
            }
            return z;
        } else if (isLastDepth) {
            return true;
        } else {
            if (depth + 1 < this.f10062a.size() - 1) {
                return false;
            }
            return ((String) this.f10062a.get(depth + 1)).equals(key);
        }
    }

    /* renamed from: d */
    public boolean mo18124d(String key, int depth) {
        boolean z = true;
        if (key.equals("__container")) {
            return true;
        }
        if (depth >= this.f10062a.size() - 1 && !((String) this.f10062a.get(depth)).equals("**")) {
            z = false;
        }
        return z;
    }

    /* renamed from: b */
    private boolean m10385b(String key) {
        return key.equals("__container");
    }

    /* renamed from: b */
    private boolean m10384b() {
        List<String> list = this.f10062a;
        return ((String) list.get(list.size() - 1)).equals("**");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KeyPath{keys=");
        sb.append(this.f10062a);
        sb.append(",resolved=");
        sb.append(this.f10063b != null);
        sb.append('}');
        return sb.toString();
    }
}
