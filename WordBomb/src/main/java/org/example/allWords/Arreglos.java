package org.example.allWords;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Arreglos {

    String line;
    String rletra;
    String path = "F:\\Java\\palabra_estres\\src\\main\\java\\org\\example\\allWords\\txt\\";

    Random r = new Random();
    int rnumber;

    int index = 1;
    public void rLetra() throws IOException {
        try {
            rnumber = r.nextInt(1,27);
            BufferedReader readAtoZ;
            readAtoZ = new BufferedReader(new FileReader(path + "atoz.txt"));
            index =1;
            while ((line = readAtoZ.readLine()) != null) {
                if (index == rnumber){
                    rletra = line;
                    break;
                }
                index++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String rword;


    public String rWord() {
        try {
            rLetra();
            BufferedReader randomTXT;
            randomTXT = new BufferedReader(new FileReader(path + rletra + ".txt"));
            index = 1;
            while((line =randomTXT.readLine())!=null){
                index++;
            }
            rnumber = r.nextInt(1,index);
            randomTXT.close();
            randomTXT = new BufferedReader(new FileReader(path + rletra + ".txt"));
            index = 1;
            while((line =randomTXT.readLine())!=null){
                if (index == rnumber){
                    rword = line;
                    break;
                }
                index++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return rword;
    }

}