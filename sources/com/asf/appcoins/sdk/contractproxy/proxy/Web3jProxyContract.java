package com.asf.appcoins.sdk.contractproxy.proxy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.FunctionReturnDecoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.Response.Error;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;

public class Web3jProxyContract implements ProxyContract {
    private final ProxyContractAddressProvider proxyContractAddressProvider;
    private final Web3jProvider web3jProvider;

    public Web3jProxyContract(Web3jProvider web3jProvider2, ProxyContractAddressProvider proxyContractAddressProvider2) {
        this.web3jProvider = web3jProvider2;
        this.proxyContractAddressProvider = proxyContractAddressProvider2;
    }

    public String getContractAddressById(String fromAddress, int chainId, String contractId) {
        List<Type> arguments = new ArrayList<>();
        List<TypeReference<?>> returnValues = new ArrayList<>();
        returnValues.add(new TypeReference<Address>() {
        });
        arguments.add(stringToBytes32(contractId));
        Function getContractAddressById = new Function("getContractAddressById", arguments, returnValues);
        try {
            EthCall rawResponse = this.web3jProvider.get(chainId).ethCall(Transaction.createEthCallTransaction(fromAddress, this.proxyContractAddressProvider.getProxyContractAddress(chainId), FunctionEncoder.encode(getContractAddressById)), DefaultBlockParameterName.LATEST).send();
            if (!rawResponse.hasError()) {
                return ((Address) FunctionReturnDecoder.decode(rawResponse.getValue(), getContractAddressById.getOutputParameters()).get(0)).getValue();
            }
            throw new RuntimeException(mapErrorToMessage(rawResponse.getError()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String mapErrorToMessage(Error error) {
        StringBuilder sb = new StringBuilder();
        sb.append("Code: ");
        sb.append(error.getCode());
        sb.append("\nmessage: ");
        sb.append(error.getMessage());
        sb.append("\nData: ");
        sb.append(error.getData());
        return sb.toString();
    }

    private Bytes32 stringToBytes32(String string) {
        byte[] value = new byte[32];
        byte[] bytes = string.getBytes();
        System.arraycopy(bytes, 0, value, 0, bytes.length);
        return new Bytes32(value);
    }
}
