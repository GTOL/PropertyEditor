package me.gtol.application.editor.propertyeditor.model;

import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {
	private final SimpleListProperty<Project> projects;

	public Model() {
		projects = new SimpleListProperty<Project>(this, "projects", FXCollections.observableArrayList());
	}

	public final SimpleListProperty<Project> projectsProperty() {
		return projects;
	}

	public final ObservableList<Project> getProjects() {
		return projects.get();
	}
}
