package me.gtol.application.editor.propertyeditor.ui;

import java.io.IOException;
import java.nio.file.Paths;

import javafx.collections.ListChangeListener;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import me.gtol.application.editor.propertyeditor.PropertyEditor;
import me.gtol.application.editor.propertyeditor.model.Model;
import me.gtol.application.editor.propertyeditor.model.Project;
import me.gtol.application.editor.propertyeditor.model.SingleFileProject;

public class ProjectTabPane extends TabPane {
	private final PropertyEditor	mainApp;
	private final Model				model;

	public ProjectTabPane(PropertyEditor mainApp, Model model) {
		this.mainApp = mainApp;
		this.model = model;

		model.getProjects().addListener((ListChangeListener<Project>) change -> {
			while (change.next()) {
				for (Project project : change.getAddedSubList()) {
					ProjectTab tab = new ProjectTab(project);
					getTabs().add(tab);
				}
			}
		});

		SingleFileProject project = new SingleFileProject(
				Paths.get("./src/main/resources/assets/lang/ApplicationResources.properties"));
		model.getProjects().add(project);
	}

	public void save() {
		Tab tab = getSelectionModel().getSelectedItem();
		if (tab != null && tab.getContent() instanceof Savable) {
			try {
				((Savable) tab.getContent()).save();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public class ProjectTab extends Tab {
		private final Project project;

		public ProjectTab(Project project) {
			if (project == null) {
				throw new NullPointerException();
			}
			this.project = project;

			this.setText(project.getName());

			if (project instanceof SingleFileProject) {
				// TODO use multi-thread file reading
				try {
					this.setContent(new SingleFileRawPane(mainApp, model, (SingleFileProject) project));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
