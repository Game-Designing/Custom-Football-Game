package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealResponseBody;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import p362h.C14179A;
import p362h.C14180B;
import p362h.C14191g;
import p362h.C14195j;
import p362h.C14197l;
import p362h.C14205t;

public final class Http2Codec implements HttpCodec {
    private static final C14195j CONNECTION = C14195j.m45649c("connection");
    private static final C14195j ENCODING = C14195j.m45649c("encoding");
    private static final C14195j HOST = C14195j.m45649c("host");
    private static final List<C14195j> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList((T[]) new C14195j[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, f43234TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY});
    private static final List<C14195j> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList((T[]) new C14195j[]{CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, f43234TE, TRANSFER_ENCODING, ENCODING, UPGRADE});
    private static final C14195j KEEP_ALIVE = C14195j.m45649c("keep-alive");
    private static final C14195j PROXY_CONNECTION = C14195j.m45649c("proxy-connection");

    /* renamed from: TE */
    private static final C14195j f43234TE = C14195j.m45649c("te");
    private static final C14195j TRANSFER_ENCODING = C14195j.m45649c("transfer-encoding");
    private static final C14195j UPGRADE = C14195j.m45649c("upgrade");
    private final Chain chain;
    private final OkHttpClient client;
    private final Http2Connection connection;
    private Http2Stream stream;
    final StreamAllocation streamAllocation;

    class StreamFinishingSource extends C14197l {
        long bytesRead = 0;
        boolean completed = false;

        StreamFinishingSource(C14180B delegate) {
            super(delegate);
        }

        public long read(C14191g sink, long byteCount) throws IOException {
            try {
                long read = delegate().read(sink, byteCount);
                if (read > 0) {
                    this.bytesRead += read;
                }
                return read;
            } catch (IOException e) {
                endOfInput(e);
                throw e;
            }
        }

        public void close() throws IOException {
            super.close();
            endOfInput(null);
        }

        private void endOfInput(IOException e) {
            if (!this.completed) {
                this.completed = true;
                Http2Codec http2Codec = Http2Codec.this;
                http2Codec.streamAllocation.streamFinished(false, http2Codec, this.bytesRead, e);
            }
        }
    }

    public Http2Codec(OkHttpClient client2, Chain chain2, StreamAllocation streamAllocation2, Http2Connection connection2) {
        this.client = client2;
        this.chain = chain2;
        this.streamAllocation = streamAllocation2;
        this.connection = connection2;
    }

    public C14179A createRequestBody(Request request, long contentLength) {
        return this.stream.getSink();
    }

    public void writeRequestHeaders(Request request) throws IOException {
        if (this.stream == null) {
            this.stream = this.connection.newStream(http2HeadersList(request), request.body() != null);
            this.stream.readTimeout().timeout((long) this.chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
            this.stream.writeTimeout().timeout((long) this.chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        }
    }

    public void flushRequest() throws IOException {
        this.connection.flush();
    }

    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    public Builder readResponseHeaders(boolean expectContinue) throws IOException {
        Builder responseBuilder = readHttp2HeadersList(this.stream.takeResponseHeaders());
        if (!expectContinue || Internal.instance.code(responseBuilder) != 100) {
            return responseBuilder;
        }
        return null;
    }

    public static List<Header> http2HeadersList(Request request) {
        Headers headers = request.headers();
        List<Header> result = new ArrayList<>(headers.size() + 4);
        result.add(new Header(Header.TARGET_METHOD, request.method()));
        result.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.url())));
        String host = request.header("Host");
        if (host != null) {
            result.add(new Header(Header.TARGET_AUTHORITY, host));
        }
        result.add(new Header(Header.TARGET_SCHEME, request.url().scheme()));
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            C14195j name = C14195j.m45649c(headers.name(i).toLowerCase(Locale.US));
            if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(name)) {
                result.add(new Header(name, headers.value(i)));
            }
        }
        return result;
    }

    public static Builder readHttp2HeadersList(List<Header> headerBlock) throws IOException {
        StatusLine statusLine = null;
        Headers.Builder headersBuilder = new Headers.Builder();
        int size = headerBlock.size();
        for (int i = 0; i < size; i++) {
            Header header = (Header) headerBlock.get(i);
            if (header != null) {
                C14195j name = header.name;
                String value = header.value.mo44289v();
                if (name.equals(Header.RESPONSE_STATUS)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("HTTP/1.1 ");
                    sb.append(value);
                    statusLine = StatusLine.parse(sb.toString());
                } else if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(name)) {
                    Internal.instance.addLenient(headersBuilder, name.mo44289v(), value);
                }
            } else if (statusLine != null && statusLine.code == 100) {
                statusLine = null;
                headersBuilder = new Headers.Builder();
            }
        }
        if (statusLine != null) {
            return new Builder().protocol(Protocol.HTTP_2).code(statusLine.code).message(statusLine.message).headers(headersBuilder.build());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    public ResponseBody openResponseBody(Response response) throws IOException {
        StreamAllocation streamAllocation2 = this.streamAllocation;
        streamAllocation2.eventListener.responseBodyStart(streamAllocation2.call);
        return new RealResponseBody(response.header("Content-Type"), HttpHeaders.contentLength(response), C14205t.m45683a(new StreamFinishingSource(this.stream.getSource())));
    }

    public void cancel() {
        Http2Stream http2Stream = this.stream;
        if (http2Stream != null) {
            http2Stream.closeLater(ErrorCode.CANCEL);
        }
    }
}
