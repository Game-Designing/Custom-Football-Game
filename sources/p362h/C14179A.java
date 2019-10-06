package p362h;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: h.A */
/* compiled from: Sink */
public interface C14179A extends Closeable, Flushable {
    void close() throws IOException;

    void flush() throws IOException;

    C14182D timeout();

    void write(C14191g gVar, long j) throws IOException;
}
