package p005cm.aptoide.p006pt.dataprovider.p010ws.p013v7.analyticsbody;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v7.analyticsbody.Result */
public class Result {
    private ResultError error;
    private ResultStatus status;

    /* renamed from: cm.aptoide.pt.dataprovider.ws.v7.analyticsbody.Result$ResultStatus */
    public enum ResultStatus {
        SUCC,
        FAIL
    }

    public ResultStatus getStatus() {
        return this.status;
    }

    public void setStatus(ResultStatus status2) {
        this.status = status2;
    }

    public ResultError getError() {
        return this.error;
    }

    public void setError(ResultError error2) {
        this.error = error2;
    }
}
