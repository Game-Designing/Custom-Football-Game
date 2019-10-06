package p362h;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: h.s */
/* compiled from: Okio */
class C14204s extends C14186c {

    /* renamed from: a */
    final /* synthetic */ Socket f43100a;

    C14204s(Socket socket) {
        this.f43100a = socket;
    }

    /* access modifiers changed from: protected */
    public IOException newTimeoutException(IOException cause) {
        InterruptedIOException ioe = new SocketTimeoutException("timeout");
        if (cause != null) {
            ioe.initCause(cause);
        }
        return ioe;
    }

    /* access modifiers changed from: protected */
    public void timedOut() {
        String str = "Failed to close timed out socket ";
        try {
            this.f43100a.close();
        } catch (Exception e) {
            Logger logger = C14205t.f43101a;
            Level level = Level.WARNING;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(this.f43100a);
            logger.log(level, sb.toString(), e);
        } catch (AssertionError e2) {
            if (C14205t.m45684a(e2)) {
                Logger logger2 = C14205t.f43101a;
                Level level2 = Level.WARNING;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(this.f43100a);
                logger2.log(level2, sb2.toString(), e2);
                return;
            }
            throw e2;
        }
    }
}
