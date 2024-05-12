package com.paymentchain.transactions.Service;

import com.paymentchain.transactions.entities.Transactions;
import org.apache.el.parser.ParseException;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class TransationsServicesImpl {
    /*
    @Override
    public double saberFee(Transactions fee) {
        double x = 0;
        if (fee.getFee()> 0) {
            x = fee.getAmount() - fee.getFee();
        }
        return x;
    }

    @Override
    public double saberTransaction(Transactions amount) {
        double saldo = amount.getAmount();
        if (saldo > 0) {
            saldo += amount.getAmount();
        } else {
            saldo -= amount.getAmount();
        }
        return saldo;
    }

    @Autowired
    public boolean saberMoneyActual(double amountActual, double amount) {
        if ((amountActual - amount) == 0) {
            return true;
        }
        return false;
    }

    @Autowired
    public double saberAmount(Transactions amount){
        return amount.getAmount();
    }


     */
    public String dateTransaction(Transactions date) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date actual = new Date();
        //Date date = dateFormat.parse();
        if (date.getDataTime().compareTo(actual) <= 0) {
            return " liquidado";
        }else{
           return "pendiente";
        }

    }
}

