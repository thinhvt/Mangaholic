package swd;

import core.truyentranh8.TruyenTranh8;

public class Main {

    public static void main(String[] args) {
        TruyenTranh8 tt8 = new TruyenTranh8();
        try {
            System.out.println(tt8.getMangaInfo("http://truyentranh8.net/bungaku-shoujo-to-shi-ni-tagari-no-douke/"));
        } catch (NullPointerException e) {
            System.out.println("PARSER IS OUTDATED");
            System.out.println(e.getMessage());
        }


    }
}
