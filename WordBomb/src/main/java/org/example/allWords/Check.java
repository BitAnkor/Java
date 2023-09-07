package org.example.allWords;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Check {
    Arreglos arreglos = new Arreglos();

    String path = "F:\\Java\\palabra_estres\\src\\main\\java\\org\\example\\allWords\\txt\\";
    String letter;
    boolean isThere = false;
    boolean inWord = false;

    boolean isRepeated = false;
    String res;


    ArrayList<String> usedWords = new ArrayList<>();
    String checkWord;

    public Check()  {
    }

    String rword;


    int rnumber;

    String wordLine;
    Random r = new Random();
    public String randomWord() throws IOException {
        rnumber = r.nextInt(1,27);
        rword = arreglos.rWord();

        if (rword.length()<4){
            rword = wordLine.substring((rword.length()/2)-1,(rword.length()/2)+1);
        } else {
            rword = rword.substring((rword.length()/2)-1,(rword.length()/2)+2) ;
        }
        res = "Must contain:\t"+"'" + rword + "'";
        return res;
    }

    public boolean wordCheck (String word) {
    if (!word.equalsIgnoreCase("")) {
        try {
            checkWord = word;
            char first = word.charAt(0);
            letter = Character.toString(first);
            BufferedReader r = new BufferedReader(new FileReader(path + letter + ".txt"));
            String line;

            while ((line = r.readLine()) != null && !isRepeated) {

                if (line.equalsIgnoreCase(word)) {
                    isThere = true;
                    usedWords.add(word);
                }
            }
            r.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        return isThere;
    }
    public Boolean wordRepeated(String word){
        isRepeated = false;
        for (String repeat: usedWords){
            if (repeat.equalsIgnoreCase(word)) {
                isRepeated = true;
                break;
            }
        }
        return isRepeated;
    }

    public boolean insideWord(String word){
        inWord = word.contains(rword);
        return inWord;
    }

}
