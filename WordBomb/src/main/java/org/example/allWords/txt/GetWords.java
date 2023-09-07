package org.example.allWords.txt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GetWords {
    public static void main(String[] args) throws IOException {
        String path = "F:\\Java\\palabra_estres\\src\\main\\java\\org\\example\\allWords\\txt";
        String path1 = path + "\\0_palabras_todas.txt";

//LisT of the all letters in Spanish language including [ñ]------------------------------------------------------------

        List<String> aToz = new ArrayList<>();
        aToz.add("ñ");

        for( int i = 97; i<123; i++){
            String letter = Character.toString(i);
            aToz.add(letter);
        }
//Creation of all txt by letter a.txt - z.txt.-------------------------------------------------------------------------

        /*File word ;
        for (String letter : aToz){
            word = new File(path,letter + ".txt");
            word.createNewFile();
        }*/
//----------------------------------------------------------------
        ArrayList<String> words = new ArrayList<>();

        boolean b;

        try {
            BufferedReader r = new BufferedReader(new FileReader(path1));
            String line;

//Saving and cleaning all words with no accents or [ ü ï ] in word list------------------------------------------------
            while ((line = r.readLine()) != null) {
                b = line.contains("á") || line.contains("é") || line.contains("í") || line.contains("ó") || line.contains("ú")
                        || line.contains("ü") || line.contains("ï");
                if (line.length() > 2 && !b) {
                    words.add(line);
                } else {
                    String wordsForGame = TildeRemover.removerTildes(line);
                    if (!words.contains(wordsForGame)) {
                        words.add(wordsForGame);
                    }
                }
            }
            r.close();
//---------------------------------------------------------------------------------------------------------------------

//Adding the words from all words in Spanish language by first letter--------------------------------------------------

            for (String l : aToz){
                BufferedWriter writer = new BufferedWriter(new FileWriter(path + "\\" + l + ".txt" ));
                for (String w : words) {
                    if (w.startsWith(l)){
                        writer.append(w).append("\n");
                    }
                }
                writer.close();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
