package com.google.android.gms.common.api;

public class ApiException extends Exception {

    /* renamed from: a */
    protected final Status f19548a;

    public ApiException(Status status) {
        int a = status.mo27417a();
        String c = status.mo27419c() != null ? status.mo27419c() : "";
        StringBuilder sb = new StringBuilder(String.valueOf(c).length() + 13);
        sb.append(a);
        sb.append(": ");
        sb.append(c);
        super(sb.toString());
        this.f19548a = status;
    }
}
