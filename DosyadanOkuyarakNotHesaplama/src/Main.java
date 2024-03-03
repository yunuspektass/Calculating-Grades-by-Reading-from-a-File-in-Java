import java.io.*;
import java.util.Scanner;

public class Main {
    public static String harfnotuHesapla(String isim, int vize1, int vize2, int finalnot) {
        String cikti = "";

        double toplamnot = (vize1 * 0.3) + (vize2 * 0.3) + (finalnot * 0.4);

        if (toplamnot >= 90) {
            cikti = isim + " bu dersten AA aldı.";
        } else if (toplamnot >= 85) {
            cikti = isim + " bu dersten BA aldı.";
        } else if (toplamnot >= 80) {
            cikti = isim + " bu dersten BB aldı.";
        } else if (toplamnot >= 75) {
            cikti = isim + " bu dersten CB aldı.";
        } else if (toplamnot >= 70) {
            cikti = isim + " bu dersten CC aldı.";
        } else if (toplamnot >= 65) {
            cikti = isim + " bu dersten DC aldı.";
        } else if (toplamnot >= 60) {
            cikti = isim + " bu dersten DD aldı.";
        } else if (toplamnot >= 55) {
            cikti = isim + " bu dersten FD aldı.";
        } else {
            cikti = isim + " bu dersten FF aldı.";
        }
        return cikti;
    }

    public static void main(String[] args) {




        try (Scanner scanner = new Scanner(new FileReader("dosya.txt"));
             FileWriter writer = new FileWriter("harfnotları.txt")) {

            while (scanner.hasNextLine()) {//hasNextLine daha okuyacak ver kaldımı anlamı var

                String ogrenciBilgileri = scanner.nextLine();

                String[] ogrenciArray = ogrenciBilgileri.split(",");
                //virgülleri ayırdık 0. index isim 1. index vize1 oldu vs. ,
                //split metoduyla ayırdık

                int vize1 = Integer.valueOf(ogrenciArray[1]);//Integer.valueOf arraydeki string değeri integere çevirir.
                int vize2 = Integer.valueOf(ogrenciArray[2]);
                int finalnot = Integer.valueOf(ogrenciArray[3]);

                String cikti = harfnotuHesapla(ogrenciArray[0], vize1, vize2, finalnot);
                writer.write(cikti + " \n");

            }
        } catch (FileNotFoundException e) {
            System.out.println("Dosya Bulunamadı.");
        } catch (IOException e) {
            System.out.println("Dosyayı Açarken Hata Oluştu.");
        }

    }

}