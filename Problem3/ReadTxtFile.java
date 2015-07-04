public ReadTxtFile extends ReadFile{

	// The .txt files are all delimited by Tab
	public void parseHead(){
		String[] s;
		s =  br.readLine().split("\t");
		getIndex();
		return "\t";
	}
}