package application;
	
import demo.WholePanel;
import demo.controller.BuildOntologyController;
import demo.controller.UseOntologyController;
import demo.ontology.OntologyModel;
import demo.ontology.OntologyTableView;
import demo.textField.DocumentModel;
import demo.textField.DocumentView;
import demo.textField.InputTextModel;
import demo.textField.InputTextView;
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
	        swingNode.setContent(createWholePanel());

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
	
	/*
	private void createSwingContent(SwingNode swingNode) {
	     SwingUtilities.invokeLater(() -> {
	    	   swingNode.setContent(createWholePanel());
	        });
	}
	*/

	private WholePanel createWholePanel() {
		/** Model生成 **/
		InputTextModel iptModel = new InputTextModel();
		OntologyModel ontModel = new OntologyModel();
		DocumentModel docModel = new DocumentModel();
		OntologyModel subOntModel = new OntologyModel();

		/** Controller生成 **/
		BuildOntologyController buildCtrl = new BuildOntologyController(iptModel, ontModel);
		UseOntologyController useCtrl = new UseOntologyController(docModel, ontModel, subOntModel);

		/** View生成 **/
		InputTextView iptView = new InputTextView(buildCtrl);
		OntologyTableView ontView = new OntologyTableView(useCtrl, buildCtrl);
		DocumentView docView = new DocumentView(useCtrl);
		
		return new WholePanel(iptView, ontView, docView);
	}
}