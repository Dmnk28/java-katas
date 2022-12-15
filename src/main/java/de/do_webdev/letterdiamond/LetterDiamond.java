package de.do_webdev.letterdiamond;

public class LetterDiamond {
    private final char letter;
    private final StringBuilder diamond = new StringBuilder();
    
    public char getLetter() {
        return this.letter;
    }
    
    public LetterDiamond() {
        this('A');
    }
    
    public LetterDiamond(char letter) {
        if (letter < 'A') throw new IllegalArgumentException();
        
        this.letter = Character.toUpperCase(letter);
        
        if (letter == 'A') {
            diamond.append('A');
        } else {
            constructDiamond();
        }
    }
    
    public void print() {
        System.out.println(diamond);
    }
    
    private void constructDiamond() {
        diamond.append(calcOuterSpace('A'))
                .append('A')
                .append("\n");
        
        char currentChar = 'B';
        for (; currentChar < letter; currentChar++) {
            constructCharacterLine(currentChar);
        }
        for (; currentChar >= 'B'; currentChar--) {
            constructCharacterLine(currentChar);
        }

        diamond.append(calcOuterSpace('A'))
                .append('A');
    }
    
    private void constructCharacterLine(char currentChar) {
        diamond.append(calcOuterSpace(currentChar))
                .append(currentChar)
                .append(calcInnerSpace(currentChar))
                .append(currentChar)
                .append("\n");
    }
    
    public String calcInnerSpace(char currentChar) {
        int spaceCount = Math.abs((currentChar - 'A') * 2 - 1);
        return " ".repeat(spaceCount);
    }
    
    public String calcOuterSpace(char currentChar) {
        int spaceCount = Math.abs((letter - 'A') - (currentChar - 'A'));
        return " ".repeat(spaceCount);
    }
    
    @Override
    public String toString() {
        return diamond.toString();
    }
}