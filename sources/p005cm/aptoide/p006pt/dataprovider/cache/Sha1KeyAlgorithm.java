package p005cm.aptoide.p006pt.dataprovider.cache;

import java.io.IOException;
import okhttp3.Request;
import p005cm.aptoide.p006pt.crashreports.CrashReport;
import p005cm.aptoide.p006pt.utils.AptoideUtils.AlgorithmU;
import p362h.C14191g;

/* renamed from: cm.aptoide.pt.dataprovider.cache.Sha1KeyAlgorithm */
public class Sha1KeyAlgorithm implements KeyAlgorithm<Request, String> {
    private static final String TAG = Sha1KeyAlgorithm.class.getName();

    public String getKeyFrom(Request request) {
        String requestIdentifier;
        try {
            C14191g bodyBuffer = new C14191g();
            Request clonedRequest = request.newBuilder().build();
            if (clonedRequest.body() == null || clonedRequest.body().contentLength() <= 0) {
                requestIdentifier = clonedRequest.url().toString();
            } else {
                clonedRequest.body().writeTo(bodyBuffer);
                StringBuilder sb = new StringBuilder();
                sb.append(clonedRequest.url().toString());
                sb.append(bodyBuffer.mo44232h());
                requestIdentifier = sb.toString();
            }
            return AlgorithmU.computeSha1(requestIdentifier);
        } catch (IOException e) {
            CrashReport.getInstance().log(e);
            return null;
        }
    }
}
