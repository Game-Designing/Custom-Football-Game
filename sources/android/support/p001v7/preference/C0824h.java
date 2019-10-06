package android.support.p001v7.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* renamed from: android.support.v7.preference.h */
/* compiled from: ListPreferenceDialogFragmentCompat */
class C0824h implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ C0825i f2496a;

    C0824h(C0825i this$0) {
        this.f2496a = this$0;
    }

    public void onClick(DialogInterface dialog, int which) {
        this.f2496a.f2497i = which;
        this.f2496a.onClick(dialog, -1);
        dialog.dismiss();
    }
}
