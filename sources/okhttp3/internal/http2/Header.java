package okhttp3.internal.http2;

import okhttp3.internal.Util;
import p362h.C14195j;

public final class Header {
    public static final C14195j PSEUDO_PREFIX = C14195j.m45649c(":");
    public static final C14195j RESPONSE_STATUS = C14195j.m45649c(":status");
    public static final C14195j TARGET_AUTHORITY = C14195j.m45649c(":authority");
    public static final C14195j TARGET_METHOD = C14195j.m45649c(":method");
    public static final C14195j TARGET_PATH = C14195j.m45649c(":path");
    public static final C14195j TARGET_SCHEME = C14195j.m45649c(":scheme");
    final int hpackSize;
    public final C14195j name;
    public final C14195j value;

    public Header(String name2, String value2) {
        this(C14195j.m45649c(name2), C14195j.m45649c(value2));
    }

    public Header(C14195j name2, String value2) {
        this(name2, C14195j.m45649c(value2));
    }

    public Header(C14195j name2, C14195j value2) {
        this.name = name2;
        this.value = value2;
        this.hpackSize = name2.mo44285s() + 32 + value2.mo44285s();
    }

    public boolean equals(Object other) {
        boolean z = false;
        if (!(other instanceof Header)) {
            return false;
        }
        Header that = (Header) other;
        if (this.name.equals(that.name) && this.value.equals(that.value)) {
            z = true;
        }
        return z;
    }

    public int hashCode() {
        return (((17 * 31) + this.name.hashCode()) * 31) + this.value.hashCode();
    }

    public String toString() {
        return Util.format("%s: %s", this.name.mo44289v(), this.value.mo44289v());
    }
}
