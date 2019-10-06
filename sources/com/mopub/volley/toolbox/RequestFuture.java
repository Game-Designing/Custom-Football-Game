package com.mopub.volley.toolbox;

import android.os.SystemClock;
import com.mopub.volley.Request;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyError;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFuture<T> implements Future<T>, Listener<T>, ErrorListener {

    /* renamed from: a */
    private Request<?> f36543a;

    /* renamed from: b */
    private boolean f36544b = false;

    /* renamed from: c */
    private T f36545c;

    /* renamed from: d */
    private VolleyError f36546d;

    public static <E> RequestFuture<E> newFuture() {
        return new RequestFuture<>();
    }

    private RequestFuture() {
    }

    public void setRequest(Request<?> request) {
        this.f36543a = request;
    }

    public synchronized boolean cancel(boolean mayInterruptIfRunning) {
        if (this.f36543a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f36543a.cancel();
        return true;
    }

    public T get() throws InterruptedException, ExecutionException {
        try {
            return m38675a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public T get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return m38675a(Long.valueOf(TimeUnit.MILLISECONDS.convert(timeout, unit)));
    }

    /* renamed from: a */
    private synchronized T m38675a(Long timeoutMs) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.f36546d != null) {
            throw new ExecutionException(this.f36546d);
        } else if (this.f36544b) {
            return this.f36545c;
        } else {
            if (timeoutMs == null) {
                while (!isDone()) {
                    wait(0);
                }
            } else if (timeoutMs.longValue() > 0) {
                long nowMs = SystemClock.uptimeMillis();
                long deadlineMs = timeoutMs.longValue() + nowMs;
                while (!isDone() && nowMs < deadlineMs) {
                    wait(deadlineMs - nowMs);
                    nowMs = SystemClock.uptimeMillis();
                }
            }
            if (this.f36546d != null) {
                throw new ExecutionException(this.f36546d);
            } else if (this.f36544b) {
                return this.f36545c;
            } else {
                throw new TimeoutException();
            }
        }
    }

    public boolean isCancelled() {
        Request<?> request = this.f36543a;
        if (request == null) {
            return false;
        }
        return request.isCanceled();
    }

    public synchronized boolean isDone() {
        return this.f36544b || this.f36546d != null || isCancelled();
    }

    public synchronized void onResponse(T response) {
        this.f36544b = true;
        this.f36545c = response;
        notifyAll();
    }

    public synchronized void onErrorResponse(VolleyError error) {
        this.f36546d = error;
        notifyAll();
    }
}
