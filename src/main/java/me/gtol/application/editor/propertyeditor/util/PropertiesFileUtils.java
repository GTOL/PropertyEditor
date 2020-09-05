package me.gtol.application.editor.propertyeditor.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;

import org.apache.commons.text.StringEscapeUtils;

public class PropertiesFileUtils {
	private PropertiesFileUtils() {
	}

//	public static String readString(Path path) throws IOException {
//		String escStr = Files.readString(path, StandardCharsets.ISO_8859_1);
//		escStr = escStr.replaceAll("\\\\n", "\\\\\\\\n");
//		escStr = escStr.replaceAll("\\\\r", "\\\\\\\\r");
//		escStr = escStr.replaceAll("\\\\t", "\\\\\\\\t");
//		return StringEscapeUtils.unescapeJava(escStr);
//	}
//
//	public static void writeString(Path path, String text, OpenOption... options) throws IOException {
//		String escStr = StringEscapeUtils.escapeJava(text);
//		escStr = escStr.replaceAll("(?<=^|[^\\\\])(\\\\\\\\)*\\\\n", "$1\n");
//		escStr = escStr.replaceAll("(?<=^|[^\\\\])(\\\\\\\\)*\\\\r", "$1\r");
//		escStr = escStr.replaceAll("(?<=^|[^\\\\])(\\\\\\\\)*\\\\t", "$1\t");
//		escStr = escStr.replaceAll("\\\\\\\\n", "\\\\n");
//		escStr = escStr.replaceAll("\\\\\\\\r", "\\\\r");
//		escStr = escStr.replaceAll("\\\\\\\\t", "\\\\t");
//		Files.writeString(path, StringEscapeUtils.escapeJava(escStr), options);
//	}

	public static String readRaw(Path path) throws IOException {
		return Files.readString(path, StandardCharsets.ISO_8859_1);
	}

	public static void writeRaw(Path path, String text, OpenOption... options) throws IOException {
		Files.writeString(path, text, options);
	}
}
