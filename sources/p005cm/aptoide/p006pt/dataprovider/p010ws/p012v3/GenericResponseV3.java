package p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3;

import java.util.List;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.ErrorResponse;

/* renamed from: cm.aptoide.pt.dataprovider.ws.v3.GenericResponseV3 */
public class GenericResponseV3 {
    private String error;
    private String errorDescription;
    private List<ErrorResponse> errors;
    private String status;

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status2) {
        this.status = status2;
    }

    public List<ErrorResponse> getErrors() {
        return this.errors;
    }

    public void setErrors(List<ErrorResponse> errors2) {
        this.errors = errors2;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String error2) {
        this.error = error2;
    }

    public String getErrorDescription() {
        return this.errorDescription;
    }

    public void setErrorDescription(String errorDescription2) {
        this.errorDescription = errorDescription2;
    }
}
