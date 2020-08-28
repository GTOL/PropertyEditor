module me.gtol.application.editor.propertyeditor {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;

	opens me.gtol.application.editor.propertyeditor.ui to javafx.fxml;

	exports me.gtol.application.editor.propertyeditor;
}