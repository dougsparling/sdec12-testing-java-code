package com.protegra.sdec12.coverage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class FileUtil {
	public static boolean writeLines(String path, Collection<String> lines) {
		
		File output = new File(path);
		if (!output.exists() && !lines.isEmpty()) {
			FileWriter writer = null;
			try {
				writer = new FileWriter(output);
				for (String line : lines) {
					writer.write(line);
					writer.write(System.getProperty("line.separator"));
				}
				return true;
			} catch (IOException e) {
				output.delete();
			} finally {
				try {
					if (writer != null) {
						writer.close();
					}
				} catch (IOException e) {
				}
			}
		}
		
		return false;
	}
}
