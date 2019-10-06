package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import p362h.C14180B;
import p362h.C14193h;
import p362h.C14195j;
import p362h.C14205t;

public abstract class RequestBody {
    public abstract MediaType contentType();

    public abstract void writeTo(C14193h hVar) throws IOException;

    public long contentLength() throws IOException {
        return -1;
    }

    public static RequestBody create(MediaType contentType, String content) {
        Charset charset = Util.UTF_8;
        if (contentType != null) {
            charset = contentType.charset();
            if (charset == null) {
                charset = Util.UTF_8;
                StringBuilder sb = new StringBuilder();
                sb.append(contentType);
                sb.append("; charset=utf-8");
                contentType = MediaType.parse(sb.toString());
            }
        }
        return create(contentType, content.getBytes(charset));
    }

    public static RequestBody create(final MediaType contentType, final C14195j content) {
        return new RequestBody() {
            public MediaType contentType() {
                return MediaType.this;
            }

            public long contentLength() throws IOException {
                return (long) content.mo44285s();
            }

            public void writeTo(C14193h sink) throws IOException {
                sink.mo44207a(content);
            }
        };
    }

    public static RequestBody create(MediaType contentType, byte[] content) {
        return create(contentType, content, 0, content.length);
    }

    public static RequestBody create(final MediaType contentType, final byte[] content, final int offset, final int byteCount) {
        if (content != null) {
            Util.checkOffsetAndCount((long) content.length, (long) offset, (long) byteCount);
            return new RequestBody() {
                public MediaType contentType() {
                    return MediaType.this;
                }

                public long contentLength() {
                    return (long) byteCount;
                }

                public void writeTo(C14193h sink) throws IOException {
                    sink.write(content, offset, byteCount);
                }
            };
        }
        throw new NullPointerException("content == null");
    }

    public static RequestBody create(final MediaType contentType, final File file) {
        if (file != null) {
            return new RequestBody() {
                public MediaType contentType() {
                    return MediaType.this;
                }

                public long contentLength() {
                    return file.length();
                }

                public void writeTo(C14193h sink) throws IOException {
                    C14180B source = null;
                    try {
                        source = C14205t.m45687c(file);
                        sink.mo44203a(source);
                    } finally {
                        Util.closeQuietly((Closeable) source);
                    }
                }
            };
        }
        throw new NullPointerException("content == null");
    }
}
