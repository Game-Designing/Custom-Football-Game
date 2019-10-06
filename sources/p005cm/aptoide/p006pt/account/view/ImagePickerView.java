package p005cm.aptoide.p006pt.account.view;

import android.content.DialogInterface;
import p005cm.aptoide.p006pt.account.view.exception.InvalidImageException;
import p005cm.aptoide.p006pt.presenter.View;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.account.view.ImagePickerView */
public interface ImagePickerView extends View {
    C0120S<DialogInterface> dialogCameraSelected();

    C0120S<DialogInterface> dialogGallerySelected();

    void dismissLoadImageDialog();

    void loadImage(String str);

    C0120S<Void> selectStoreImageClick();

    void showIconPropertiesError(InvalidImageException invalidImageException);

    void showImagePickerDialog();
}
