package de.illner.codejam;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlienLanguage extends AbstractCodejam {

	public static final String IN_SMALL = "A-small-practice.in";
	public static final String OUT_SMALL = "A-small-practice.out";
	public static final String IN_LARGE = "A-large-practice.in";
	public static final String OUT_LARGE = "A-large-practice.out";

	public static void main(String[] args) throws FileNotFoundException {
		AlienLanguage alienLanguage = new AlienLanguage();
		alienLanguage.solve(AlienLanguage.class, IN_LARGE, OUT_LARGE);
		System.out.println("Finished successfully!");
	}

	public void solve(Class<?> caller, String inFile, String outFile) throws FileNotFoundException {
		IoHelperForCodejam ioHelper = new IoHelperForCodejam(caller, inFile, outFile);

		ioHelper.getScanner().nextInt();
		int nWords = ioHelper.getScanner().nextInt();
		int nTestCases = ioHelper.getScanner().nextInt();

		ioHelper.getScanner().nextLine();
		ArrayList<String> wordsList = new ArrayList<>(nWords);

		for (int i = 0; i < nWords; i++) {
			wordsList.add(ioHelper.getScanner().nextLine());
		}

		for (int i = 0; i < nTestCases; i++) {
			Pattern pattern = Pattern.compile(ioHelper.getScanner().nextLine().replace('(', '[').replace(')', ']'));
			int count = 0;

			for (String word : wordsList) {
				Matcher m = pattern.matcher(word);
				if (m.matches()) {
					count++;
				}
			}
			ioHelper.printLineWithWriter("Case #" + (i + 1) + ": " + count);
		}
		ioHelper.closeScanner();
		ioHelper.closeWriter();
	}

}
