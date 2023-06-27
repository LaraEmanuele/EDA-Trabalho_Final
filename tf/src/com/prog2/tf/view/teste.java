package com.prog2.tf;

import java.sql.Connection;
import com.prog2.rh.persistencia.ConnectionFactory;

public class Teste {
    public static void main(String[] args) {
        Connection con = ConnectionFactory.getConnection();
        if (con != null) {
            System.out.println("OK");
            ConnectionFactory.close(con);
        }
    }
}
