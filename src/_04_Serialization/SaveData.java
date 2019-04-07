package _04_Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Complete this class so that it can be serialized.
 */
public class SaveData {
	public final String name;
	public final int age;

	public SaveData(String name, int age) {
		this.name = name;
		this.age = age;
	}
	private static void save(SaveData data) {
		try (FileOutputStream fos = new FileOutputStream(new File("dataFile")); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static SaveData load() {
		try (FileInputStream fis = new FileInputStream(new File("dataFile")); ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (SaveData) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			e.printStackTrace();
			return null;
		}
	}
}
