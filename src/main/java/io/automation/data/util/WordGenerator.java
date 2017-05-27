package io.automation.data.util;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by Bonso on 5/20/2017.
 */
public class WordGenerator {

    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    private List<String> words;

    public WordGenerator() {
        initWords();
    }

    private void initWords() {
        InputStream in = this.getClass().getResourceAsStream("/wordsEn.txt");
        words = new BufferedReader(new InputStreamReader(in,
                StandardCharsets.UTF_8)).lines().collect(Collectors.toList());
    }

    public String getWord(){
        return words.get(Randomizer.random(words.size()));
    }

    public String getSentence(){
        return getSentence(4,12);
    }

    public String getSentence(int min, int max){
        StringBuilder sentence = new StringBuilder();
        for(int i = 0; i < Randomizer.random(min,max); i++){
            if(i > 0){
                sentence.append(" ");
            }
            sentence.append(getWord());
        }
        sentence.append(".");
        return sentence.toString();
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
