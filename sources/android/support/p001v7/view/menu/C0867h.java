package android.support.p001v7.view.menu;

import android.os.SystemClock;
import android.support.p001v7.widget.C1128wa;
import android.view.MenuItem;

/* renamed from: android.support.v7.view.menu.h */
/* compiled from: CascadingMenuPopup */
class C0867h implements C1128wa {

    /* renamed from: a */
    final /* synthetic */ C0868i f2661a;

    C0867h(C0868i this$0) {
        this.f2661a = this$0;
    }

    /* renamed from: a */
    public void mo6675a(C0873l menu, MenuItem item) {
        this.f2661a.f2668g.removeCallbacksAndMessages(menu);
    }

    /* renamed from: b */
    public void mo6676b(C0873l menu, MenuItem item) {
        C0869a nextInfo;
        this.f2661a.f2668g.removeCallbacksAndMessages(null);
        int menuIndex = -1;
        int i = 0;
        int count = this.f2661a.f2670i.size();
        while (true) {
            if (i >= count) {
                break;
            } else if (menu == ((C0869a) this.f2661a.f2670i.get(i)).f2689b) {
                menuIndex = i;
                break;
            } else {
                i++;
            }
        }
        if (menuIndex != -1) {
            int nextIndex = menuIndex + 1;
            if (nextIndex < this.f2661a.f2670i.size()) {
                nextInfo = (C0869a) this.f2661a.f2670i.get(nextIndex);
            } else {
                nextInfo = null;
            }
            this.f2661a.f2668g.postAtTime(new C0866g(this, nextInfo, item, menu), menu, SystemClock.uptimeMillis() + 200);
        }
    }
}
