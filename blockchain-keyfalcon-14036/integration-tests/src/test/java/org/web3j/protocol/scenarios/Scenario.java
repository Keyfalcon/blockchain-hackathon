package org.web3j.protocol.scenarios;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Optional;

import org.junit.Before;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Uint;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.admin.methods.response.PersonalUnlockAccount;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthGetTransactionReceipt;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import static junit.framework.TestCase.fail;

/**
 * Common methods & settings used accross scenarios.
 */
public class Scenario {

    static final BigInteger GAS_PRICE = BigInteger.valueOf(22_000_000_000L);
    static final BigInteger GAS_LIMIT = BigInteger.valueOf(4_300_000);

    // testnet
    private static final String WALLET_PASSWORD = "0xa392604efc2fad9c0b3da43b5f698a2e3f270f170d859912be0d54742275c5f6";

    /*
    If you want to use regular Ethereum wallet addresses, provide a WALLET address variable
    "0x..." // 20 bytes (40 hex characters) & replace instances of ALICE.getAddress() with this
    WALLET address variable you've defined.
    */
    static final Credentials ALICE = Credentials.create(
            "0xa392604efc2fad9c0b3da43b5f698a2e3f270f170d859912be0d54742275c5f6",  // 32 byte hex value
            "0x506bc1dc099358e5137292f4efdd57e400f29ba5132aa5d12b18dac1c1f6aaba645c0b7b58158babbfa6c6cd5a48aa7340a8749176b120e8516216787a13dc76" // 64 byte hex value
    );

    static final Credentials BOB = Credentials.create(
            "0xc85ef7d79691fe79573b1a7064c19c1a9819ebdbd1faaab1a8ec92344438aaf4",  // 32 byte hex value
            "0x947751e3022ecf3016be03ec77ab0ce3c2662b4843898cb068d74f698ccc8ad7"+
			                                 "5aa17564ae80a20bb044ee7a6d903e8e8df624b089c95d66a0570f051e5a05b"  // 64 byte hex value
    );

    private static final BigInteger ACCOUNT_UNLOCK_DURATION = BigInteger.valueOf(30);

    private static final int SLEEP_DURATION = 15000;
    private static final int ATTEMPTS = 40;

    Admin web3j;

    public Scenario() { }

    @Before
    public void setUp() {
        this.web3j = Admin.build(new HttpService());
    }

    boolean unlockAccount() throws Exception {
        PersonalUnlockAccount personalUnlockAccount =
                web3j.personalUnlockAccount(
                        ALICE.getAddress(), WALLET_PASSWORD, ACCOUNT_UNLOCK_DURATION)
                        .sendAsync().get();
        return personalUnlockAccount.accountUnlocked();
    }

    TransactionReceipt waitForTransactionReceipt(
            String transactionHash) throws Exception {

        Optional<TransactionReceipt> transactionReceiptOptional =
                getTransactionReceipt(transactionHash, SLEEP_DURATION, ATTEMPTS);

        if (!transactionReceiptOptional.isPresent()) {
            fail("Transaction receipt not generated after " + ATTEMPTS + " attempts");
        }

        return transactionReceiptOptional.get();
    }

    private Optional<TransactionReceipt> getTransactionReceipt(
            String transactionHash, int sleepDuration, int attempts) throws Exception {

        Optional<TransactionReceipt> receiptOptional =
                sendTransactionReceiptRequest(transactionHash);
        for (int i = 0; i < attempts; i++) {
            if (!receiptOptional.isPresent()) {
                Thread.sleep(sleepDuration);
                receiptOptional = sendTransactionReceiptRequest(transactionHash);
            } else {
                break;
            }
        }

        return receiptOptional;
    }

    private Optional<TransactionReceipt> sendTransactionReceiptRequest(
            String transactionHash) throws Exception {
        EthGetTransactionReceipt transactionReceipt =
                web3j.ethGetTransactionReceipt(transactionHash).sendAsync().get();

        return transactionReceipt.getTransactionReceipt();
    }

    BigInteger getNonce(String address) throws Exception {
        EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
                address, DefaultBlockParameterName.LATEST).sendAsync().get();

        return ethGetTransactionCount.getTransactionCount();
    }

    Function createFibonacciFunction() {
        return new Function(
                "fibonacciNotify",
                Collections.singletonList(new Uint(BigInteger.valueOf(7))),
                Collections.singletonList(new TypeReference<Uint>() {}));
    }

    static String load(String filePath) throws URISyntaxException, IOException {
        URL url = Scenario.class.getClass().getResource(filePath);
        byte[] bytes = Files.readAllBytes(Paths.get(url.toURI()));
        return new String(bytes);
    }

    static String getFibonacciSolidityBinary() throws Exception {
        return load("/solidity/fibonacci/build/Fibonacci.bin");
    }
}
