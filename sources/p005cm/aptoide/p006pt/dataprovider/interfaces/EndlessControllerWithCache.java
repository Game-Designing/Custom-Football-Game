package p005cm.aptoide.p006pt.dataprovider.interfaces;

import java.util.List;
import p026rx.C0120S;

/* renamed from: cm.aptoide.pt.dataprovider.interfaces.EndlessControllerWithCache */
public interface EndlessControllerWithCache<U> extends EndlessController<U> {
    C0120S<List<U>> loadMore(boolean z);
}
