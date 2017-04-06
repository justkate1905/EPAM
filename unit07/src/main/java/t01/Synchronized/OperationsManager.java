package t01.Synchronized;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperationsManager {

    private final static Pattern pattern = Pattern.compile("From: (\\d+) to: (\\d+) amount: (\\d+)");
    private HashMap<Integer, Account> accounts = new HashMap<Integer, Account>();

    public void runOperations(String path) throws IOException, InterruptedException {

        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int sourceID;
        int destID;
        int amount;

        Matcher matherForOperation;
        String operation;
        while((operation = bufferedReader.readLine())!=null) {

            matherForOperation = pattern.matcher(operation);
            if(matherForOperation.find()){
                sourceID = Integer.parseInt(matherForOperation.group(1));
                destID = Integer.parseInt(matherForOperation.group(2));
                amount = Integer.parseInt(matherForOperation.group(3));
                //System.out.println(matherForOperation.group(1));
                this.operation(accounts,sourceID,destID,amount);
            }

        }

    }


    public void operation(HashMap<Integer, Account> accounts, int source, int destination, int amount) throws InterruptedException {

        if(!accounts.keySet().contains(source)) {
            accounts.put(source, new Account(source,1000));
        }
        if(!accounts.containsKey(destination)){
            accounts.put(destination,new Account(destination,400));
        }

        OperatorDeposit opD = new OperatorDeposit(accounts.get(source),amount);
        OperatorWithdraw opW = new OperatorWithdraw(accounts.get(destination),amount);

        opD.start();
        opW.start();

        opD.join();
        opW.join();

    }

    public static void main(String[] args)
            throws InterruptedException, IOException {
        OperationsManager operationsManager = new OperationsManager();
        operationsManager.runOperations("operations.txt");

        for (Integer arg : operationsManager.accounts.keySet()) {
            System.out.println("Balance of account "
                    + arg+ " is "
                    + operationsManager.accounts.get(arg).getBalance());
        }
    }
}
