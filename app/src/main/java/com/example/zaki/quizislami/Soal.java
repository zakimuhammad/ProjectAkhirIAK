package com.example.zaki.quizislami;

/**
 * Created by zaki on 10/09/17.
 */

public class Soal {
    private String soal;
    private String jwbA;
    private String jwbB;
    private String jwbC;
    private String jwbD;
    private String jwbBenar;
    private int gambar;

    public Soal(String soal, String jwbA, String jwbB, String jwbC, String jwbD, String jwbBenar, int gambar) {
        this.soal = soal;
        this.jwbA = jwbA;
        this.jwbB = jwbB;
        this.jwbC = jwbC;
        this.jwbD = jwbD;
        this.jwbBenar = jwbBenar;
        this.gambar = gambar;
    }

    public int getGambar() {
        return gambar;
    }

    public String getSoal() {
        return soal;
    }

    public String getJwbA() {
        return jwbA;
    }

    public String getJwbB() {
        return jwbB;
    }

    public String getJwbC() {
        return jwbC;
    }

    public String getJwbD() {
        return jwbD;
    }

    public String getJwbBenar() {
        return jwbBenar;
    }
}
