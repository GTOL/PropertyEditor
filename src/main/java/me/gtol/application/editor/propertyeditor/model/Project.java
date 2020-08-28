package me.gtol.application.editor.propertyeditor.model;

import java.io.Serializable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	protected final StringProperty name;

	public Project(String name) {
		this.name = new SimpleStringProperty(this, "name", name);
	}

	public final StringProperty nameProperty() {
		return name;
	}

	public final String getName() {
		return name.get();
	}

	public final void setName(String name) {
		this.name.set(name);
	}
}
