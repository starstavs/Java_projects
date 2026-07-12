package service;

import question.Answer;
import question.AnswerOrder;
import question.Question;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class LoadingQuestionFromCsv {
    private int questionLevel;
    private int questionNumber;
    private String questionName;
    private int questionScore;
    private int isCorrect;

    public List<Question> loadFromCsv(String filePath) {
        List<Question> questions = new ArrayList<>();
        try (Reader reader = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT
                    .builder()
                    .setDelimiter(";")
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build()
                    .parse(reader);

            for (CSVRecord record : records) {
                isCorrect = Integer.parseInt(record.get("correctAnswer"));
                Answer[] answer = new Answer[4];
                answer[0] = new Answer(record.get("answer1"), isCorrect == 1, AnswerOrder.LETTER_1);
                answer[1] = new Answer(record.get("answer2"), isCorrect == 2, AnswerOrder.LETTER_2);
                answer[2] = new Answer(record.get("answer3"), isCorrect == 3, AnswerOrder.LETTER_3);
                answer[3] = new Answer(record.get("answer4"), isCorrect == 4, AnswerOrder.LETTER_4);

                questionLevel = Integer.parseInt(record.get("numberOfCategory"));
                questionNumber = Integer.parseInt(record.get("numberOfQuestion"));
                questionName = record.get("question");
                questionScore = Integer.parseInt(record.get("score"));
                Question question = new Question(questionLevel, questionNumber, questionName, answer, questionScore);
                questions.add(question);

            }

        } catch (IOException e) {
            throw new RecordFileReadException("Error reading CSV file", e);
        }
        return questions;
    }

}


