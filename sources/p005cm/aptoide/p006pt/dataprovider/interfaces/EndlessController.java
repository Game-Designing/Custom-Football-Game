package p005cm.aptoide.p006pt.dataprovider.interfaces;

import java.util.List;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.dataprovider.interfaces.EndlessController */
public interface EndlessController<U> {
    C0120S<List<U>> get();

    C0120S<List<U>> loadMore();
}
