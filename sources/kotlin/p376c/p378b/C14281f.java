package kotlin.p376c.p378b;

import java.util.Arrays;
import java.util.List;
import kotlin.UninitializedPropertyAccessException;

/* renamed from: kotlin.c.b.f */
/* compiled from: Intrinsics */
public class C14281f {
    private C14281f() {
    }

    /* renamed from: a */
    public static void m45914a(String message) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(message);
        m45911a((T) uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    /* renamed from: b */
    public static void m45917b(String propertyName) {
        StringBuilder sb = new StringBuilder();
        sb.append("lateinit property ");
        sb.append(propertyName);
        sb.append(" has not been initialized");
        m45914a(sb.toString());
        throw null;
    }

    /* renamed from: a */
    public static void m45913a(Object value, String expression) {
        if (value == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(expression);
            sb.append(" must not be null");
            IllegalStateException illegalStateException = new IllegalStateException(sb.toString());
            m45911a((T) illegalStateException);
            throw illegalStateException;
        }
    }

    /* renamed from: b */
    public static void m45916b(Object value, String paramName) {
        if (value == null) {
            m45918c(paramName);
            throw null;
        }
    }

    /* renamed from: c */
    private static void m45918c(String paramName) {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[3];
        String className = caller.getClassName();
        String methodName = caller.getMethodName();
        StringBuilder sb = new StringBuilder();
        sb.append("Parameter specified as non-null is null: method ");
        sb.append(className);
        sb.append(".");
        sb.append(methodName);
        sb.append(", parameter ");
        sb.append(paramName);
        IllegalArgumentException exception = new IllegalArgumentException(sb.toString());
        m45911a((T) exception);
        throw exception;
    }

    /* renamed from: a */
    public static boolean m45915a(Object first, Object second) {
        if (first == null) {
            return second == null;
        }
        return first.equals(second);
    }

    /* renamed from: a */
    private static <T extends Throwable> T m45911a(T throwable) {
        m45912a(throwable, C14281f.class.getName());
        return throwable;
    }

    /* renamed from: a */
    static <T extends Throwable> T m45912a(T throwable, String classNameToDrop) {
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int size = stackTrace.length;
        int lastIntrinsic = -1;
        for (int i = 0; i < size; i++) {
            if (classNameToDrop.equals(stackTrace[i].getClassName())) {
                lastIntrinsic = i;
            }
        }
        List<StackTraceElement> list = Arrays.asList(stackTrace).subList(lastIntrinsic + 1, size);
        throwable.setStackTrace((StackTraceElement[]) list.toArray(new StackTraceElement[list.size()]));
        return throwable;
    }
}
