package p005cm.aptoide.p006pt.dataprovider.exception;

import p005cm.aptoide.p006pt.dataprovider.model.p009v7.BaseV7Response;
import p005cm.aptoide.p006pt.utils.BaseException;

/* renamed from: cm.aptoide.pt.dataprovider.exception.AptoideWsV7Exception */
public class AptoideWsV7Exception extends BaseException {
    private BaseV7Response baseResponse;

    public AptoideWsV7Exception(Throwable cause) {
        super(cause);
    }

    public AptoideWsV7Exception() {
    }

    public BaseV7Response getBaseResponse() {
        return this.baseResponse;
    }

    public void setBaseResponse(BaseV7Response baseResponse2) {
        this.baseResponse = baseResponse2;
    }
}
