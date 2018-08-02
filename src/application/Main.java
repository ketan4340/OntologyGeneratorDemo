package application;
	
import demo.WholePanel;
import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

    
	
	@Override
	public void start(Stage primaryStage) {
		try {
			final SwingNode swingNode = new SwingNode();
	        swingNode.setContent(new WholePanel());

	        StackPane pane = new StackPane();
	        pane.getChildren().add(swingNode);
	        
			Scene scene = new Scene(pane,400,400);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("OntologyGenerator");
			primaryStage.setMaximized(true);	// ウィンドウ最大化
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
