package android.support.design.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: android.support.design.widget.ba */
/* compiled from: TextInputLayout */
class C0283ba implements OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TextInputLayout f1082a;

    C0283ba(TextInputLayout this$0) {
        this.f1082a = this$0;
    }

    public void onClick(View view) {
        this.f1082a.passwordVisibilityToggleRequested(false);
    }
}
