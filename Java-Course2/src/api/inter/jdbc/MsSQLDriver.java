package api.inter.jdbc;

public class MsSQLDriver implements Connection{
    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("MsSQL 접속 시도한다.");
    }
}
