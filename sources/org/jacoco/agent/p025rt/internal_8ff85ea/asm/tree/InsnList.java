package org.jacoco.agent.p025rt.internal_8ff85ea.asm.tree;

import java.util.ListIterator;
import java.util.NoSuchElementException;
import org.jacoco.agent.p025rt.internal_8ff85ea.asm.MethodVisitor;

/* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.InsnList */
public class InsnList {
    AbstractInsnNode[] cache;
    private AbstractInsnNode first;
    private AbstractInsnNode last;
    private int size;

    /* renamed from: org.jacoco.agent.rt.internal_8ff85ea.asm.tree.InsnList$InsnListIterator */
    private final class InsnListIterator implements ListIterator {
        AbstractInsnNode next;
        AbstractInsnNode prev;
        AbstractInsnNode remove;

        InsnListIterator(int index) {
            if (index == InsnList.this.size()) {
                this.next = null;
                this.prev = InsnList.this.getLast();
                return;
            }
            this.next = InsnList.this.get(index);
            this.prev = this.next.prev;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public Object next() {
            if (this.next != null) {
                AbstractInsnNode result = this.next;
                this.prev = result;
                this.next = result.next;
                this.remove = result;
                return result;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            AbstractInsnNode abstractInsnNode = this.remove;
            if (abstractInsnNode != null) {
                AbstractInsnNode abstractInsnNode2 = this.next;
                if (abstractInsnNode == abstractInsnNode2) {
                    this.next = abstractInsnNode2.next;
                } else {
                    this.prev = this.prev.prev;
                }
                InsnList.this.remove(this.remove);
                this.remove = null;
                return;
            }
            throw new IllegalStateException();
        }

        public boolean hasPrevious() {
            return this.prev != null;
        }

        public Object previous() {
            AbstractInsnNode result = this.prev;
            this.next = result;
            this.prev = result.prev;
            this.remove = result;
            return result;
        }

        public int nextIndex() {
            if (this.next == null) {
                return InsnList.this.size();
            }
            InsnList insnList = InsnList.this;
            if (insnList.cache == null) {
                insnList.cache = insnList.toArray();
            }
            return this.next.index;
        }

        public int previousIndex() {
            if (this.prev == null) {
                return -1;
            }
            InsnList insnList = InsnList.this;
            if (insnList.cache == null) {
                insnList.cache = insnList.toArray();
            }
            return this.prev.index;
        }

        public void add(Object o) {
            AbstractInsnNode abstractInsnNode = this.next;
            if (abstractInsnNode != null) {
                InsnList.this.insertBefore(abstractInsnNode, (AbstractInsnNode) o);
            } else {
                AbstractInsnNode abstractInsnNode2 = this.prev;
                if (abstractInsnNode2 != null) {
                    InsnList.this.insert(abstractInsnNode2, (AbstractInsnNode) o);
                } else {
                    InsnList.this.add((AbstractInsnNode) o);
                }
            }
            this.prev = (AbstractInsnNode) o;
            this.remove = null;
        }

        public void set(Object o) {
            AbstractInsnNode abstractInsnNode = this.remove;
            if (abstractInsnNode != null) {
                InsnList.this.set(abstractInsnNode, (AbstractInsnNode) o);
                if (this.remove == this.prev) {
                    this.prev = (AbstractInsnNode) o;
                } else {
                    this.next = (AbstractInsnNode) o;
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public int size() {
        return this.size;
    }

    public AbstractInsnNode getFirst() {
        return this.first;
    }

    public AbstractInsnNode getLast() {
        return this.last;
    }

    public AbstractInsnNode get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        if (this.cache == null) {
            this.cache = toArray();
        }
        return this.cache[index];
    }

    public boolean contains(AbstractInsnNode insn) {
        AbstractInsnNode i = this.first;
        while (i != null && i != insn) {
            i = i.next;
        }
        return i != null;
    }

    public int indexOf(AbstractInsnNode insn) {
        if (this.cache == null) {
            this.cache = toArray();
        }
        return insn.index;
    }

    public void accept(MethodVisitor mv) {
        for (AbstractInsnNode insn = this.first; insn != null; insn = insn.next) {
            insn.accept(mv);
        }
    }

    public ListIterator<AbstractInsnNode> iterator() {
        return iterator(0);
    }

    public ListIterator<AbstractInsnNode> iterator(int index) {
        return new InsnListIterator(index);
    }

    public AbstractInsnNode[] toArray() {
        int i = 0;
        AbstractInsnNode elem = this.first;
        AbstractInsnNode[] insns = new AbstractInsnNode[this.size];
        while (elem != null) {
            insns[i] = elem;
            int i2 = i + 1;
            elem.index = i;
            elem = elem.next;
            i = i2;
        }
        return insns;
    }

    public void set(AbstractInsnNode location, AbstractInsnNode insn) {
        AbstractInsnNode next = location.next;
        insn.next = next;
        if (next != null) {
            next.prev = insn;
        } else {
            this.last = insn;
        }
        AbstractInsnNode prev = location.prev;
        insn.prev = prev;
        if (prev != null) {
            prev.next = insn;
        } else {
            this.first = insn;
        }
        AbstractInsnNode[] abstractInsnNodeArr = this.cache;
        if (abstractInsnNodeArr != null) {
            int index = location.index;
            abstractInsnNodeArr[index] = insn;
            insn.index = index;
        } else {
            insn.index = 0;
        }
        location.index = -1;
        location.prev = null;
        location.next = null;
    }

    public void add(AbstractInsnNode insn) {
        this.size++;
        AbstractInsnNode abstractInsnNode = this.last;
        if (abstractInsnNode == null) {
            this.first = insn;
            this.last = insn;
        } else {
            abstractInsnNode.next = insn;
            insn.prev = abstractInsnNode;
        }
        this.last = insn;
        this.cache = null;
        insn.index = 0;
    }

    public void add(InsnList insns) {
        int i = insns.size;
        if (i != 0) {
            this.size += i;
            AbstractInsnNode abstractInsnNode = this.last;
            if (abstractInsnNode == null) {
                this.first = insns.first;
                this.last = insns.last;
            } else {
                AbstractInsnNode elem = insns.first;
                abstractInsnNode.next = elem;
                elem.prev = abstractInsnNode;
                this.last = insns.last;
            }
            this.cache = null;
            insns.removeAll(false);
        }
    }

    public void insert(AbstractInsnNode insn) {
        this.size++;
        AbstractInsnNode abstractInsnNode = this.first;
        if (abstractInsnNode == null) {
            this.first = insn;
            this.last = insn;
        } else {
            abstractInsnNode.prev = insn;
            insn.next = abstractInsnNode;
        }
        this.first = insn;
        this.cache = null;
        insn.index = 0;
    }

    public void insert(InsnList insns) {
        int i = insns.size;
        if (i != 0) {
            this.size += i;
            AbstractInsnNode abstractInsnNode = this.first;
            if (abstractInsnNode == null) {
                this.first = insns.first;
                this.last = insns.last;
            } else {
                AbstractInsnNode elem = insns.last;
                abstractInsnNode.prev = elem;
                elem.next = abstractInsnNode;
                this.first = insns.first;
            }
            this.cache = null;
            insns.removeAll(false);
        }
    }

    public void insert(AbstractInsnNode location, AbstractInsnNode insn) {
        this.size++;
        AbstractInsnNode next = location.next;
        if (next == null) {
            this.last = insn;
        } else {
            next.prev = insn;
        }
        location.next = insn;
        insn.next = next;
        insn.prev = location;
        this.cache = null;
        insn.index = 0;
    }

    public void insert(AbstractInsnNode location, InsnList insns) {
        int i = insns.size;
        if (i != 0) {
            this.size += i;
            AbstractInsnNode ifirst = insns.first;
            AbstractInsnNode ilast = insns.last;
            AbstractInsnNode next = location.next;
            if (next == null) {
                this.last = ilast;
            } else {
                next.prev = ilast;
            }
            location.next = ifirst;
            ilast.next = next;
            ifirst.prev = location;
            this.cache = null;
            insns.removeAll(false);
        }
    }

    public void insertBefore(AbstractInsnNode location, AbstractInsnNode insn) {
        this.size++;
        AbstractInsnNode prev = location.prev;
        if (prev == null) {
            this.first = insn;
        } else {
            prev.next = insn;
        }
        location.prev = insn;
        insn.next = location;
        insn.prev = prev;
        this.cache = null;
        insn.index = 0;
    }

    public void insertBefore(AbstractInsnNode location, InsnList insns) {
        int i = insns.size;
        if (i != 0) {
            this.size += i;
            AbstractInsnNode ifirst = insns.first;
            AbstractInsnNode ilast = insns.last;
            AbstractInsnNode prev = location.prev;
            if (prev == null) {
                this.first = ifirst;
            } else {
                prev.next = ifirst;
            }
            location.prev = ilast;
            ilast.next = location;
            ifirst.prev = prev;
            this.cache = null;
            insns.removeAll(false);
        }
    }

    public void remove(AbstractInsnNode insn) {
        this.size--;
        AbstractInsnNode next = insn.next;
        AbstractInsnNode prev = insn.prev;
        if (next == null) {
            if (prev == null) {
                this.first = null;
                this.last = null;
            } else {
                prev.next = null;
                this.last = prev;
            }
        } else if (prev == null) {
            this.first = next;
            next.prev = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
        this.cache = null;
        insn.index = -1;
        insn.prev = null;
        insn.next = null;
    }

    /* access modifiers changed from: 0000 */
    public void removeAll(boolean mark) {
        if (mark) {
            AbstractInsnNode insn = this.first;
            while (insn != null) {
                AbstractInsnNode next = insn.next;
                insn.index = -1;
                insn.prev = null;
                insn.next = null;
                insn = next;
            }
        }
        this.size = 0;
        this.first = null;
        this.last = null;
        this.cache = null;
    }

    public void clear() {
        removeAll(false);
    }

    public void resetLabels() {
        for (AbstractInsnNode insn = this.first; insn != null; insn = insn.next) {
            if (insn instanceof LabelNode) {
                ((LabelNode) insn).resetLabel();
            }
        }
    }
}
