package api.inter.jdbc;

public class OracleDriver implements Connection{
    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("Oracle 접속 시도한다.");
    }
}
