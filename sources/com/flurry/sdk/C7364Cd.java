package com.flurry.sdk;

import java.io.PrintStream;
import java.io.PrintWriter;

/* renamed from: com.flurry.sdk.Cd */
public abstract class C7364Cd implements Runnable {

    /* renamed from: a */
    private static final String f14384a = C7364Cd.class.getSimpleName();

    /* renamed from: b */
    private PrintStream f14385b;

    /* renamed from: c */
    private PrintWriter f14386c;

    /* renamed from: a */
    public abstract void mo23803a() throws Exception;

    public final void run() {
        try {
            mo23803a();
        } catch (Throwable th) {
            PrintStream printStream = this.f14385b;
            if (printStream != null) {
                th.printStackTrace(printStream);
            } else {
                PrintWriter printWriter = this.f14386c;
                if (printWriter != null) {
                    th.printStackTrace(printWriter);
                } else {
                    th.printStackTrace();
                }
            }
            C7513ec.m16640a(6, f14384a, "", th);
        }
    }
}
