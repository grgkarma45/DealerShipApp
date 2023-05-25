package example;

import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {

    public void saveContract(Contract contract) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("contracts.csv", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            fileWriter.write(contract.getPersistenceString());
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
