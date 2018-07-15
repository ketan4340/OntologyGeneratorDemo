package demo;

import java.awt.GridLayout;

import javax.swing.JPanel;

import demo.controller.BuildOntologyController;
import demo.controller.UseOntologyController;
import demo.ontology.OntologyModel;
import demo.ontology.OntologyTableView;
import demo.textField.DocumentModel;
import demo.textField.DocumentView;
import demo.textField.InputTextModel;
import demo.textField.InputTextView;

public class WholePanel extends JPanel {
	private static final long serialVersionUID = -8108903772139391920L;

	
	public WholePanel() {
		/** Model生成 **/
		InputTextModel iptModel = new InputTextModel();
		OntologyModel ontModel = new OntologyModel();
		DocumentModel docModel = new DocumentModel();
		OntologyModel subOntModel = new OntologyModel();

		/** Controller生成 **/
		BuildOntologyController buildCtrl = new BuildOntologyController(iptModel, ontModel);
		UseOntologyController useCtrl = new UseOntologyController(docModel, ontModel, subOntModel);

		/** View生成 **/
		InputTextView iptView = new InputTextView(buildCtrl);
		OntologyTableView ontView = new OntologyTableView(useCtrl, buildCtrl);
		DocumentView docView = new DocumentView(useCtrl);
		
		
		setLayout(new GridLayout(1, 3));				// 横に3つ並べる
		// 子ビュー(JPanel)を配置
		add(iptView);
		add(ontView);
		add(docView);
	}
	
}