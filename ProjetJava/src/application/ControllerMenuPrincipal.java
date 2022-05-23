package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ControllerMenuPrincipal implements Initializable {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	

	public void switchToMain(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		root = loader.load();
		
		ControllerMain controller = loader.getController();
			 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.show();
		controller.init();
		controller.go(event);
	}
	
	
	public void switchToMenuHistorique(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("menuHistorique.fxml"));
		root = loader.load();
			
		ControllerMenuHistorique controller = loader.getController();
		controller.displayBDD();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToSaves(ActionEvent event) throws IOException {//page ou l'on écrit les saves
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Saves.fxml"));
		root = loader.load();
		
		ControllerSaves controller = loader.getController();
		controller.displayBDD();
		
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	}
	
	@FXML
	private Button logoutButton;
	@FXML
	private AnchorPane scenePane;
	public void logout(ActionEvent event) {
		stage = (Stage) scenePane.getScene().getWindow();
		System.out.println("Vous avez quitté l'application avec succès !");
		stage.close();
	}
	
    @FXML
    private AnchorPane pane;

    @FXML
    private Circle circle;
    @FXML
    private Circle circle2;
    @FXML
    private Circle circle3;
    @FXML
    private Circle circle4;

    //1 Frame evey 10 millis, which means 100 FPS
    Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10), new EventHandler<ActionEvent>() {

        double deltaX = 2;
        double deltaY = 2;            
        double deltaX2 = 2;
        double deltaY2 = 2;
        double deltaX3 = 2;
        double deltaY3 = 2;            
        double deltaX4 = 2;
        double deltaY4 = 2;

        @Override
        public void handle(ActionEvent actionEvent) {
            circle.setLayoutX(circle.getLayoutX() + deltaX);
            circle.setLayoutY(circle.getLayoutY() + deltaY);

            Bounds bounds = pane.getBoundsInLocal();
            boolean rightBorder = circle.getLayoutX() >= (bounds.getMaxX() - circle.getRadius());
            boolean leftBorder = circle.getLayoutX() <= (bounds.getMinX() + circle.getRadius());
            boolean bottomBorder = circle.getLayoutY() >= (bounds.getMaxY() - circle.getRadius());
            boolean topBorder = circle.getLayoutY() <= (bounds.getMinY() + circle.getRadius());

            if (rightBorder || leftBorder) {
                deltaX *= -1;
            }
            if (bottomBorder || topBorder) {
                deltaY *= -1;
            }
        

        	circle2.setLayoutX(circle2.getLayoutX() - deltaX2);
        	circle2.setLayoutY(circle2.getLayoutY() + deltaY2);
        	
        	Bounds bounds2 = pane.getBoundsInLocal();
        	boolean rightBorder2 = circle2.getLayoutX() >= (bounds2.getMaxX() - circle2.getRadius());
        	boolean leftBorder2 = circle2.getLayoutX() <= (bounds2.getMinX() + circle2.getRadius());
        	boolean bottomBorder2 = circle2.getLayoutY() >= (bounds2.getMaxY() - circle2.getRadius());
        	boolean topBorder2 = circle2.getLayoutY() <= (bounds2.getMinY() + circle2.getRadius());
        	
        	if (rightBorder2 || leftBorder2) {
        		deltaX2 *= -1;
        	}
        	if (bottomBorder2 || topBorder2) {
        		deltaY2 *= -1;
        	}
        	circle3.setLayoutX(circle3.getLayoutX() + deltaX3);
        	circle3.setLayoutY(circle3.getLayoutY() - deltaY3);
        	
        	Bounds bounds3 = pane.getBoundsInLocal();
        	boolean rightBorder3 = circle3.getLayoutX() >= (bounds3.getMaxX() - circle3.getRadius());
        	boolean leftBorder3 = circle3.getLayoutX() <= (bounds3.getMinX() + circle3.getRadius());
        	boolean bottomBorder3 = circle3.getLayoutY() >= (bounds3.getMaxY() - circle3.getRadius());
        	boolean topBorder3 = circle3.getLayoutY() <= (bounds3.getMinY() + circle3.getRadius());
        	
        	if (rightBorder3 || leftBorder3) {
        		deltaX3 *= -1;
        	}
        	if (bottomBorder3 || topBorder3) {
        		deltaY3 *= -1;
        	}
        	circle4.setLayoutX(circle4.getLayoutX() - deltaX4);
        	circle4.setLayoutY(circle4.getLayoutY() - deltaY4);
        	
        	Bounds bounds4 = pane.getBoundsInLocal();
        	boolean rightBorder4 = circle4.getLayoutX() >= (bounds4.getMaxX() - circle4.getRadius());
        	boolean leftBorder4 = circle4.getLayoutX() <= (bounds4.getMinX() + circle4.getRadius());
        	boolean bottomBorder4 = circle4.getLayoutY() >= (bounds4.getMaxY() - circle4.getRadius());
        	boolean topBorder4 = circle4.getLayoutY() <= (bounds4.getMinY() + circle4.getRadius());
        	
        	if (rightBorder4 || leftBorder4) {
        		deltaX4 *= -1;
        	}
        	if (bottomBorder4 || topBorder4) {
        		deltaY4 *= -1;
        	}
        }
    
    }));


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }	
}
