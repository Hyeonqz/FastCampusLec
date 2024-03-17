package api.inter.jdbc;

public interface Connection {

    // DB Connection
    public void getConnection(String url, String username, String password);
}
