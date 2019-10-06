package p005cm.aptoide.p006pt.account.view.user;

import p005cm.aptoide.p006pt.account.view.ImagePickerView;
import p026rx.C0117M;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.account.view.user.ManageUserView */
public interface ManageUserView extends ImagePickerView {
    C0120S<Void> calendarLayoutClick();

    C0120S<Void> cancelButtonClick();

    void hideProgressDialog();

    void loadImageStateless(String str);

    C0120S<ViewModel> saveUserDataButtonClick();

    void setUserName(String str);

    void showCalendar();

    void showEmptyBirthdayMessage();

    C0117M showErrorMessage(String str);

    void showProgressDialog();
}
