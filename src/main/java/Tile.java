public class Tile {

    // attributes
    private String name;
    private int number;
    private String symbol;

    // constructor

    public Tile(String tileName, int tileNumber, String tileSymbol) {
        name = tileName;
        number = tileNumber;
        symbol = tileSymbol;
    }

    // getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

}
