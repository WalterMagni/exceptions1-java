/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.exceptions;

public class DomainException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public DomainException(String msg){
        super(msg);
    }
    
    
}
