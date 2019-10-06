package com.paypal.android.sdk;

/* renamed from: com.paypal.android.sdk.ca */
public class C11797ca extends C11789aa {
    public C11797ca(C11793ba baVar, Exception exc) {
        this(baVar.toString(), (Throwable) exc);
    }

    public C11797ca(String str) {
        super("RequestError", str);
    }

    public C11797ca(String str, String str2, String str3) {
        super("RequestError", str, str2, str3);
    }

    public C11797ca(String str, Throwable th) {
        super(th.getClass().toString(), str, th.toString(), th.getMessage());
    }
}
