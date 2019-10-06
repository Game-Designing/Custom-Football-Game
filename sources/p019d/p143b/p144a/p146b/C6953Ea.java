package p019d.p143b.p144a.p146b;

import android.util.AttributeSet;
import p019d.p143b.p150d.C7257g;
import p019d.p143b.p150d.C7269s;

/* renamed from: d.b.a.b.Ea */
class C6953Ea {
    /* renamed from: a */
    static C7257g m14346a(AttributeSet attributeSet) {
        C7257g gVar = null;
        if (attributeSet == null) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue("http://schemas.applovin.com/android/1.0", "size");
        if (C7269s.m15819a(attributeValue)) {
            gVar = C7257g.m15776a(attributeValue);
        }
        return gVar;
    }

    /* renamed from: b */
    static boolean m14347b(AttributeSet attributeSet) {
        return attributeSet != null && attributeSet.getAttributeBooleanValue("http://schemas.applovin.com/android/1.0", "loadAdOnCreate", false);
    }
}
