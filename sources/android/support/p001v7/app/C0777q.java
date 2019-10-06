package android.support.p001v7.app;

import android.content.res.Resources.NotFoundException;
import java.lang.Thread.UncaughtExceptionHandler;

/* renamed from: android.support.v7.app.q */
/* compiled from: AppCompatDelegateImplBase */
class C0777q implements UncaughtExceptionHandler {

    /* renamed from: a */
    final /* synthetic */ UncaughtExceptionHandler f2343a;

    C0777q(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f2343a = uncaughtExceptionHandler;
    }

    public void uncaughtException(Thread thread, Throwable thowable) {
        if (m3662a(thowable)) {
            StringBuilder sb = new StringBuilder();
            sb.append(thowable.getMessage());
            sb.append(". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
            Throwable wrapped = new NotFoundException(sb.toString());
            wrapped.initCause(thowable.getCause());
            wrapped.setStackTrace(thowable.getStackTrace());
            this.f2343a.uncaughtException(thread, wrapped);
            return;
        }
        this.f2343a.uncaughtException(thread, thowable);
    }

    /* renamed from: a */
    private boolean m3662a(Throwable throwable) {
        boolean z = false;
        if (!(throwable instanceof NotFoundException)) {
            return false;
        }
        String message = throwable.getMessage();
        if (message != null && (message.contains("drawable") || message.contains("Drawable"))) {
            z = true;
        }
        return z;
    }
}
