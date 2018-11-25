package demo.textField;

import java.util.Arrays;
import java.util.List;

import javax.swing.text.BadLocationException;

import org.apache.jena.rdf.model.Model;

import grammar.naturalLanguage.NaturalLanguage;
import main.Generator;

public class InputTextModel extends AbstractDocumentModel{

	private static final long serialVersionUID = 1L;
	
	private final Generator generator = new Generator();

	public InputTextModel() {
		super();
	}

	// Generator実行
	public Model runGenerator() {
		String allText;
		try {
			allText = getText(0, getLength());
		} catch (BadLocationException e) {
			allText = "InputTextModelはテキストの取得に失敗しました。";
			e.printStackTrace();
		}
		List<NaturalLanguage> naturalLanguageParagraphs = 
				Arrays.asList(NaturalLanguage.toNaturalLanguageArray(allText.split("\n")));
				
		return generator.generate(naturalLanguageParagraphs);
	}
}