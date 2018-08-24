/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;



public class Program {
    
    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Numero do quarto: ");
        int number = sc.nextInt();
        System.out.print("Data de check-in (dd/mm/aaaa): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.print("Data de check-out (dd/mm/aaaa): ");
        Date checkOut = sdf.parse(sc.next());
        
        if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: a data de check out deve ser depois da data de check in");
        } else {
            Reservation reserva = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva:" + reserva);
            
            System.out.println();
            System.out.println("Entre com a data para atualizar a reserva: ");
            System.out.print("Data de check-in (dd/mm/aaaa): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (dd/mm/aaaa): ");
            checkOut = sdf.parse(sc.next());
            
            Date now = new Date();
            if (checkIn.before(now) || checkOut.before(now)) {
                System.out.println("Erro na reserva: as datas para atualização devem ser futura");
            } else if (!checkOut.after(checkIn)) {
            System.out.println("Erro na reserva: a data de check out deve ser depois da data de check in");
            } else{
                reserva.updatesDates(checkIn, checkOut);
                System.out.println("Reserva:" + reserva);
            }
            
            
            
        }
        
        
        sc.close();
    }
    
}
