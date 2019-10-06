package p002b.p003c.p062h.p070f;

import android.support.p001v7.widget.RecyclerView.C0970a;
import android.support.v7.util.DiffUtil.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: b.c.h.f.d */
/* compiled from: DiffUtil */
public class C1292d {

    /* renamed from: a */
    private static final Comparator<C1297e> f4103a = new C1291c();

    /* renamed from: b.c.h.f.d$a */
    /* compiled from: DiffUtil */
    public static abstract class C1293a {
        /* renamed from: a */
        public abstract int mo6487a();

        /* renamed from: a */
        public abstract boolean mo6488a(int i, int i2);

        /* renamed from: b */
        public abstract int mo6489b();

        /* renamed from: b */
        public abstract boolean mo6490b(int i, int i2);

        /* renamed from: c */
        public Object mo9218c(int oldItemPosition, int newItemPosition) {
            return null;
        }
    }

    /* renamed from: b.c.h.f.d$b */
    /* compiled from: DiffUtil */
    public static class C1294b {

        /* renamed from: a */
        private final List<C1297e> f4104a;

        /* renamed from: b */
        private final int[] f4105b;

        /* renamed from: c */
        private final int[] f4106c;

        /* renamed from: d */
        private final C1293a f4107d;

        /* renamed from: e */
        private final int f4108e;

        /* renamed from: f */
        private final int f4109f;

        /* renamed from: g */
        private final boolean f4110g;

        C1294b(C1293a callback, List<C1297e> snakes, int[] oldItemStatuses, int[] newItemStatuses, boolean detectMoves) {
            this.f4104a = snakes;
            this.f4105b = oldItemStatuses;
            this.f4106c = newItemStatuses;
            Arrays.fill(this.f4105b, 0);
            Arrays.fill(this.f4106c, 0);
            this.f4107d = callback;
            this.f4108e = callback.mo6489b();
            this.f4109f = callback.mo6487a();
            this.f4110g = detectMoves;
            m6029a();
            m6033b();
        }

        /* renamed from: a */
        private void m6029a() {
            C1297e firstSnake = this.f4104a.isEmpty() ? null : (C1297e) this.f4104a.get(0);
            if (firstSnake == null || firstSnake.f4118a != 0 || firstSnake.f4119b != 0) {
                C1297e root = new C1297e();
                root.f4118a = 0;
                root.f4119b = 0;
                root.f4121d = false;
                root.f4120c = 0;
                root.f4122e = false;
                this.f4104a.add(0, root);
            }
        }

        /* renamed from: b */
        private void m6033b() {
            int posOld = this.f4108e;
            int posNew = this.f4109f;
            for (int i = this.f4104a.size() - 1; i >= 0; i--) {
                C1297e snake = (C1297e) this.f4104a.get(i);
                int i2 = snake.f4118a;
                int i3 = snake.f4120c;
                int endX = i2 + i3;
                int endY = snake.f4119b + i3;
                if (this.f4110g) {
                    while (posOld > endX) {
                        m6030a(posOld, posNew, i);
                        posOld--;
                    }
                    while (posNew > endY) {
                        m6034b(posOld, posNew, i);
                        posNew--;
                    }
                }
                for (int j = 0; j < snake.f4120c; j++) {
                    int oldItemPos = snake.f4118a + j;
                    int newItemPos = snake.f4119b + j;
                    int changeFlag = this.f4107d.mo6488a(oldItemPos, newItemPos) ? 1 : 2;
                    this.f4105b[oldItemPos] = (newItemPos << 5) | changeFlag;
                    this.f4106c[newItemPos] = (oldItemPos << 5) | changeFlag;
                }
                posOld = snake.f4118a;
                posNew = snake.f4119b;
            }
        }

        /* renamed from: a */
        private void m6030a(int x, int y, int snakeIndex) {
            if (this.f4105b[x - 1] == 0) {
                m6032a(x, y, snakeIndex, false);
            }
        }

        /* renamed from: b */
        private void m6034b(int x, int y, int snakeIndex) {
            if (this.f4106c[y - 1] == 0) {
                m6032a(x, y, snakeIndex, true);
            }
        }

        /* renamed from: a */
        private boolean m6032a(int x, int y, int snakeIndex, boolean removal) {
            int curY;
            int curX;
            int myItemPos;
            if (removal) {
                myItemPos = y - 1;
                curX = x;
                curY = y - 1;
            } else {
                myItemPos = x - 1;
                curX = x - 1;
                curY = y;
            }
            for (int i = snakeIndex; i >= 0; i--) {
                C1297e snake = (C1297e) this.f4104a.get(i);
                int i2 = snake.f4118a;
                int i3 = snake.f4120c;
                int endX = i2 + i3;
                int endY = snake.f4119b + i3;
                int changeFlag = 8;
                if (removal) {
                    for (int pos = curX - 1; pos >= endX; pos--) {
                        if (this.f4107d.mo6490b(pos, myItemPos)) {
                            if (!this.f4107d.mo6488a(pos, myItemPos)) {
                                changeFlag = 4;
                            }
                            this.f4106c[myItemPos] = (pos << 5) | 16;
                            this.f4105b[pos] = (myItemPos << 5) | changeFlag;
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (int pos2 = curY - 1; pos2 >= endY; pos2--) {
                        if (this.f4107d.mo6490b(myItemPos, pos2)) {
                            if (!this.f4107d.mo6488a(myItemPos, pos2)) {
                                changeFlag = 4;
                            }
                            this.f4105b[x - 1] = (pos2 << 5) | 16;
                            this.f4106c[pos2] = ((x - 1) << 5) | changeFlag;
                            return true;
                        }
                    }
                    continue;
                }
                curX = snake.f4118a;
                curY = snake.f4119b;
            }
            return false;
        }

        /* renamed from: a */
        public void mo9219a(C0970a adapter) {
            mo9220a((C1298e) new C1289a(adapter));
        }

        /* renamed from: a */
        public void mo9220a(C1298e updateCallback) {
            C1290b batchingCallback;
            int endY;
            int snakeSize;
            C1298e eVar = updateCallback;
            if (eVar instanceof C1290b) {
                C1298e eVar2 = eVar;
                batchingCallback = (C1290b) eVar;
            } else {
                C1290b batchingCallback2 = new C1290b(eVar);
                C1290b bVar = batchingCallback2;
                batchingCallback = batchingCallback2;
            }
            ArrayList arrayList = new ArrayList();
            int posOld = this.f4108e;
            int posOld2 = posOld;
            int posNew = this.f4109f;
            for (int snakeIndex = this.f4104a.size() - 1; snakeIndex >= 0; snakeIndex--) {
                C1297e snake = (C1297e) this.f4104a.get(snakeIndex);
                int snakeSize2 = snake.f4120c;
                int endX = snake.f4118a + snakeSize2;
                int endY2 = snake.f4119b + snakeSize2;
                if (endX < posOld2) {
                    endY = endY2;
                    m6035b(arrayList, batchingCallback, endX, posOld2 - endX, endX);
                } else {
                    endY = endY2;
                }
                if (endY < posNew) {
                    int i = endX;
                    snakeSize = snakeSize2;
                    m6031a(arrayList, batchingCallback, endX, posNew - endY, endY);
                } else {
                    snakeSize = snakeSize2;
                }
                for (int i2 = snakeSize - 1; i2 >= 0; i2--) {
                    int[] iArr = this.f4105b;
                    int i3 = snake.f4118a;
                    if ((iArr[i3 + i2] & 31) == 2) {
                        batchingCallback.mo9212a(i3 + i2, 1, this.f4107d.mo9218c(i3 + i2, snake.f4119b + i2));
                    }
                }
                posOld2 = snake.f4118a;
                posNew = snake.f4119b;
            }
            batchingCallback.mo9215a();
        }

        /* renamed from: a */
        private static C1295c m6028a(List<C1295c> updates, int pos, boolean removal) {
            for (int i = updates.size() - 1; i >= 0; i--) {
                C1295c update = (C1295c) updates.get(i);
                if (update.f4111a == pos && update.f4113c == removal) {
                    updates.remove(i);
                    for (int j = i; j < updates.size(); j++) {
                        C1295c cVar = (C1295c) updates.get(j);
                        cVar.f4112b += removal ? 1 : -1;
                    }
                    return update;
                }
            }
            return null;
        }

        /* renamed from: a */
        private void m6031a(List<C1295c> postponedUpdates, C1298e updateCallback, int start, int count, int globalIndex) {
            if (!this.f4110g) {
                updateCallback.mo9211a(start, count);
                return;
            }
            for (int i = count - 1; i >= 0; i--) {
                int status = this.f4106c[globalIndex + i] & 31;
                if (status == 0) {
                    updateCallback.mo9211a(start, 1);
                    for (C1295c update : postponedUpdates) {
                        update.f4112b++;
                    }
                } else if (status == 4 || status == 8) {
                    int pos = this.f4106c[globalIndex + i] >> 5;
                    updateCallback.mo9214c(m6028a(postponedUpdates, pos, true).f4112b, start);
                    if (status == 4) {
                        updateCallback.mo9212a(start, 1, this.f4107d.mo9218c(pos, globalIndex + i));
                    }
                } else if (status == 16) {
                    postponedUpdates.add(new C1295c(globalIndex + i, start, false));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown flag for pos ");
                    sb.append(globalIndex + i);
                    sb.append(" ");
                    sb.append(Long.toBinaryString((long) status));
                    throw new IllegalStateException(sb.toString());
                }
            }
        }

        /* renamed from: b */
        private void m6035b(List<C1295c> postponedUpdates, C1298e updateCallback, int start, int count, int globalIndex) {
            if (!this.f4110g) {
                updateCallback.mo9213b(start, count);
                return;
            }
            for (int i = count - 1; i >= 0; i--) {
                int status = this.f4105b[globalIndex + i] & 31;
                if (status == 0) {
                    updateCallback.mo9213b(start + i, 1);
                    for (C1295c update : postponedUpdates) {
                        update.f4112b--;
                    }
                } else if (status == 4 || status == 8) {
                    int pos = this.f4105b[globalIndex + i] >> 5;
                    C1295c update2 = m6028a(postponedUpdates, pos, false);
                    updateCallback.mo9214c(start + i, update2.f4112b - 1);
                    if (status == 4) {
                        updateCallback.mo9212a(update2.f4112b - 1, 1, this.f4107d.mo9218c(globalIndex + i, pos));
                    }
                } else if (status == 16) {
                    postponedUpdates.add(new C1295c(globalIndex + i, start + i, true));
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("unknown flag for pos ");
                    sb.append(globalIndex + i);
                    sb.append(" ");
                    sb.append(Long.toBinaryString((long) status));
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
    }

    /* renamed from: b.c.h.f.d$c */
    /* compiled from: DiffUtil */
    private static class C1295c {

        /* renamed from: a */
        int f4111a;

        /* renamed from: b */
        int f4112b;

        /* renamed from: c */
        boolean f4113c;

        public C1295c(int posInOwnerList, int currentPos, boolean removal) {
            this.f4111a = posInOwnerList;
            this.f4112b = currentPos;
            this.f4113c = removal;
        }
    }

    /* renamed from: b.c.h.f.d$d */
    /* compiled from: DiffUtil */
    static class C1296d {

        /* renamed from: a */
        int f4114a;

        /* renamed from: b */
        int f4115b;

        /* renamed from: c */
        int f4116c;

        /* renamed from: d */
        int f4117d;

        public C1296d() {
        }

        public C1296d(int oldListStart, int oldListEnd, int newListStart, int newListEnd) {
            this.f4114a = oldListStart;
            this.f4115b = oldListEnd;
            this.f4116c = newListStart;
            this.f4117d = newListEnd;
        }
    }

    /* renamed from: b.c.h.f.d$e */
    /* compiled from: DiffUtil */
    static class C1297e {

        /* renamed from: a */
        int f4118a;

        /* renamed from: b */
        int f4119b;

        /* renamed from: c */
        int f4120c;

        /* renamed from: d */
        boolean f4121d;

        /* renamed from: e */
        boolean f4122e;

        C1297e() {
        }
    }

    /* renamed from: a */
    public static C1294b m6020a(C1293a cb) {
        return m6021a(cb, true);
    }

    /* renamed from: a */
    public static C1294b m6021a(C1293a cb, boolean detectMoves) {
        int oldSize = cb.mo6489b();
        int newSize = cb.mo6487a();
        ArrayList arrayList = new ArrayList();
        List<Range> stack = new ArrayList<>();
        stack.add(new C1296d(0, oldSize, 0, newSize));
        int max = oldSize + newSize + Math.abs(oldSize - newSize);
        int[] forward = new int[(max * 2)];
        int[] backward = new int[(max * 2)];
        ArrayList arrayList2 = new ArrayList();
        while (!stack.isEmpty()) {
            C1296d range = (C1296d) stack.remove(stack.size() - 1);
            C1297e snake = m6022a(cb, range.f4114a, range.f4115b, range.f4116c, range.f4117d, forward, backward, max);
            if (snake != null) {
                if (snake.f4120c > 0) {
                    arrayList.add(snake);
                }
                snake.f4118a += range.f4114a;
                snake.f4119b += range.f4116c;
                C1296d left = arrayList2.isEmpty() ? new C1296d() : (C1296d) arrayList2.remove(arrayList2.size() - 1);
                left.f4114a = range.f4114a;
                left.f4116c = range.f4116c;
                if (snake.f4122e) {
                    left.f4115b = snake.f4118a;
                    left.f4117d = snake.f4119b;
                } else if (snake.f4121d) {
                    left.f4115b = snake.f4118a - 1;
                    left.f4117d = snake.f4119b;
                } else {
                    left.f4115b = snake.f4118a;
                    left.f4117d = snake.f4119b - 1;
                }
                stack.add(left);
                C1296d right = range;
                if (!snake.f4122e) {
                    int i = snake.f4118a;
                    int i2 = snake.f4120c;
                    right.f4114a = i + i2;
                    right.f4116c = snake.f4119b + i2;
                } else if (snake.f4121d) {
                    int i3 = snake.f4118a;
                    int i4 = snake.f4120c;
                    right.f4114a = i3 + i4 + 1;
                    right.f4116c = snake.f4119b + i4;
                } else {
                    int i5 = snake.f4118a;
                    int i6 = snake.f4120c;
                    right.f4114a = i5 + i6;
                    right.f4116c = snake.f4119b + i6 + 1;
                }
                stack.add(right);
            } else {
                arrayList2.add(range);
            }
        }
        Collections.sort(arrayList, f4103a);
        ArrayList arrayList3 = arrayList2;
        int[] iArr = backward;
        int[] iArr2 = forward;
        C1294b bVar = new C1294b(cb, arrayList, forward, backward, detectMoves);
        return bVar;
    }

    /* renamed from: a */
    private static C1297e m6022a(C1293a cb, int startOld, int endOld, int startNew, int endNew, int[] forward, int[] backward, int kOffset) {
        boolean removal;
        int x;
        int oldSize;
        boolean removal2;
        int x2;
        C1293a aVar = cb;
        int[] iArr = forward;
        int[] iArr2 = backward;
        int oldSize2 = endOld - startOld;
        int newSize = endNew - startNew;
        if (endOld - startOld < 1) {
        } else if (endNew - startNew < 1) {
            int i = oldSize2;
        } else {
            int delta = oldSize2 - newSize;
            int dLimit = ((oldSize2 + newSize) + 1) / 2;
            Arrays.fill(iArr, (kOffset - dLimit) - 1, kOffset + dLimit + 1, 0);
            Arrays.fill(iArr2, ((kOffset - dLimit) - 1) + delta, kOffset + dLimit + 1 + delta, oldSize2);
            boolean checkInFwd = delta % 2 != 0;
            for (int d = 0; d <= dLimit; d++) {
                int k = -d;
                while (k <= d) {
                    if (k == (-d) || (k != d && iArr[(kOffset + k) - 1] < iArr[kOffset + k + 1])) {
                        x2 = iArr[kOffset + k + 1];
                        removal2 = false;
                    } else {
                        x2 = iArr[(kOffset + k) - 1] + 1;
                        removal2 = true;
                    }
                    int y = x2 - k;
                    while (x2 < oldSize2 && y < newSize && aVar.mo6490b(startOld + x2, startNew + y)) {
                        x2++;
                        y++;
                    }
                    iArr[kOffset + k] = x2;
                    if (!checkInFwd || k < (delta - d) + 1 || k > (delta + d) - 1 || iArr[kOffset + k] < iArr2[kOffset + k]) {
                        k += 2;
                    } else {
                        C1297e outSnake = new C1297e();
                        outSnake.f4118a = iArr2[kOffset + k];
                        outSnake.f4119b = outSnake.f4118a - k;
                        outSnake.f4120c = iArr[kOffset + k] - iArr2[kOffset + k];
                        outSnake.f4121d = removal2;
                        outSnake.f4122e = false;
                        return outSnake;
                    }
                }
                int k2 = -d;
                while (k2 <= d) {
                    int backwardK = k2 + delta;
                    if (backwardK == d + delta || (backwardK != (-d) + delta && iArr2[(kOffset + backwardK) - 1] < iArr2[kOffset + backwardK + 1])) {
                        x = iArr2[(kOffset + backwardK) - 1];
                        removal = false;
                    } else {
                        x = iArr2[(kOffset + backwardK) + 1] - 1;
                        removal = true;
                    }
                    int y2 = x - backwardK;
                    while (true) {
                        if (x > 0 && y2 > 0) {
                            oldSize = oldSize2;
                            if (!aVar.mo6490b((startOld + x) - 1, (startNew + y2) - 1)) {
                                break;
                            }
                            x--;
                            y2--;
                            oldSize2 = oldSize;
                        } else {
                            oldSize = oldSize2;
                        }
                    }
                    oldSize = oldSize2;
                    iArr2[kOffset + backwardK] = x;
                    if (checkInFwd || k2 + delta < (-d) || k2 + delta > d || iArr[kOffset + backwardK] < iArr2[kOffset + backwardK]) {
                        k2 += 2;
                        oldSize2 = oldSize;
                    } else {
                        C1297e outSnake2 = new C1297e();
                        outSnake2.f4118a = iArr2[kOffset + backwardK];
                        outSnake2.f4119b = outSnake2.f4118a - backwardK;
                        outSnake2.f4120c = iArr[kOffset + backwardK] - iArr2[kOffset + backwardK];
                        outSnake2.f4121d = removal;
                        outSnake2.f4122e = true;
                        return outSnake2;
                    }
                }
            }
            throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
        }
        return null;
    }
}
