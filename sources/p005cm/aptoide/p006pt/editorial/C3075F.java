package p005cm.aptoide.p006pt.editorial;

import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: cm.aptoide.pt.editorial.F */
/* compiled from: lambda */
public final /* synthetic */ class C3075F implements OnClickListener {

    /* renamed from: a */
    private final /* synthetic */ EditorialItemsViewHolder f6413a;

    /* renamed from: b */
    private final /* synthetic */ EditorialMedia f6414b;

    public /* synthetic */ C3075F(EditorialItemsViewHolder editorialItemsViewHolder, EditorialMedia editorialMedia) {
        this.f6413a = editorialItemsViewHolder;
        this.f6414b = editorialMedia;
    }

    public final void onClick(View view) {
        this.f6413a.mo13844a(this.f6414b, view);
    }
}
