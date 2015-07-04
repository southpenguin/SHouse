Problem3: Automation Design
========

The difficulty here is how to handle the different types of files and inside the file, how to acqure the useful information.

There are 6 files here:

1. [```Automation.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/Automation.java): This is the main class, the main function is here

2. [```ReadFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadFile.java): This is the parent class of the [```ReadCsvFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadCsvFile.java), [```ReadTxtFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadTxtFile.java), [```ReadExcelFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadExcelFile.java)

3. [```ReadCsvFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadCsvFile.java): This is the inheritance class of [```ReadFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadFile.java), which deals with .csv files and using "," to parse the file.

4. [```ReadTxtFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadTxtFile.java): This is the inheritance class of [```ReadFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadFile.java), which deals with .txt files and using "\b" (Tab) to parse the file.

5. [```ReadExcelFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadExcelFile.java): This is the inheritance class of [```ReadFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadFile.java), which deals with .xls and .xlsx files and use its own way to parse file.

6. [```DatabaseManager.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/DatabaseManager.java): This is the class set up the database.

So what I did is very straight forward, having [```Automation.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/Automation.java) starting the program, and when reading the files, by identifying its extension name as ```.csv```, ```.txt``` or ```.xls``` (or ```.xlsx```) to use different subclass of [```ReadFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadFile.java):
```
  if(getFileExtension(fileEntry).equals("csv")){
		ReadCsvFile readFile = new ReadCsvFile(fileEntry);
	}
	if(getFileExtension(fileEntry).equals("txt")){
		ReadTxtFile readFile = new ReadTxtFile(fileEntry);
	}
	if(getFileExtension(fileEntry).equals("xls") || getFileExtension(fileEntry).equals("xlsx")){
		ReadExcelFile readFile = new ReadExcelFile(fileEntry);
	}
```
This can easily sovle the problem of different types of the files.

Now within the [```ReadFile.java```](https://github.com/southpenguin/SHouse/blob/master/Problem3/ReadFile.java), there is a function called ```getIndex()``` which is used to get the index numbers of the columns which contains the ```PRODUCT_ID``` and ```QUANTITY``` by scanning the first line of the file and find in which item has the keywords "product" or "quantity", etc.

So after getting the index numbers, we know which columns are actually storing the ```PRODUCT_ID``` and ```QUANTITY``` and next is just read the files line by line, and find the right columns to parse and insert into the database.
