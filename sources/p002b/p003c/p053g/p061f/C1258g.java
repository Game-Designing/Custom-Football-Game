package p002b.p003c.p053g.p061f;

import android.util.Log;
import java.io.Writer;

/* renamed from: b.c.g.f.g */
/* compiled from: LogWriter */
public class C1258g extends Writer {

    /* renamed from: a */
    private final String f4039a;

    /* renamed from: b */
    private StringBuilder f4040b = new StringBuilder(128);

    public C1258g(String tag) {
        this.f4039a = tag;
    }

    public void close() {
        m5914a();
    }

    public void flush() {
        m5914a();
    }

    public void write(char[] buf, int offset, int count) {
        for (int i = 0; i < count; i++) {
            char c = buf[offset + i];
            if (c == 10) {
                m5914a();
            } else {
                this.f4040b.append(c);
            }
        }
    }

    /* renamed from: a */
    private void m5914a() {
        if (this.f4040b.length() > 0) {
            Log.d(this.f4039a, this.f4040b.toString());
            StringBuilder sb = this.f4040b;
            sb.delete(0, sb.length());
        }
    }
}
