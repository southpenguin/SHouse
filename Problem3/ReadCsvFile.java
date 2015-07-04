public ReadCsvFile extends ReadFile{

	//since csv stands for "comma-separated values", the delimiter is ","
	public void parseHead(){
		String[] s;
		s =  br.readLine().split(",");
		getIndex();
		return ",";
	}
}