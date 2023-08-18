import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Market {

    /* TASK :
     * Bir bakkalın 7 günlük tüm kazançlarını günlük olarak gösteren bir program yazınız.
     * Ayrıca bakkalın bu hafta ortalama kazandığı miktarı gösteren bir method yazınız.
     * Ayrıca bakkalın hangi günler ortalamanın üstüne kazandığını gösteren bir method yazınız.
     * Ayrıca bakkalın hangi günler ortalamanın altında kazandığını gösteren bir method yazınız.
     *
     * 1. Adım : Günleri içeren bir tane ArrayList oluşturun. (gunler)
     * 2. Adım : Günlük kazançları ekleyeceğimiz bir tane ArrayList oluşturun. (gunlukKazanclar)
     * 3. Adım : While döngüsü ile kullanıcıdan 7 günlük kazançları tekek teker alıp gunlukKazanclar ArrayList'e ekle.
     * 4. Adım : getOrtalamaKazanc() adlı method ile ortalama kazancı alın.
     * 5. Adım : getOrtalamaninUstundeKazancGünleri() adlı method oluşturun.
     * 			 for döngüsü ile tüm günleri ortalama kazanç ile karşılaştır
     * 			 ortalama kazançtan yüksekse o günleri return yap.
     * 6. Adım : getOrtalamaninAltindaKazancGünleri() adlı method oluşturun.
     * 			 for döngüsü ile tüm günleri ortalama kazanç ile karşılaştır
     * 			 ortalama kazançtan aşağıysa o günleri return yap.
     * */

    static ArrayList<String> days =new ArrayList<>(Arrays.asList("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"));
    static ArrayList<Double> dailyEarnings=new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static double weeklyTurnover=0;
    public static void main(String[] args) {
        int gun=0;
        while (gun<7){
            System.out.println("Lutfen "+ days.get(gun) + " gunun hasilatini girin: ");

            double gunKazancı=sc.nextDouble();

            dailyEarnings.add(gunKazancı);

            weeklyTurnover+= gunKazancı;

            gun++;

        }
        getOrtalamaninUstundeKazancGünleri();
        getOrtalamaninAltindaKazancGünleri();
        getOrtalamaKazanc();
        System.out.println("haftanın cirosu :" + weeklyTurnover);
        System.out.println("haftanın ortalaması : " + getOrtalamaKazanc());
        System.out.println("ortalam ustu kazanc olan günler : "+getOrtalamaninUstundeKazancGünleri());
        System.out.println("ortalam altı kazanc olan günler : "+getOrtalamaninAltindaKazancGünleri());
    }

    private static String getOrtalamaninAltindaKazancGünleri() {//6. adim
        String ortalamaAltıGun = "";

        for (int i = 0; i < dailyEarnings.size(); i++) {// gunluk hasilat döngüsü
            if (dailyEarnings.get(i) < getOrtalamaKazanc()) { //gunluk hasilat haftanin ortalamasi ile kontrol
                ortalamaAltıGun += days.get(i);//ortlamanin altindaki hasilat olan gun ortalama alti gune eklendi
            }
        }

        return ortalamaAltıGun;


    }

    private static String getOrtalamaninUstundeKazancGünleri() {//5. adim
        String ortalaUstuGun = "";

        for (int i = 0; i < dailyearnings.size(); i++) {// gunluk hasilat döngüsü
            if (dailyearnings.get(i) > getOrtalamaKazanc()) { //gunluk hasilat haftanin ortalamasi ile kontrol
                ortalaUstuGun += days.get(i);//ortalamanin ustunde hasilat olan gun ortalama ustu gune eklendi
            }
        }

        return ortalaUstuGun;
    }

    private static double getOrtalamaKazanc() {//4. adim

        double ortalama = haftaCirosu / 7;

        return ortalama;

    }
}
