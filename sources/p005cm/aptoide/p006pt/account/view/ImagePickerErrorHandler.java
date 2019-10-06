package p005cm.aptoide.p006pt.account.view;

import android.content.Context;
import android.content.res.Resources;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.C1375R;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException.ImageError;
import p005cm.aptoide.p006pt.utils.GenericDialogs;
import p005cm.aptoide.p006pt.utils.GenericDialogs.EResponse;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.account.view.ImagePickerErrorHandler */
public class ImagePickerErrorHandler {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Context context;
    private final Resources resources;

    /* renamed from: cm.aptoide.pt.account.view.ImagePickerErrorHandler$1 */
    static /* synthetic */ class C14631 {

        /* renamed from: $SwitchMap$cm$aptoide$pt$account$view$exception$InvalidImageException$ImageError */
        static final /* synthetic */ int[] f4387xc452ba21 = new int[ImageError.values().length];
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-7026112844068233435L, "cm/aptoide/pt/account/view/ImagePickerErrorHandler$1", 14);
            $jacocoData = probes;
            return probes;
        }

        static {
            boolean[] $jacocoInit = $jacocoInit();
            try {
                $jacocoInit[0] = true;
                f4387xc452ba21[ImageError.MIN_HEIGHT.ordinal()] = 1;
                $jacocoInit[1] = true;
            } catch (NoSuchFieldError e) {
                try {
                    $jacocoInit[2] = true;
                } catch (NoSuchFieldError e2) {
                    try {
                        $jacocoInit[4] = true;
                    } catch (NoSuchFieldError e3) {
                        try {
                            $jacocoInit[6] = true;
                        } catch (NoSuchFieldError e4) {
                            try {
                                $jacocoInit[8] = true;
                            } catch (NoSuchFieldError e5) {
                                try {
                                    $jacocoInit[10] = true;
                                } catch (NoSuchFieldError e6) {
                                    $jacocoInit[12] = true;
                                }
                            }
                        }
                    }
                }
            }
            f4387xc452ba21[ImageError.MAX_HEIGHT.ordinal()] = 2;
            $jacocoInit[3] = true;
            f4387xc452ba21[ImageError.MIN_WIDTH.ordinal()] = 3;
            $jacocoInit[5] = true;
            f4387xc452ba21[ImageError.MAX_WIDTH.ordinal()] = 4;
            $jacocoInit[7] = true;
            f4387xc452ba21[ImageError.MAX_IMAGE_SIZE.ordinal()] = 5;
            $jacocoInit[9] = true;
            f4387xc452ba21[ImageError.ERROR_DECODING.ordinal()] = 6;
            $jacocoInit[11] = true;
            $jacocoInit[13] = true;
        }
    }

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(3291841174767546794L, "cm/aptoide/pt/account/view/ImagePickerErrorHandler", 21);
        $jacocoData = probes;
        return probes;
    }

    public ImagePickerErrorHandler(Context context2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.context = context2;
        $jacocoInit[0] = true;
        this.resources = context2.getResources();
        $jacocoInit[1] = true;
    }

    public C0120S<EResponse> showIconPropertiesError(InvalidImageException exception) {
        boolean[] $jacocoInit = $jacocoInit();
        String errors = buildErrorMessage(exception);
        Context context2 = this.context;
        Resources resources2 = this.resources;
        $jacocoInit[2] = true;
        String string = resources2.getString(C1375R.string.image_requirements_error_popup_title);
        $jacocoInit[3] = true;
        C0120S<EResponse> createGenericOkMessage = GenericDialogs.createGenericOkMessage(context2, string, errors);
        $jacocoInit[4] = true;
        return createGenericOkMessage;
    }

    private String buildErrorMessage(InvalidImageException err) {
        boolean[] $jacocoInit = $jacocoInit();
        StringBuilder message = new StringBuilder();
        $jacocoInit[5] = true;
        message.append(this.resources.getString(C1375R.string.image_requirements_popup_message));
        $jacocoInit[6] = true;
        $jacocoInit[7] = true;
        for (ImageError imageSizeError : err.getImageErrors()) {
            $jacocoInit[8] = true;
            switch (C14631.f4387xc452ba21[imageSizeError.ordinal()]) {
                case 1:
                    message.append(this.resources.getString(C1375R.string.image_requirements_error_min_height));
                    $jacocoInit[10] = true;
                    break;
                case 2:
                    message.append(this.resources.getString(C1375R.string.image_requirements_error_max_height));
                    $jacocoInit[11] = true;
                    break;
                case 3:
                    message.append(this.resources.getString(C1375R.string.image_requirements_error_min_width));
                    $jacocoInit[12] = true;
                    break;
                case 4:
                    message.append(this.resources.getString(C1375R.string.image_requirements_error_max_width));
                    $jacocoInit[13] = true;
                    break;
                case 5:
                    message.append(this.resources.getString(C1375R.string.image_requirements_error_max_file_size));
                    $jacocoInit[14] = true;
                    break;
                case 6:
                    message.append(this.resources.getString(C1375R.string.image_requirements_error_open_image));
                    $jacocoInit[15] = true;
                    break;
                default:
                    $jacocoInit[9] = true;
                    break;
            }
            $jacocoInit[16] = true;
        }
        int index = message.lastIndexOf("\n");
        if (index <= 0) {
            $jacocoInit[17] = true;
        } else {
            $jacocoInit[18] = true;
            message.delete(index, message.length());
            $jacocoInit[19] = true;
        }
        String sb = message.toString();
        $jacocoInit[20] = true;
        return sb;
    }
}
