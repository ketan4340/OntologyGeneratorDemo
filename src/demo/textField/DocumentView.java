package demo.textField;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

import demo.controller.UseOntologyController;
import demo.ontology.SubOntologyView;

public class DocumentView extends AbstractEditorView{
	private static final long serialVersionUID = -7215454239121272210L;

	/**** Model ****/
	private final DocumentModel docModel;

	/**** Controller ****/
	private final UseOntologyController useController;

	/**** View ****/
	private JToggleButton html_PlainTgBt;
	SubOntologyView subOntView;


	/****************************************/
	/**********     Constructor    **********/
	/****************************************/
	public DocumentView(UseOntologyController uCtrl) {
		super();
		this.useController = uCtrl;
		this.docModel = uCtrl.getDocumentModel();
		useController.setDocumentView(this);

		// 抜き出したオントロジーを表とグラフで表示するビュー
		subOntView = new SubOntologyView(uCtrl);
		this.add(subOntView, BorderLayout.SOUTH);

		setMenu();
		setDocument();
	}

	@Override
	protected void setMenu() {
	    importBt = new JButton("インポート");
	    importBt.addActionListener(useController.getImportTextAction());
	    clearBt = new JButton("クリア");
		clearBt.addActionListener(useController.getClearTextAction());
		html_PlainTgBt = new JToggleButton("plain", false);
		html_PlainTgBt.addItemListener(useController.getSwitchHTMLPlainAction());
		clearBt = new JButton("クリア");
		clearBt.addActionListener(useController.getClearTextAction());

		menuPanel.add(importBt);
		menuPanel.add(new JLabel("設定"));
		menuPanel.add(Box.createGlue());	// 可変長の隙間を挿入
		menuPanel.add(html_PlainTgBt);
		menuPanel.add(Box.createGlue());	// 可変長の隙間を挿入
		menuPanel.add(clearBt);
	}

	@Override
	protected void setDocument() {
		editorpane.setDocument(docModel);	// DocumentModelのメンバPlainDocをセット
	    editorpane.addHyperlinkListener(useController.getHyperlinkAction());
	}
}
