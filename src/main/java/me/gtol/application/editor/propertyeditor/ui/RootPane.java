package me.gtol.application.editor.propertyeditor.ui;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import me.gtol.application.editor.propertyeditor.PropertyEditor;
import me.gtol.application.editor.propertyeditor.model.Model;
import me.gtol.application.editor.propertyeditor.model.Project;
import me.gtol.application.editor.propertyeditor.model.SingleFileProject;
import me.gtol.application.editor.propertyeditor.util.FXUtils;
import me.gtol.application.editor.propertyeditor.util.RBProvider;

public class RootPane extends BorderPane {
	private final PropertyEditor	mainApp;
	private final Model				model;

	@FXML
	private MenuBar		menuBar;
	@FXML
	private Menu		fileMenu;
	@FXML
	private MenuItem	newMenuItem;
	@FXML
	private MenuItem	openMenuItem;
	@FXML
	private MenuItem	saveMenuItem;
	@FXML
	private MenuItem	exitMenuItem;
	@FXML
	private Menu		editMenu;
	@FXML
	private Menu		helpMenu;
	@FXML
	private MenuItem	docMenuItem;
	@FXML
	private MenuItem	aboutMenuItem;

	private ProjectTabPane projectTabPane;

	@FXML
	private HBox statusBar;

	public RootPane(PropertyEditor mainApp, Model model) throws IOException {
		this.mainApp = mainApp;
		this.model = model;
		FXUtils.loadFXML(this, "/assets/fxml/RootPane.fxml");

		this.projectTabPane = new ProjectTabPane(mainApp, model);
		this.setCenter(projectTabPane);

		saveMenuItem.disableProperty().bind(projectTabPane.getSelectionModel().selectedItemProperty().isNull());
	}

	@FXML
	public void openClicked() {
		FileChooser chooser = new FileChooser();
		chooser.setTitle(RBProvider.getResourceBundle().getString("dialog.open.title"));
		chooser.getExtensionFilters().setAll(new ExtensionFilter("Java Properties", "*.properties"),
				new ExtensionFilter("All Files", "*.*"));
		File file = chooser.showOpenDialog(this.getScene().getWindow());
		if (file != null) {
			Project project = new SingleFileProject(file);
			model.getProjects().add(project);
		}
	}

	@FXML
	public void saveClicked() {
		projectTabPane.save();
	}
}
