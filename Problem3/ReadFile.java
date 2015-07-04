public class ReadFile{
	
	File file;

	// The database related attributes
	String supplier_id;
	String product_id;
	int quantity;
	
	// The numbers of the index which stands for the columns in the file
	int product_id_index;
	int quantity_index;

	// The first line of each file has the parsing information
	String header;
	String[] headerSplit;

	// Some information about the database, store the table and column names of our database
	String table_name = "SUPPLIER_PRODUCT";
	String supplier_id_name = "SUPPLIER_ID";
	String product_id_name = "PRODUCT_ID";
	String quantity_name = "QUANTITY";

	//constructor
	public ReadFile(File file){
		this.file = file;
		this.supplier_id = file.getName();
	}


	public void parse(){
		try{
			BufferedReader br = 
				new BufferedReader(
				new InputStreamReader(
				new FileInputStream(file), "UTF-8"));

			//read the first line of each file
			this.head = br.readLine();

			//get the dilimiter of the file and also get the numbers of column index within parseHead()
			String dilimiter = parseHead();

			DatabaseManager db = DatabaseManager.getDBManager();

			//start to continuing reading the file
			while((line = br.readLine()) != null){
				String[] record;
				content = line.split(dilimiter);

				//parse the PRODUCT_ID and QUANTITY
				this.product_id = content[product_id_index];
				this.quantity = Integer.parseInt(content[quantity_index]);

				writeToDB();
			}

		}
		catch(Exception e){

		}

	}

	//implemented in the sub classes
	protected String parseHead(){
		return "";
	}


	protected void getIndex(){
		for(int i = 0; i < headerSplit.length; i++){
			
			String s = headerSplit.toLowerCase();

			if(s.equals("product")) this.product_id_index = i;
			else if(s.equals("inventory") || s.equals("inventory")) this.quantity_index = i;
		}
	}

	protected void writeToDB(){
		String query = 
			"insert into " + table_name + 
			" (" + supplier_id_name + ", " + product_id_name + ", " + quantity_name + ") " + 
			"values(?, ?, ?)";
		/* Some methods set the connection to the DB */
		/*                                           */
		
		stmt = conn.createStatement();
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, supplier_id);
		ps.setString(2, product_id);
		ps.setInt(3, quantity);
		ps.executeUpdate();
	}

}