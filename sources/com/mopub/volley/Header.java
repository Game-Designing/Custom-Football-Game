package com.mopub.volley;

import android.text.TextUtils;

public final class Header {

    /* renamed from: a */
    private final String f36425a;

    /* renamed from: b */
    private final String f36426b;

    public Header(String name, String value) {
        this.f36425a = name;
        this.f36426b = value;
    }

    public final String getName() {
        return this.f36425a;
    }

    public final String getValue() {
        return this.f36426b;
    }

    public boolean equals(Object o) {
        boolean z = true;
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Header header = (Header) o;
        if (!TextUtils.equals(this.f36425a, header.f36425a) || !TextUtils.equals(this.f36426b, header.f36426b)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        return (this.f36425a.hashCode() * 31) + this.f36426b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Header[name=");
        sb.append(this.f36425a);
        sb.append(",value=");
        sb.append(this.f36426b);
        sb.append("]");
        return sb.toString();
    }
}
