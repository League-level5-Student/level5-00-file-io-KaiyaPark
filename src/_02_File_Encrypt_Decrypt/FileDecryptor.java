package _02_File_Encrypt_Decrypt;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDecryptor {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("encrpyt");
			int c = fr.read();
			while (c != -1) {
				System.out.print((char) (c / 2));
				c = fr.read();

			}
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}