package edu.tekwill.millionaire.game;

public class Rules {
    private String rules = "Bine ați venit la joaca \"Cine vrea să fie millionar\".\n" +
            "Vei avea de înfruntat 15 întrebări.\n" +
            "Un răspuns corect îți aduce un anumit număr de puncte,\n" +
            "în funcție de dificultatea întrebării.\n" +
            "Dacă răspunzi greșit la o întrebare, jocul se termină.\n" +
            "Ai trei variante de ajutor:\n" +
            "1. „50/50” — care elimină două variante de răspuns greșite;\n"+
        "2. „Suna un prieten” — poți cere sfatul unui prieten, având la dispoziție exact un minut;\n" +
            "3. „Întreabă publicul” — pentru a afla opinia celor prezenți;\n" +
            "Jocul are, de asemenea, două sume garantate: 1.000 de lei și 100.000 de lei.\n" +
            "În cazul unui răspuns greșit, vei primi suma corespunzătoare ultimului prag de siguranță atins.\n" +
            "Îți doresc mult succes!\n";

    public String getRules(){
        return rules;
    }
}
