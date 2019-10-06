package p005cm.aptoide.p006pt.account.view;

import android.graphics.Bitmap;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException.ImageError;
import p005cm.aptoide.p006pt.networking.image.ImageLoader;
import p026rx.C0117M;
import p026rx.C0126V;
import p026rx.p027b.C0131o;

/* renamed from: cm.aptoide.pt.account.view.ImageValidator */
public class ImageValidator {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    private static final int MAX_IMAGE_HEIGHT = 10240;
    private static final int MAX_IMAGE_SIZE_IN_BYTES = 5242880;
    private static final int MAX_IMAGE_WIDTH = 10240;
    private static final int MIN_IMAGE_HEIGHT = 600;
    private static final int MIN_IMAGE_WIDTH = 600;
    private final ImageLoader imageLoader;
    private final C0126V scheduler;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(1569796378611508605L, "cm/aptoide/pt/account/view/ImageValidator", 33);
        $jacocoData = probes;
        return probes;
    }

    public ImageValidator(ImageLoader imageLoader2, C0126V scheduler2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.imageLoader = imageLoader2;
        this.scheduler = scheduler2;
        $jacocoInit[0] = true;
    }

    public C0117M validateOrGetException(String imagePath) {
        boolean[] $jacocoInit = $jacocoInit();
        C0117M a = C0117M.m586a((C0131o<? extends C0117M>) new C1478V<Object>(this, imagePath));
        C0126V v = this.scheduler;
        $jacocoInit[1] = true;
        C0117M b = a.mo3593b(v);
        $jacocoInit[2] = true;
        return b;
    }

    /* renamed from: a */
    public /* synthetic */ C0117M mo9699a(String imagePath) {
        boolean[] $jacocoInit = $jacocoInit();
        try {
            validate(imagePath);
            $jacocoInit[29] = true;
            C0117M b = C0117M.m590b();
            $jacocoInit[30] = true;
            return b;
        } catch (InvalidImageException ex) {
            $jacocoInit[31] = true;
            C0117M b2 = C0117M.m591b((Throwable) ex);
            $jacocoInit[32] = true;
            return b2;
        }
    }

    private ImageInfo getInfo(String imagePath) {
        boolean[] $jacocoInit = $jacocoInit();
        ImageInfo imageInfo = null;
        $jacocoInit[3] = true;
        Bitmap image = this.imageLoader.load(imagePath);
        if (image == null) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            imageInfo = new ImageInfo(image.getWidth(), image.getHeight(), new File(imagePath).length());
            $jacocoInit[6] = true;
        }
        image.recycle();
        $jacocoInit[7] = true;
        return imageInfo;
    }

    private void validate(String imagePath) throws InvalidImageException {
        boolean[] $jacocoInit = $jacocoInit();
        ImageInfo imageInfo = getInfo(imagePath);
        $jacocoInit[8] = true;
        List<ImageError> errors = new ArrayList<>();
        if (imageInfo == null) {
            $jacocoInit[9] = true;
            errors.add(ImageError.ERROR_DECODING);
            $jacocoInit[10] = true;
        } else {
            if (imageInfo.getHeight() >= 600) {
                $jacocoInit[11] = true;
            } else {
                $jacocoInit[12] = true;
                errors.add(ImageError.MIN_HEIGHT);
                $jacocoInit[13] = true;
            }
            if (imageInfo.getWidth() >= 600) {
                $jacocoInit[14] = true;
            } else {
                $jacocoInit[15] = true;
                errors.add(ImageError.MIN_WIDTH);
                $jacocoInit[16] = true;
            }
            if (imageInfo.getHeight() <= 10240) {
                $jacocoInit[17] = true;
            } else {
                $jacocoInit[18] = true;
                errors.add(ImageError.MAX_HEIGHT);
                $jacocoInit[19] = true;
            }
            if (imageInfo.getWidth() <= 10240) {
                $jacocoInit[20] = true;
            } else {
                $jacocoInit[21] = true;
                errors.add(ImageError.MAX_WIDTH);
                $jacocoInit[22] = true;
            }
            if (imageInfo.getSize() <= 5242880) {
                $jacocoInit[23] = true;
            } else {
                $jacocoInit[24] = true;
                errors.add(ImageError.MAX_IMAGE_SIZE);
                $jacocoInit[25] = true;
            }
        }
        if (errors.isEmpty()) {
            $jacocoInit[28] = true;
            return;
        }
        $jacocoInit[26] = true;
        InvalidImageException invalidImageException = new InvalidImageException(errors);
        $jacocoInit[27] = true;
        throw invalidImageException;
    }
}
