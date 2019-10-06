package p005cm.aptoide.p006pt.editorialList;

import javax.inject.Provider;
import org.jacoco.agent.p025rt.internal_8ff85ea.Offline;
import p005cm.aptoide.p006pt.editorial.CaptionBackgroundPainter;
import p318e.C13183b;

/* renamed from: cm.aptoide.pt.editorialList.EditorialListFragment_MembersInjector */
public final class EditorialListFragment_MembersInjector implements C13183b<EditorialListFragment> {
    private static transient /* synthetic */ boolean[] $jacocoData;
    private final Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider;
    private final Provider<EditorialListPresenter> presenterProvider;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-3592753471760848407L, "cm/aptoide/pt/editorialList/EditorialListFragment_MembersInjector", 7);
        $jacocoData = probes;
        return probes;
    }

    public /* bridge */ /* synthetic */ void injectMembers(Object obj) {
        boolean[] $jacocoInit = $jacocoInit();
        injectMembers((EditorialListFragment) obj);
        $jacocoInit[6] = true;
    }

    public EditorialListFragment_MembersInjector(Provider<EditorialListPresenter> presenterProvider2, Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        this.presenterProvider = presenterProvider2;
        this.captionBackgroundPainterProvider = captionBackgroundPainterProvider2;
        $jacocoInit[0] = true;
    }

    public static C13183b<EditorialListFragment> create(Provider<EditorialListPresenter> presenterProvider2, Provider<CaptionBackgroundPainter> captionBackgroundPainterProvider2) {
        boolean[] $jacocoInit = $jacocoInit();
        EditorialListFragment_MembersInjector editorialListFragment_MembersInjector = new EditorialListFragment_MembersInjector(presenterProvider2, captionBackgroundPainterProvider2);
        $jacocoInit[1] = true;
        return editorialListFragment_MembersInjector;
    }

    public void injectMembers(EditorialListFragment instance) {
        boolean[] $jacocoInit = $jacocoInit();
        injectPresenter(instance, (EditorialListPresenter) this.presenterProvider.get());
        $jacocoInit[2] = true;
        injectCaptionBackgroundPainter(instance, (CaptionBackgroundPainter) this.captionBackgroundPainterProvider.get());
        $jacocoInit[3] = true;
    }

    public static void injectPresenter(EditorialListFragment instance, EditorialListPresenter presenter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.presenter = presenter;
        $jacocoInit[4] = true;
    }

    public static void injectCaptionBackgroundPainter(EditorialListFragment instance, CaptionBackgroundPainter captionBackgroundPainter) {
        boolean[] $jacocoInit = $jacocoInit();
        instance.captionBackgroundPainter = captionBackgroundPainter;
        $jacocoInit[5] = true;
    }
}
