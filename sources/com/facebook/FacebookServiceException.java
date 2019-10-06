package com.facebook;

public class FacebookServiceException extends FacebookException {

    /* renamed from: a */
    private final FacebookRequestError f11797a;

    public FacebookServiceException(FacebookRequestError error, String errorMessage) {
        super(errorMessage);
        this.f11797a = error;
    }

    /* renamed from: a */
    public final FacebookRequestError mo19671a() {
        return this.f11797a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{FacebookServiceException: ");
        sb.append("httpResponseCode: ");
        sb.append(this.f11797a.mo19666f());
        sb.append(", facebookErrorCode: ");
        sb.append(this.f11797a.mo19661b());
        sb.append(", facebookErrorType: ");
        sb.append(this.f11797a.mo19663d());
        sb.append(", message: ");
        sb.append(this.f11797a.mo19662c());
        sb.append("}");
        return sb.toString();
    }
}
