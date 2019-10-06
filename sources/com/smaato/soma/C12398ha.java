package com.smaato.soma;

import com.smaato.soma.p238b.C12143a;
import com.smaato.soma.p238b.C12146d;
import com.smaato.soma.p238b.C12147e;
import com.smaato.soma.p239c.p252i.C12277c;

/* renamed from: com.smaato.soma.ha */
/* compiled from: CrashReportTemplate */
public abstract class C12398ha<T> {
    public abstract T process() throws Exception;

    public T execute() {
        try {
            return process();
        } catch (Throwable e) {
            C12147e eVar = new C12147e("Error", "Crash Detected", 2, C12143a.EXCEPTION, e);
            C12146d.m39965a(eVar);
            C12277c.m40409a().mo39667c();
            return null;
        }
    }
}
