import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    private PasswordManager manager = new PasswordManager();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Secure Password Manager");

        // Master password prompt
        PasswordField masterField = new PasswordField();
        masterField.setPromptText("Enter Master Password");

        Button loginBtn = new Button("Login");
        Label loginLabel = new Label();

        VBox loginBox = new VBox(10, masterField, loginBtn, loginLabel);
        loginBox.setStyle("-fx-padding: 20;");

        Scene loginScene = new Scene(loginBox, 300, 150);

        loginBtn.setOnAction(e -> {
            String master = masterField.getText();
            if (master.isEmpty()) {
                loginLabel.setText("Master password cannot be empty!");
                return;
            }
            // For demo, we accept any master password
            showMainScene(primaryStage, master);
        });

        primaryStage.setScene(loginScene);
        primaryStage.show();
    }

    private void showMainScene(Stage stage, String masterPassword) {
        // Fields to add entry
        TextField accountField = new TextField();
        accountField.setPromptText("Account");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Username");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button addBtn = new Button("Add Entry");

        TextArea entriesArea = new TextArea();
        entriesArea.setEditable(false);
        entriesArea.setPrefHeight(200);

        addBtn.setOnAction(e -> {
            String account = accountField.getText();
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (account.isEmpty() || username.isEmpty() || password.isEmpty()) return;

            PasswordEntry entry = new PasswordEntry(account, username, password);
            manager.addEntry(entry);

            // Show all entries
            entriesArea.setText(manager.getAllEntries());
            
            // Clear fields
            accountField.clear();
            usernameField.clear();
            passwordField.clear();
        });

        VBox root = new VBox(10,
                new HBox(10, accountField, usernameField, passwordField, addBtn),
                entriesArea
        );
        root.setStyle("-fx-padding: 20;");

        Scene scene = new Scene(root, 600, 300);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
