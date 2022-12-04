package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVConfig {
    private static final String COMMA_DELIMITER = ",";

    public List<List<String>> readCsv() {
        List<List<String>> csv = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("login.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                csv.add(Arrays.asList(values));
            }
            return csv;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
