import java.io.File

public class Automation{
	
	// the directory of the files
	String directory = "/some/directory";

	public static void main(String[] args){

		Class.forName(driver).newInstance();
		conn = DriverManager.getConnection(url,user,pw);

		readFiles(new File(directory));

	}

	// recursively get the directory, until it's no longer directory but files
	public void getFile(File folder){
		for(File fileEntry: folder.listFiles()){
			if(.isDerectory()){
				getFile(fileEntry);
			}
			else{
				//by identifying the extension to get to the file types.
				if(getFileExtension(fileEntry).equals("csv")){
					ReadCsvFile readFile = new ReadCsvFile(fileEntry);
				}
				if(getFileExtension(fileEntry).equals("txt")){
					ReadTxtFile readFile = new ReadTxtFile(fileEntry);
				}
				if(getFileExtension(fileEntry).equals("xls") || getFileExtension(fileEntry).equals("xlsx")){
					ReadExcelFile readFile = new ReadExcelFile(fileEntry);
				}
				readFile.parse();
			}
		}
	}

	// get the extension by splitting the part after the last "." of the file name
	private String getFileExtension(File file) {
	    String name = file.getName();
	    try {
	        return name.substring(name.lastIndexOf("."));
	    } catch (Exception e) {
	        return "";
	    }

	}
}