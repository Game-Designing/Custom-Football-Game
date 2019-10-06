package com.liulishuo.filedownloader.message;

import com.liulishuo.filedownloader.message.BlockCompleteMessage.BlockCompleteMessageImpl;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.CompletedFlowDirectlySnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.CompletedSnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.ConnectedMessageSnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.ErrorMessageSnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.ProgressMessageSnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.WarnFlowDirectlySnapshot;
import com.liulishuo.filedownloader.message.LargeMessageSnapshot.WarnMessageSnapshot;
import com.liulishuo.filedownloader.message.MessageSnapshot.StartedMessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot.PausedSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot.PendingMessageSnapshot;
import com.liulishuo.filedownloader.message.SmallMessageSnapshot.RetryMessageSnapshot;
import com.liulishuo.filedownloader.model.C10912b;
import com.liulishuo.filedownloader.services.C10924i;
import java.io.File;
import p019d.p307j.p308a.C13079a;
import p019d.p307j.p308a.p313e.C13117d;
import p019d.p307j.p308a.p313e.C13121g;

/* renamed from: com.liulishuo.filedownloader.message.e */
/* compiled from: MessageSnapshotTaker */
public class C10907e {
    /* renamed from: a */
    public static MessageSnapshot m35763a(int id, File oldFile, boolean flowDirectly) {
        long totalBytes = oldFile.length();
        if (totalBytes > 2147483647L) {
            if (flowDirectly) {
                return new CompletedFlowDirectlySnapshot(id, true, totalBytes);
            }
            return new CompletedSnapshot(id, true, totalBytes);
        } else if (flowDirectly) {
            return new SmallMessageSnapshot.CompletedFlowDirectlySnapshot(id, true, (int) totalBytes);
        } else {
            return new SmallMessageSnapshot.CompletedSnapshot(id, true, (int) totalBytes);
        }
    }

    /* renamed from: a */
    public static MessageSnapshot m35762a(int id, long sofar, long total, boolean flowDirectly) {
        if (total > 2147483647L) {
            if (flowDirectly) {
                WarnFlowDirectlySnapshot warnFlowDirectlySnapshot = new WarnFlowDirectlySnapshot(id, sofar, total);
                return warnFlowDirectlySnapshot;
            }
            WarnMessageSnapshot warnMessageSnapshot = new WarnMessageSnapshot(id, sofar, total);
            return warnMessageSnapshot;
        } else if (flowDirectly) {
            return new SmallMessageSnapshot.WarnFlowDirectlySnapshot(id, (int) sofar, (int) total);
        } else {
            return new SmallMessageSnapshot.WarnMessageSnapshot(id, (int) sofar, (int) total);
        }
    }

    /* renamed from: a */
    public static MessageSnapshot m35765a(C13079a task) {
        if (task.mo42019g()) {
            return new ErrorMessageSnapshot(task.getId(), task.mo42038w(), task.mo42018f());
        }
        return new SmallMessageSnapshot.ErrorMessageSnapshot(task.getId(), task.mo42031n(), task.mo42018f());
    }

    /* renamed from: b */
    public static MessageSnapshot m35766b(C13079a task) {
        if (!task.mo42019g()) {
            return new PausedSnapshot(task.getId(), task.mo42031n(), task.mo42026i());
        }
        LargeMessageSnapshot.PausedSnapshot pausedSnapshot = new LargeMessageSnapshot.PausedSnapshot(task.getId(), task.mo42038w(), task.mo42039y());
        return pausedSnapshot;
    }

    /* renamed from: a */
    public static MessageSnapshot m35764a(MessageSnapshot snapshot) {
        if (snapshot.mo35687k() == -3) {
            return new BlockCompleteMessageImpl(snapshot);
        }
        throw new IllegalStateException(C13121g.m42792a("take block completed snapshot, must has already be completed. %d %d", Integer.valueOf(snapshot.mo35701e()), Byte.valueOf(snapshot.mo35687k())));
    }

    /* renamed from: a */
    public static MessageSnapshot m35761a(byte status, C10912b model, C10924i runnable) {
        Throwable throwable;
        int id = model.mo35730d();
        if (status == -4) {
            throw new IllegalStateException(C13121g.m42792a("please use #catchWarn instead %d", Integer.valueOf(id)));
        } else if (status != -3) {
            if (status != -1) {
                if (status != 1) {
                    if (status == 2) {
                        String filename = model.mo35740m() ? model.mo35728c() : null;
                        if (model.mo35739l()) {
                            ConnectedMessageSnapshot connectedMessageSnapshot = new ConnectedMessageSnapshot(id, runnable.mo35814f(), model.mo35737j(), model.mo35719a(), filename);
                            return connectedMessageSnapshot;
                        }
                        SmallMessageSnapshot.ConnectedMessageSnapshot connectedMessageSnapshot2 = new SmallMessageSnapshot.ConnectedMessageSnapshot(id, runnable.mo35814f(), (int) model.mo35737j(), model.mo35719a(), filename);
                        return connectedMessageSnapshot2;
                    } else if (status != 3) {
                        if (status != 5) {
                            if (status == 6) {
                                return new StartedMessageSnapshot(id);
                            }
                            String message = C13121g.m42792a("it can't takes a snapshot for the task(%s) when its status is %d,", model, Byte.valueOf(status));
                            C13117d.m42783e(C10907e.class, message, new Object[0]);
                            if (runnable.mo35812d() != null) {
                                throwable = new IllegalStateException(message, runnable.mo35812d());
                            } else {
                                throwable = new IllegalStateException(message);
                            }
                            if (model.mo35739l()) {
                                return new ErrorMessageSnapshot(id, model.mo35733f(), throwable);
                            }
                            return new SmallMessageSnapshot.ErrorMessageSnapshot(id, (int) model.mo35733f(), throwable);
                        } else if (!model.mo35739l()) {
                            return new RetryMessageSnapshot(id, (int) model.mo35733f(), runnable.mo35812d(), runnable.mo35811c());
                        } else {
                            LargeMessageSnapshot.RetryMessageSnapshot retryMessageSnapshot = new LargeMessageSnapshot.RetryMessageSnapshot(id, model.mo35733f(), runnable.mo35812d(), runnable.mo35811c());
                            return retryMessageSnapshot;
                        }
                    } else if (model.mo35739l()) {
                        return new ProgressMessageSnapshot(id, model.mo35733f());
                    } else {
                        return new SmallMessageSnapshot.ProgressMessageSnapshot(id, (int) model.mo35733f());
                    }
                } else if (!model.mo35739l()) {
                    return new PendingMessageSnapshot(id, (int) model.mo35733f(), (int) model.mo35737j());
                } else {
                    LargeMessageSnapshot.PendingMessageSnapshot pendingMessageSnapshot = new LargeMessageSnapshot.PendingMessageSnapshot(id, model.mo35733f(), model.mo35737j());
                    return pendingMessageSnapshot;
                }
            } else if (model.mo35739l()) {
                return new ErrorMessageSnapshot(id, model.mo35733f(), runnable.mo35812d());
            } else {
                return new SmallMessageSnapshot.ErrorMessageSnapshot(id, (int) model.mo35733f(), runnable.mo35812d());
            }
        } else if (model.mo35739l()) {
            return new CompletedSnapshot(id, false, model.mo35737j());
        } else {
            return new SmallMessageSnapshot.CompletedSnapshot(id, false, (int) model.mo35737j());
        }
    }
}
