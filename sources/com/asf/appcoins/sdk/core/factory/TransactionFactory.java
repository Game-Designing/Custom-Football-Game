package com.asf.appcoins.sdk.core.factory;

import com.asf.appcoins.sdk.core.transaction.Transaction;
import com.asf.appcoins.sdk.core.transaction.Transaction.Status;
import java.math.BigInteger;
import java.util.Arrays;
import org.spongycastle.util.encoders.Hex;
import org.web3j.abi.datatypes.Address;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.EthTransaction;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

public final class TransactionFactory {
    private TransactionFactory() {
    }

    public static Transaction fromEthGetTransactionReceipt(EthGetTransactionReceipt ethGetTransactionReceipt) {
        TransactionReceipt transactionReceipt = ethGetTransactionReceipt.getTransactionReceipt();
        String hash = transactionReceipt.getTransactionHash();
        String from = transactionReceipt.getFrom();
        Log log = (Log) transactionReceipt.getLogs().get(0);
        String to = log.getAddress();
        String value = extractValueFromEthGetTransactionReceipt(log.getData());
        Status status = parseStatus(transactionReceipt.getStatus());
        String to2 = ethGetTransactionReceipt.getTransactionReceipt().getTo();
        Transaction transaction = new Transaction(hash, from, to, value, status);
        return transaction;
    }

    public static Transaction fromEthTransaction(EthTransaction ethTransaction, Status status) {
        org.web3j.protocol.core.methods.response.Transaction transaction = ethTransaction.getTransaction();
        String hash = transaction.getHash();
        String from = transaction.getFrom();
        String input = ethTransaction.getTransaction().getInput();
        String to = extractToFromEthTransaction(input);
        String value = extractValueFromEthTransaction(input);
        String to2 = ethTransaction.getTransaction().getTo();
        Transaction transaction2 = new Transaction(hash, from, to, value, status);
        return transaction2;
    }

    private static Status parseStatus(String status) {
        if (status.equals("0x1")) {
            return Status.ACCEPTED;
        }
        return Status.FAILED;
    }

    static String extractValueFromEthGetTransactionReceipt(String data) {
        if (data.startsWith("0x")) {
            data = data.substring(2);
        }
        return decodeInt(Hex.decode(data), 0).toString();
    }

    static String extractValueFromEthTransaction(String input) {
        return decodeInt(Hex.decode(input.substring(input.length() - 64)), 0).toString();
    }

    static String extractToFromEthTransaction(String input) {
        return new Address(decodeInt(Hex.decode(input.substring(10, input.length() - 64)), 0)).toString();
    }

    public static BigInteger decodeInt(byte[] encoded, int offset) {
        return new BigInteger(Arrays.copyOfRange(encoded, offset, offset + 32));
    }
}
