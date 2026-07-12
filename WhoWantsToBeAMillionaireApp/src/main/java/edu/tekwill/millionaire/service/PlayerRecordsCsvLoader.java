package edu.tekwill.millionaire.service;

import game.PlayerRecords;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class PlayerRecordsCsvLoader {

    public List<PlayerRecords> loadPlayerFromCsv(String filePath) {
        List<PlayerRecords> playerList = new ArrayList<>();
        try (Reader reader = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .builder()
                    .setDelimiter(";")
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(reader);

            for (CSVRecord record : records) {
                String name = record.get("userName");
                int score = parseInt(record.get("userScore"));
                int guaranteedAmount = parseInt(record.get("userGuaranteedAmount"));
                PlayerRecords player = new PlayerRecords(name, score, guaranteedAmount);
                playerList.add(player);
            }
        } catch (IOException e) {
            throw new RecordFileReadException("Error reading  PlayerCSV file", e);
        }
        return playerList;
    }

    private int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid input data " + value, e);
        }
    }

}
