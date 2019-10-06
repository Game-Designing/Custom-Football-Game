package p363i.p364a.p366b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import p363i.p364a.p366b.p367a.C14222b;

/* renamed from: i.a.b.c */
public final class C14225c {

    /* renamed from: a */
    public final C14227d f43138a;

    /* renamed from: b */
    public final C14224b f43139b;

    /* renamed from: i.a.b.c$a */
    public static class C14226a {

        /* renamed from: a */
        public final C14227d f43140a;

        /* renamed from: b */
        public final C14225c f43141b;

        public /* synthetic */ C14226a(byte b) {
            this();
        }

        private C14226a() {
            this.f43140a = new C14227d();
            this.f43141b = new C14225c(this.f43140a, 0);
        }
    }

    /* synthetic */ C14225c(C14227d dVar, byte b) {
        this(dVar);
    }

    private C14225c(C14227d dVar) {
        this.f43138a = dVar;
        this.f43139b = new C14224b();
    }

    /* renamed from: a */
    public final void mo44338a(CharSequence charSequence, C14222b bVar) {
        C14224b bVar2 = this.f43139b;
        int i = 0;
        while (i < charSequence.length()) {
            Character valueOf = Character.valueOf(charSequence.charAt(i));
            if (this.f43138a.f43145d) {
                valueOf = Character.valueOf(Character.toLowerCase(valueOf.charValue()));
            }
            C14224b bVar3 = bVar2;
            bVar2 = bVar2.mo44332a(valueOf, false);
            while (bVar2 == null) {
                bVar3 = bVar3.f43136d;
                bVar2 = bVar3.mo44332a(valueOf, false);
            }
            Collection a = bVar2.mo44334a();
            boolean z = true;
            if (a != null && !a.isEmpty()) {
                Iterator it = a.iterator();
                boolean z2 = false;
                while (true) {
                    if (!it.hasNext()) {
                        z = z2;
                        break;
                    }
                    String str = (String) it.next();
                    bVar.mo44331a(new C14220a((i - str.length()) + 1, i, str));
                    if (this.f43138a.f43146e) {
                        break;
                    }
                    z2 = true;
                }
            } else {
                z = false;
            }
            if (!z || !this.f43138a.f43146e) {
                i++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    public static void m45764a(CharSequence charSequence, List<C14220a> list) {
        ArrayList<C14220a> arrayList = new ArrayList<>();
        for (C14220a aVar : list) {
            int i = aVar.f43120a;
            boolean z = true;
            if ((i == 0 || !Character.isAlphabetic(charSequence.charAt(i - 1))) && (aVar.f43121b + 1 == charSequence.length() || !Character.isAlphabetic(charSequence.charAt(aVar.f43121b + 1)))) {
                z = false;
            }
            if (z) {
                arrayList.add(aVar);
            }
        }
        for (C14220a remove : arrayList) {
            list.remove(remove);
        }
    }

    /* renamed from: b */
    public static void m45765b(CharSequence charSequence, List<C14220a> list) {
        long length = (long) charSequence.length();
        ArrayList<C14220a> arrayList = new ArrayList<>();
        for (C14220a aVar : list) {
            int i = aVar.f43120a;
            if (i == 0 || Character.isWhitespace(charSequence.charAt(i - 1))) {
                int i2 = aVar.f43121b;
                if (((long) (i2 + 1)) != length) {
                    if (Character.isWhitespace(charSequence.charAt(i2 + 1))) {
                    }
                }
            }
            arrayList.add(aVar);
        }
        for (C14220a remove : arrayList) {
            list.remove(remove);
        }
    }

    /* renamed from: a */
    public final void mo44337a() {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        C14224b bVar = this.f43139b;
        for (C14224b bVar2 : bVar.f43135c.values()) {
            bVar2.f43136d = bVar;
            linkedBlockingDeque.add(bVar2);
        }
        while (!linkedBlockingDeque.isEmpty()) {
            C14224b bVar3 = (C14224b) linkedBlockingDeque.remove();
            for (Character ch : bVar3.f43135c.keySet()) {
                C14224b a = bVar3.mo44332a(ch, false);
                linkedBlockingDeque.add(a);
                C14224b bVar4 = bVar3.f43136d;
                while (bVar4.mo44332a(ch, false) == null) {
                    bVar4 = bVar4.f43136d;
                }
                C14224b a2 = bVar4.mo44332a(ch, false);
                a.f43136d = a2;
                a.mo44335a(a2.mo44334a());
            }
        }
    }
}
