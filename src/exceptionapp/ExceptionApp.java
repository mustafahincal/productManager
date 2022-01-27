package exceptionapp;

import java.util.Scanner;

/**
 *
 * @author hncal
 */

public class ExceptionApp {

    public static void main(String[] args) {
        
        try {
            Stock stk = null;
            int secim, sayac = 0, kapasite;
            Scanner s = new Scanner(System.in);
            String ad;
            double fiyat, boyut, agirlik;
            do {
                System.out.println("\n1)Stok Oluştur");
                System.out.println("2)Urun Ekle");
                System.out.println("3)Hacim başına fiyat hesapla");
                System.out.println("4)Ağırlık başına fiyat Hesapla");
                System.out.println("5)Kayıtlı Urunleri göster");
                System.out.println("6)Dosyaya kaydet");
                
                System.out.print("İşlem : ");
                secim = s.nextInt();

                switch (secim) {
                    case 1:
                        System.out.print("Kapasite giriniz : ");
                        kapasite = s.nextInt();
                        stk = new Stock(kapasite);

                        break;
                    case 2:
                        if(stk==null){
                            System.out.println("Ürün eklemeden önce stok oluşturmanız gerekmekmektedir!!");
                        }else{
                            System.out.print("Urun fiyatı : ");
                            fiyat = s.nextDouble();
                            System.out.print("Urun ağırlık : ");
                            agirlik = s.nextDouble();
                            System.out.print("Urun boyut : ");
                            boyut = s.nextDouble();
                            System.out.print("Urun adı : ");
                            s.nextLine();
                            ad = s.nextLine();
                            try{
                                stk.addProduct(ad, fiyat, boyut, agirlik);
                            }catch(ArrayOutOfBoundsException ex){
                                System.out.println(ex.getMessage());
                            }
                        }
                        break;
                    case 3:
                        stk.calculatepricePerSize();
                        break;
                    case 4:
                        stk.calculatepricePerWeight();
                        break;
                    case 5:
                        stk.showInventory();
                        break;
                    case 6:
                        stk.writeFile();
                        break;
                    default:
                        System.out.println("Hatalı Seçim Yaptınız!!");
                        break;
                }

            } while (secim != 0);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
