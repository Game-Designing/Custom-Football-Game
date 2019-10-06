package com.bumptech.glide.p103f.p104a;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.support.p001v7.widget.LinearLayoutManager;
import android.widget.RemoteViews;
import com.bumptech.glide.p103f.p105b.C5983b;
import com.bumptech.glide.p107h.C6024i;

/* renamed from: com.bumptech.glide.f.a.f */
/* compiled from: NotificationTarget */
public class C5973f extends C5974g<Bitmap> {

    /* renamed from: a */
    private final RemoteViews f10530a;

    /* renamed from: b */
    private final Context f10531b;

    /* renamed from: c */
    private final int f10532c;

    /* renamed from: d */
    private final String f10533d;

    /* renamed from: e */
    private final Notification f10534e;

    /* renamed from: f */
    private final int f10535f;

    public C5973f(Context context, int viewId, RemoteViews remoteViews, Notification notification, int notificationId) {
        this(context, viewId, remoteViews, notification, notificationId, null);
    }

    public C5973f(Context context, int viewId, RemoteViews remoteViews, Notification notification, int notificationId, String notificationTag) {
        this(context, LinearLayoutManager.INVALID_OFFSET, LinearLayoutManager.INVALID_OFFSET, viewId, remoteViews, notification, notificationId, notificationTag);
    }

    public C5973f(Context context, int width, int height, int viewId, RemoteViews remoteViews, Notification notification, int notificationId, String notificationTag) {
        super(width, height);
        C6024i.m11265a(context, "Context must not be null!");
        this.f10531b = context;
        C6024i.m11265a(notification, "Notification object can not be null!");
        this.f10534e = notification;
        C6024i.m11265a(remoteViews, "RemoteViews object can not be null!");
        this.f10530a = remoteViews;
        this.f10535f = viewId;
        this.f10532c = notificationId;
        this.f10533d = notificationTag;
    }

    /* renamed from: a */
    private void m11060a() {
        NotificationManager manager = (NotificationManager) this.f10531b.getSystemService("notification");
        C6024i.m11264a(manager);
        manager.notify(this.f10533d, this.f10532c, this.f10534e);
    }

    /* renamed from: a */
    public void onResourceReady(Bitmap resource, C5983b<? super Bitmap> bVar) {
        this.f10530a.setImageViewBitmap(this.f10535f, resource);
        m11060a();
    }
}
