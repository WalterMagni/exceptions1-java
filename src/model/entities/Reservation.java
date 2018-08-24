/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.exceptions.DomainException;

public class Reservation {
    
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Erro na reserva: a data de check out deve ser depois da data de check in");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    
    public Reservation(){
        
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration(){
        
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
      
    }
    
    public void updatesDates(Date checkIn, Date checkOut) {
        
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
             throw new DomainException("Erro na reserva: as datas para atualização devem ser futura");
        } 
        if (!checkOut.after(checkIn)) {
            throw new DomainException("Erro na reserva: a data de check out deve ser depois da data de check in");
        }       
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        
    }

    @Override
    public String toString() {
        return "Room: " + roomNumber + ", checkIn: " + sdf.format(checkIn) + ", checkOut: " + sdf.format(checkOut) + " " +duration() + " nights";
    }
    
    
    
    
}
