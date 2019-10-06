package okhttp3.logging;

import java.io.EOFException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import p362h.C14191g;
import p362h.C14194i;

public final class HttpLoggingInterceptor implements Interceptor {
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Level level;
    private final Logger logger;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface Logger {
        public static final Logger DEFAULT = new Logger() {
            public void log(String message) {
                Platform.get().log(4, message, null);
            }
        };

        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this(Logger.DEFAULT);
    }

    public HttpLoggingInterceptor(Logger logger2) {
        this.level = Level.NONE;
        this.logger = logger2;
    }

    public HttpLoggingInterceptor setLevel(Level level2) {
        if (level2 != null) {
            this.level = level2;
            return this;
        }
        throw new NullPointerException("level == null. Use Level.NONE instead.");
    }

    public Level getLevel() {
        return this.level;
    }

    public Response intercept(Chain chain) throws IOException {
        Object obj;
        String requestStartMessage;
        String str;
        String requestStartMessage2;
        String str2;
        String bodySize;
        String str3;
        String str4;
        Object obj2;
        Chain chain2 = chain;
        Level level2 = this.level;
        Request request = chain.request();
        if (level2 == Level.NONE) {
            return chain2.proceed(request);
        }
        boolean hasRequestBody = false;
        boolean logBody = level2 == Level.BODY;
        boolean logHeaders = logBody || level2 == Level.HEADERS;
        RequestBody requestBody = request.body();
        if (requestBody != null) {
            hasRequestBody = true;
        }
        Connection connection = chain.connection();
        Protocol protocol = connection != null ? connection.protocol() : Protocol.HTTP_1_1;
        StringBuilder sb = new StringBuilder();
        sb.append("--> ");
        sb.append(request.method());
        sb.append(' ');
        sb.append(request.url());
        sb.append(' ');
        sb.append(protocol);
        String requestStartMessage3 = sb.toString();
        String str5 = "-byte body)";
        String str6 = " (";
        if (logHeaders || !hasRequestBody) {
            obj = protocol;
            requestStartMessage = requestStartMessage3;
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(requestStartMessage3);
            sb2.append(str6);
            obj = protocol;
            sb2.append(requestBody.contentLength());
            sb2.append(str5);
            requestStartMessage = sb2.toString();
        }
        this.logger.log(requestStartMessage);
        String str7 = "-byte body omitted)";
        String str8 = ": ";
        String str9 = "";
        if (logHeaders) {
            if (hasRequestBody) {
                if (requestBody.contentType() != null) {
                    Level level3 = level2;
                    Logger logger2 = this.logger;
                    Connection connection2 = connection;
                    StringBuilder sb3 = new StringBuilder();
                    String str10 = requestStartMessage;
                    sb3.append("Content-Type: ");
                    sb3.append(requestBody.contentType());
                    logger2.log(sb3.toString());
                } else {
                    Connection connection3 = connection;
                    String str11 = requestStartMessage;
                }
                if (requestBody.contentLength() != -1) {
                    Logger logger3 = this.logger;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Content-Length: ");
                    requestStartMessage2 = str5;
                    str4 = str6;
                    sb4.append(requestBody.contentLength());
                    logger3.log(sb4.toString());
                } else {
                    requestStartMessage2 = str5;
                    str4 = str6;
                }
            } else {
                Connection connection4 = connection;
                String str12 = requestStartMessage;
                requestStartMessage2 = str5;
                str4 = str6;
            }
            Headers headers = request.headers();
            int i = 0;
            int count = headers.size();
            while (i < count) {
                String name = headers.name(i);
                int count2 = count;
                if ("Content-Type".equalsIgnoreCase(name) || "Content-Length".equalsIgnoreCase(name)) {
                    obj2 = obj;
                } else {
                    Logger logger4 = this.logger;
                    obj2 = obj;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(name);
                    sb5.append(str8);
                    String str13 = name;
                    sb5.append(headers.value(i));
                    logger4.log(sb5.toString());
                }
                i++;
                count = count2;
                obj = obj2;
            }
            Object obj3 = obj;
            String str14 = "--> END ";
            if (!logBody) {
                boolean z = hasRequestBody;
                str = str9;
                str2 = str4;
            } else if (!hasRequestBody) {
                Headers headers2 = headers;
                boolean z2 = hasRequestBody;
                str = str9;
                str2 = str4;
            } else if (bodyEncoded(request.headers())) {
                Logger logger5 = this.logger;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str14);
                sb6.append(request.method());
                sb6.append(" (encoded body omitted)");
                logger5.log(sb6.toString());
                boolean z3 = hasRequestBody;
                str = str9;
                str2 = str4;
            } else {
                C14191g buffer = new C14191g();
                requestBody.writeTo(buffer);
                Charset charset = UTF8;
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    Headers headers3 = headers;
                    charset = contentType.charset(UTF8);
                }
                this.logger.log(str9);
                if (isPlaintext(buffer)) {
                    boolean z4 = hasRequestBody;
                    this.logger.log(buffer.mo44213a(charset));
                    Logger logger6 = this.logger;
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str14);
                    sb7.append(request.method());
                    String str15 = str4;
                    sb7.append(str15);
                    C14191g gVar = buffer;
                    Charset charset2 = charset;
                    sb7.append(requestBody.contentLength());
                    sb7.append(requestStartMessage2);
                    logger6.log(sb7.toString());
                    str2 = str15;
                    str = str9;
                } else {
                    Charset charset3 = charset;
                    str2 = str4;
                    C14191g gVar2 = buffer;
                    Logger logger7 = this.logger;
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str14);
                    sb8.append(request.method());
                    sb8.append(" (binary ");
                    str = str9;
                    sb8.append(requestBody.contentLength());
                    sb8.append(str7);
                    logger7.log(sb8.toString());
                }
            }
            Logger logger8 = this.logger;
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str14);
            sb9.append(request.method());
            logger8.log(sb9.toString());
        } else {
            boolean z5 = hasRequestBody;
            Connection connection5 = connection;
            String str16 = requestStartMessage;
            requestStartMessage2 = str5;
            str2 = str6;
            str = str9;
            Object obj4 = obj;
        }
        long startNs = System.nanoTime();
        try {
            Response response = chain2.proceed(request);
            long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);
            ResponseBody responseBody = response.body();
            Request request2 = request;
            long j = startNs;
            long contentLength = responseBody.contentLength();
            if (contentLength != -1) {
                StringBuilder sb10 = new StringBuilder();
                sb10.append(contentLength);
                sb10.append("-byte");
                bodySize = sb10.toString();
            } else {
                bodySize = "unknown-length";
            }
            Logger logger9 = this.logger;
            RequestBody requestBody2 = requestBody;
            StringBuilder sb11 = new StringBuilder();
            String str17 = requestStartMessage2;
            sb11.append("<-- ");
            sb11.append(response.code());
            sb11.append(' ');
            long contentLength2 = contentLength;
            sb11.append(response.message());
            sb11.append(' ');
            sb11.append(response.request().url());
            sb11.append(str2);
            sb11.append(tookMs);
            sb11.append("ms");
            if (!logHeaders) {
                StringBuilder sb12 = new StringBuilder();
                sb12.append(", ");
                sb12.append(bodySize);
                sb12.append(" body");
                str3 = sb12.toString();
            } else {
                str3 = str;
            }
            sb11.append(str3);
            sb11.append(')');
            logger9.log(sb11.toString());
            if (logHeaders) {
                Headers headers4 = response.headers();
                int count3 = headers4.size();
                for (int i2 = 0; i2 < count3; i2++) {
                    Logger logger10 = this.logger;
                    StringBuilder sb13 = new StringBuilder();
                    sb13.append(headers4.name(i2));
                    sb13.append(str8);
                    sb13.append(headers4.value(i2));
                    logger10.log(sb13.toString());
                }
                if (!logBody) {
                    Headers headers5 = headers4;
                } else if (!HttpHeaders.hasBody(response)) {
                    String str18 = bodySize;
                    Headers headers6 = headers4;
                } else if (bodyEncoded(response.headers())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                    String str19 = bodySize;
                } else {
                    C14194i source = responseBody.source();
                    source.request(Long.MAX_VALUE);
                    C14191g buffer2 = source.mo44238k();
                    Charset charset4 = UTF8;
                    MediaType contentType2 = responseBody.contentType();
                    if (contentType2 != null) {
                        charset4 = contentType2.charset(UTF8);
                    }
                    if (!isPlaintext(buffer2)) {
                        this.logger.log(str);
                        Logger logger11 = this.logger;
                        StringBuilder sb14 = new StringBuilder();
                        String str20 = bodySize;
                        sb14.append("<-- END HTTP (binary ");
                        Headers headers7 = headers4;
                        sb14.append(buffer2.size());
                        sb14.append(str7);
                        logger11.log(sb14.toString());
                        return response;
                    }
                    Headers headers8 = headers4;
                    String str21 = str;
                    if (contentLength2 != 0) {
                        this.logger.log(str21);
                        this.logger.log(buffer2.clone().mo44213a(charset4));
                    }
                    Logger logger12 = this.logger;
                    StringBuilder sb15 = new StringBuilder();
                    sb15.append("<-- END HTTP (");
                    sb15.append(buffer2.size());
                    sb15.append(str17);
                    logger12.log(sb15.toString());
                }
                this.logger.log("<-- END HTTP");
            }
            return response;
        } catch (Exception e) {
            Request request3 = request;
            long j2 = startNs;
            RequestBody requestBody3 = requestBody;
            Exception e2 = e;
            Logger logger13 = this.logger;
            StringBuilder sb16 = new StringBuilder();
            sb16.append("<-- HTTP FAILED: ");
            sb16.append(e2);
            logger13.log(sb16.toString());
            throw e2;
        }
    }

    static boolean isPlaintext(C14191g buffer) {
        try {
            C14191g prefix = new C14191g();
            long byteCount = 64;
            if (buffer.size() < 64) {
                byteCount = buffer.size();
            }
            buffer.mo44206a(prefix, 0, byteCount);
            int i = 0;
            while (true) {
                if (i >= 16) {
                    break;
                } else if (prefix.mo44244q()) {
                    break;
                } else {
                    int codePoint = prefix.mo44259w();
                    if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                        return false;
                    }
                    i++;
                }
            }
            return true;
        } catch (EOFException e) {
            return false;
        }
    }

    private boolean bodyEncoded(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null && !contentEncoding.equalsIgnoreCase("identity");
    }
}
