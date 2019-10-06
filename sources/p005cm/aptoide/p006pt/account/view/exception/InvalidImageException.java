package p005cm.aptoide.p006pt.account.view.exception;

import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;

/* renamed from: cm.aptoide.pt.account.view.exception.InvalidImageException */
public class InvalidImageException extends Exception {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final String errorCode;
    private final List<ImageError> imageErrors;

    /* renamed from: cm.aptoide.pt.account.view.exception.InvalidImageException$ImageError */
    public enum ImageError {
        ERROR_DECODING,
        MIN_HEIGHT,
        MAX_HEIGHT,
        MIN_WIDTH,
        MAX_WIDTH,
        MAX_IMAGE_SIZE,
        API_ERROR;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-8519853781469621474L, "cm/aptoide/pt/account/view/exception/InvalidImageException", 4);
        $jacocoData = probes;
        return probes;
    }

    public InvalidImageException(List<ImageError> imageErrors2, String errorCode2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.errorCode = errorCode2;
        this.imageErrors = imageErrors2;
        $jacocoInit[0] = true;
    }

    public InvalidImageException(List<ImageError> imageErrors2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.imageErrors = imageErrors2;
        this.errorCode = null;
        $jacocoInit[1] = true;
    }

    public List<ImageError> getImageErrors() {
        boolean[] $jacocoInit = $jacocoInit();
        List<ImageError> list = this.imageErrors;
        $jacocoInit[2] = true;
        return list;
    }

    public String getErrorCode() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = this.errorCode;
        $jacocoInit[3] = true;
        return str;
    }
}
