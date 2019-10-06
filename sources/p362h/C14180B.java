package p362h;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: h.B */
/* compiled from: Source */
public interface C14180B extends Closeable {
    void close() throws IOException;

    long read(C14191g gVar, long j) throws IOException;

    C14182D timeout();
}
