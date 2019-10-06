package com.asf.appcoins.sdk.core.web3;

import com.asf.appcoins.sdk.core.exception.TransactionFailedException;
import com.asf.appcoins.sdk.core.factory.TransactionFactory;
import com.asf.appcoins.sdk.core.transaction.Transaction;
import com.asf.appcoins.sdk.core.transaction.Transaction.Status;
import java.math.BigDecimal;
import org.web3j.abi.datatypes.Address;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGasPrice;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import p320f.p321a.C13797m;
import p320f.p321a.C13802r;

public final class AsfWeb3jImpl implements AsfWeb3j {
    private final Web3j web3j;

    public AsfWeb3jImpl(Web3j web3j2) {
        this.web3j = web3j2;
    }

    public C13797m<Long> getNonce(Address address) {
        return C13797m.fromCallable(new C5879d(this, address)).map(C5886k.f10232a);
    }

    /* renamed from: a */
    public /* synthetic */ EthGetTransactionCount mo18364a(Address address) throws Exception {
        return this.web3j.ethGetTransactionCount(address.getValue(), DefaultBlockParameterName.PENDING).send();
    }

    public C13797m<Long> getGasPrice(Address address) {
        return C13797m.fromCallable(new C5882g(this)).map(C5878c.f10221a);
    }

    /* renamed from: a */
    public /* synthetic */ EthGasPrice mo18363a() throws Exception {
        return this.web3j.ethGasPrice().send();
    }

    public C13797m<BigDecimal> getBalance(Address address) {
        throw new RuntimeException("Not implemented yet");
    }

    public C13797m<String> sendRawTransaction(String rawData) {
        return C13797m.fromCallable(new C5880e(this, rawData)).map(new C5883h(this));
    }

    /* renamed from: b */
    public /* synthetic */ EthSendTransaction mo18366b(String rawData) throws Exception {
        return this.web3j.ethSendRawTransaction(rawData).send();
    }

    /* access modifiers changed from: private */
    public String successOrThrow(EthSendTransaction ethSendTransaction) throws TransactionFailedException {
        if (ethSendTransaction.getError() == null) {
            return ethSendTransaction.getTransactionHash();
        }
        throw new TransactionFailedException(ethSendTransaction.getError().getMessage());
    }

    public C13797m<Transaction> getTransactionByHash(String txHash) {
        return C13797m.fromCallable(new C5876a(this, txHash)).flatMap(new C5885j(this, txHash)).retryWhen(C5887l.f10233a);
    }

    /* renamed from: a */
    public /* synthetic */ EthGetTransactionReceipt mo18365a(String txHash) throws Exception {
        return this.web3j.ethGetTransactionReceipt(txHash).send();
    }

    /* renamed from: a */
    public /* synthetic */ C13802r mo18361a(String txHash, EthGetTransactionReceipt ethGetTransactionReceipt) throws Exception {
        if (ethGetTransactionReceipt == null || ethGetTransactionReceipt.getTransactionReceipt() == null) {
            return C13797m.just(TransactionFactory.fromEthTransaction(this.web3j.ethGetTransactionByHash(txHash).send(), Status.PENDING));
        }
        return C13797m.just(TransactionFactory.fromEthGetTransactionReceipt(ethGetTransactionReceipt));
    }

    public C13797m<String> call(org.web3j.protocol.core.methods.request.Transaction transaction) {
        return C13797m.fromCallable(new C5877b(this, transaction)).map(C5881f.f10226a);
    }

    /* renamed from: a */
    public /* synthetic */ EthCall mo18362a(org.web3j.protocol.core.methods.request.Transaction transaction) throws Exception {
        return this.web3j.ethCall(transaction, DefaultBlockParameterName.LATEST).send();
    }
}
