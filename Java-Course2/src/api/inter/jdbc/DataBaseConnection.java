package api.inter.jdbc;

public class DataBaseConnection {
    public static void main(String[] args) {
        // oracle DB 접속
        var oracle = new OracleDriver();
        oracle.getConnection("jdbc:oracle:thin:@localhost:1521:XE","root","1234");

        // MySql 접속
        var mysql = new MySQLDriver();
        mysql.getConnection("jdbc:mysql:thin:@localhost:3306/root","root","1234");

        // MsSQL
        var mssql = new MsSQLDriver();
        mssql.getConnection("jdbc:sqlserver://@localhost:1433;DatabaseName=root","root","1234");
    }
}
