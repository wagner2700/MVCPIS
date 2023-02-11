package br.com.fiap.patterns.main;

import br.com.fiap.imposto.model.Pis;
import br.com.fiap.imposto.view.TelaPis;
import br.com.fiap.patterns.controller.ImpostoController;

public class TesteCalculo {
	
	public static void main(String[] args) {
		Pis model = new Pis();
		TelaPis tela = new TelaPis();
				
		model.addObserver(tela);
		
		ImpostoController controller = new ImpostoController(model, tela);
		
		tela.addController(controller);
				
				
	}

}
