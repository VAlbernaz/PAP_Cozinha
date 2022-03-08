package model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class MySQlConnection {
    //atributos
    private Properties p;
    private Connection connection;

    //construtor
    public MySQlConnection() {
        setConnection();
    }

    //metodo para fazer a ligaçao
    public void setConnection() {
        p = new Properties();
        try {
            InputStream input = new FileInputStream("dbConfig.properties");
            p.load(input);
            connection = DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"), p.getProperty("password"));
            //System.out.println("Ligado à DB");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um problema");
        }
    }

    public ResultSet numPedidos()
    {
        ResultSet result=null;
        String sql = "SELECT idpedidos \n" +
                "FROM pedidoscozinha \n" +
                "WHERE estado = 'Enviado'\n" +
                "GROUP BY idpedidos;";
        try {
            Statement s = connection.createStatement();
            result = s.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  result;
    }

    public ResultSet detalhesPedidos(int numPedido)
    {
        ResultSet result=null;
        String sql = "SELECT p.produto, pc.qtd, pc.obs\n" +
                "FROM produto p, pedidoscozinha pc\n" +
                "WHERE pc.idproduto = p.idproduto\n" +
                "AND pc.idpedidos ="+numPedido+";";
        try {
            Statement s = connection.createStatement();
            result = s.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  result;
    }
     public boolean alteraEstado(int idpedido, String estado)
     {
         try{
             String sql = "UPDATE pedidoscozinha SET estado =\""+estado+"\" WHERE idpedidos ="+idpedido+";";

             PreparedStatement statement = connection.prepareStatement(sql);



             int linhas = statement.executeUpdate();
             if (linhas == 1) {
                 return true;

             } else return false;


         } catch (SQLException throwables) {
             throwables.printStackTrace();
             return false;
         }
     }
     public ResultSet numPedidosEmConfeção()
    {
        ResultSet result=null;
        String sql = "SELECT idpedidos \n" +
                "FROM pedidoscozinha \n" +
                "WHERE estado = 'Em confeção'\n" +
                "GROUP BY idpedidos;";
        try {
            Statement s = connection.createStatement();
            result = s.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return  result;
    }
}
