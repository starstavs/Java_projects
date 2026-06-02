package help;

public enum HelpType {


    FIFTY_FIFTY_HELP("F - 50 / 50"),
    AUDIENCE_HELP("S - Ask the Audience"),
    PHONE_HELP("P - Call a friend"),
    NONE("Game");

    private final String helpOptionName;

    HelpType(String helpOptionName){

        this.helpOptionName = helpOptionName;
    }

    public String getHelpOptionName() {
        return helpOptionName;
    }
}
