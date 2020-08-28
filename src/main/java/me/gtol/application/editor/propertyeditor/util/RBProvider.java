package me.gtol.application.editor.propertyeditor.util;

import java.util.ResourceBundle;

public class RBProvider {
	private static ResourceBundle BUNDLE;
	
	private RBProvider() {}
	
	public static void loadResourceBundle() {
		BUNDLE = ResourceBundle.getBundle("assets.lang.ApplicationResources");
	}
	
	public static ResourceBundle getResourceBundle() {
		return BUNDLE;
	}
}
