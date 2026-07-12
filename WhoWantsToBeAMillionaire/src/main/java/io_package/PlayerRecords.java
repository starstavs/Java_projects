package io_package;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class PlayerRecords {

    public void WritePlayerScore(List<PlayerRecords> playerList, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            //writer.write();
            System.out.println("fdf");
        } catch (IOException e) {
            throw new RuntimeException("Failed to write data to file: " + filePath, e);
        }

    }
}
