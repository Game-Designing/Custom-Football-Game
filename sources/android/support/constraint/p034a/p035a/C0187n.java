package android.support.constraint.p034a.p035a;

import android.support.constraint.p034a.C0198e;
import android.support.constraint.p034a.C0200f;
import android.support.constraint.p034a.p035a.C0180h.C0181a;

/* renamed from: android.support.constraint.a.a.n */
/* compiled from: Optimizer */
public class C0187n {

    /* renamed from: a */
    static boolean[] f503a = new boolean[3];

    /* renamed from: a */
    static void m1082a(C0182i container, C0198e system, C0180h widget) {
        if (container.f386F[0] != C0181a.WRAP_CONTENT && widget.f386F[0] == C0181a.MATCH_PARENT) {
            int left = widget.f448v.f355e;
            int right = container.mo3920s() - widget.f450x.f355e;
            C0175f fVar = widget.f448v;
            fVar.f360j = system.mo4013a((Object) fVar);
            C0175f fVar2 = widget.f450x;
            fVar2.f360j = system.mo4013a((Object) fVar2);
            system.mo4018a(widget.f448v.f360j, left);
            system.mo4018a(widget.f450x.f360j, right);
            widget.f408b = 2;
            widget.mo3860a(left, right);
        }
        if (container.f386F[1] != C0181a.WRAP_CONTENT && widget.f386F[1] == C0181a.MATCH_PARENT) {
            int top = widget.f449w.f355e;
            int bottom = container.mo3900i() - widget.f451y.f355e;
            C0175f fVar3 = widget.f449w;
            fVar3.f360j = system.mo4013a((Object) fVar3);
            C0175f fVar4 = widget.f451y;
            fVar4.f360j = system.mo4013a((Object) fVar4);
            system.mo4018a(widget.f449w.f360j, top);
            system.mo4018a(widget.f451y.f360j, bottom);
            if (widget.f402V > 0 || widget.mo3918r() == 8) {
                C0175f fVar5 = widget.f452z;
                fVar5.f360j = system.mo4013a((Object) fVar5);
                system.mo4018a(widget.f452z.f360j, widget.f402V + top);
            }
            widget.f410c = 2;
            widget.mo3893e(top, bottom);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x003c A[RETURN] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m1083a(android.support.constraint.p034a.p035a.C0180h r5, int r6) {
        /*
            android.support.constraint.a.a.h$a[] r0 = r5.f386F
            r1 = r0[r6]
            android.support.constraint.a.a.h$a r2 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            r3 = 0
            if (r1 == r2) goto L_0x000a
            return r3
        L_0x000a:
            float r1 = r5.f390J
            r2 = 0
            r4 = 1
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x001e
            if (r6 != 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r4 = 0
        L_0x0016:
            r0 = r0[r4]
            android.support.constraint.a.a.h$a r1 = android.support.constraint.p034a.p035a.C0180h.C0181a.MATCH_CONSTRAINT
            if (r0 != r1) goto L_0x001d
            return r3
        L_0x001d:
            return r3
        L_0x001e:
            if (r6 != 0) goto L_0x002e
            int r0 = r5.f416f
            if (r0 == 0) goto L_0x0025
            return r3
        L_0x0025:
            int r0 = r5.f422i
            if (r0 != 0) goto L_0x002d
            int r0 = r5.f424j
            if (r0 == 0) goto L_0x003c
        L_0x002d:
            return r3
        L_0x002e:
            int r0 = r5.f418g
            if (r0 == 0) goto L_0x0033
            return r3
        L_0x0033:
            int r0 = r5.f428l
            if (r0 != 0) goto L_0x003d
            int r0 = r5.f430m
            if (r0 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            return r4
        L_0x003d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.constraint.p034a.p035a.C0187n.m1083a(android.support.constraint.a.a.h, int):boolean");
    }

    /* renamed from: a */
    static void m1080a(int optimisationLevel, C0180h widget) {
        C0180h hVar = widget;
        widget.mo3857I();
        C0189p leftNode = hVar.f448v.mo3843d();
        C0189p topNode = hVar.f449w.mo3843d();
        C0189p rightNode = hVar.f450x.mo3843d();
        C0189p bottomNode = hVar.f451y.mo3843d();
        boolean optimiseDimensions = (optimisationLevel & 8) == 8;
        boolean isOptimizableHorizontalMatch = hVar.f386F[0] == C0181a.MATCH_CONSTRAINT && m1083a(hVar, 0);
        if (!(leftNode.f510i == 4 || rightNode.f510i == 4)) {
            if (hVar.f386F[0] == C0181a.FIXED || (isOptimizableHorizontalMatch && widget.mo3918r() == 8)) {
                if (hVar.f448v.f354d == null && hVar.f450x.f354d == null) {
                    leftNode.mo3962b(1);
                    rightNode.mo3962b(1);
                    if (optimiseDimensions) {
                        rightNode.mo3960a(leftNode, 1, widget.mo3908m());
                    } else {
                        rightNode.mo3959a(leftNode, widget.mo3920s());
                    }
                } else if (hVar.f448v.f354d != null && hVar.f450x.f354d == null) {
                    leftNode.mo3962b(1);
                    rightNode.mo3962b(1);
                    if (optimiseDimensions) {
                        rightNode.mo3960a(leftNode, 1, widget.mo3908m());
                    } else {
                        rightNode.mo3959a(leftNode, widget.mo3920s());
                    }
                } else if (hVar.f448v.f354d == null && hVar.f450x.f354d != null) {
                    leftNode.mo3962b(1);
                    rightNode.mo3962b(1);
                    leftNode.mo3959a(rightNode, -widget.mo3920s());
                    if (optimiseDimensions) {
                        leftNode.mo3960a(rightNode, -1, widget.mo3908m());
                    } else {
                        leftNode.mo3959a(rightNode, -widget.mo3920s());
                    }
                } else if (!(hVar.f448v.f354d == null || hVar.f450x.f354d == null)) {
                    leftNode.mo3962b(2);
                    rightNode.mo3962b(2);
                    if (optimiseDimensions) {
                        widget.mo3908m().mo3973a(leftNode);
                        widget.mo3908m().mo3973a(rightNode);
                        leftNode.mo3964b(rightNode, -1, widget.mo3908m());
                        rightNode.mo3964b(leftNode, 1, widget.mo3908m());
                    } else {
                        leftNode.mo3963b(rightNode, (float) (-widget.mo3920s()));
                        rightNode.mo3963b(leftNode, (float) widget.mo3920s());
                    }
                }
            } else if (isOptimizableHorizontalMatch) {
                int width = widget.mo3920s();
                leftNode.mo3962b(1);
                rightNode.mo3962b(1);
                if (hVar.f448v.f354d == null && hVar.f450x.f354d == null) {
                    if (optimiseDimensions) {
                        rightNode.mo3960a(leftNode, 1, widget.mo3908m());
                    } else {
                        rightNode.mo3959a(leftNode, width);
                    }
                } else if (hVar.f448v.f354d == null || hVar.f450x.f354d != null) {
                    if (hVar.f448v.f354d != null || hVar.f450x.f354d == null) {
                        if (!(hVar.f448v.f354d == null || hVar.f450x.f354d == null)) {
                            if (optimiseDimensions) {
                                widget.mo3908m().mo3973a(leftNode);
                                widget.mo3908m().mo3973a(rightNode);
                            }
                            if (hVar.f390J == 0.0f) {
                                leftNode.mo3962b(3);
                                rightNode.mo3962b(3);
                                leftNode.mo3963b(rightNode, 0.0f);
                                rightNode.mo3963b(leftNode, 0.0f);
                            } else {
                                leftNode.mo3962b(2);
                                rightNode.mo3962b(2);
                                leftNode.mo3963b(rightNode, (float) (-width));
                                rightNode.mo3963b(leftNode, (float) width);
                                hVar.mo3913o(width);
                            }
                        }
                    } else if (optimiseDimensions) {
                        leftNode.mo3960a(rightNode, -1, widget.mo3908m());
                    } else {
                        leftNode.mo3959a(rightNode, -width);
                    }
                } else if (optimiseDimensions) {
                    rightNode.mo3960a(leftNode, 1, widget.mo3908m());
                } else {
                    rightNode.mo3959a(leftNode, width);
                }
            }
        }
        boolean isOptimizableVerticalMatch = hVar.f386F[1] == C0181a.MATCH_CONSTRAINT && m1083a(hVar, 1);
        if (topNode.f510i != 4 && bottomNode.f510i != 4) {
            if (hVar.f386F[1] == C0181a.FIXED || (isOptimizableVerticalMatch && widget.mo3918r() == 8)) {
                if (hVar.f449w.f354d == null && hVar.f451y.f354d == null) {
                    topNode.mo3962b(1);
                    bottomNode.mo3962b(1);
                    if (optimiseDimensions) {
                        bottomNode.mo3960a(topNode, 1, widget.mo3906l());
                    } else {
                        bottomNode.mo3959a(topNode, widget.mo3900i());
                    }
                    C0175f fVar = hVar.f452z;
                    if (fVar.f354d != null) {
                        fVar.mo3843d().mo3962b(1);
                        topNode.mo3957a(1, hVar.f452z.mo3843d(), -hVar.f402V);
                    }
                } else if (hVar.f449w.f354d != null && hVar.f451y.f354d == null) {
                    topNode.mo3962b(1);
                    bottomNode.mo3962b(1);
                    if (optimiseDimensions) {
                        bottomNode.mo3960a(topNode, 1, widget.mo3906l());
                    } else {
                        bottomNode.mo3959a(topNode, widget.mo3900i());
                    }
                    if (hVar.f402V > 0) {
                        hVar.f452z.mo3843d().mo3957a(1, topNode, hVar.f402V);
                    }
                } else if (hVar.f449w.f354d == null && hVar.f451y.f354d != null) {
                    topNode.mo3962b(1);
                    bottomNode.mo3962b(1);
                    if (optimiseDimensions) {
                        topNode.mo3960a(bottomNode, -1, widget.mo3906l());
                    } else {
                        topNode.mo3959a(bottomNode, -widget.mo3900i());
                    }
                    if (hVar.f402V > 0) {
                        hVar.f452z.mo3843d().mo3957a(1, topNode, hVar.f402V);
                    }
                } else if (hVar.f449w.f354d != null && hVar.f451y.f354d != null) {
                    topNode.mo3962b(2);
                    bottomNode.mo3962b(2);
                    if (optimiseDimensions) {
                        topNode.mo3964b(bottomNode, -1, widget.mo3906l());
                        bottomNode.mo3964b(topNode, 1, widget.mo3906l());
                        widget.mo3906l().mo3973a(topNode);
                        widget.mo3908m().mo3973a(bottomNode);
                    } else {
                        topNode.mo3963b(bottomNode, (float) (-widget.mo3900i()));
                        bottomNode.mo3963b(topNode, (float) widget.mo3900i());
                    }
                    if (hVar.f402V > 0) {
                        hVar.f452z.mo3843d().mo3957a(1, topNode, hVar.f402V);
                    }
                }
            } else if (isOptimizableVerticalMatch) {
                int height = widget.mo3900i();
                topNode.mo3962b(1);
                bottomNode.mo3962b(1);
                if (hVar.f449w.f354d == null && hVar.f451y.f354d == null) {
                    if (optimiseDimensions) {
                        bottomNode.mo3960a(topNode, 1, widget.mo3906l());
                    } else {
                        bottomNode.mo3959a(topNode, height);
                    }
                } else if (hVar.f449w.f354d == null || hVar.f451y.f354d != null) {
                    if (hVar.f449w.f354d != null || hVar.f451y.f354d == null) {
                        if (hVar.f449w.f354d != null && hVar.f451y.f354d != null) {
                            if (optimiseDimensions) {
                                widget.mo3906l().mo3973a(topNode);
                                widget.mo3908m().mo3973a(bottomNode);
                            }
                            if (hVar.f390J == 0.0f) {
                                topNode.mo3962b(3);
                                bottomNode.mo3962b(3);
                                topNode.mo3963b(bottomNode, 0.0f);
                                bottomNode.mo3963b(topNode, 0.0f);
                                return;
                            }
                            topNode.mo3962b(2);
                            bottomNode.mo3962b(2);
                            topNode.mo3963b(bottomNode, (float) (-height));
                            bottomNode.mo3963b(topNode, (float) height);
                            hVar.mo3897g(height);
                            if (hVar.f402V > 0) {
                                hVar.f452z.mo3843d().mo3957a(1, topNode, hVar.f402V);
                            }
                        }
                    } else if (optimiseDimensions) {
                        topNode.mo3960a(bottomNode, -1, widget.mo3906l());
                    } else {
                        topNode.mo3959a(bottomNode, -height);
                    }
                } else if (optimiseDimensions) {
                    bottomNode.mo3960a(topNode, 1, widget.mo3906l());
                } else {
                    bottomNode.mo3959a(topNode, height);
                }
            }
        }
    }

    /* renamed from: a */
    static boolean m1084a(C0182i container, C0198e system, int orientation, int offset, C0173d chainHead) {
        boolean isChainSpreadInside;
        boolean isChainSpread;
        boolean isChainPacked;
        float distance;
        float distance2;
        C0180h widget;
        boolean isChainSpread2;
        float extraMargin;
        float dimension;
        float distance3;
        float totalWeights;
        float dimension2;
        float firstOffset;
        C0189p lastNode;
        int numMatchConstraints;
        int numMatchConstraints2;
        C0180h next;
        C0198e eVar = system;
        int i = orientation;
        C0173d dVar = chainHead;
        C0180h first = dVar.f333a;
        C0180h last = dVar.f335c;
        C0180h firstVisibleWidget = dVar.f334b;
        C0180h lastVisibleWidget = dVar.f336d;
        C0180h head = dVar.f337e;
        C0180h widget2 = first;
        boolean done = false;
        float totalWeights2 = dVar.f343k;
        C0180h firstMatchConstraintsWidget = dVar.f338f;
        C0180h previousMatchConstraintsWidget = dVar.f339g;
        C0180h widget3 = widget2;
        boolean isWrapContent = container.f386F[i] == C0181a.WRAP_CONTENT;
        if (i == 0) {
            isChainSpread = head.f431ma == 0;
            boolean z = isWrapContent;
            isChainSpreadInside = head.f431ma == 1;
            isChainPacked = head.f431ma == 2;
        } else {
            isChainSpread = head.f433na == 0;
            isChainSpreadInside = head.f433na == 1;
            isChainPacked = head.f433na == 2;
        }
        C0180h hVar = widget3;
        C0180h widget4 = head;
        int numMatchConstraints3 = 0;
        int numVisibleWidgets = 0;
        float totalMargins = 0.0f;
        float totalSize = 0.0f;
        C0180h widget5 = hVar;
        while (true) {
            C0180h firstMatchConstraintsWidget2 = firstMatchConstraintsWidget;
            if (!done) {
                boolean done2 = done;
                if (widget5.mo3918r() != 8) {
                    numVisibleWidgets++;
                    if (i == 0) {
                        totalSize += (float) widget5.mo3920s();
                    } else {
                        totalSize += (float) widget5.mo3900i();
                    }
                    if (widget5 != firstVisibleWidget) {
                        totalSize += (float) widget5.f384D[offset].mo3841b();
                    }
                    if (widget5 != lastVisibleWidget) {
                        totalSize += (float) widget5.f384D[offset + 1].mo3841b();
                    }
                    totalMargins = totalMargins + ((float) widget5.f384D[offset].mo3841b()) + ((float) widget5.f384D[offset + 1].mo3841b());
                }
                C0175f fVar = widget5.f384D[offset];
                if (widget5.mo3918r() != 8 && widget5.f386F[i] == C0181a.MATCH_CONSTRAINT) {
                    numMatchConstraints3++;
                    if (i == 0) {
                        if (!(widget5.f416f == 0 && widget5.f422i == 0 && widget5.f424j == 0)) {
                            return false;
                        }
                    } else if (!(widget5.f418g == 0 && widget5.f428l == 0 && widget5.f430m == 0)) {
                        return false;
                    }
                    if (widget5.f390J != 0.0f) {
                        return false;
                    }
                }
                C0175f nextAnchor = widget5.f384D[offset + 1].f354d;
                if (nextAnchor != null) {
                    C0180h next2 = nextAnchor.f352b;
                    numMatchConstraints2 = numMatchConstraints3;
                    C0175f[] fVarArr = next2.f384D;
                    C0175f fVar2 = nextAnchor;
                    if (fVarArr[offset].f354d == null || fVarArr[offset].f354d.f352b != widget5) {
                        next = null;
                    } else {
                        next = next2;
                    }
                } else {
                    numMatchConstraints2 = numMatchConstraints3;
                    C0175f fVar3 = nextAnchor;
                    next = null;
                }
                if (next != null) {
                    widget5 = next;
                    done = done2;
                } else {
                    done = true;
                }
                numMatchConstraints3 = numMatchConstraints2;
                firstMatchConstraintsWidget = firstMatchConstraintsWidget2;
            } else {
                boolean z2 = done;
                C0189p firstNode = first.f384D[offset].mo3843d();
                C0189p lastNode2 = last.f384D[offset + 1].mo3843d();
                C0180h hVar2 = previousMatchConstraintsWidget;
                C0189p pVar = firstNode.f506e;
                if (pVar != null) {
                    C0189p pVar2 = lastNode2.f506e;
                    if (pVar2 == null) {
                        boolean z3 = isChainPacked;
                        C0180h hVar3 = lastVisibleWidget;
                        int i2 = numMatchConstraints3;
                        float f = totalWeights2;
                        C0189p pVar3 = lastNode2;
                        C0198e eVar2 = eVar;
                    } else {
                        if (pVar.f519b != 1) {
                            C0180h hVar4 = lastVisibleWidget;
                            int i3 = numMatchConstraints3;
                            float f2 = totalWeights2;
                            C0189p pVar4 = lastNode2;
                            C0198e eVar3 = system;
                        } else if (pVar2.f519b != 1) {
                            boolean z4 = isChainPacked;
                            C0180h hVar5 = lastVisibleWidget;
                            int i4 = numMatchConstraints3;
                            float f3 = totalWeights2;
                            C0189p pVar5 = lastNode2;
                            C0198e eVar4 = system;
                        } else if (numMatchConstraints3 > 0 && numMatchConstraints3 != numVisibleWidgets) {
                            return false;
                        } else {
                            float extraMargin2 = 0.0f;
                            if (isChainPacked || isChainSpread || isChainSpreadInside) {
                                if (firstVisibleWidget != null) {
                                    extraMargin2 = (float) firstVisibleWidget.f384D[offset].mo3841b();
                                }
                                if (lastVisibleWidget != null) {
                                    extraMargin2 += (float) lastVisibleWidget.f384D[offset + 1].mo3841b();
                                }
                            }
                            float firstOffset2 = firstNode.f506e.f509h;
                            float lastOffset = lastNode2.f506e.f509h;
                            if (firstOffset2 < lastOffset) {
                                distance = (lastOffset - firstOffset2) - totalSize;
                            } else {
                                distance = (firstOffset2 - lastOffset) - totalSize;
                            }
                            if (numMatchConstraints3 <= 0 || numMatchConstraints3 != numVisibleWidgets) {
                                boolean isChainPacked2 = isChainPacked;
                                C0180h hVar6 = lastVisibleWidget;
                                int i5 = numMatchConstraints3;
                                C0189p pVar6 = lastNode2;
                                float firstOffset3 = firstOffset2;
                                C0198e eVar5 = system;
                                if (distance < 0.0f) {
                                    isChainSpread = false;
                                    isChainSpreadInside = false;
                                    isChainPacked2 = true;
                                }
                                if (isChainPacked2) {
                                    C0180h widget6 = first;
                                    float distance4 = firstOffset3 + (first.mo3873b(i) * (distance - extraMargin2));
                                    while (widget6 != null) {
                                        C0200f fVar4 = C0198e.f540b;
                                        if (fVar4 != null) {
                                            fVar4.f583z--;
                                            fVar4.f575r++;
                                            fVar4.f581x++;
                                        }
                                        C0180h next3 = widget6.f443sa[i];
                                        if (next3 != null || widget6 == last) {
                                            if (i == 0) {
                                                dimension2 = (float) widget6.mo3920s();
                                            } else {
                                                dimension2 = (float) widget6.mo3900i();
                                            }
                                            float distance5 = distance4 + ((float) widget6.f384D[offset].mo3841b());
                                            widget6.f384D[offset].mo3843d().mo3958a(firstNode.f508g, distance5);
                                            totalWeights = totalWeights2;
                                            widget6.f384D[offset + 1].mo3843d().mo3958a(firstNode.f508g, distance5 + dimension2);
                                            widget6.f384D[offset].mo3843d().mo3961a(eVar5);
                                            widget6.f384D[offset + 1].mo3843d().mo3961a(eVar5);
                                            distance4 = distance5 + dimension2 + ((float) widget6.f384D[offset + 1].mo3841b());
                                        } else {
                                            totalWeights = totalWeights2;
                                        }
                                        widget6 = next3;
                                        totalWeights2 = totalWeights;
                                    }
                                    float f4 = extraMargin2;
                                    boolean z5 = isChainSpread;
                                } else {
                                    if (isChainSpread || isChainSpreadInside) {
                                        if (isChainSpread) {
                                            distance -= extraMargin2;
                                        } else if (isChainSpreadInside) {
                                            distance -= extraMargin2;
                                        }
                                        C0180h widget7 = first;
                                        float gap = distance / ((float) (numVisibleWidgets + 1));
                                        if (isChainSpreadInside) {
                                            if (numVisibleWidgets > 1) {
                                                gap = distance / ((float) (numVisibleWidgets - 1));
                                            } else {
                                                gap = distance / 2.0f;
                                            }
                                        }
                                        float distance6 = firstOffset3;
                                        if (first.mo3918r() != 8) {
                                            distance6 += gap;
                                        }
                                        if (isChainSpreadInside && numVisibleWidgets > 1) {
                                            distance6 = firstOffset3 + ((float) firstVisibleWidget.f384D[offset].mo3841b());
                                        }
                                        if (!isChainSpread || firstVisibleWidget == null) {
                                            widget = widget7;
                                            distance2 = distance6;
                                        } else {
                                            widget = widget7;
                                            distance2 = distance6 + ((float) firstVisibleWidget.f384D[offset].mo3841b());
                                        }
                                        while (widget != null) {
                                            C0200f fVar5 = C0198e.f540b;
                                            if (fVar5 != null) {
                                                isChainSpread2 = isChainSpread;
                                                fVar5.f583z--;
                                                fVar5.f575r++;
                                                fVar5.f581x++;
                                            } else {
                                                isChainSpread2 = isChainSpread;
                                            }
                                            C0180h next4 = widget.f443sa[i];
                                            if (next4 != null || widget == last) {
                                                if (i == 0) {
                                                    dimension = (float) widget.mo3920s();
                                                } else {
                                                    dimension = (float) widget.mo3900i();
                                                }
                                                if (widget != firstVisibleWidget) {
                                                    distance3 = distance2 + ((float) widget.f384D[offset].mo3841b());
                                                } else {
                                                    distance3 = distance2;
                                                }
                                                widget.f384D[offset].mo3843d().mo3958a(firstNode.f508g, distance3);
                                                extraMargin = extraMargin2;
                                                widget.f384D[offset + 1].mo3843d().mo3958a(firstNode.f508g, distance3 + dimension);
                                                widget.f384D[offset].mo3843d().mo3961a(eVar5);
                                                widget.f384D[offset + 1].mo3843d().mo3961a(eVar5);
                                                distance2 = distance3 + ((float) widget.f384D[offset + 1].mo3841b()) + dimension;
                                                if (next4 != null) {
                                                    if (next4.mo3918r() != 8) {
                                                        distance2 += gap;
                                                    }
                                                }
                                            } else {
                                                extraMargin = extraMargin2;
                                            }
                                            widget = next4;
                                            isChainSpread = isChainSpread2;
                                            extraMargin2 = extraMargin;
                                        }
                                        boolean z6 = isChainSpread;
                                    } else {
                                        float f5 = extraMargin2;
                                        boolean z7 = isChainSpread;
                                    }
                                }
                                return true;
                            }
                            if (widget5.mo3904k() != null) {
                                boolean z8 = isChainPacked;
                                C0180h hVar7 = lastVisibleWidget;
                                if (widget5.mo3904k().f386F[i] == C0181a.WRAP_CONTENT) {
                                    return false;
                                }
                            } else {
                                C0180h hVar8 = lastVisibleWidget;
                            }
                            float distance7 = (distance + totalSize) - totalMargins;
                            C0180h widget8 = first;
                            float position = firstOffset2;
                            while (widget8 != null) {
                                C0200f fVar6 = C0198e.f540b;
                                if (fVar6 != null) {
                                    lastNode = lastNode2;
                                    firstOffset = firstOffset2;
                                    fVar6.f583z--;
                                    fVar6.f575r++;
                                    fVar6.f581x++;
                                } else {
                                    lastNode = lastNode2;
                                    firstOffset = firstOffset2;
                                }
                                C0180h next5 = widget8.f443sa[i];
                                if (next5 != null || widget8 == last) {
                                    float dimension3 = distance7 / ((float) numMatchConstraints3);
                                    if (totalWeights2 > 0.0f) {
                                        float[] fArr = widget8.f439qa;
                                        if (fArr[i] == -1.0f) {
                                            dimension3 = 0.0f;
                                        } else {
                                            dimension3 = (fArr[i] * distance7) / totalWeights2;
                                        }
                                    }
                                    if (widget8.mo3918r() == 8) {
                                        dimension3 = 0.0f;
                                    }
                                    float position2 = position + ((float) widget8.f384D[offset].mo3841b());
                                    widget8.f384D[offset].mo3843d().mo3958a(firstNode.f508g, position2);
                                    numMatchConstraints = numMatchConstraints3;
                                    widget8.f384D[offset + 1].mo3843d().mo3958a(firstNode.f508g, position2 + dimension3);
                                    C0198e eVar6 = system;
                                    widget8.f384D[offset].mo3843d().mo3961a(eVar6);
                                    widget8.f384D[offset + 1].mo3843d().mo3961a(eVar6);
                                    position = position2 + dimension3 + ((float) widget8.f384D[offset + 1].mo3841b());
                                } else {
                                    C0198e eVar7 = system;
                                    numMatchConstraints = numMatchConstraints3;
                                }
                                widget8 = next5;
                                lastNode2 = lastNode;
                                firstOffset2 = firstOffset;
                                numMatchConstraints3 = numMatchConstraints;
                            }
                            C0189p pVar7 = lastNode2;
                            float f6 = firstOffset2;
                            C0198e eVar8 = system;
                            return true;
                        }
                        return false;
                    }
                } else {
                    C0180h hVar9 = lastVisibleWidget;
                    int i6 = numMatchConstraints3;
                    float f7 = totalWeights2;
                    C0189p pVar8 = lastNode2;
                    C0198e eVar9 = eVar;
                }
                return false;
            }
        }
        return false;
    }

    /* renamed from: a */
    static void m1081a(C0180h widget, int orientation, int resolvedOffset) {
        int startOffset = orientation * 2;
        int endOffset = startOffset + 1;
        widget.f384D[startOffset].mo3843d().f508g = widget.mo3904k().f448v.mo3843d();
        widget.f384D[startOffset].mo3843d().f509h = (float) resolvedOffset;
        widget.f384D[startOffset].mo3843d().f519b = 1;
        widget.f384D[endOffset].mo3843d().f508g = widget.f384D[startOffset].mo3843d();
        widget.f384D[endOffset].mo3843d().f509h = (float) widget.mo3888d(orientation);
        widget.f384D[endOffset].mo3843d().f519b = 1;
    }
}
