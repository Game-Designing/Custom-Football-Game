package p005cm.aptoide.p006pt.dataprovider.exception;

import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.GenericResponseV3;
import p005cm.aptoide.p006pt.utils.BaseException;

/* renamed from: cm.aptoide.pt.dataprovider.exception.AptoideWsV3Exception */
public class AptoideWsV3Exception extends BaseException {
    private GenericResponseV3 baseResponse;

    public AptoideWsV3Exception(Throwable cause) {
        super(cause);
    }

    public GenericResponseV3 getBaseResponse() {
        return this.baseResponse;
    }

    public void setBaseResponse(GenericResponseV3 baseResponse2) {
        this.baseResponse = baseResponse2;
    }
}
