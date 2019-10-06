package p346g.p347a.p356a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import javax.jmdns.impl.DNSRecord;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.Opcodes;

/* renamed from: g.a.a.f */
/* compiled from: DNSMessage */
public abstract class C14126f {

    /* renamed from: a */
    private int f42936a;

    /* renamed from: b */
    boolean f42937b;

    /* renamed from: c */
    private int f42938c;

    /* renamed from: d */
    protected final List<C14130i> f42939d = Collections.synchronizedList(new LinkedList());

    /* renamed from: e */
    protected final List<C14138j> f42940e = Collections.synchronizedList(new LinkedList());

    /* renamed from: f */
    protected final List<C14138j> f42941f = Collections.synchronizedList(new LinkedList());

    /* renamed from: g */
    protected final List<C14138j> f42942g = Collections.synchronizedList(new LinkedList());

    protected C14126f(int flags, int id, boolean multicast) {
        this.f42938c = flags;
        this.f42936a = id;
        this.f42937b = multicast;
    }

    /* renamed from: f */
    public int mo43937f() {
        if (this.f42937b) {
            return 0;
        }
        return this.f42936a;
    }

    /* renamed from: b */
    public void mo43933b(int id) {
        this.f42936a = id;
    }

    /* renamed from: e */
    public int mo43936e() {
        return this.f42938c;
    }

    /* renamed from: a */
    public void mo43931a(int flags) {
        this.f42938c = flags;
    }

    /* renamed from: o */
    public boolean mo43946o() {
        return this.f42937b;
    }

    /* renamed from: l */
    public Collection<? extends C14130i> mo43943l() {
        return this.f42939d;
    }

    /* renamed from: j */
    public int mo43941j() {
        return mo43943l().size();
    }

    /* renamed from: b */
    public List<C14138j> mo43932b() {
        List<DNSRecord> aList = new ArrayList<>(this.f42940e.size() + this.f42941f.size() + this.f42942g.size());
        aList.addAll(this.f42940e);
        aList.addAll(this.f42941f);
        aList.addAll(this.f42942g);
        return aList;
    }

    /* renamed from: c */
    public Collection<? extends C14138j> mo43934c() {
        return this.f42940e;
    }

    /* renamed from: h */
    public int mo43939h() {
        return mo43934c().size();
    }

    /* renamed from: d */
    public Collection<? extends C14138j> mo43935d() {
        return this.f42941f;
    }

    /* renamed from: i */
    public int mo43940i() {
        return mo43935d().size();
    }

    /* renamed from: a */
    public Collection<? extends C14138j> mo43930a() {
        return this.f42942g;
    }

    /* renamed from: g */
    public int mo43938g() {
        return mo43930a().size();
    }

    /* renamed from: s */
    public boolean mo43950s() {
        return (this.f42938c & 15) == 0;
    }

    /* renamed from: k */
    public int mo43942k() {
        return (this.f42938c & 30720) >> 11;
    }

    /* renamed from: r */
    public boolean mo43949r() {
        return (this.f42938c & 512) != 0;
    }

    /* renamed from: m */
    public boolean mo43944m() {
        return (this.f42938c & Opcodes.ACC_ABSTRACT) != 0;
    }

    /* renamed from: p */
    public boolean mo43947p() {
        return (this.f42938c & Opcodes.ACC_MANDATED) == 0;
    }

    /* renamed from: q */
    public boolean mo43948q() {
        return (this.f42938c & Opcodes.ACC_MANDATED) == 32768;
    }

    /* renamed from: n */
    public boolean mo43945n() {
        return ((mo43941j() + mo43939h()) + mo43940i()) + mo43938g() == 0;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: t */
    public String mo43951t() {
        StringBuffer buf = new StringBuffer(200);
        buf.append(toString());
        String str = "\n";
        buf.append(str);
        for (C14130i question : this.f42939d) {
            buf.append("\tquestion:      ");
            buf.append(question);
            buf.append(str);
        }
        for (C14138j answer : this.f42940e) {
            buf.append("\tanswer:        ");
            buf.append(answer);
            buf.append(str);
        }
        for (C14138j answer2 : this.f42941f) {
            buf.append("\tauthoritative: ");
            buf.append(answer2);
            buf.append(str);
        }
        for (C14138j answer3 : this.f42942g) {
            buf.append("\tadditional:    ");
            buf.append(answer3);
            buf.append(str);
        }
        return buf.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo43929a(byte[] data) {
        StringBuilder buf = new StringBuilder(4000);
        int off = 0;
        int len = data.length;
        while (true) {
            if (off >= len) {
                break;
            }
            int n = Math.min(32, len - off);
            if (off < 16) {
                buf.append(' ');
            }
            if (off < 256) {
                buf.append(' ');
            }
            if (off < 4096) {
                buf.append(' ');
            }
            buf.append(Integer.toHexString(off));
            buf.append(':');
            int index = 0;
            while (index < n) {
                if (index % 8 == 0) {
                    buf.append(' ');
                }
                buf.append(Integer.toHexString((data[off + index] & 240) >> 4));
                buf.append(Integer.toHexString((data[off + index] & 15) >> 0));
                index++;
            }
            if (index < 32) {
                for (int i = index; i < 32; i++) {
                    if (i % 8 == 0) {
                        buf.append(' ');
                    }
                    buf.append("  ");
                }
            }
            buf.append("    ");
            for (int index2 = 0; index2 < n; index2++) {
                if (index2 % 8 == 0) {
                    buf.append(' ');
                }
                int ch = data[off + index2] & 255;
                buf.append((ch <= 32 || ch >= 127) ? '.' : (char) ch);
            }
            buf.append("\n");
            if (off + 32 >= 2048) {
                buf.append("....\n");
                break;
            }
            off += 32;
        }
        return buf.toString();
    }
}
