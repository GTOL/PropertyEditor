package me.gtol.application.editor.propertyeditor.ui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import me.gtol.application.editor.propertyeditor.PropertyEditor;
import me.gtol.application.editor.propertyeditor.model.Model;
import me.gtol.application.editor.propertyeditor.model.SingleFileProject;
import me.gtol.application.editor.propertyeditor.util.FXUtils;

public class SingleFileFlatPane extends StackPane implements Initializable, Savable {
	private final SingleFileProject project;

	@FXML
	SplitPane			splitPane;
	@FXML
	ListView<String>	listView;
	@FXML
	TextArea			textArea;

	public SingleFileFlatPane(PropertyEditor mainApp, Model model, SingleFileProject project) throws IOException {
		if (project == null)
			throw new NullPointerException();
		this.project = project;

		FXUtils.loadFXML(this, "/assets/fxml/SingleFileFlatPane.fxml");
//		readFile();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@Override
	public void save() throws IOException {
		// TODO save flat
	}
}
