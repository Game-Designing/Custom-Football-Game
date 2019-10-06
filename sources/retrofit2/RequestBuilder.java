package retrofit2;

import java.io.IOException;
import okhttp3.FormBody.Builder;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Part;
import okhttp3.Request;
import okhttp3.RequestBody;
import p362h.C14191g;
import p362h.C14193h;

final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final HttpUrl baseUrl;
    private RequestBody body;
    private MediaType contentType;
    private Builder formBuilder;
    private final boolean hasBody;
    private final String method;
    private MultipartBody.Builder multipartBuilder;
    private String relativeUrl;
    private final Request.Builder requestBuilder = new Request.Builder();
    private HttpUrl.Builder urlBuilder;

    private static class ContentTypeOverridingRequestBody extends RequestBody {
        private final MediaType contentType;
        private final RequestBody delegate;

        ContentTypeOverridingRequestBody(RequestBody delegate2, MediaType contentType2) {
            this.delegate = delegate2;
            this.contentType = contentType2;
        }

        public MediaType contentType() {
            return this.contentType;
        }

        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        public void writeTo(C14193h sink) throws IOException {
            this.delegate.writeTo(sink);
        }
    }

    RequestBuilder(String method2, HttpUrl baseUrl2, String relativeUrl2, Headers headers, MediaType contentType2, boolean hasBody2, boolean isFormEncoded, boolean isMultipart) {
        this.method = method2;
        this.baseUrl = baseUrl2;
        this.relativeUrl = relativeUrl2;
        this.contentType = contentType2;
        this.hasBody = hasBody2;
        if (headers != null) {
            this.requestBuilder.headers(headers);
        }
        if (isFormEncoded) {
            this.formBuilder = new Builder();
        } else if (isMultipart) {
            this.multipartBuilder = new MultipartBody.Builder();
            this.multipartBuilder.setType(MultipartBody.FORM);
        }
    }

    /* access modifiers changed from: 0000 */
    public void setRelativeUrl(Object relativeUrl2) {
        this.relativeUrl = relativeUrl2.toString();
    }

    /* access modifiers changed from: 0000 */
    public void addHeader(String name, String value) {
        if ("Content-Type".equalsIgnoreCase(name)) {
            MediaType type = MediaType.parse(value);
            if (type != null) {
                this.contentType = type;
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed content type: ");
            sb.append(value);
            throw new IllegalArgumentException(sb.toString());
        }
        this.requestBuilder.addHeader(name, value);
    }

    /* access modifiers changed from: 0000 */
    public void addPathParam(String name, String value, boolean encoded) {
        String str = this.relativeUrl;
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append(name);
            sb.append("}");
            this.relativeUrl = str.replace(sb.toString(), canonicalizeForPath(value, encoded));
            return;
        }
        throw new AssertionError();
    }

    private static String canonicalizeForPath(String input, boolean alreadyEncoded) {
        int i = 0;
        int limit = input.length();
        while (i < limit) {
            int codePoint = input.codePointAt(i);
            if (codePoint < 32 || codePoint >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePoint) != -1 || (!alreadyEncoded && (codePoint == 47 || codePoint == 37))) {
                C14191g out = new C14191g();
                out.mo44208a(input, 0, i);
                canonicalizeForPath(out, input, i, limit, alreadyEncoded);
                return out.mo44232h();
            }
            i += Character.charCount(codePoint);
        }
        return input;
    }

    private static void canonicalizeForPath(C14191g out, String input, int pos, int limit, boolean alreadyEncoded) {
        C14191g utf8Buffer = null;
        int i = pos;
        while (i < limit) {
            int codePoint = input.codePointAt(i);
            if (!alreadyEncoded || !(codePoint == 9 || codePoint == 10 || codePoint == 12 || codePoint == 13)) {
                if (codePoint < 32 || codePoint >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePoint) != -1 || (!alreadyEncoded && (codePoint == 47 || codePoint == 37))) {
                    if (utf8Buffer == null) {
                        utf8Buffer = new C14191g();
                    }
                    utf8Buffer.mo44221c(codePoint);
                    while (!utf8Buffer.mo44244q()) {
                        int b = utf8Buffer.readByte() & 255;
                        out.writeByte(37);
                        out.writeByte((int) HEX_DIGITS[(b >> 4) & 15]);
                        out.writeByte((int) HEX_DIGITS[b & 15]);
                    }
                } else {
                    out.mo44221c(codePoint);
                }
            }
            i += Character.charCount(codePoint);
        }
    }

    /* access modifiers changed from: 0000 */
    public void addQueryParam(String name, String value, boolean encoded) {
        String str = this.relativeUrl;
        if (str != null) {
            this.urlBuilder = this.baseUrl.newBuilder(str);
            if (this.urlBuilder != null) {
                this.relativeUrl = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed URL. Base: ");
                sb.append(this.baseUrl);
                sb.append(", Relative: ");
                sb.append(this.relativeUrl);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        if (encoded) {
            this.urlBuilder.addEncodedQueryParameter(name, value);
        } else {
            this.urlBuilder.addQueryParameter(name, value);
        }
    }

    /* access modifiers changed from: 0000 */
    public void addFormField(String name, String value, boolean encoded) {
        if (encoded) {
            this.formBuilder.addEncoded(name, value);
        } else {
            this.formBuilder.add(name, value);
        }
    }

    /* access modifiers changed from: 0000 */
    public void addPart(Headers headers, RequestBody body2) {
        this.multipartBuilder.addPart(headers, body2);
    }

    /* access modifiers changed from: 0000 */
    public void addPart(Part part) {
        this.multipartBuilder.addPart(part);
    }

    /* access modifiers changed from: 0000 */
    public void setBody(RequestBody body2) {
        this.body = body2;
    }

    /* access modifiers changed from: 0000 */
    public Request build() {
        HttpUrl url;
        HttpUrl.Builder urlBuilder2 = this.urlBuilder;
        if (urlBuilder2 != null) {
            url = urlBuilder2.build();
        } else {
            url = this.baseUrl.resolve(this.relativeUrl);
            if (url == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed URL. Base: ");
                sb.append(this.baseUrl);
                sb.append(", Relative: ");
                sb.append(this.relativeUrl);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        RequestBody body2 = this.body;
        if (body2 == null) {
            Builder builder = this.formBuilder;
            if (builder != null) {
                body2 = builder.build();
            } else {
                MultipartBody.Builder builder2 = this.multipartBuilder;
                if (builder2 != null) {
                    body2 = builder2.build();
                } else if (this.hasBody) {
                    body2 = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType contentType2 = this.contentType;
        if (contentType2 != null) {
            if (body2 != null) {
                body2 = new ContentTypeOverridingRequestBody(body2, contentType2);
            } else {
                this.requestBuilder.addHeader("Content-Type", contentType2.toString());
            }
        }
        return this.requestBuilder.url(url).method(this.method, body2).build();
    }
}
