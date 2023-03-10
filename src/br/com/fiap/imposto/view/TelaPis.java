package br.com.fiap.imposto.view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TelaPis implements TelaImposto , Observer{
	
	private static final Logger log = LogManager.getLogger(TelaPis.class);
	
	private TextField txtValor;
	private Button btnCalcular;

	
	 public TelaPis() {
		Frame frame = new Frame("Calcular Imposto ");
		
		frame.add("North" , new Label("Valor para calcular"));
		txtValor = new TextField();
		frame.add("Center" , txtValor);
		
		Panel panel = new Panel();
		btnCalcular = new Button("Calcular");
		panel.add(btnCalcular);
		frame.add("South" , panel);
		
		frame.addWindowListener(new CloseListener());
		frame.setSize(200 , 150);
		frame.setLocation(100 , 100);
		frame.setVisible(true);

	}
		public void addController(ActionListener controller) {
			btnCalcular.addActionListener(controller);
		}
	@Override
	public float getValor() {
		// TODO Auto-generated method stub
		return Float.parseFloat(txtValor.getText());
	}
	
	public static class CloseListener extends WindowAdapter{
		public void windowClosing(WindowEvent event) {
			event.getWindow().setVisible(false);
			System.exit(0);
		}
	}

	@Override
	public void update(Observable model, Object estadoModel) {
		log.debug("Exibindo o valor modificado");
		String msg = model.getClass() + "" + estadoModel;
		JOptionPane.showMessageDialog(null, msg);
		
	}

}
