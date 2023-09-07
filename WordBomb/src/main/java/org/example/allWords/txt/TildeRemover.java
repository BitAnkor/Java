package org.example.allWords.txt;

public interface TildeRemover {
        static String removerTildes(String word) {
            return word.replace("á", "a")
                    .replace("é", "e")
                    .replace("í", "i")
                    .replace("ó", "o")
                    .replace("ú", "u")
                    .replace("ï", "i")
                    .replace("ü", "ü");
        };


}
