package p019d.p307j.p308a.p312d;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import p019d.p307j.p308a.p313e.C13113c.C13116c;

/* renamed from: d.j.a.d.b */
/* compiled from: FileDownloadRandomAccessFile */
public class C13106b implements C13105a {

    /* renamed from: a */
    private final RandomAccessFile f40119a;

    /* renamed from: d.j.a.d.b$a */
    /* compiled from: FileDownloadRandomAccessFile */
    public static class C13107a implements C13116c {
        /* renamed from: a */
        public C13105a mo42090a(File file) throws FileNotFoundException {
            return new C13106b(file);
        }

        /* renamed from: a */
        public boolean mo42091a() {
            return true;
        }
    }

    C13106b(File file) throws FileNotFoundException {
        this.f40119a = new RandomAccessFile(file, "rw");
    }

    public void write(byte[] b, int off, int len) throws IOException {
        this.f40119a.write(b, off, len);
    }

    /* renamed from: a */
    public void mo42085a() throws IOException {
        this.f40119a.getFD().sync();
    }

    public void close() throws IOException {
        this.f40119a.close();
    }

    /* renamed from: b */
    public void mo42087b(long offset) throws IOException {
        this.f40119a.seek(offset);
    }

    /* renamed from: a */
    public void mo42086a(long totalBytes) throws IOException {
        this.f40119a.setLength(totalBytes);
    }
}
