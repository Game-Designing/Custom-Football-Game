package p005cm.aptoide.p006pt.updates.view.excluded;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/* renamed from: cm.aptoide.pt.updates.view.excluded.a */
/* compiled from: lambda */
public final /* synthetic */ class C5151a implements OnCheckedChangeListener {

    /* renamed from: a */
    private final /* synthetic */ ExcludedUpdateDisplayable f8891a;

    public /* synthetic */ C5151a(ExcludedUpdateDisplayable excludedUpdateDisplayable) {
        this.f8891a = excludedUpdateDisplayable;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        ExcludedUpdateWidget.m9436a(this.f8891a, compoundButton, z);
    }
}
