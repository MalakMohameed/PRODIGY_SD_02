

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        Button button = new Button("Guess!");
        TextField input = new TextField();
        Label text = new Label("Welcome to the Guessing Game!\nGuess a number between 1 and 100:");
        text.setStyle("-fx-font-size: 14px;");
        Label output = new Label("");
        output.setStyle("-fx-text-fill: red;");
        
        int random = (int) (Math.random() * 100) + 1;
        int[] counter = {0};
        button.setOnAction(e -> {
            try {
                counter[0]++; 
                int guess = Integer.valueOf(input.getText());
        
                if (guess == random) {
                    output.setStyle("-fx-text-fill: green;");
                    output.setText("Congratulations! You guessed the number in "+ counter[0] +" attempt.");
                } else {
                    if (guess < random) {
                        output.setText("The random number is greater than your guess. Guess again");
                    } else {
                        output.setText("The random number is less than your guess. Guess again");
                    }
                }
            } catch (Exception ex) {
                output.setText("Please enter a valid integer.");
            }
        });

        
        GridPane root = new GridPane();
        root.add(text, 0, 0, 3, 1); 
        root.add(input, 0, 1);
        root.add(button, 1, 1);
        root.add(output, 0, 2, 3, 1); 
        
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);

        Scene scene = new Scene(root, 500, 200);

        primaryStage.setTitle("Guessing Game");
        primaryStage.getIcons().add(new Image("icon.jpg"));
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
