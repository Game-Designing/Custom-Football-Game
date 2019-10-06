package p024io.fabric.sdk.android.services.network;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: io.fabric.sdk.android.services.network.e */
/* compiled from: HttpRequest */
class C13969e extends C13961a<HttpRequest> {

    /* renamed from: c */
    final /* synthetic */ InputStream f42342c;

    /* renamed from: d */
    final /* synthetic */ OutputStream f42343d;

    /* renamed from: e */
    final /* synthetic */ HttpRequest f42344e;

    C13969e(HttpRequest this$0, Closeable closeable, boolean ignoreCloseExceptions, InputStream inputStream, OutputStream outputStream) {
        this.f42344e = this$0;
        this.f42342c = inputStream;
        this.f42343d = outputStream;
        super(closeable, ignoreCloseExceptions);
    }

    /* renamed from: b */
    public HttpRequest m44434b() throws IOException {
        byte[] buffer = new byte[this.f42344e.f42325j];
        while (true) {
            int read = this.f42342c.read(buffer);
            int read2 = read;
            if (read == -1) {
                return this.f42344e;
            }
            this.f42343d.write(buffer, 0, read2);
        }
    }
}
