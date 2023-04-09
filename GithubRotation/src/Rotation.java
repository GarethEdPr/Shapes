
// import javafx application for GUI tools and components
import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

//name of public class extends the application

public class Rotation extends Application {

	// code to start the GUI process
	public void start(Stage stage) {

		// BorderPane lays out children in top, left, right, bottom, and centre
		// positions.

		BorderPane root = new BorderPane();

		// Create a VBox to hold the components, setting spacing in parenthesis
		VBox vbox = new VBox(10);

		// Minimum width
		vbox.setMinWidth(150);

		// Creating the rotation transformation
		Rotate rotate = new Rotate();

		// Setting the angle for the rotation
		rotate.setAngle(30);

		// Setting pivot points for the rotation
		rotate.setPivotX(160);
		rotate.setPivotY(250);

		// Static initialisation of shapes to allow for removal from screen

		Rectangle rectangle = new Rectangle();
		Polygon pentagon = new Polygon();
		Polygon hexagon = new Polygon();

		// Create and customise field for user input
		TextField clickMeTextField = new TextField();
		clickMeTextField.setMaxWidth(385);

		// create and configure buttons to display instructions
		Button clickMeButton = new Button();
		clickMeButton.setText("Enter number");

		Button rotateMeButton = new Button();
		rotateMeButton.setText("Click to rotate shape");

		// Starting the action

		clickMeButton.setOnAction(e -> {

			// Set of conditions to decide which, if any, shape to be printed

			if (clickMeTextField.getText().equals("4")) {

				// Code block to ensure only one shape visible on screen

				if (pentagon != null || rectangle != null || hexagon != null) {

					root.getChildren().remove(rectangle);

					root.getChildren().remove(pentagon);

					root.getChildren().remove(hexagon);

				}

				// Code for configuring rectangle

				rectangle.setHeight(200);
				rectangle.setWidth(300);

				rectangle.setFill(Color.BLUE);

				// Code for adding rectangle

				/// Placing shape in centre

				root.setCenter(rectangle);

				// root.getChildren().add(rectangle);

				stage.setTitle("Rectangle");

			}

			else if (clickMeTextField.getText().equals("5"))

			{

				// Code block to ensure only one shape visible on screen

				if (rectangle != null || pentagon != null || hexagon != null) {

					root.getChildren().remove(rectangle);

					root.getChildren().remove(pentagon);

					root.getChildren().remove(hexagon);

				}

				// Code for configuring pentagon

				pentagon.getPoints()
						.addAll(new Double[] { 250.0, 75.0, 450.0, 75.0, 550.0, 200.0, 450.0, 350.0, 350.0, 300.0 });
				pentagon.setFill(Color.BLUE);

				// code for centering and titling shape

				root.setCenter(pentagon);

				stage.setTitle("Pentagon");

			}

			else if (clickMeTextField.getText().equals("6"))

			{

				// Code block to ensure only one shape is visible on screen

				if (rectangle != null || pentagon != null || hexagon != null) {

					root.getChildren().remove(rectangle);

					root.getChildren().remove(hexagon);

					root.getChildren().remove(pentagon);

				}

				// Code for configuring hexagon

				hexagon.getPoints().addAll(new Double[] { 250.0, 75.0, 450.0, 75.0, 500.0, 200.0, 450.0, 300.0, 250.0,
						250.0, 150.0, 150.0 });
				hexagon.setFill(Color.BLUE);

				// Code for adding hexagon

				root.setCenter(hexagon);

				stage.setTitle("Hexagon");

			}

			// Else statement at end of code block to indicate appropriate input

			else {

				clickMeTextField.setText("Enter 4, 5 or 6");
			}

		});

		// Block of code allowing user to change colour of shape printed on screen

		// Creating and configuring button for colour change

		Button colourButton = new Button();

		TextField colourButtonText = new TextField();
		colourButtonText.setMaxWidth(305);

		// Button message

		colourButton.setText("Enter colour");

		// Add the buttons to the container

		// Adding colour button to root

		root.getChildren().addAll(colourButtonText, colourButton);

		// Adding buttons to vobox

		vbox.getChildren().addAll(clickMeTextField, clickMeButton, rotateMeButton, colourButtonText, colourButton);
		root.setLeft(vbox);

		// Creating scene
		Scene scene = new Scene(root, 1200, 800);

		stage.setScene(scene);
		stage.setTitle("Shapes");
		stage.show();

		// Start of action with .setOnAction

		rotateMeButton.setOnAction(e3 -> {

			// Adding shapes to screen per user input, for possible rotation

			if (clickMeTextField.getText().equals("4")) {

				rectangle.getTransforms().addAll(rotate);
			}

			if (clickMeTextField.getText().equals("5")) {

				pentagon.getTransforms().addAll(rotate);
			}

			if (clickMeTextField.getText().equals("6")) {

				hexagon.getTransforms().addAll(rotate);
			}

		});

		colourButton.setOnAction(e2 -> {

			// Conditional statements for changing colour of shape

			// EqualsIgnoreCase allows for input variation

			if (colourButtonText.getText().equalsIgnoreCase("yellow") && clickMeTextField.getText().equals("4")) {

				rectangle.setFill(Color.YELLOW);

			}

			else if (colourButtonText.getText().equalsIgnoreCase("orange") && clickMeTextField.getText().equals("4")) {

				rectangle.setFill(Color.ORANGE);

			}

			else if (colourButtonText.getText().equalsIgnoreCase("green") && clickMeTextField.getText().equals("4")) {

				rectangle.setFill(Color.GREEN);

			}

			else if (colourButtonText.getText().equalsIgnoreCase("yellow") && clickMeTextField.getText().equals("5")) {

				pentagon.setFill(Color.YELLOW);

			}

			else if (colourButtonText.getText().equalsIgnoreCase("orange") && clickMeTextField.getText().equals("5")) {

				pentagon.setFill(Color.ORANGE);

			}

			else if (colourButtonText.getText().equalsIgnoreCase("green") && clickMeTextField.getText().equals("5")) {

				pentagon.setFill(Color.GREEN);

			}

			else if (colourButtonText.getText().equalsIgnoreCase("yellow") && clickMeTextField.getText().equals("6")) {

				hexagon.setFill(Color.YELLOW);

			}

			else if (colourButtonText.getText().equalsIgnoreCase("orange") && clickMeTextField.getText().equals("6")) {

				hexagon.setFill(Color.ORANGE);

			}

			else if (colourButtonText.getText().equalsIgnoreCase("green") && clickMeTextField.getText().equals("6")) {

				hexagon.setFill(Color.GREEN);

			}

			// Else if statement towards end of code block to alert user to input an
			// appropriate entry in FIRST text box

			else if (clickMeTextField.getText().isEmpty() || clickMeTextField.getText().equals("Enter 4, 5 or 6")) {

				colourButtonText.setText("First, enter a valid shape");

			}

			// Else statement at end of code block to alert user to input appropriate colour

			else {

				colourButtonText.setText("Enter orange, green or yellow");
			}

		});

	}

	// Code to launch application

	public static void main(String[] args) {
		launch(args);
	}

}
