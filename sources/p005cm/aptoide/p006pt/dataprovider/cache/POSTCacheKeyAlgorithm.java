package p005cm.aptoide.p006pt.dataprovider.cache;

import java.io.IOException;
import okhttp3.Headers;
import okhttp3.Request;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.utils.AptoideUtils.AlgorithmU;
import p005cm.aptoide.p006pt.utils.AptoideUtils.StringU;
import p362h.C14191g;

/* renamed from: cm.aptoide.pt.dataprovider.cache.POSTCacheKeyAlgorithm */
public class POSTCacheKeyAlgorithm implements KeyAlgorithm<Request, String> {
    public String getKeyFrom(Request request) {
        Request clonedRequest = request.newBuilder().build();
        StringBuilder content = new StringBuilder();
        content.append(String.format("URL:%s\n", new Object[]{clonedRequest.url().toString()}));
        Headers headers = clonedRequest.headers();
        if (headers.size() > 0) {
            content.append("Headers:\n");
            for (String headerName : headers.names()) {
                content.append(String.format("\t%s: %s\n", new Object[]{headerName, StringU.join((Iterable<?>) headers.values(headerName), ", ")}));
            }
        }
        try {
            if (clonedRequest.body() != null && clonedRequest.body().contentLength() > 0) {
                content.append("Body:\n");
                C14191g bodyBuffer = new C14191g();
                clonedRequest.body().writeTo(bodyBuffer);
                content.append(bodyBuffer.mo44232h());
            }
            return AlgorithmU.computeSha1(content.toString());
        } catch (IOException e) {
            CrashReport.getInstance().log(e);
            return null;
        }
    }
}
