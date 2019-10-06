package okhttp3;

import java.nio.charset.Charset;
import okhttp3.internal.Util;

public final class Challenge {
    private final Charset charset;
    private final String realm;
    private final String scheme;

    public Challenge(String scheme2, String realm2) {
        this(scheme2, realm2, Util.ISO_8859_1);
    }

    private Challenge(String scheme2, String realm2, Charset charset2) {
        if (scheme2 == null) {
            throw new NullPointerException("scheme == null");
        } else if (realm2 == null) {
            throw new NullPointerException("realm == null");
        } else if (charset2 != null) {
            this.scheme = scheme2;
            this.realm = realm2;
            this.charset = charset2;
        } else {
            throw new NullPointerException("charset == null");
        }
    }

    public Challenge withCharset(Charset charset2) {
        return new Challenge(this.scheme, this.realm, charset2);
    }

    public String scheme() {
        return this.scheme;
    }

    public String realm() {
        return this.realm;
    }

    public Charset charset() {
        return this.charset;
    }

    public boolean equals(Object other) {
        return (other instanceof Challenge) && ((Challenge) other).scheme.equals(this.scheme) && ((Challenge) other).realm.equals(this.realm) && ((Challenge) other).charset.equals(this.charset);
    }

    public int hashCode() {
        return (((((29 * 31) + this.realm.hashCode()) * 31) + this.scheme.hashCode()) * 31) + this.charset.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.scheme);
        sb.append(" realm=\"");
        sb.append(this.realm);
        sb.append("\" charset=\"");
        sb.append(this.charset);
        sb.append("\"");
        return sb.toString();
    }
}
