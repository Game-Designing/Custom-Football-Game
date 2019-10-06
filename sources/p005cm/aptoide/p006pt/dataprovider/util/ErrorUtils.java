package p005cm.aptoide.p006pt.dataprovider.util;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import p005cm.aptoide.p006pt.dataprovider.exception.NoNetworkConnectionException;

/* renamed from: cm.aptoide.pt.dataprovider.util.ErrorUtils */
public class ErrorUtils {
    public static boolean isNoNetworkConnection(Throwable throwable) {
        return (throwable instanceof NoNetworkConnectionException) || (throwable.getCause() != null && (throwable.getCause() instanceof SocketTimeoutException)) || (throwable instanceof UnknownHostException) || (throwable instanceof ConnectException);
    }
}
