package p019d.p135a.p136a.p138b;

import p019d.p135a.p136a.p137a.C6852h;

/* renamed from: d.a.a.b.s */
/* compiled from: PaymentRequestState */
public enum C6874s implements C6852h {
    IDLE,
    WAITING_FOR_PAYMENT_DATA,
    FETCHING_AND_FILTERING_PAYMENT_METHODS,
    WAITING_FOR_PAYMENT_METHOD_SELECTION,
    WAITING_FOR_PAYMENT_METHOD_DETAILS,
    PROCESSING_PAYMENT,
    WAITING_FOR_REDIRECTION,
    PROCESSED,
    ABORTED
}
