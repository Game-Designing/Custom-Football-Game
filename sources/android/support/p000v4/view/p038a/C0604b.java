package android.support.p000v4.view.p038a;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionInfo;
import android.view.accessibility.AccessibilityNodeInfo.CollectionItemInfo;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: android.support.v4.view.a.b */
/* compiled from: AccessibilityNodeInfoCompat */
public class C0604b {

    /* renamed from: a */
    private final AccessibilityNodeInfo f1826a;

    /* renamed from: b */
    public int f1827b = -1;

    /* renamed from: android.support.v4.view.a.b$a */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class C0605a {

        /* renamed from: a */
        final Object f1828a;

        /* renamed from: a */
        public static C0605a m2843a(int rowCount, int columnCount, boolean hierarchical, int selectionMode) {
            int i = VERSION.SDK_INT;
            if (i >= 21) {
                return new C0605a(CollectionInfo.obtain(rowCount, columnCount, hierarchical, selectionMode));
            }
            if (i >= 19) {
                return new C0605a(CollectionInfo.obtain(rowCount, columnCount, hierarchical));
            }
            return new C0605a(null);
        }

        C0605a(Object info) {
            this.f1828a = info;
        }
    }

    /* renamed from: android.support.v4.view.a.b$b */
    /* compiled from: AccessibilityNodeInfoCompat */
    public static class C0606b {

        /* renamed from: a */
        final Object f1829a;

        /* renamed from: a */
        public static C0606b m2844a(int rowIndex, int rowSpan, int columnIndex, int columnSpan, boolean heading, boolean selected) {
            int i = VERSION.SDK_INT;
            if (i >= 21) {
                return new C0606b(CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading, selected));
            }
            if (i >= 19) {
                return new C0606b(CollectionItemInfo.obtain(rowIndex, rowSpan, columnIndex, columnSpan, heading));
            }
            return new C0606b(null);
        }

        C0606b(Object info) {
            this.f1829a = info;
        }

        /* renamed from: a */
        public int mo5612a() {
            if (VERSION.SDK_INT >= 19) {
                return ((CollectionItemInfo) this.f1829a).getColumnIndex();
            }
            return 0;
        }

        /* renamed from: b */
        public int mo5613b() {
            if (VERSION.SDK_INT >= 19) {
                return ((CollectionItemInfo) this.f1829a).getColumnSpan();
            }
            return 0;
        }

        /* renamed from: c */
        public int mo5614c() {
            if (VERSION.SDK_INT >= 19) {
                return ((CollectionItemInfo) this.f1829a).getRowIndex();
            }
            return 0;
        }

        /* renamed from: d */
        public int mo5615d() {
            if (VERSION.SDK_INT >= 19) {
                return ((CollectionItemInfo) this.f1829a).getRowSpan();
            }
            return 0;
        }

        /* renamed from: e */
        public boolean mo5616e() {
            if (VERSION.SDK_INT >= 21) {
                return ((CollectionItemInfo) this.f1829a).isSelected();
            }
            return false;
        }
    }

    private C0604b(AccessibilityNodeInfo info) {
        this.f1826a = info;
    }

    /* renamed from: a */
    public static C0604b m2810a(AccessibilityNodeInfo info) {
        return new C0604b(info);
    }

    /* renamed from: r */
    public AccessibilityNodeInfo mo5610r() {
        return this.f1826a;
    }

    /* renamed from: a */
    public int mo5578a() {
        return this.f1826a.getActions();
    }

    /* renamed from: a */
    public void mo5579a(int action) {
        this.f1826a.addAction(action);
    }

    /* renamed from: a */
    public void mo5580a(Rect outBounds) {
        this.f1826a.getBoundsInParent(outBounds);
    }

    /* renamed from: b */
    public void mo5586b(Rect outBounds) {
        this.f1826a.getBoundsInScreen(outBounds);
    }

    /* renamed from: h */
    public boolean mo5599h() {
        return this.f1826a.isCheckable();
    }

    /* renamed from: a */
    public void mo5584a(boolean checkable) {
        this.f1826a.setCheckable(checkable);
    }

    /* renamed from: i */
    public boolean mo5601i() {
        return this.f1826a.isChecked();
    }

    /* renamed from: b */
    public void mo5589b(boolean checked) {
        this.f1826a.setChecked(checked);
    }

    /* renamed from: l */
    public boolean mo5604l() {
        return this.f1826a.isFocusable();
    }

    /* renamed from: m */
    public boolean mo5605m() {
        return this.f1826a.isFocused();
    }

    /* renamed from: q */
    public boolean mo5609q() {
        return this.f1826a.isSelected();
    }

    /* renamed from: j */
    public boolean mo5602j() {
        return this.f1826a.isClickable();
    }

    /* renamed from: n */
    public boolean mo5606n() {
        return this.f1826a.isLongClickable();
    }

    /* renamed from: k */
    public boolean mo5603k() {
        return this.f1826a.isEnabled();
    }

    /* renamed from: o */
    public boolean mo5607o() {
        return this.f1826a.isPassword();
    }

    /* renamed from: p */
    public boolean mo5608p() {
        return this.f1826a.isScrollable();
    }

    /* renamed from: d */
    public void mo5594d(boolean scrollable) {
        this.f1826a.setScrollable(scrollable);
    }

    /* renamed from: e */
    public CharSequence mo5595e() {
        return this.f1826a.getPackageName();
    }

    /* renamed from: b */
    public CharSequence mo5585b() {
        return this.f1826a.getClassName();
    }

    /* renamed from: a */
    public void mo5582a(CharSequence className) {
        this.f1826a.setClassName(className);
    }

    /* renamed from: f */
    public CharSequence mo5597f() {
        return this.f1826a.getText();
    }

    /* renamed from: c */
    public void mo5591c(CharSequence text) {
        this.f1826a.setText(text);
    }

    /* renamed from: d */
    public CharSequence mo5593d() {
        return this.f1826a.getContentDescription();
    }

    /* renamed from: g */
    public String mo5598g() {
        if (VERSION.SDK_INT >= 18) {
            return this.f1826a.getViewIdResourceName();
        }
        return null;
    }

    /* renamed from: a */
    public void mo5583a(Object collectionInfo) {
        if (VERSION.SDK_INT >= 19) {
            this.f1826a.setCollectionInfo((CollectionInfo) ((C0605a) collectionInfo).f1828a);
        }
    }

    /* renamed from: b */
    public void mo5588b(Object collectionItemInfo) {
        if (VERSION.SDK_INT >= 19) {
            this.f1826a.setCollectionItemInfo((CollectionItemInfo) ((C0606b) collectionItemInfo).f1829a);
        }
    }

    /* renamed from: c */
    public C0606b mo5590c() {
        if (VERSION.SDK_INT >= 19) {
            CollectionItemInfo info = this.f1826a.getCollectionItemInfo();
            if (info != null) {
                return new C0606b(info);
            }
        }
        return null;
    }

    /* renamed from: c */
    public void mo5592c(boolean contentInvalid) {
        if (VERSION.SDK_INT >= 19) {
            this.f1826a.setContentInvalid(contentInvalid);
        }
    }

    /* renamed from: b */
    public void mo5587b(CharSequence error) {
        if (VERSION.SDK_INT >= 21) {
            this.f1826a.setError(error);
        }
    }

    /* renamed from: a */
    public void mo5581a(View labeled) {
        if (VERSION.SDK_INT >= 17) {
            this.f1826a.setLabelFor(labeled);
        }
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1826a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0604b other = (C0604b) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.f1826a;
        if (accessibilityNodeInfo == null) {
            if (other.f1826a != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(other.f1826a)) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        Rect bounds = new Rect();
        mo5580a(bounds);
        StringBuilder sb = new StringBuilder();
        sb.append("; boundsInParent: ");
        sb.append(bounds);
        builder.append(sb.toString());
        mo5586b(bounds);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("; boundsInScreen: ");
        sb2.append(bounds);
        builder.append(sb2.toString());
        builder.append("; packageName: ");
        builder.append(mo5595e());
        builder.append("; className: ");
        builder.append(mo5585b());
        builder.append("; text: ");
        builder.append(mo5597f());
        builder.append("; contentDescription: ");
        builder.append(mo5593d());
        builder.append("; viewId: ");
        builder.append(mo5598g());
        builder.append("; checkable: ");
        builder.append(mo5599h());
        builder.append("; checked: ");
        builder.append(mo5601i());
        builder.append("; focusable: ");
        builder.append(mo5604l());
        builder.append("; focused: ");
        builder.append(mo5605m());
        builder.append("; selected: ");
        builder.append(mo5609q());
        builder.append("; clickable: ");
        builder.append(mo5602j());
        builder.append("; longClickable: ");
        builder.append(mo5606n());
        builder.append("; enabled: ");
        builder.append(mo5603k());
        builder.append("; password: ");
        builder.append(mo5607o());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("; scrollable: ");
        sb3.append(mo5608p());
        builder.append(sb3.toString());
        builder.append("; [");
        int actionBits = mo5578a();
        while (actionBits != 0) {
            int action = 1 << Integer.numberOfTrailingZeros(actionBits);
            actionBits &= action ^ -1;
            builder.append(m2811b(action));
            if (actionBits != 0) {
                builder.append(", ");
            }
        }
        builder.append("]");
        return builder.toString();
    }

    /* renamed from: b */
    private static String m2811b(int action) {
        if (action == 1) {
            return "ACTION_FOCUS";
        }
        if (action == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (action) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case Opcodes.ACC_NATIVE /*256*/:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case Opcodes.ACC_ABSTRACT /*1024*/:
                return "ACTION_NEXT_HTML_ELEMENT";
            case Opcodes.ACC_STRICT /*2048*/:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case Opcodes.ACC_SYNTHETIC /*4096*/:
                return "ACTION_SCROLL_FORWARD";
            case Opcodes.ACC_ANNOTATION /*8192*/:
                return "ACTION_SCROLL_BACKWARD";
            case Opcodes.ACC_ENUM /*16384*/:
                return "ACTION_COPY";
            case Opcodes.ACC_MANDATED /*32768*/:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case Opcodes.ACC_DEPRECATED /*131072*/:
                return "ACTION_SET_SELECTION";
            default:
                return "ACTION_UNKNOWN";
        }
    }
}
