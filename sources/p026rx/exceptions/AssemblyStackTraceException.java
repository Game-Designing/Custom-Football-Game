package p026rx.exceptions;

/* renamed from: rx.exceptions.AssemblyStackTraceException */
public final class AssemblyStackTraceException extends RuntimeException {
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
