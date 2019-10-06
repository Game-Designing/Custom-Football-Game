package android.support.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: android.support.transition.V */
/* compiled from: TransitionValues */
public class C0347V {

    /* renamed from: a */
    public final Map<String, Object> f1214a = new HashMap();

    /* renamed from: b */
    public View f1215b;

    /* renamed from: c */
    final ArrayList<C0334M> f1216c = new ArrayList<>();

    public boolean equals(Object other) {
        if (!(other instanceof C0347V) || this.f1215b != ((C0347V) other).f1215b || !this.f1214a.equals(((C0347V) other).f1214a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.f1215b.hashCode() * 31) + this.f1214a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TransitionValues@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(":\n");
        String returnValue = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(returnValue);
        sb2.append("    view = ");
        sb2.append(this.f1215b);
        String str = "\n";
        sb2.append(str);
        String returnValue2 = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(returnValue2);
        sb3.append("    values:");
        String returnValue3 = sb3.toString();
        for (String s : this.f1214a.keySet()) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(returnValue3);
            sb4.append("    ");
            sb4.append(s);
            sb4.append(": ");
            sb4.append(this.f1214a.get(s));
            sb4.append(str);
            returnValue3 = sb4.toString();
        }
        return returnValue3;
    }
}
