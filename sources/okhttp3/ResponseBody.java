package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import okhttp3.internal.Util;
import p362h.C14191g;
import p362h.C14194i;

public abstract class ResponseBody implements Closeable {
    private Reader reader;

    static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final C14194i source;

        BomAwareReader(C14194i source2, Charset charset2) {
            this.source = source2;
            this.charset = charset2;
        }

        public int read(char[] cbuf, int off, int len) throws IOException {
            if (!this.closed) {
                Reader delegate2 = this.delegate;
                if (delegate2 == null) {
                    Reader inputStreamReader = new InputStreamReader(this.source.mo44258u(), Util.bomAwareCharset(this.source, this.charset));
                    this.delegate = inputStreamReader;
                    delegate2 = inputStreamReader;
                }
                return delegate2.read(cbuf, off, len);
            }
            throw new IOException("Stream closed");
        }

        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract C14194i source();

    public final InputStream byteStream() {
        return source().mo44258u();
    }

    /* JADX INFO: finally extract failed */
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= 2147483647L) {
            C14194i source = source();
            try {
                byte[] bytes = source.mo44243p();
                Util.closeQuietly((Closeable) source);
                if (contentLength == -1 || contentLength == ((long) bytes.length)) {
                    return bytes;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Content-Length (");
                sb.append(contentLength);
                sb.append(") and stream length (");
                sb.append(bytes.length);
                sb.append(") disagree");
                throw new IOException(sb.toString());
            } catch (Throwable th) {
                Util.closeQuietly((Closeable) source);
                throw th;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot buffer entire body for content length: ");
            sb2.append(contentLength);
            throw new IOException(sb2.toString());
        }
    }

    public final Reader charStream() {
        Reader r = this.reader;
        if (r != null) {
            return r;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    public final String string() throws IOException {
        C14194i source = source();
        try {
            return source.mo44213a(Util.bomAwareCharset(source, charset()));
        } finally {
            Util.closeQuietly((Closeable) source);
        }
    }

    private Charset charset() {
        MediaType contentType = contentType();
        return contentType != null ? contentType.charset(Util.UTF_8) : Util.UTF_8;
    }

    public void close() {
        Util.closeQuietly((Closeable) source());
    }

    public static ResponseBody create(MediaType contentType, String content) {
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
        C14191g buffer = new C14191g().mo44210a(content, charset);
        return create(contentType, buffer.size(), buffer);
    }

    public static ResponseBody create(MediaType contentType, byte[] content) {
        return create(contentType, (long) content.length, new C14191g().write(content));
    }

    public static ResponseBody create(final MediaType contentType, final long contentLength, final C14194i content) {
        if (content != null) {
            return new ResponseBody() {
                public MediaType contentType() {
                    return MediaType.this;
                }

                public long contentLength() {
                    return contentLength;
                }

                public C14194i source() {
                    return content;
                }
            };
        }
        throw new NullPointerException("source == null");
    }
}
