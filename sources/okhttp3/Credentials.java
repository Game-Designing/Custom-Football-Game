package okhttp3;

import java.nio.charset.Charset;
import okhttp3.internal.Util;
import p362h.C14195j;

public final class Credentials {
    private Credentials() {
    }

    public static String basic(String username, String password) {
        return basic(username, password, Util.ISO_8859_1);
    }

    public static String basic(String username, String password, Charset charset) {
        StringBuilder sb = new StringBuilder();
        sb.append(username);
        sb.append(":");
        sb.append(password);
        String encoded = C14195j.m45646a(sb.toString(), charset).mo44278e();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Basic ");
        sb2.append(encoded);
        return sb2.toString();
    }
}
