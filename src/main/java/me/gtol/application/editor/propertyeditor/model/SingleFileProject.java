package me.gtol.application.editor.propertyeditor.model;

import java.io.File;
import java.nio.file.Path;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class SingleFileProject extends Project {
	private static final long serialVersionUID = 1L;

	private final ObjectProperty<ProjectViewMode>	projectViewMode	= new SimpleObjectProperty<ProjectViewMode>(this,
			"ProjectViewMode", ProjectViewMode.FLAT);
	private final ObjectProperty<Path>				filePath		= new SimpleObjectProperty<Path>(this, "filePath",
			null);

	public SingleFileProject(Path path) {
		super(path.getFileName().toString());
		setFilePath(path);
	}

	public SingleFileProject(File file) {
		this(file.toPath());
	}

	public final ObjectProperty<ProjectViewMode> projectViewModeProperty() {
		return projectViewMode;
	}

	public final ProjectViewMode getProjectViewMode() {
		return projectViewMode.get();
	}

	public final void setProjectViewMode(ProjectViewMode value) {
		this.projectViewMode.set(value);
	}

	public final ObjectProperty<Path> filePathProperty() {
		return filePath;
	}

	public final Path getFilePath() {
		return filePath.get();
	}

	public final void setFilePath(Path value) {
		this.filePath.set(value);
	}

	public enum ProjectViewMode {
		RAW, FLAT, HIERARCHICAL
	}
}
