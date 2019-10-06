package okhttp3.internal.http;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import p362h.C14194i;

public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final C14194i source;

    public RealResponseBody(String contentTypeString2, long contentLength2, C14194i source2) {
        this.contentTypeString = contentTypeString2;
        this.contentLength = contentLength2;
        this.source = source2;
    }

    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.parse(str);
        }
        return null;
    }

    public long contentLength() {
        return this.contentLength;
    }

    public C14194i source() {
        return this.source;
    }
}
