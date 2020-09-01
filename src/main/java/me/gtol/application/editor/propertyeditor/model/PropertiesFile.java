package me.gtol.application.editor.propertyeditor.model;

import java.util.Iterator;

import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PropertiesFile {
	private final StringProperty				filePath	= new SimpleStringProperty(this, "filePath", null);
	private final ReadOnlyListWrapper<Property>	properties	= new ReadOnlyListWrapper<>(this, "properties",
			FXCollections.observableArrayList());

	public PropertiesFile() {
	}

	public PropertiesFile(String filePath) {
		setFilePath(filePath);
	}

	public final StringProperty filePathProperty() {
		return filePath;
	}

	public final String getFilePath() {
		return filePath.get();
	}

	public final void setFilePath(final String filePath) {
		this.filePath.set(filePath);
	}

	public final ReadOnlyListProperty<Property> propertiesProperty() {
		return properties.getReadOnlyProperty();
	}

	public final ObservableList<Property> getProperties() {
		return properties.get();
	}

	public boolean containsKey(String key) {
		if (key == null) {
			throw new NullPointerException();
		}
		Iterator<Property> it = properties.iterator();
		while (it.hasNext())
			if (key.equals(it.next().getKey()))
				return true;
		return false;
	}

	public static class Property {
		private String	key;
		private String	value;

		public Property(String key, String value) {
			setKey(key);
			setValue(value);
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			if (key == null) {
				throw new NullPointerException();
			}
			this.key = key;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			if (value == null) {
				throw new NullPointerException();
			}
			this.value = value;
		}
	}
}
