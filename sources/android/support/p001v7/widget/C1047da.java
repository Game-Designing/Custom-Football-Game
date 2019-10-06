package android.support.p001v7.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.support.p000v4.view.C0646w;
import android.support.p001v7.widget.RecyclerView.C1000w;
import android.support.p001v7.widget.RecyclerView.ViewHolder;
import android.support.v7.widget.DefaultItemAnimator.ChangeInfo;
import android.support.v7.widget.DefaultItemAnimator.MoveInfo;
import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.v7.widget.da */
/* compiled from: DefaultItemAnimator */
public class C1047da extends C1053eb {

    /* renamed from: h */
    private static TimeInterpolator f3477h;

    /* renamed from: i */
    private ArrayList<C1000w> f3478i = new ArrayList<>();

    /* renamed from: j */
    private ArrayList<C1000w> f3479j = new ArrayList<>();

    /* renamed from: k */
    private ArrayList<C1049b> f3480k = new ArrayList<>();

    /* renamed from: l */
    private ArrayList<C1048a> f3481l = new ArrayList<>();

    /* renamed from: m */
    ArrayList<ArrayList<C1000w>> f3482m = new ArrayList<>();

    /* renamed from: n */
    ArrayList<ArrayList<C1049b>> f3483n = new ArrayList<>();

    /* renamed from: o */
    ArrayList<ArrayList<C1048a>> f3484o = new ArrayList<>();

    /* renamed from: p */
    ArrayList<C1000w> f3485p = new ArrayList<>();

    /* renamed from: q */
    ArrayList<C1000w> f3486q = new ArrayList<>();

    /* renamed from: r */
    ArrayList<C1000w> f3487r = new ArrayList<>();

    /* renamed from: s */
    ArrayList<C1000w> f3488s = new ArrayList<>();

    /* renamed from: android.support.v7.widget.da$a */
    /* compiled from: DefaultItemAnimator */
    private static class C1048a {

        /* renamed from: a */
        public C1000w f3489a;

        /* renamed from: b */
        public C1000w f3490b;

        /* renamed from: c */
        public int f3491c;

        /* renamed from: d */
        public int f3492d;

        /* renamed from: e */
        public int f3493e;

        /* renamed from: f */
        public int f3494f;

        private C1048a(C1000w oldHolder, C1000w newHolder) {
            this.f3489a = oldHolder;
            this.f3490b = newHolder;
        }

        C1048a(C1000w oldHolder, C1000w newHolder, int fromX, int fromY, int toX, int toY) {
            this(oldHolder, newHolder);
            this.f3491c = fromX;
            this.f3492d = fromY;
            this.f3493e = toX;
            this.f3494f = toY;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ChangeInfo{oldHolder=");
            sb.append(this.f3489a);
            sb.append(", newHolder=");
            sb.append(this.f3490b);
            sb.append(", fromX=");
            sb.append(this.f3491c);
            sb.append(", fromY=");
            sb.append(this.f3492d);
            sb.append(", toX=");
            sb.append(this.f3493e);
            sb.append(", toY=");
            sb.append(this.f3494f);
            sb.append('}');
            return sb.toString();
        }
    }

    /* renamed from: android.support.v7.widget.da$b */
    /* compiled from: DefaultItemAnimator */
    private static class C1049b {

        /* renamed from: a */
        public C1000w f3495a;

        /* renamed from: b */
        public int f3496b;

        /* renamed from: c */
        public int f3497c;

        /* renamed from: d */
        public int f3498d;

        /* renamed from: e */
        public int f3499e;

        C1049b(C1000w holder, int fromX, int fromY, int toX, int toY) {
            this.f3495a = holder;
            this.f3496b = fromX;
            this.f3497c = fromY;
            this.f3498d = toX;
            this.f3499e = toY;
        }
    }

    /* renamed from: i */
    public void mo7740i() {
        boolean removalsPending = !this.f3478i.isEmpty();
        boolean movesPending = !this.f3480k.isEmpty();
        boolean changesPending = !this.f3481l.isEmpty();
        boolean additionsPending = !this.f3479j.isEmpty();
        if (removalsPending || movesPending || additionsPending || changesPending) {
            Iterator it = this.f3478i.iterator();
            while (it.hasNext()) {
                m5211u((C1000w) it.next());
            }
            this.f3478i.clear();
            if (movesPending) {
                ArrayList<MoveInfo> moves = new ArrayList<>();
                moves.addAll(this.f3480k);
                this.f3483n.add(moves);
                this.f3480k.clear();
                Runnable mover = new C1023V(this, moves);
                if (removalsPending) {
                    C0646w.m2959a(((C1049b) moves.get(0)).f3495a.itemView, mover, mo7737f());
                } else {
                    mover.run();
                }
            }
            if (changesPending) {
                ArrayList<ChangeInfo> changes = new ArrayList<>();
                changes.addAll(this.f3481l);
                this.f3484o.add(changes);
                this.f3481l.clear();
                Runnable changer = new C1026W(this, changes);
                if (removalsPending) {
                    C0646w.m2959a(((C1048a) changes.get(0)).f3489a.itemView, changer, mo7737f());
                } else {
                    changer.run();
                }
            }
            if (additionsPending) {
                ArrayList<ViewHolder> additions = new ArrayList<>();
                additions.addAll(this.f3479j);
                this.f3482m.add(additions);
                this.f3479j.clear();
                Runnable adder = new C1028X(this, additions);
                if (removalsPending || movesPending || changesPending) {
                    long changeDuration = 0;
                    long removeDuration = removalsPending ? mo7737f() : 0;
                    long moveDuration = movesPending ? mo7735e() : 0;
                    if (changesPending) {
                        changeDuration = mo7733d();
                    }
                    C0646w.m2959a(((C1000w) additions.get(0)).itemView, adder, Math.max(moveDuration, changeDuration) + removeDuration);
                } else {
                    adder.run();
                }
            }
        }
    }

    /* renamed from: g */
    public boolean mo8405g(C1000w holder) {
        m5212v(holder);
        this.f3478i.add(holder);
        return true;
    }

    /* renamed from: u */
    private void m5211u(C1000w holder) {
        View view = holder.itemView;
        ViewPropertyAnimator animation = view.animate();
        this.f3487r.add(holder);
        animation.setDuration(mo7737f()).alpha(0.0f).setListener(new C1030Y(this, holder, animation, view)).start();
    }

    /* renamed from: f */
    public boolean mo8404f(C1000w holder) {
        m5212v(holder);
        holder.itemView.setAlpha(0.0f);
        this.f3479j.add(holder);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public void mo8407t(C1000w holder) {
        View view = holder.itemView;
        ViewPropertyAnimator animation = view.animate();
        this.f3485p.add(holder);
        animation.alpha(1.0f).setDuration(mo7730c()).setListener(new C1032Z(this, holder, view, animation)).start();
    }

    /* renamed from: a */
    public boolean mo8401a(C1000w holder, int fromX, int fromY, int toX, int toY) {
        C1000w wVar = holder;
        View view = wVar.itemView;
        int fromX2 = fromX + ((int) wVar.itemView.getTranslationX());
        int fromY2 = fromY + ((int) wVar.itemView.getTranslationY());
        m5212v(holder);
        int deltaX = toX - fromX2;
        int deltaY = toY - fromY2;
        if (deltaX == 0 && deltaY == 0) {
            mo8419j(holder);
            return false;
        }
        if (deltaX != 0) {
            view.setTranslationX((float) (-deltaX));
        }
        if (deltaY != 0) {
            view.setTranslationY((float) (-deltaY));
        }
        ArrayList<C1049b> arrayList = this.f3480k;
        C1049b bVar = new C1049b(holder, fromX2, fromY2, toX, toY);
        arrayList.add(bVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8403b(C1000w holder, int fromX, int fromY, int toX, int toY) {
        C1000w wVar = holder;
        View view = wVar.itemView;
        int deltaX = toX - fromX;
        int deltaY = toY - fromY;
        if (deltaX != 0) {
            view.animate().translationX(0.0f);
        }
        if (deltaY != 0) {
            view.animate().translationY(0.0f);
        }
        ViewPropertyAnimator animation = view.animate();
        this.f3486q.add(wVar);
        ViewPropertyAnimator duration = animation.setDuration(mo7735e());
        C1038aa aaVar = new C1038aa(this, holder, deltaX, view, deltaY, animation);
        duration.setListener(aaVar).start();
    }

    /* renamed from: a */
    public boolean mo8402a(C1000w oldHolder, C1000w newHolder, int fromX, int fromY, int toX, int toY) {
        C1000w wVar = oldHolder;
        C1000w wVar2 = newHolder;
        if (wVar == wVar2) {
            return mo8401a(oldHolder, fromX, fromY, toX, toY);
        }
        float prevTranslationX = wVar.itemView.getTranslationX();
        float prevTranslationY = wVar.itemView.getTranslationY();
        float prevAlpha = wVar.itemView.getAlpha();
        m5212v(oldHolder);
        int deltaX = (int) (((float) (toX - fromX)) - prevTranslationX);
        int deltaY = (int) (((float) (toY - fromY)) - prevTranslationY);
        wVar.itemView.setTranslationX(prevTranslationX);
        wVar.itemView.setTranslationY(prevTranslationY);
        wVar.itemView.setAlpha(prevAlpha);
        if (wVar2 != null) {
            m5212v(wVar2);
            wVar2.itemView.setTranslationX((float) (-deltaX));
            wVar2.itemView.setTranslationY((float) (-deltaY));
            wVar2.itemView.setAlpha(0.0f);
        }
        ArrayList<C1048a> arrayList = this.f3481l;
        float f = prevTranslationX;
        C1048a aVar = r7;
        C1048a aVar2 = new C1048a(oldHolder, newHolder, fromX, fromY, toX, toY);
        arrayList.add(aVar);
        return true;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8399a(C1048a changeInfo) {
        C1000w holder = changeInfo.f3489a;
        View newView = null;
        View view = holder == null ? null : holder.itemView;
        C1000w newHolder = changeInfo.f3490b;
        if (newHolder != null) {
            newView = newHolder.itemView;
        }
        if (view != null) {
            ViewPropertyAnimator oldViewAnim = view.animate().setDuration(mo7733d());
            this.f3488s.add(changeInfo.f3489a);
            oldViewAnim.translationX((float) (changeInfo.f3493e - changeInfo.f3491c));
            oldViewAnim.translationY((float) (changeInfo.f3494f - changeInfo.f3492d));
            oldViewAnim.alpha(0.0f).setListener(new C1041ba(this, changeInfo, oldViewAnim, view)).start();
        }
        if (newView != null) {
            ViewPropertyAnimator newViewAnimation = newView.animate();
            this.f3488s.add(changeInfo.f3490b);
            newViewAnimation.translationX(0.0f).translationY(0.0f).setDuration(mo7733d()).alpha(1.0f).setListener(new C1044ca(this, changeInfo, newViewAnimation, newView)).start();
        }
    }

    /* renamed from: a */
    private void m5208a(List<C1048a> infoList, C1000w item) {
        for (int i = infoList.size() - 1; i >= 0; i--) {
            C1048a changeInfo = (C1048a) infoList.get(i);
            if (m5209a(changeInfo, item) && changeInfo.f3489a == null && changeInfo.f3490b == null) {
                infoList.remove(changeInfo);
            }
        }
    }

    /* renamed from: b */
    private void m5210b(C1048a changeInfo) {
        C1000w wVar = changeInfo.f3489a;
        if (wVar != null) {
            m5209a(changeInfo, wVar);
        }
        C1000w wVar2 = changeInfo.f3490b;
        if (wVar2 != null) {
            m5209a(changeInfo, wVar2);
        }
    }

    /* renamed from: a */
    private boolean m5209a(C1048a changeInfo, C1000w item) {
        boolean oldItem = false;
        if (changeInfo.f3490b == item) {
            changeInfo.f3490b = null;
        } else if (changeInfo.f3489a != item) {
            return false;
        } else {
            changeInfo.f3489a = null;
            oldItem = true;
        }
        item.itemView.setAlpha(1.0f);
        item.itemView.setTranslationX(0.0f);
        item.itemView.setTranslationY(0.0f);
        mo8412a(item, oldItem);
        return true;
    }

    /* renamed from: d */
    public void mo7734d(C1000w item) {
        View view = item.itemView;
        view.animate().cancel();
        int i = this.f3480k.size();
        while (true) {
            i--;
            if (i < 0) {
                break;
            } else if (((C1049b) this.f3480k.get(i)).f3495a == item) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                mo8419j(item);
                this.f3480k.remove(i);
            }
        }
        m5208a((List<C1048a>) this.f3481l, item);
        if (this.f3478i.remove(item)) {
            view.setAlpha(1.0f);
            mo8421l(item);
        }
        if (this.f3479j.remove(item)) {
            view.setAlpha(1.0f);
            mo8417h(item);
        }
        for (int i2 = this.f3484o.size() - 1; i2 >= 0; i2--) {
            ArrayList<ChangeInfo> changes = (ArrayList) this.f3484o.get(i2);
            m5208a((List<C1048a>) changes, item);
            if (changes.isEmpty()) {
                this.f3484o.remove(i2);
            }
        }
        for (int i3 = this.f3483n.size() - 1; i3 >= 0; i3--) {
            ArrayList<MoveInfo> moves = (ArrayList) this.f3483n.get(i3);
            int j = moves.size() - 1;
            while (true) {
                if (j < 0) {
                    break;
                } else if (((C1049b) moves.get(j)).f3495a == item) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    mo8419j(item);
                    moves.remove(j);
                    if (moves.isEmpty()) {
                        this.f3483n.remove(i3);
                    }
                } else {
                    j--;
                }
            }
        }
        for (int i4 = this.f3482m.size() - 1; i4 >= 0; i4--) {
            ArrayList<ViewHolder> additions = (ArrayList) this.f3482m.get(i4);
            if (additions.remove(item)) {
                view.setAlpha(1.0f);
                mo8417h(item);
                if (additions.isEmpty()) {
                    this.f3482m.remove(i4);
                }
            }
        }
        this.f3487r.remove(item);
        this.f3485p.remove(item);
        this.f3488s.remove(item);
        this.f3486q.remove(item);
        mo8406j();
    }

    /* renamed from: v */
    private void m5212v(C1000w holder) {
        if (f3477h == null) {
            f3477h = new ValueAnimator().getInterpolator();
        }
        holder.itemView.animate().setInterpolator(f3477h);
        mo7734d(holder);
    }

    /* renamed from: g */
    public boolean mo7738g() {
        return !this.f3479j.isEmpty() || !this.f3481l.isEmpty() || !this.f3480k.isEmpty() || !this.f3478i.isEmpty() || !this.f3486q.isEmpty() || !this.f3487r.isEmpty() || !this.f3485p.isEmpty() || !this.f3488s.isEmpty() || !this.f3483n.isEmpty() || !this.f3482m.isEmpty() || !this.f3484o.isEmpty();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: j */
    public void mo8406j() {
        if (!mo7738g()) {
            mo7721a();
        }
    }

    /* renamed from: b */
    public void mo7727b() {
        for (int i = this.f3480k.size() - 1; i >= 0; i--) {
            C1049b item = (C1049b) this.f3480k.get(i);
            View view = item.f3495a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            mo8419j(item.f3495a);
            this.f3480k.remove(i);
        }
        for (int i2 = this.f3478i.size() - 1; i2 >= 0; i2--) {
            mo8421l((C1000w) this.f3478i.get(i2));
            this.f3478i.remove(i2);
        }
        for (int i3 = this.f3479j.size() - 1; i3 >= 0; i3--) {
            C1000w item2 = (C1000w) this.f3479j.get(i3);
            item2.itemView.setAlpha(1.0f);
            mo8417h(item2);
            this.f3479j.remove(i3);
        }
        for (int i4 = this.f3481l.size() - 1; i4 >= 0; i4--) {
            m5210b((C1048a) this.f3481l.get(i4));
        }
        this.f3481l.clear();
        if (mo7738g()) {
            for (int i5 = this.f3483n.size() - 1; i5 >= 0; i5--) {
                ArrayList<MoveInfo> moves = (ArrayList) this.f3483n.get(i5);
                for (int j = moves.size() - 1; j >= 0; j--) {
                    C1049b moveInfo = (C1049b) moves.get(j);
                    View view2 = moveInfo.f3495a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    mo8419j(moveInfo.f3495a);
                    moves.remove(j);
                    if (moves.isEmpty()) {
                        this.f3483n.remove(moves);
                    }
                }
            }
            for (int i6 = this.f3482m.size() - 1; i6 >= 0; i6--) {
                ArrayList<ViewHolder> additions = (ArrayList) this.f3482m.get(i6);
                for (int j2 = additions.size() - 1; j2 >= 0; j2--) {
                    C1000w item3 = (C1000w) additions.get(j2);
                    item3.itemView.setAlpha(1.0f);
                    mo8417h(item3);
                    additions.remove(j2);
                    if (additions.isEmpty()) {
                        this.f3482m.remove(additions);
                    }
                }
            }
            for (int i7 = this.f3484o.size() - 1; i7 >= 0; i7--) {
                ArrayList<ChangeInfo> changes = (ArrayList) this.f3484o.get(i7);
                for (int j3 = changes.size() - 1; j3 >= 0; j3--) {
                    m5210b((C1048a) changes.get(j3));
                    if (changes.isEmpty()) {
                        this.f3484o.remove(changes);
                    }
                }
            }
            mo8400a((List<C1000w>) this.f3487r);
            mo8400a((List<C1000w>) this.f3486q);
            mo8400a((List<C1000w>) this.f3485p);
            mo8400a((List<C1000w>) this.f3488s);
            mo7721a();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8400a(List<C1000w> viewHolders) {
        for (int i = viewHolders.size() - 1; i >= 0; i--) {
            ((C1000w) viewHolders.get(i)).itemView.animate().cancel();
        }
    }

    /* renamed from: a */
    public boolean mo7726a(C1000w viewHolder, List<Object> payloads) {
        return !payloads.isEmpty() || super.mo7726a(viewHolder, payloads);
    }
}
