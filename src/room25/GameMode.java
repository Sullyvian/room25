package room25;

import javax.naming.ConfigurationException;

public enum GameMode {
    SUSPICION, COMPETITION, TEAM, COOPERATION, SOLO;


    protected int getLaps() throws ConfigurationException {
        switch (this) {
            case SUSPICION:
            case COMPETITION:
            case TEAM:
                return 10;
            case COOPERATION:
            case SOLO:
                return 8;
            default:
                throw new ConfigurationException("Invalid game mode.");
        }
    }
}
