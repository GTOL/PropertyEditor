package me.gtol.application.editor.propertyeditor.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import me.gtol.application.editor.propertyeditor.PropertyEditor;
import me.gtol.application.editor.propertyeditor.model.Model;
import me.gtol.application.editor.propertyeditor.util.FXUtils;

public class RootPane extends BorderPane {

	@FXML
	private MenuBar		menuBar;
	@FXML
	private Menu		fileMenu;
	@FXML
	private MenuItem	newMenuItem;
	@FXML
	private MenuItem	openMenuItem;
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
		FXUtils.loadFXML(this, "/assets/fxml/RootPane.fxml");
		
		this.projectTabPane = new ProjectTabPane(mainApp, model);
		this.setCenter(projectTabPane);
	}
}
