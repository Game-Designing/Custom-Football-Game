package com.google.android.exoplayer2.upstream;

import com.google.android.exoplayer2.util.C8537v;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HttpDataSource extends C8487i {

    /* renamed from: b */
    public static final C8537v<String> f18598b = C8461b.f18630a;

    public static class HttpDataSourceException extends IOException {

        /* renamed from: a */
        public final int f18599a;

        /* renamed from: b */
        public final C8489j f18600b;

        public HttpDataSourceException(String message, C8489j dataSpec, int type) {
            super(message);
            this.f18600b = dataSpec;
            this.f18599a = type;
        }

        public HttpDataSourceException(IOException cause, C8489j dataSpec, int type) {
            super(cause);
            this.f18600b = dataSpec;
            this.f18599a = type;
        }

        public HttpDataSourceException(String message, IOException cause, C8489j dataSpec, int type) {
            super(message, cause);
            this.f18600b = dataSpec;
            this.f18599a = type;
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {

        /* renamed from: c */
        public final String f18601c;

        public InvalidContentTypeException(String contentType, C8489j dataSpec) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid content type: ");
            sb.append(contentType);
            super(sb.toString(), dataSpec, 1);
            this.f18601c = contentType;
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {

        /* renamed from: c */
        public final int f18602c;

        /* renamed from: d */
        public final String f18603d;

        /* renamed from: e */
        public final Map<String, List<String>> f18604e;

        public InvalidResponseCodeException(int responseCode, String responseMessage, Map<String, List<String>> headerFields, C8489j dataSpec) {
            StringBuilder sb = new StringBuilder();
            sb.append("Response code: ");
            sb.append(responseCode);
            super(sb.toString(), dataSpec, 1);
            this.f18602c = responseCode;
            this.f18603d = responseMessage;
            this.f18604e = headerFields;
        }
    }

    /* renamed from: com.google.android.exoplayer2.upstream.HttpDataSource$a */
    public static final class C8453a {

        /* renamed from: a */
        private final Map<String, String> f18605a = new HashMap();

        /* renamed from: b */
        private Map<String, String> f18606b;

        /* renamed from: a */
        public synchronized Map<String, String> mo25921a() {
            if (this.f18606b == null) {
                this.f18606b = Collections.unmodifiableMap(new HashMap(this.f18605a));
            }
            return this.f18606b;
        }
    }
}
