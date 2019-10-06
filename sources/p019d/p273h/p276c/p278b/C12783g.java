package p019d.p273h.p276c.p278b;

import p019d.p273h.p276c.p280d.C12800c.C12801a;
import p019d.p273h.p276c.p280d.C12802d;

/* renamed from: d.h.c.b.g */
/* compiled from: EventsFormatterFactory */
class C12783g {
    /* renamed from: a */
    static C12776a m41501a(String type, int adUnit) {
        if ("ironbeast".equals(type)) {
            return new C12785i(adUnit);
        }
        if ("outcome".equals(type)) {
            return new C12786j(adUnit);
        }
        if (adUnit == 2) {
            return new C12785i(adUnit);
        }
        if (adUnit == 3) {
            return new C12786j(adUnit);
        }
        C12802d c = C12802d.m41613c();
        C12801a aVar = C12801a.NATIVE;
        StringBuilder sb = new StringBuilder();
        sb.append("EventsFormatterFactory failed to instantiate a formatter (type: ");
        sb.append(type);
        sb.append(", adUnit: ");
        sb.append(adUnit);
        sb.append(")");
        c.mo41427b(aVar, sb.toString(), 2);
        return null;
    }
}
