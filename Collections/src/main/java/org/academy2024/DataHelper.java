package org.academy2024;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

public class DataHelper {

    public static List<Transaction> loadTransactions() {

        try(InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("transactions.json")) {
            ObjectMapper mapper = new ObjectMapper();
            List<Transaction> transactions = mapper.readValue(in, new TypeReference<>() {});
            return transactions;
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<AccountHolder> loadAccountHolders() {

        try(InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("names.json")) {
            ObjectMapper mapper = new ObjectMapper();
            List<AccountHolder> holders = mapper.readValue(in, new TypeReference<>() {});
            return holders;
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}
