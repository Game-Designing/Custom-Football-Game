package com.facebook;

public class FacebookGraphResponseException extends FacebookException {

    /* renamed from: a */
    private final C6817z f11775a;

    public FacebookGraphResponseException(C6817z graphResponse, String errorMessage) {
        super(errorMessage);
        this.f11775a = graphResponse;
    }

    public final String toString() {
        C6817z zVar = this.f11775a;
        FacebookRequestError requestError = zVar != null ? zVar.mo20227a() : null;
        StringBuilder errorStringBuilder = new StringBuilder().append("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            errorStringBuilder.append(message);
            errorStringBuilder.append(" ");
        }
        if (requestError != null) {
            errorStringBuilder.append("httpResponseCode: ");
            errorStringBuilder.append(requestError.mo19666f());
            errorStringBuilder.append(", facebookErrorCode: ");
            errorStringBuilder.append(requestError.mo19661b());
            errorStringBuilder.append(", facebookErrorType: ");
            errorStringBuilder.append(requestError.mo19663d());
            errorStringBuilder.append(", message: ");
            errorStringBuilder.append(requestError.mo19662c());
            errorStringBuilder.append("}");
        }
        return errorStringBuilder.toString();
    }
}
