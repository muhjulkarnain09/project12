/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratikum12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author MUHAMMADJULKARNAIN
 */
public class RentalControl extends Others {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // object
        SilverMember sm = new SilverMember();
        GoldMember gm = new GoldMember();
        PlatinumMember pm = new PlatinumMember();
        
        
        // do insert data member
        insertMember();
        
        
        // attribute
        String idMember;
        int dateRent, monthRent, yearRent, dateReturn, monthReturn, yearReturn;
        Scanner input = new Scanner(System.in);
    
        
        // inputan
        System.out.println("+ ========================= Program Pengembalian Console Leptop Rental ========================= +");
        
        System.out.print("\n| Masukkan ID Member               | : ");
        idMember = input.nextLine();
        
        System.out.print("\n| Masukkan Tanggal Pinjam (1 - 31) | : ");
        dateRent = input.nextInt();
        
        System.out.print("| Masukkan Bulan Pinjam (1 - 12)   | : ");
        monthRent = input.nextInt();
        
        System.out.print("| Masukkan Tahun Pinjam (xxxx)     | : ");
        yearRent = input.nextInt();
        
        System.out.print("\n| Masukkan Tanggal Kembali (1 - 31)| : ");
        dateReturn = input.nextInt();
        
        System.out.print("| Masukkan Bulan Kembali (1 - 12)  | : ");
        monthReturn = input.nextInt();
        
        System.out.print("| Masukkan Tahun Kembali (xxxx)    | : ");
        yearReturn = input.nextInt();
        
        
        // do search data member
        System.out.println("\n+ -------------------------------------------------------------------------------------------- +");
        searchMember(idMember);
        
        
        // show rent date and return date
        System.out.println("\n+ -------------------------------------------------------------------------------------------- +");
        System.out.println("\n| Tanggal Pinjam                   | : " + dateRent + " - " + monthRent + " - " + yearRent);
        System.out.println("| Tanggal Kembali                  | : " + dateReturn + " - " + monthReturn + " - " + yearReturn);
        
        
        // show rent duration
        int rentalDuration = rentDuration(dateRent, monthRent, yearRent, dateReturn, monthReturn, yearReturn);
        System.out.println("| Lama Sewa                        | : " + rentalDuration + " hari");
        
        
        // show rent cost
        String jenisMember = getJenisMember(idMember);
        if(jenisMember == "Silver") {
            System.out.println("\n| Total Sewa                       | : Rp. " + sm.costAmount(rentalDuration));
            System.out.println("| Jumlah Poin                      | : " + sm.getPoint(rentalDuration));
        
        } else if(jenisMember == "Gold") {
            System.out.println("\n| Total Sewa                       | : Rp. " + gm.costAmount(rentalDuration));
            System.out.println("| Jumlah Poin                      | : " + gm.getPoint(rentalDuration));
            System.out.println("| Jumlah Cashback              | : Rp. " + gm.cashback);
            
        } else if(jenisMember == "Platinum") {
            System.out.println("\n| Total Sewa                       | : Rp. " + pm.costAmount(rentalDuration));
            System.out.println("| Jumlah Poin                      | : " + pm.getPoint(rentalDuration));
            System.out.println("| Jumlah Cashback              | : Rp. " + pm.cashback);
            System.out.println("| Bonus Pulsa                  | : Rp. " + pm.getBonus(rentalDuration));
            
        } else {
            System.out.println("");
        }
    }
}
