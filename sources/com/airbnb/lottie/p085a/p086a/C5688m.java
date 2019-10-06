package com.airbnb.lottie.p085a.p086a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import com.airbnb.lottie.animation.content.PathContent;
import com.airbnb.lottie.p089c.p091b.C5743h;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
/* renamed from: com.airbnb.lottie.a.a.m */
/* compiled from: MergePathsContent */
public class C5688m implements C5690o, C5685j {

    /* renamed from: a */
    private final Path f9724a = new Path();

    /* renamed from: b */
    private final Path f9725b = new Path();

    /* renamed from: c */
    private final Path f9726c = new Path();

    /* renamed from: d */
    private final String f9727d;

    /* renamed from: e */
    private final List<C5690o> f9728e = new ArrayList();

    /* renamed from: f */
    private final C5743h f9729f;

    public C5688m(C5743h mergePaths) {
        if (VERSION.SDK_INT >= 19) {
            this.f9727d = mergePaths.mo18027b();
            this.f9729f = mergePaths;
            return;
        }
        throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
    }

    /* renamed from: a */
    public void mo17942a(ListIterator<C5678c> contents) {
        while (contents.hasPrevious()) {
            if (contents.previous() == this) {
                break;
            }
        }
        while (contents.hasPrevious()) {
            C5678c content = (C5678c) contents.previous();
            if (content instanceof C5690o) {
                this.f9728e.add((C5690o) content);
                contents.remove();
            }
        }
    }

    /* renamed from: a */
    public void mo17937a(List<C5678c> contentsBefore, List<C5678c> contentsAfter) {
        for (int i = 0; i < this.f9728e.size(); i++) {
            ((C5690o) this.f9728e.get(i)).mo17937a(contentsBefore, contentsAfter);
        }
    }

    public Path getPath() {
        this.f9726c.reset();
        int i = C5687l.f9723a[this.f9729f.mo18026a().ordinal()];
        if (i == 1) {
            m10077a();
        } else if (i == 2) {
            m10078a(Op.UNION);
        } else if (i == 3) {
            m10078a(Op.REVERSE_DIFFERENCE);
        } else if (i == 4) {
            m10078a(Op.INTERSECT);
        } else if (i == 5) {
            m10078a(Op.XOR);
        }
        return this.f9726c;
    }

    /* renamed from: a */
    private void m10077a() {
        for (int i = 0; i < this.f9728e.size(); i++) {
            this.f9726c.addPath(((C5690o) this.f9728e.get(i)).getPath());
        }
    }

    @TargetApi(19)
    /* renamed from: a */
    private void m10078a(Op op) {
        this.f9725b.reset();
        this.f9724a.reset();
        for (int i = this.f9728e.size() - 1; i >= 1; i--) {
            C5690o content = (C5690o) this.f9728e.get(i);
            if (content instanceof C5679d) {
                List<PathContent> pathList = ((C5679d) content).mo17939b();
                for (int j = pathList.size() - 1; j >= 0; j--) {
                    Path path = ((C5690o) pathList.get(j)).getPath();
                    path.transform(((C5679d) content).mo17940c());
                    this.f9725b.addPath(path);
                }
            } else {
                this.f9725b.addPath(content.getPath());
            }
        }
        C5690o lastContent = (C5690o) this.f9728e.get(0);
        if (lastContent instanceof C5679d) {
            List<PathContent> pathList2 = ((C5679d) lastContent).mo17939b();
            for (int j2 = 0; j2 < pathList2.size(); j2++) {
                Path path2 = ((C5690o) pathList2.get(j2)).getPath();
                path2.transform(((C5679d) lastContent).mo17940c());
                this.f9724a.addPath(path2);
            }
        } else {
            this.f9724a.set(lastContent.getPath());
        }
        this.f9726c.op(this.f9724a, this.f9725b, op);
    }
}
