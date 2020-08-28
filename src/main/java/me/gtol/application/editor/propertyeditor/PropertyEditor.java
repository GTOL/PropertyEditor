package me.gtol.application.editor.propertyeditor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import me.gtol.application.editor.propertyeditor.model.Model;
import me.gtol.application.editor.propertyeditor.ui.RootPane;
import me.gtol.application.editor.propertyeditor.util.RBProvider;

public class PropertyEditor extends Application {
	private final Model model = new Model();

	@Override
	public void init() throws Exception {
		RBProvider.loadResourceBundle();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		RootPane root = new RootPane(this, model);
		Scene scene = new Scene(root, 800, 600);
		scene.getStylesheets().add(this.getClass().getResource("/assets/css/style.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
