package demo;

import java.awt.GridLayout;

import javax.swing.JPanel;

import demo.ontology.OntologyTableView;
import demo.textField.DocumentView;
import demo.textField.InputTextView;

public class WholePanel extends JPanel {
	private static final long serialVersionUID = -8108903772139391920L;

	
	public WholePanel(InputTextView iptView, OntologyTableView ontView, DocumentView docView) {	
		
		setLayout(new GridLayout(1, 3));				// 横に3つ並べる
		// 子ビュー(JPanel)を配置
		add(iptView);
		add(ontView);
		add(docView);
	}
}