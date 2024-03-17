package api.inter.jdbc;


public class MySQLDriver implements Connection {

    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("MySQL 접속 시도한다.");
    }
}

