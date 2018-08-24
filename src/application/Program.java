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
import model.exceptions.DomainException;



public class Program {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            System.out.print("Numero do quarto: ");
            int number = sc.nextInt();
            System.out.print("Data de check-in (dd/mm/aaaa): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (dd/mm/aaaa): ");
            Date checkOut = sdf.parse(sc.next());



            Reservation reserva = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva:" + reserva);

            System.out.println();
            System.out.println("Entre com a data para atualizar a reserva: ");
            System.out.print("Data de check-in (dd/mm/aaaa): ");
            checkIn = sdf.parse(sc.next());
            System.out.print("Data de check-out (dd/mm/aaaa): ");
            checkOut = sdf.parse(sc.next());


                /* Date now = new Date();
                if (checkIn.before(now) || checkOut.before(now)) {
                    System.out.println("Erro na reserva: as datas para atualização devem ser futura");
                } else if (!checkOut.after(checkIn)) {
                System.out.println("Erro na reserva: a data de check out deve ser depois da data de check in");
                }  else{
                    reserva.updatesDates(checkIn, checkOut);
                    System.out.println("Reserva:" + reserva);
                }
                */

            reserva.updatesDates(checkIn, checkOut);
            System.out.println("Reserva:" + reserva);
        }    
        catch(ParseException e ) {
            System.out.println("Data invalida");
        }    
        catch(DomainException e) {
            System.out.println("Erro: " + e.getMessage());
        }
        catch(RuntimeException e ){
            System.out.println("Erro inesperado");
        }
        
        
        
        sc.close();
    }
    
}
