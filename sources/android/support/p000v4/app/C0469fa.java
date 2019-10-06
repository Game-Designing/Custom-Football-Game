package android.support.p000v4.app;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;
import p005cm.aptoide.p006pt.file.CacheHelper;

/* renamed from: android.support.v4.app.fa */
/* compiled from: SharedElementCallback */
public abstract class C0469fa {

    /* renamed from: a */
    private static int f1602a = CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES;

    /* renamed from: android.support.v4.app.fa$a */
    /* compiled from: SharedElementCallback */
    public interface C0470a {
    }

    /* renamed from: a */
    public abstract Parcelable mo5163a(View view, Matrix matrix, RectF rectF);

    /* renamed from: a */
    public abstract View mo5164a(Context context, Parcelable parcelable);

    /* renamed from: a */
    public abstract void mo5165a(List<View> list);

    /* renamed from: a */
    public abstract void mo5166a(List<String> list, List<View> list2, C0470a aVar);

    /* renamed from: a */
    public abstract void mo5167a(List<String> list, List<View> list2, List<View> list3);

    /* renamed from: a */
    public abstract void mo5168a(List<String> list, Map<String, View> map);

    /* renamed from: b */
    public abstract void mo5169b(List<String> list, List<View> list2, List<View> list3);
}
