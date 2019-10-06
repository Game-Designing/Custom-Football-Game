package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import p362h.C14179A;
import p362h.C14180B;
import p362h.C14182D;
import p362h.C14191g;
import p362h.C14193h;
import p362h.C14194i;
import p362h.C14198m;
import p362h.C14205t;

public final class Http1Codec implements HttpCodec {
    private static final int HEADER_LIMIT = 262144;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    final OkHttpClient client;
    private long headerLimit = 262144;
    final C14193h sink;
    final C14194i source;
    int state = 0;
    final StreamAllocation streamAllocation;

    private abstract class AbstractSource implements C14180B {
        protected long bytesRead;
        protected boolean closed;
        protected final C14198m timeout;

        private AbstractSource() {
            this.timeout = new C14198m(Http1Codec.this.source.timeout());
            this.bytesRead = 0;
        }

        public C14182D timeout() {
            return this.timeout;
        }

        public long read(C14191g sink, long byteCount) throws IOException {
            try {
                long read = Http1Codec.this.source.read(sink, byteCount);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e) {
                endOfInput(false, e);
                throw e;
            }
        }

        /* access modifiers changed from: protected */
        public final void endOfInput(boolean reuseConnection, IOException e) throws IOException {
            Http1Codec http1Codec = Http1Codec.this;
            int i = http1Codec.state;
            if (i != 6) {
                if (i == 5) {
                    http1Codec.detachTimeout(this.timeout);
                    Http1Codec http1Codec2 = Http1Codec.this;
                    http1Codec2.state = 6;
                    StreamAllocation streamAllocation = http1Codec2.streamAllocation;
                    if (streamAllocation != null) {
                        streamAllocation.streamFinished(!reuseConnection, http1Codec2, this.bytesRead, e);
                    }
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("state: ");
                sb.append(Http1Codec.this.state);
                throw new IllegalStateException(sb.toString());
            }
        }
    }

    private final class ChunkedSink implements C14179A {
        private boolean closed;
        private final C14198m timeout = new C14198m(Http1Codec.this.sink.timeout());

        ChunkedSink() {
        }

        public C14182D timeout() {
            return this.timeout;
        }

        public void write(C14191g source, long byteCount) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (byteCount != 0) {
                Http1Codec.this.sink.mo44219b(byteCount);
                String str = "\r\n";
                Http1Codec.this.sink.mo44229f(str);
                Http1Codec.this.sink.write(source, byteCount);
                Http1Codec.this.sink.mo44229f(str);
            }
        }

        public synchronized void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public synchronized void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                Http1Codec.this.sink.mo44229f("0\r\n\r\n");
                Http1Codec.this.detachTimeout(this.timeout);
                Http1Codec.this.state = 3;
            }
        }
    }

    private class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk = NO_CHUNK_YET;
        private boolean hasMoreChunks = true;
        private final HttpUrl url;

        ChunkedSource(HttpUrl url2) {
            super();
            this.url = url2;
        }

        public long read(C14191g sink, long byteCount) throws IOException {
            if (byteCount < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(byteCount);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (!this.hasMoreChunks) {
                return NO_CHUNK_YET;
            } else {
                long j = this.bytesRemainingInChunk;
                if (j == 0 || j == NO_CHUNK_YET) {
                    readChunkSize();
                    if (!this.hasMoreChunks) {
                        return NO_CHUNK_YET;
                    }
                }
                long read = super.read(sink, Math.min(byteCount, this.bytesRemainingInChunk));
                if (read != NO_CHUNK_YET) {
                    this.bytesRemainingInChunk -= read;
                    return read;
                }
                ProtocolException e = new ProtocolException("unexpected end of stream");
                endOfInput(false, e);
                throw e;
            }
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != NO_CHUNK_YET) {
                Http1Codec.this.source.mo44241n();
            }
            try {
                this.bytesRemainingInChunk = Http1Codec.this.source.mo44256t();
                String extensions = Http1Codec.this.source.mo44241n().trim();
                if (this.bytesRemainingInChunk < 0 || (!extensions.isEmpty() && !extensions.startsWith(";"))) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("expected chunk size and optional extensions but was \"");
                    sb.append(this.bytesRemainingInChunk);
                    sb.append(extensions);
                    sb.append("\"");
                    throw new ProtocolException(sb.toString());
                } else if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    HttpHeaders.receiveHeaders(Http1Codec.this.client.cookieJar(), this.url, Http1Codec.this.readHeaders());
                    endOfInput(true, null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    private final class FixedLengthSink implements C14179A {
        private long bytesRemaining;
        private boolean closed;
        private final C14198m timeout = new C14198m(Http1Codec.this.sink.timeout());

        FixedLengthSink(long bytesRemaining2) {
            this.bytesRemaining = bytesRemaining2;
        }

        public C14182D timeout() {
            return this.timeout;
        }

        public void write(C14191g source, long byteCount) throws IOException {
            if (!this.closed) {
                Util.checkOffsetAndCount(source.size(), 0, byteCount);
                if (byteCount <= this.bytesRemaining) {
                    Http1Codec.this.sink.write(source, byteCount);
                    this.bytesRemaining -= byteCount;
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("expected ");
                sb.append(this.bytesRemaining);
                sb.append(" bytes but received ");
                sb.append(byteCount);
                throw new ProtocolException(sb.toString());
            }
            throw new IllegalStateException("closed");
        }

        public void flush() throws IOException {
            if (!this.closed) {
                Http1Codec.this.sink.flush();
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                this.closed = true;
                if (this.bytesRemaining <= 0) {
                    Http1Codec.this.detachTimeout(this.timeout);
                    Http1Codec.this.state = 3;
                    return;
                }
                throw new ProtocolException("unexpected end of stream");
            }
        }
    }

    private class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        FixedLengthSource(long length) throws IOException {
            super();
            this.bytesRemaining = length;
            if (this.bytesRemaining == 0) {
                endOfInput(true, null);
            }
        }

        public long read(C14191g sink, long byteCount) throws IOException {
            if (byteCount < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(byteCount);
                throw new IllegalArgumentException(sb.toString());
            } else if (!this.closed) {
                long j = this.bytesRemaining;
                if (j == 0) {
                    return -1;
                }
                long read = super.read(sink, Math.min(j, byteCount));
                if (read != -1) {
                    this.bytesRemaining -= read;
                    if (this.bytesRemaining == 0) {
                        endOfInput(true, null);
                    }
                    return read;
                }
                ProtocolException e = new ProtocolException("unexpected end of stream");
                endOfInput(false, e);
                throw e;
            } else {
                throw new IllegalStateException("closed");
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    private class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        UnknownLengthSource() {
            super();
        }

        public long read(C14191g sink, long byteCount) throws IOException {
            if (byteCount < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("byteCount < 0: ");
                sb.append(byteCount);
                throw new IllegalArgumentException(sb.toString());
            } else if (this.closed) {
                throw new IllegalStateException("closed");
            } else if (this.inputExhausted) {
                return -1;
            } else {
                long read = super.read(sink, byteCount);
                if (read != -1) {
                    return read;
                }
                this.inputExhausted = true;
                endOfInput(true, null);
                return -1;
            }
        }

        public void close() throws IOException {
            if (!this.closed) {
                if (!this.inputExhausted) {
                    endOfInput(false, null);
                }
                this.closed = true;
            }
        }
    }

    public Http1Codec(OkHttpClient client2, StreamAllocation streamAllocation2, C14194i source2, C14193h sink2) {
        this.client = client2;
        this.streamAllocation = streamAllocation2;
        this.source = source2;
        this.sink = sink2;
    }

    public C14179A createRequestBody(Request request, long contentLength) {
        if ("chunked".equalsIgnoreCase(request.header("Transfer-Encoding"))) {
            return newChunkedSink();
        }
        if (contentLength != -1) {
            return newFixedLengthSink(contentLength);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public void cancel() {
        RealConnection connection = this.streamAllocation.connection();
        if (connection != null) {
            connection.cancel();
        }
    }

    public void writeRequestHeaders(Request request) throws IOException {
        writeRequest(request.headers(), RequestLine.get(request, this.streamAllocation.connection().route().proxy().type()));
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation2 = this.streamAllocation;
        streamAllocation2.eventListener.responseBodyStart(streamAllocation2.call);
        String contentType = response.header("Content-Type");
        if (!HttpHeaders.hasBody(response)) {
            return new RealResponseBody(contentType, 0, C14205t.m45683a(newFixedLengthSource(0)));
        }
        if ("chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return new RealResponseBody(contentType, -1, C14205t.m45683a(newChunkedSource(response.request().url())));
        }
        long contentLength = HttpHeaders.contentLength(response);
        if (contentLength != -1) {
            return new RealResponseBody(contentType, contentLength, C14205t.m45683a(newFixedLengthSource(contentLength)));
        }
        return new RealResponseBody(contentType, -1, C14205t.m45683a(newUnknownLengthSource()));
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public void flushRequest() throws IOException {
        this.sink.flush();
    }

    public void finishRequest() throws IOException {
        this.sink.flush();
    }

    public void writeRequest(Headers headers, String requestLine) throws IOException {
        if (this.state == 0) {
            String str = "\r\n";
            this.sink.mo44229f(requestLine).mo44229f(str);
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                this.sink.mo44229f(headers.name(i)).mo44229f(": ").mo44229f(headers.value(i)).mo44229f(str);
            }
            this.sink.mo44229f(str);
            this.state = 1;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    public Builder readResponseHeaders(boolean expectContinue) throws IOException {
        int i = this.state;
        if (i == 1 || i == 3) {
            try {
                StatusLine statusLine = StatusLine.parse(readHeaderLine());
                Builder responseBuilder = new Builder().protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message).headers(readHeaders());
                if (expectContinue && statusLine.code == 100) {
                    return null;
                }
                if (statusLine.code == 100) {
                    this.state = 3;
                    return responseBuilder;
                }
                this.state = 4;
                return responseBuilder;
            } catch (EOFException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("unexpected end of stream on ");
                sb.append(this.streamAllocation);
                IOException exception = new IOException(sb.toString());
                exception.initCause(e);
                throw exception;
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("state: ");
            sb2.append(this.state);
            throw new IllegalStateException(sb2.toString());
        }
    }

    private String readHeaderLine() throws IOException {
        String line = this.source.mo44223c(this.headerLimit);
        this.headerLimit -= (long) line.length();
        return line;
    }

    public Headers readHeaders() throws IOException {
        Headers.Builder headers = new Headers.Builder();
        while (true) {
            String readHeaderLine = readHeaderLine();
            String line = readHeaderLine;
            if (readHeaderLine.length() == 0) {
                return headers.build();
            }
            Internal.instance.addLenient(headers, line);
        }
    }

    public C14179A newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    public C14179A newFixedLengthSink(long contentLength) {
        if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(contentLength);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    public C14180B newFixedLengthSource(long length) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(length);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    public C14180B newChunkedSource(HttpUrl url) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(url);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    public C14180B newUnknownLengthSource() throws IOException {
        if (this.state == 4) {
            StreamAllocation streamAllocation2 = this.streamAllocation;
            if (streamAllocation2 != null) {
                this.state = 5;
                streamAllocation2.noNewStreams();
                return new UnknownLengthSource();
            }
            throw new IllegalStateException("streamAllocation == null");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("state: ");
        sb.append(this.state);
        throw new IllegalStateException(sb.toString());
    }

    /* access modifiers changed from: 0000 */
    public void detachTimeout(C14198m timeout) {
        C14182D oldDelegate = timeout.mo44294a();
        timeout.mo44295a(C14182D.NONE);
        oldDelegate.clearDeadline();
        oldDelegate.clearTimeout();
    }
}
