package cs220;

import java.util.*;
import cs220.csv.*;

public class Main {

    // A helper method to print out the usage and exit:
    private static void usage() {
	System.out.println("lec01 tool: filename");
	System.exit(1);
    }

    // This is a simple method for joining a list with a delimiter:
    private static String join(List<String> xs, String delim) {
	StringBuffer b = new StringBuffer();
	for (int i = 0; i < xs.size(); i++) {
	    b.append(xs.get(i));
	    if (i+1 != xs.size()) {
		b.append(delim);
	    }
	}
	return b.toString();
    }

    public static void main(String[] args) {
	// Check the arguments:
	if (args.length != 1) {
	    usage();
	}

	// If we have an argument, grab it:
	String filename = args[0];

	try {
	    // Create a new Csv object:
	    Csv csv = new Csv(filename);
	    System.out.println("file: " + csv.getFileName());
	    for (List<String> row : csv) {
		System.out.println(join(row, ","));
	    }

	    // Create a reverse of that:
	    Csv rcsv = csv.reverse();
	    for (List<String> row : rcsv) {
		System.out.println(join(row, ","));
	    }

	}
	catch (Exception e) {
	    System.out.println("Problem reading CSV file: " + e.getMessage());
	    e.printStackTrace();
	    System.exit(1);
	}	
    }
    
}
