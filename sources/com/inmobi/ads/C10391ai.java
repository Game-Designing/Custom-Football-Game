package com.inmobi.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import com.inmobi.ads.C10478c.C10490l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: com.inmobi.ads.ai */
/* compiled from: NativeAdTracker */
public class C10391ai {

    /* renamed from: a */
    static final Map<Context, C10608y> f31587a = new WeakHashMap();

    /* renamed from: b */
    private static final String f31588b = C10391ai.class.getSimpleName();

    /* renamed from: c */
    private static final Map<Context, C10523ce> f31589c = new WeakHashMap();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final Map<View, C10395a> f31590d = new HashMap();

    /* renamed from: e */
    private static final C10610a f31591e = new C10610a() {
        /* renamed from: a */
        public final void mo34076a(View view, Object obj) {
            ((C10380ah) obj).mo34009a(view);
        }
    };

    /* renamed from: f */
    private static final C10524a f31592f = new C10524a() {

        /* renamed from: a */
        private final Rect f31595a = new Rect();

        /* renamed from: a */
        public final boolean mo34077a(View view, View view2, int i, Object obj) {
            if (!(obj instanceof C10380ah) || ((C10380ah) obj).f31563l) {
                return false;
            }
            if (view2 instanceof NativeVideoView) {
                C10432av mediaPlayer = ((NativeVideoView) view2).getMediaPlayer();
                if (!(mediaPlayer == null || 3 == mediaPlayer.f31745a)) {
                    return false;
                }
            }
            if (view2 == null || view == null || !view2.isShown() || view.getParent() == null || !view2.getGlobalVisibleRect(this.f31595a)) {
                return false;
            }
            long height = ((long) this.f31595a.height()) * ((long) this.f31595a.width());
            long width = ((long) view.getWidth()) * ((long) view.getHeight());
            if (width <= 0 || height * 100 < ((long) i) * width) {
                return false;
            }
            return true;
        }
    };

    /* renamed from: g */
    private boolean f31593g;

    /* renamed from: h */
    private int f31594h;

    /* renamed from: com.inmobi.ads.ai$a */
    /* compiled from: NativeAdTracker */
    public interface C10395a {
        /* renamed from: a */
        void mo34045a(View view, boolean z);
    }

    C10391ai(int i) {
        this.f31594h = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34074a(Context context, View view, C10380ah ahVar, C10490l lVar) {
        C10608y yVar = (C10608y) f31587a.get(context);
        if (yVar == null) {
            if (context instanceof Activity) {
                yVar = new C10608y(lVar, new C10596s(f31592f, (Activity) context), f31591e);
                if (VERSION.SDK_INT >= 15 && !this.f31593g) {
                    this.f31593g = true;
                }
            } else {
                yVar = new C10608y(lVar, new C10457bk(f31592f, lVar), f31591e);
            }
            f31587a.put(context, yVar);
        }
        if (this.f31594h != 0) {
            yVar.mo34413a(view, ahVar, lVar.f31964a, lVar.f31965b);
        } else {
            yVar.mo34413a(view, ahVar, lVar.f31969f, lVar.f31970g);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34075a(Context context, C10380ah ahVar) {
        C10608y yVar = (C10608y) f31587a.get(context);
        if (yVar != null) {
            yVar.mo34411a((Object) ahVar);
            if (!(!yVar.f32312a.isEmpty())) {
                mo34071a(context);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34071a(Context context) {
        C10608y yVar = (C10608y) f31587a.remove(context);
        if (yVar != null) {
            yVar.mo34415c();
        }
        if ((context instanceof Activity) && VERSION.SDK_INT >= 15 && f31587a.isEmpty() && this.f31593g) {
            this.f31593g = false;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34073a(Context context, View view, C10380ah ahVar, C10395a aVar, C10490l lVar) {
        C10523ce ceVar;
        C10523ce ceVar2 = (C10523ce) f31589c.get(context);
        if (ceVar2 == null) {
            boolean z = context instanceof Activity;
            if (z) {
                ceVar = new C10596s(f31592f, (Activity) context);
            } else {
                ceVar = new C10457bk(f31592f, lVar);
            }
            ceVar.f32090c = new C10526c() {
                /* renamed from: a */
                public final void mo34078a(List<View> list, List<View> list2) {
                    for (View view : list) {
                        C10395a aVar = (C10395a) C10391ai.f31590d.get(view);
                        if (aVar != null) {
                            aVar.mo34045a(view, true);
                        }
                    }
                    for (View view2 : list2) {
                        C10395a aVar2 = (C10395a) C10391ai.f31590d.get(view2);
                        if (aVar2 != null) {
                            aVar2.mo34045a(view2, false);
                        }
                    }
                }
            };
            f31589c.put(context, ceVar);
            if (z && VERSION.SDK_INT >= 15 && !this.f31593g) {
                this.f31593g = true;
            }
            ceVar2 = ceVar;
        }
        f31590d.put(view, aVar);
        if (this.f31594h != 0) {
            ceVar2.mo34246a(view, ahVar, lVar.f31968e);
        } else {
            ceVar2.mo34246a(view, ahVar, lVar.f31971h);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public final void mo34072a(Context context, View view, C10380ah ahVar) {
        C10523ce ceVar = (C10523ce) f31589c.get(context);
        if (ceVar != null) {
            ceVar.mo34244a((Object) ahVar);
            if (!(!ceVar.f32089b.isEmpty())) {
                C10523ce ceVar2 = (C10523ce) f31589c.remove(context);
                if (ceVar2 != null) {
                    ceVar2.mo34249e();
                }
                if ((context instanceof Activity) && VERSION.SDK_INT >= 15 && f31589c.isEmpty() && this.f31593g) {
                    this.f31593g = false;
                }
            }
        }
        f31590d.remove(view);
    }

    /* renamed from: b */
    static void m34012b(Context context) {
        C10608y yVar = (C10608y) f31587a.get(context);
        if (yVar != null) {
            yVar.mo34414b();
        }
    }

    /* renamed from: c */
    static void m34013c(Context context) {
        C10608y yVar = (C10608y) f31587a.get(context);
        if (yVar != null) {
            yVar.mo34412a();
        }
    }
}
