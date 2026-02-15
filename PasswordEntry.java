public class PasswordEntry {
    private String account, username, password;

    public PasswordEntry(String account, String username, String password) {
        this.account = account;
        this.username = username;
        this.password = password;
    }

    public String getAccount() { return account; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
