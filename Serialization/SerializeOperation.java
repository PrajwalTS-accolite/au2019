package com.au.Serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializeOperation {

	public String filePath = "C:\\Users\\prajwal.ts\\Desktop\\serialzed.obj";

	void writeObjectToFile(ArrayList<Student> stuList) {

		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(stuList);

			oos.flush();
			oos.close();

			fos.flush();
			fos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	void readOnjectFromFile() {
		ArrayList<Student> stuList = null;

		try {
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);

			stuList = (ArrayList<Student>) ois.readObject();
			for(Student student: stuList)
				System.out.println(student);

			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		ArrayList<Student> stuList = new ArrayList<>();
		Address addr1 = new Address("Nagarbhavi Main Road", "Bangalore", "Karnataka", "560072");
		Student stu1 = new Student("fName A", "sName B", 1, "6 grade", "A section", 90, addr1);

		Address addr2 = new Address("Vijayanagar", "Bangalore", "Karnataka", "560040");
		Student stu2 = new Student("fName X", "sName Y", 2, "7 grade", "B section", 80, addr2);

		stuList.add(stu1);
		stuList.add(stu2);

		SerializeOperation ser = new SerializeOperation();
		ser.writeObjectToFile(stuList);

		ser.readOnjectFromFile();

	}
}
