package p005cm.aptoide.p006pt.utils;

import android.util.Base64;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: cm.aptoide.pt.utils.IdUtils */
public final class IdUtils {
    private static final String TAG = IdUtils.class.getSimpleName();
    private static final SecureRandom random = new SecureRandom();
    private static final AtomicLong sequentialLongId = new AtomicLong();
    private final AtomicLong longId;

    public IdUtils(long initialValue) {
        this.longId = new AtomicLong(initialValue);
    }

    public static String randomString() {
        byte[] stringKey = new byte[32];
        random.nextBytes(stringKey);
        return Arrays.toString(Base64.encode(stringKey, 8));
    }

    public static long randomLong() {
        return random.nextLong();
    }

    public static long nextSequentialLong() {
        return sequentialLongId.incrementAndGet();
    }

    public long nextLong() {
        return this.longId.incrementAndGet();
    }
}
