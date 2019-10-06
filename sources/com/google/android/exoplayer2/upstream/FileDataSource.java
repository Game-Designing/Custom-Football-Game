package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class FileDataSource extends C8484f {

    /* renamed from: e */
    private RandomAccessFile f18594e;

    /* renamed from: f */
    private Uri f18595f;

    /* renamed from: g */
    private long f18596g;

    /* renamed from: h */
    private boolean f18597h;

    public static class FileDataSourceException extends IOException {
        public FileDataSourceException(IOException cause) {
            super(cause);
        }
    }

    public FileDataSource() {
        super(false);
    }

    /* renamed from: a */
    public long mo25917a(C8489j dataSpec) throws FileDataSourceException {
        try {
            this.f18595f = dataSpec.f18714a;
            mo26014b(dataSpec);
            this.f18594e = new RandomAccessFile(dataSpec.f18714a.getPath(), "r");
            this.f18594e.seek(dataSpec.f18719f);
            this.f18596g = dataSpec.f18720g == -1 ? this.f18594e.length() - dataSpec.f18719f : dataSpec.f18720g;
            if (this.f18596g >= 0) {
                this.f18597h = true;
                mo26015c(dataSpec);
                return this.f18596g;
            }
            throw new EOFException();
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    public int read(byte[] buffer, int offset, int readLength) throws FileDataSourceException {
        if (readLength == 0) {
            return 0;
        }
        long j = this.f18596g;
        if (j == 0) {
            return -1;
        }
        try {
            int bytesRead = this.f18594e.read(buffer, offset, (int) Math.min(j, (long) readLength));
            if (bytesRead > 0) {
                this.f18596g -= (long) bytesRead;
                mo26012a(bytesRead);
            }
            return bytesRead;
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        }
    }

    public Uri getUri() {
        return this.f18595f;
    }

    public void close() throws FileDataSourceException {
        this.f18595f = null;
        try {
            if (this.f18594e != null) {
                this.f18594e.close();
            }
            this.f18594e = null;
            if (this.f18597h) {
                this.f18597h = false;
                mo26013b();
            }
        } catch (IOException e) {
            throw new FileDataSourceException(e);
        } catch (Throwable th) {
            this.f18594e = null;
            if (this.f18597h) {
                this.f18597h = false;
                mo26013b();
            }
            throw th;
        }
    }
}
