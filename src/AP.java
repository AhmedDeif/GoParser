
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import java_cup.runtime.Symbol;

public class AP {

	public static void main(String[] args) {

		String inFile = "MS3/ourGo1.in";
		String outFile = "Go1.out";

		
		if (args.length > 1) {
			inFile = args[0];	
		}

		try {
			FileReader fis = new FileReader(inFile);
			BufferedReader bis = new BufferedReader(fis);
			BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

			@SuppressWarnings("deprecation")
			parser parser = new parser(new Lexer(bis));

			try {
				Symbol x =parser.parse();
				
				writer.write(x.value.toString());
				
			} catch (Exception e) {
				writer.write("ParseError");
			}
			
			fis.close();
			bis.close();
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
