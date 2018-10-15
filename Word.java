/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AnhTam
 */
public class Word {
    String word;
    String mean;
    String type;
    int stt;
    public Word()
    {
    }
    public Word(String word, String mean, String type)
    {
        this.word = word;
        this.mean = mean;
        this.type = type;
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    
    }
}
