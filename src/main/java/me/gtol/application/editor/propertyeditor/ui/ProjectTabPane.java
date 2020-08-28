package me.gtol.application.editor.propertyeditor.ui;

import java.nio.file.Paths;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import me.gtol.application.editor.propertyeditor.PropertyEditor;
import me.gtol.application.editor.propertyeditor.model.Model;
import me.gtol.application.editor.propertyeditor.model.SingleFileProject;

public class ProjectTabPane extends TabPane {

	public ProjectTabPane(PropertyEditor mainApp, Model model) {
		SingleFileProject project = new SingleFileProject("test");
		project.setFilePath(Paths.get("./src/main/resources/assets/lang/ApplicationResources.properties"));

		Tab tab = new Tab("test");
		tab.setContent(new SingleFileRawPane(mainApp, model, project));

		this.getTabs().add(tab);
	}
}
