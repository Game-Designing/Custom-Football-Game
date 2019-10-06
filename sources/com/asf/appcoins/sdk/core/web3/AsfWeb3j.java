package com.asf.appcoins.sdk.core.web3;

import java.math.BigDecimal;
import org.web3j.abi.datatypes.Address;
import org.web3j.protocol.core.methods.request.Transaction;
import p320f.p321a.C13797m;

public interface AsfWeb3j {
    C13797m<String> call(Transaction transaction);

    C13797m<BigDecimal> getBalance(Address address);

    C13797m<Long> getGasPrice(Address address);

    C13797m<Long> getNonce(Address address);

    C13797m<com.asf.appcoins.sdk.core.transaction.Transaction> getTransactionByHash(String str);

    C13797m<String> sendRawTransaction(String str);
}
