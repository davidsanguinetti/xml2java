package sanguinetti.online;

import java.io.File;

import org.apache.commons.text.WordUtils;


public class Util {

	public static String getFileName(String lname) {
		File f = new File(lname);
		String type = f.getName().substring(0, lname.indexOf("_"));
		String name = lname.substring(lname.indexOf("_")).replaceAll("_","");
		return name+type;
	}
	public static String getVariableName(String name, String type) {
		String n = name.replaceAll("_"," ");
		String var = WordUtils.capitalize(n).replaceAll(" ", "");
		var = getvartype(type) + var;
//		char[] c = var.toCharArray();
//		c[0] = Character.toLowerCase(c[0]);
//		var = new String(c);

		return var;
	}

	public static String getvartype(String datatype) {
		char[] c = datatype.toCharArray();

		String f = "";

		for (int i=0; i < c.length; i++) {
			if (Character.isUpperCase(c[i]))
				f += Character.toLowerCase(c[i]);
		}
		if (f.length() < 2)
			f = datatype.toLowerCase().substring(0, 3);
	
		return f;
	}
}
