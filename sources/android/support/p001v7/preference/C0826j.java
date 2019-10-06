package android.support.p001v7.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;

/* renamed from: android.support.v7.preference.j */
/* compiled from: MultiSelectListPreferenceDialogFragmentCompat */
class C0826j implements OnMultiChoiceClickListener {

    /* renamed from: a */
    final /* synthetic */ C0827k f2500a;

    C0826j(C0827k this$0) {
        this.f2500a = this$0;
    }

    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        if (isChecked) {
            C0827k kVar = this.f2500a;
            kVar.f2502j = kVar.f2502j | this.f2500a.f2501i.add(this.f2500a.f2504l[which].toString());
            return;
        }
        C0827k kVar2 = this.f2500a;
        kVar2.f2502j = kVar2.f2502j | this.f2500a.f2501i.remove(this.f2500a.f2504l[which].toString());
    }
}
