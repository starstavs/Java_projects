package milionare;

public enum Levels {
    LEVEL_1(1, "OOP foundation", 100),
    LEVEL_2(2, "Interfaces deeper", 200),
    LEVEL_3(3, "Inheritance logic traps", 300),
    LEVEL_4(4, "Polymorphism behavior", 500),
    LEVEL_5(5, "Memory & object behavior", 1000),
    LEVEL_6(6, "Encapsulation deeper usage", 3000),
    LEVEL_7(7, "Abstract vs Interface comparison", 5000),
    LEVEL_8(8, "Static, final, method behavior", 10000),
    LEVEL_9(9, "Interface advanced behavior", 20000),
    LEVEL_10(10, "Method resolution & JVM behavior", 50000),
    LEVEL_11(11, "Architecture thinking", 100000),
    LEVEL_12(12, "Real project thinking", 125000),
    LEVEL_13(13, "Integration thinking", 250000),
    LEVEL_14(14, "Advanced logic", 500000),
    LEVEL_15(15, "Final thinking", 1000000);

    private int levelNumber;
    private String levelDescription;
    private int levelBonus;

    Levels(int levelNumber, String levelDescription, int levelBonus) {
        this.levelNumber = levelNumber;
        this.levelDescription = levelDescription;
        this.levelBonus = levelBonus;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public String getLevelDescription() {
        return levelDescription;
    }

    public int getLevelBonus() {
        return levelBonus;
    }
    public static int getLevelBonusByNumber(int levelNumber){
        for (Levels levels : Levels.values()) {
            if (levels.getLevelNumber() == levelNumber) {
                return levels.getLevelBonus();
            }

        }
        return 0;
    }

    public static Levels getLevelNameByNumber(int levelNumber) {
        for (Levels levels : Levels.values()) {
            if (levels.getLevelNumber() == levelNumber) {
                return levels;
            }

        }
        return null;
    }

    public static String getLevelDescriptionByNumber(int levelNumber){
        for (Levels levels : Levels.values()) {
            if (levels.getLevelNumber() == levelNumber) {
                return levels.getLevelDescription();
            }

        }
        return null;
    }

}
