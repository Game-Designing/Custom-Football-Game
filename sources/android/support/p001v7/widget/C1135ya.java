package android.support.p001v7.widget;

import java.util.List;

/* renamed from: android.support.v7.widget.ya */
/* compiled from: OpReorderer */
class C1135ya {

    /* renamed from: a */
    final C1136a f3767a;

    /* renamed from: android.support.v7.widget.ya$a */
    /* compiled from: OpReorderer */
    interface C1136a {
        /* renamed from: a */
        C1070b mo8468a(int i, int i2, int i3, Object obj);

        /* renamed from: a */
        void mo8470a(C1070b bVar);
    }

    C1135ya(C1136a callback) {
        this.f3767a = callback;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8734a(List<C1070b> ops) {
        while (true) {
            int b = m5542b(ops);
            int badMove = b;
            if (b != -1) {
                m5541a(ops, badMove, badMove + 1);
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m5541a(List<C1070b> list, int badMove, int next) {
        C1070b moveOp = (C1070b) list.get(badMove);
        C1070b nextOp = (C1070b) list.get(next);
        int i = nextOp.f3539a;
        if (i == 1) {
            m5543c(list, badMove, moveOp, next, nextOp);
        } else if (i == 2) {
            mo8735a(list, badMove, moveOp, next, nextOp);
        } else if (i == 4) {
            mo8736b(list, badMove, moveOp, next, nextOp);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo8735a(List<C1070b> list, int movePos, C1070b moveOp, int removePos, C1070b removeOp) {
        boolean moveIsBackwards;
        C1070b extraRm = null;
        boolean revertedMove = false;
        int i = moveOp.f3540b;
        int i2 = moveOp.f3542d;
        if (i < i2) {
            moveIsBackwards = false;
            if (removeOp.f3540b == i && removeOp.f3542d == i2 - i) {
                revertedMove = true;
            }
        } else {
            moveIsBackwards = true;
            if (removeOp.f3540b == i2 + 1 && removeOp.f3542d == i - i2) {
                revertedMove = true;
            }
        }
        int i3 = moveOp.f3542d;
        int i4 = removeOp.f3540b;
        if (i3 < i4) {
            removeOp.f3540b = i4 - 1;
        } else {
            int i5 = removeOp.f3542d;
            if (i3 < i4 + i5) {
                removeOp.f3542d = i5 - 1;
                moveOp.f3539a = 2;
                moveOp.f3542d = 1;
                if (removeOp.f3542d == 0) {
                    list.remove(removePos);
                    this.f3767a.mo8470a(removeOp);
                }
                return;
            }
        }
        int i6 = moveOp.f3540b;
        int i7 = removeOp.f3540b;
        if (i6 <= i7) {
            removeOp.f3540b = i7 + 1;
        } else {
            int i8 = removeOp.f3542d;
            if (i6 < i7 + i8) {
                extraRm = this.f3767a.mo8468a(2, i6 + 1, (i7 + i8) - i6, null);
                removeOp.f3542d = moveOp.f3540b - removeOp.f3540b;
            }
        }
        if (revertedMove) {
            list.set(movePos, removeOp);
            list.remove(removePos);
            this.f3767a.mo8470a(moveOp);
            return;
        }
        if (moveIsBackwards) {
            if (extraRm != null) {
                int i9 = moveOp.f3540b;
                if (i9 > extraRm.f3540b) {
                    moveOp.f3540b = i9 - extraRm.f3542d;
                }
                int i10 = moveOp.f3542d;
                if (i10 > extraRm.f3540b) {
                    moveOp.f3542d = i10 - extraRm.f3542d;
                }
            }
            int i11 = moveOp.f3540b;
            if (i11 > removeOp.f3540b) {
                moveOp.f3540b = i11 - removeOp.f3542d;
            }
            int i12 = moveOp.f3542d;
            if (i12 > removeOp.f3540b) {
                moveOp.f3542d = i12 - removeOp.f3542d;
            }
        } else {
            if (extraRm != null) {
                int i13 = moveOp.f3540b;
                if (i13 >= extraRm.f3540b) {
                    moveOp.f3540b = i13 - extraRm.f3542d;
                }
                int i14 = moveOp.f3542d;
                if (i14 >= extraRm.f3540b) {
                    moveOp.f3542d = i14 - extraRm.f3542d;
                }
            }
            int i15 = moveOp.f3540b;
            if (i15 >= removeOp.f3540b) {
                moveOp.f3540b = i15 - removeOp.f3542d;
            }
            int i16 = moveOp.f3542d;
            if (i16 >= removeOp.f3540b) {
                moveOp.f3542d = i16 - removeOp.f3542d;
            }
        }
        list.set(movePos, removeOp);
        if (moveOp.f3540b != moveOp.f3542d) {
            list.set(removePos, moveOp);
        } else {
            list.remove(removePos);
        }
        if (extraRm != null) {
            list.add(movePos, extraRm);
        }
    }

    /* renamed from: c */
    private void m5543c(List<C1070b> list, int move, C1070b moveOp, int add, C1070b addOp) {
        int offset = 0;
        if (moveOp.f3542d < addOp.f3540b) {
            offset = 0 - 1;
        }
        if (moveOp.f3540b < addOp.f3540b) {
            offset++;
        }
        int i = addOp.f3540b;
        int i2 = moveOp.f3540b;
        if (i <= i2) {
            moveOp.f3540b = i2 + addOp.f3542d;
        }
        int i3 = addOp.f3540b;
        int i4 = moveOp.f3542d;
        if (i3 <= i4) {
            moveOp.f3542d = i4 + addOp.f3542d;
        }
        addOp.f3540b += offset;
        list.set(move, addOp);
        list.set(add, moveOp);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: b */
    public void mo8736b(List<C1070b> list, int move, C1070b moveOp, int update, C1070b updateOp) {
        C1070b extraUp1 = null;
        C1070b extraUp2 = null;
        int i = moveOp.f3542d;
        int i2 = updateOp.f3540b;
        if (i < i2) {
            updateOp.f3540b = i2 - 1;
        } else {
            int i3 = updateOp.f3542d;
            if (i < i2 + i3) {
                updateOp.f3542d = i3 - 1;
                extraUp1 = this.f3767a.mo8468a(4, moveOp.f3540b, 1, updateOp.f3541c);
            }
        }
        int i4 = moveOp.f3540b;
        int i5 = updateOp.f3540b;
        if (i4 <= i5) {
            updateOp.f3540b = i5 + 1;
        } else {
            int i6 = updateOp.f3542d;
            if (i4 < i5 + i6) {
                int remaining = (i5 + i6) - i4;
                extraUp2 = this.f3767a.mo8468a(4, i4 + 1, remaining, updateOp.f3541c);
                updateOp.f3542d -= remaining;
            }
        }
        list.set(update, moveOp);
        if (updateOp.f3542d > 0) {
            list.set(move, updateOp);
        } else {
            list.remove(move);
            this.f3767a.mo8470a(updateOp);
        }
        if (extraUp1 != null) {
            list.add(move, extraUp1);
        }
        if (extraUp2 != null) {
            list.add(move, extraUp2);
        }
    }

    /* renamed from: b */
    private int m5542b(List<C1070b> list) {
        boolean foundNonMove = false;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (((C1070b) list.get(i)).f3539a != 8) {
                foundNonMove = true;
            } else if (foundNonMove) {
                return i;
            }
        }
        return -1;
    }
}
