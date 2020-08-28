package me.gtol.application.editor.propertyeditor.util;

import java.io.IOException;
import java.io.UncheckedIOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class FXUtils {
	private FXUtils() {}
	
	public static void loadFXML(Node node, String absolutePath) {
		FXMLLoader loader = new FXMLLoader(node.getClass().getResource(absolutePath), RBProvider.getResourceBundle());
        loader.setRoot(node);
        loader.setController(node);
        try {
            loader.load();
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
	}
}
