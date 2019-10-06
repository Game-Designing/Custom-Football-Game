package p005cm.aptoide.p006pt.app.view;

/* renamed from: cm.aptoide.pt.app.view.Scrollable */
public interface Scrollable {

    /* renamed from: cm.aptoide.pt.app.view.Scrollable$Position */
    public enum Position {
        FIRST,
        LAST;

        static {
            boolean[] $jacocoInit;
            $jacocoInit[3] = true;
        }
    }

    void itemAdded(int i);

    void itemChanged(int i);

    void itemRemoved(int i);

    void scroll(Position position);
}
