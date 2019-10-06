package p005cm.aptoide.accountmanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.dataprovider.exception.AptoideWsV3Exception;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.ErrorResponse;
import p005cm.aptoide.p006pt.dataprovider.model.p008v3.OAuth;
import p005cm.aptoide.p006pt.dataprovider.p010ws.p012v3.GenericResponseV3;

/* renamed from: cm.aptoide.accountmanager.AccountException */
public class AccountException extends Exception {
    private String code;
    private final String error;
    private final Map<String, String> errors;

    public AccountException(List<ErrorResponse> errors2) {
        this.errors = new HashMap();
        if (errors2 == null || errors2.isEmpty()) {
            this.code = null;
        } else {
            this.code = ((ErrorResponse) errors2.get(0)).code;
        }
        if (errors2 == null || errors2.isEmpty()) {
            this.error = null;
        } else {
            this.error = ((ErrorResponse) errors2.get(0)).msg;
        }
        this.errors.put(String.valueOf(this.error), String.valueOf(this.code));
    }

    public AccountException(AptoideWsV3Exception exception) {
        this.error = exception.getBaseResponse().getError();
        this.errors = createErrorsList(exception.getBaseResponse());
    }

    public AccountException(OAuth oAuth) {
        this.error = oAuth.getError();
        this.errors = createErrorsList(oAuth);
    }

    private Map<String, String> createErrorsList(OAuth oauth) {
        if (oauth.getErrors() == null || oauth.getErrors().isEmpty()) {
            return createErrorList(oauth.getError(), oauth.getErrorDescription());
        }
        return getErrorsList(oauth.getErrors());
    }

    private Map<String, String> createErrorsList(GenericResponseV3 response) {
        if (response.getErrors() == null || response.getErrors().isEmpty()) {
            return createErrorList(response.getError(), response.getErrorDescription());
        }
        return getErrorsList(response.getErrors());
    }

    private Map<String, String> createErrorList(String code2, String description) {
        Map<String, String> error2 = new HashMap<>();
        error2.put(code2, description);
        return error2;
    }

    public String getCode() {
        return this.code;
    }

    public String getError() {
        return this.error;
    }

    public boolean hasCode() {
        return this.code != null;
    }

    public Map<String, String> getErrors() {
        return this.errors;
    }

    private Map<String, String> getErrorsList(List<ErrorResponse> errorResponses) {
        Map<String, String> errors2 = new HashMap<>();
        for (ErrorResponse error2 : errorResponses) {
            errors2.put(String.valueOf(error2.code), String.valueOf(error2.msg));
        }
        return errors2;
    }
}
