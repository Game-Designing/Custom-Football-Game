package p019d.p314k.p315a;

/* renamed from: d.k.a.b */
/* compiled from: ErrorUtils */
final class C13156b {
    /* renamed from: a */
    static int m42970a(String message) {
        if (message == null) {
            return -101;
        }
        if (message.equalsIgnoreCase("FNC") || message.equalsIgnoreCase("open failed: ENOENT (No such file or directory)")) {
            return -102;
        }
        if (message.equalsIgnoreCase("TI")) {
            return -103;
        }
        if (message.equalsIgnoreCase("DIE")) {
            return -118;
        }
        if (message.equalsIgnoreCase("recvfrom failed: ETIMEDOUT (Connection timed out)") || message.equalsIgnoreCase("timeout")) {
            return -104;
        }
        if (message.equalsIgnoreCase("java.io.IOException: 404") || message.contains("No address associated with hostname")) {
            return -106;
        }
        if (message.contains("Unable to resolve host")) {
            return -105;
        }
        if (message.equalsIgnoreCase("open failed: EACCES (Permission denied)")) {
            return -107;
        }
        if (message.equalsIgnoreCase("write failed: ENOSPC (No space left on device)") || message.equalsIgnoreCase("database or disk is full (code 13)")) {
            return -108;
        }
        if (message.contains("SSRV:")) {
            return -110;
        }
        if (message.contains("column _file_path is not unique")) {
            return -113;
        }
        return -101;
    }
}
