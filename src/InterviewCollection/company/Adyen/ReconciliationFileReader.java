package InterviewCollection.company.Adyen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReconciliationFileReader {
    private final Path path;
    private final String accountName;
    private long totalCredits;
    private long totalDebits;

    public ReconciliationFileReader(Path path, String accountName) {
        this.path = path;
        this.accountName = accountName;
    }

    public List<ReconciliationRecord> readFile() {
        System.out.println("Reading file for account '" + accountName + "' from: '" + path.toAbsolutePath().toString() + "'");
        totalCredits = 0L;
        List<ReconciliationRecord> parsed_lines = new ArrayList<>();
        totalDebits = 0L;
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            parsed_lines = reader.lines().map(LineParser::parseLine).collect(Collectors.toList());
            return Collections.emptyList();
        } catch (Exception e) {
            System.err.println("Encountered an exception" + e.toString());
            return new ArrayList<>();
        } finally {


            final List<ReconciliationRecord> credits = parsed_lines.stream()
                    .filter(l -> "C".equalsIgnoreCase(l.getCreditOrDebit()))
                    .collect(Collectors.toList());
            final List<ReconciliationRecord> debits = parsed_lines.stream()
                    .filter(l -> "D".equalsIgnoreCase(l.getCreditOrDebit()))
                    .collect(Collectors.toList());
            totalCredits = credits.stream()
                    .map(ReconciliationRecord::getQuantity)
                    .mapToLong(value -> Long.valueOf((String) value))
                    .sum();
            totalDebits = debits.stream()
                    .map(ReconciliationRecord::getQuantity)
                    .mapToLong(value -> Long.valueOf((String) value))
                    .sum();

            System.out.println("Total Credits: " + totalCredits);
            System.out.println("Total Debits: " + totalDebits);
            return parsed_lines;
        }
    }

    public long getTotalCredits() {
        return totalCredits;
    }

    public long getTotalDebits() {
        return totalDebits;
    }

}
