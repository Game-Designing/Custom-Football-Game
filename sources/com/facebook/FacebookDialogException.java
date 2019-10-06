package com.facebook;

public class FacebookDialogException extends FacebookException {

    /* renamed from: a */
    private int f11773a;

    /* renamed from: b */
    private String f11774b;

    public FacebookDialogException(String message, int errorCode, String failingUrl) {
        super(message);
        this.f11773a = errorCode;
        this.f11774b = failingUrl;
    }

    /* renamed from: a */
    public int mo19658a() {
        return this.f11773a;
    }

    /* renamed from: b */
    public String mo19659b() {
        return this.f11774b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{FacebookDialogException: ");
        sb.append("errorCode: ");
        sb.append(mo19658a());
        sb.append(", message: ");
        sb.append(getMessage());
        sb.append(", url: ");
        sb.append(mo19659b());
        sb.append("}");
        return sb.toString();
    }
}
