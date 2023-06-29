package utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileProcessor {
	public static void writeValueToFile(String content, String path) {
		File file = new File(path + CurrentDataTime.getCurrentDateTime());
		try (FileOutputStream fileOutputStream = new FileOutputStream(file);
			 BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream)) {
			if (!file.exists()) {
				file.createNewFile();
			}
			bufferedOutputStream.write(content.getBytes());
			bufferedOutputStream.flush();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
