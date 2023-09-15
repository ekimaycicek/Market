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


    static ArrayList<String> days = new ArrayList<>(Arrays.asList("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"));
    static ArrayList<Double> dailyEarnings=new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static double weeklyTurnover=0;

    public static void main(String[] args) {

        int day=0;
        while (day<7){
            System.out.println("please "+ days.get(day) + " enter the revenue of the day: ");

            double earningsOfTheDay=sc.nextDouble();

            dailyEarnings.add(earningsOfTheDay);

            weeklyTurnover+= earningsOfTheDay;

            day++;

        }

        getAboveAverageEarningsDays();
        getBelowAverageEarningDays();
        getAverageEarnings();
        System.out.println("haftanin cirosu :" + weeklyTurnover);
        System.out.println("haftanin ortalamasi : " + getAverageEarnings());
        System.out.println("ortalama ustu kazanc olan günler : "+getAboveAverageEarningsDays());
        System.out.println("ortalama alti kazanc olan günler : "+getBelowAverageEarningDays());
    }

    private static String getBelowAverageEarningDays() {

        String AverageSixDays = "";

        for (int i = 0; i < dailyEarnings.size(); i++) {// gunluk hasilat döngüsü
            if (dailyEarnings.get(i) < getAverageEarnings()) { //gunluk hasilat haftanin ortalamasi ile kontrol
                AverageSixDays += days.get(i);//ortlamanin altindaki hasilat olan gun ortalama alti gune eklendi
            }
        }

        return AverageSixDays;


    }

    private static String getAboveAverageEarningsDays() {
        String aboveAverageDays = "";

        for (int i = 0; i < dailyEarnings.size(); i++) {// gunluk hasilat döngüsü
            if (dailyEarnings.get(i) > getAverageEarnings()) { //gunluk hasilat haftanin ortalamasi ile kontrol
                aboveAverageDays += days.get(i);//ortalamanin ustunde hasilat olan gun ortalama ustu gune eklendi
            }
        }

        return aboveAverageDays;
    }

    private static double getAverageEarnings() {

        double average = weeklyTurnover / 7;

        return average;

    }
}
