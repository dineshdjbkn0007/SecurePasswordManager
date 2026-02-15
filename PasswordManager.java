import java.util.ArrayList;
import java.util.List;

public class PasswordManager {
    private List<PasswordEntry> entries = new ArrayList<>();

    public void addEntry(PasswordEntry entry) {
        entries.add(entry);
    }

    public String getAllEntries() {
        StringBuilder sb = new StringBuilder();
        for (PasswordEntry e : entries) {
            sb.append("Account: ").append(e.getAccount())
              .append(", Username: ").append(e.getUsername())
              .append(", Password: ").append(e.getPassword())
              .append("\n");
        }
        return sb.toString();
    }
}
