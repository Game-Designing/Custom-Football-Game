package p005cm.aptoide.p006pt.handlers;

import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: cm.aptoide.pt.handlers.ExtendedView */
public abstract class ExtendedView<T> {
    /* access modifiers changed from: private */
    public WeakReference<T> weakReference;

    /* renamed from: cm.aptoide.pt.handlers.ExtendedView$OnClickListener */
    public class OnClickListener implements android.view.View.OnClickListener {
        public OnClickListener() {
        }

        public void onClick(View v) {
            T ref = ExtendedView.this.weakReference.get();
            if (ref != null) {
                onClickReference(v, ref);
            } else {
                onNullReference(v);
            }
        }

        public void onClickReference(View v, T t) {
        }

        public void onNullReference(View v) {
        }
    }

    public ExtendedView(T ref) {
        this.weakReference = new WeakReference<>(ref);
    }
}
