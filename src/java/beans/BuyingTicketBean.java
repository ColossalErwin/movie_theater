/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;


/**
 *
 * @author hieutran
 */
@Named(value = "buyingTicketBean")
@RequestScoped
public class BuyingTicketBean implements Serializable {

    /**
     * Creates a new instance of BuyingTicketBean
     */

    private Integer number;

    public BuyingTicketBean() {
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }


    
    public String confirmNumberOfTickets()
    {
        if (number != null)
        {
            return "Payment.xhtml";
        }
        else
        {
            return null;
        }
    }
    
}
