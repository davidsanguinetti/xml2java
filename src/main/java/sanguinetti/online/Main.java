package sanguinetti.online;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.io.FileUtils;
import org.apache.commons.text.WordUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import sanguinetti.online.model.Variable;

public class Main {
	String filePath;
	HashMap<String, String> hmValues;
	ArrayList<Variable> vals;
	String mode;
	int type = 0;

	private static int ACTIVITY_TYPE = 0;
	private static int FRAGMENT_TYPE = 1; 

	int totalnodes = 0;
	boolean printed = false;
	
	/**
	 * @param filePath
	 */
	public Main(String filePath) {
		this.filePath = filePath;
		hmValues = new HashMap<String, String>();
		vals = new ArrayList<Variable>();

		File f = new File(filePath);
		if (f.getName().contains("activity"))
			type = ACTIVITY_TYPE;
		else if (f.getName().contains("fragment"))
			type = FRAGMENT_TYPE;


		try {
			contructDocument();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private void contructDocument()  throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.parse(filePath);
//		doc.getDocumentElement().normalize();

//		System.out.println(doc.getDocumentElement().getNodeName());
			

		printNodes(doc.getChildNodes());
	}

	private void printNodes(NodeList n) {
		totalnodes += n.getLength();
//		System.out.println("length: " + totalnodes);

		for (int i=0; i < n.getLength(); i++) {
			Node nd = n.item(i);
			
			if (nd.getAttributes() == null) {
				totalnodes--;
				continue;
			}

//			System.out.println("tag: "+ nd.getNodeName());
				
			if (nd.getNodeType() == Node.ELEMENT_NODE) {
				Element e = (Element) nd;

				if (e.getAttribute("android:id") != null &&
						!e.getAttribute("android:id").isEmpty())
					vals.add(new Variable(new String(nd.getNodeName()),
								e.getAttribute("android:id").replace("@+id/", "")));

//				hmValues.put(new String(nd.getNodeName()), e.getAttribute("android:id").replace("@+id/", ""));
				totalnodes--;
//				System.out.println("id: " + e.getAttribute("android:id").replace("@+id/", ""));;
			}
//			if (nd.getAttributes()..getNamedItem("id") != null)
//				System.out.println("id: " + nd.getAttributes().getNamedItem("id").getNodeValue());

			printNodes(nd.getChildNodes());
		}

		if (totalnodes == 0 && !printed) {
			printJava();
		}
	}


	private void printJava() {
		StringBuilder sb = new StringBuilder();

		String className = getClassName();

		sb.append("package\n");

		if (type == ACTIVITY_TYPE) {
			sb.append("public class " + className + " extends AppCompatActivity");
		} else if (type == FRAGMENT_TYPE) {
			sb.append("import android.os.Bundle;\nimport android.view.LayoutInflater;\nimport android.view.View;\nimport android.view.ViewGroup;\nimport androidx.annotation.NonNull;\nimport androidx.annotation.Nullable;")
			sb.append("public class " + className + " extends Fragment");
		}

		sb.append( " {" + System.getProperty("line.separator"));

		vals.forEach(v -> {
			sb.append("\t"+v.getTagName() + " " + Util.getVariableName(v.getIdValue(), v.getTagName()) +";"+ System.getProperty("line.separator"));
		});

		/*
		 * @Override
		 public void onCreate(@Nullable Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);

		 mSky = new Skyrunner(this);
		 gson = new Gson();
		 mApp = (AppCarePet) getApplication();

		 mCatview = new CatLoadingView();
		 }
		 */
		if (type == ACTIVITY_TYPE) {
			sb.append("\n\t@Override" + System.getProperty("line.separator") +
					"\tpublic void onCreate(@Nullable Bundle savedInstanceState) {"+System.getProperty("line.separator") +
					"\t\tsuper.onCreate(savedInstanceState);"+System.getProperty("line.separator") +
					"\t\tsetContentView(R.layout."+ getFileName() +");"+System.getProperty("line.separator"));

			vals.forEach(v -> {
				sb.append("\t\t"+Util.getVariableName(v.getIdValue(), v.getTagName()) +"\t= findViewById(R.id." + v.getIdValue() +");" + System.getProperty("line.separator"));
			});


			sb.append("}" + System.getProperty("line.separator"));
		} else if (type == FRAGMENT_TYPE) {

			sb.append(
					"\n\t@Nullable" + System.getProperty("line.separator") +
					"\t@Override" + System.getProperty("line.separator") +
					"\tpublic View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {"+System.getProperty("line.separator") +
					"\t\tsuper.onCreateView(inflater, container, savedInstanceState);" + System.getProperty("line.separator") +
					"\t\tView v = inflater.inflate(R.layout."+getFileName()+", container, false);" + System.getProperty("line.separator") 
					);

			vals.forEach(v -> {
				sb.append("\t\t"+Util.getVariableName(v.getIdValue(), v.getTagName()) +"\t= v.findViewById(R.id." + v.getIdValue() +");" + System.getProperty("line.separator"));
			});
			sb.append("\t\treturn v;")

			sb.append("\t}" + System.getProperty("line.separator"));

		}
		sb.append("}" + System.getProperty("line.separator"));
		System.out.println(sb.toString());
		
		File f = new File(filePath);
		System.out.println("path: " + f.getAbsolutePath());
		String path = f.getAbsolutePath().substring(0, f.getAbsolutePath().lastIndexOf("/")) + "/"+ getClassName() + ".java";
		System.out.println("path: " + path);

		try {
			FileUtils.write(new File(path), sb.toString(), "utf-8");
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		printed = true;
	}

	private String getFileName() {
		File f = new File(filePath);
		return f.getName().substring(0, f.getName().indexOf("."));
	}

	private String getClassName() {
		String fname = getFileName();
		fname = fname.replace("activity", "").replace("fragment", "").replace("_", " ");
		String className = WordUtils.capitalize(fname);
		if (getFileName().toLowerCase().contains("activity"))
			className += "Activity";
		else if (getFileName().toLowerCase().contains("fragment"))
			className += "Fragment";
		className = className.replaceAll(" ", "");
		
		return className;
	}
}

