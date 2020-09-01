package me.gtol.application.editor.propertyeditor.ui;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import me.gtol.application.editor.propertyeditor.PropertyEditor;
import me.gtol.application.editor.propertyeditor.model.Model;
import me.gtol.application.editor.propertyeditor.model.SingleFileProject;
import me.gtol.application.editor.propertyeditor.util.FXUtils;

public class SingleFileRawPane extends StackPane implements Initializable, Savable {
	private final SingleFileProject project;

	@FXML
	TextArea textArea;

	public SingleFileRawPane(PropertyEditor mainApp, Model model, SingleFileProject project) throws IOException {
		if (project == null)
			throw new NullPointerException();
		this.project = project;

		FXUtils.loadFXML(this, "/assets/fxml/SingleFileRawPane.fxml");
		readFile();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	private void readFile() throws IOException {
		// TODO handle deleted file
		// TODO handle new file
		// TODO handle file edit
		try {
			String fileContent = Files.readString(project.getFilePath(), StandardCharsets.ISO_8859_1);
			textArea.setText(fileContent);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void save() throws IOException {
		String text = textArea.getText();
		Files.writeString(project.getFilePath(), text, StandardCharsets.ISO_8859_1);
	}
}
