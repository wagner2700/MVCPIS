package br.com.fiap.imposto.model;


import java.util.Observable;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import br.com.fiap.patterns.config.ConfigSingleton;

// O Model é um Observable
// A Classe Pis da camada Model não possui referência a View ou ao // Controller
// Ao implementar Imposto, teremos maior flexibilidade no Controller
@SuppressWarnings("deprecation")
public class Pis extends Observable implements Imposto{
	
	private static final Logger logger = LogManager.getLogger(Pis.class);
	
	private final float aliquota;
	private float valorDoPis ;
		


	public float getAliquota() {
		return aliquota;
	}
	
	public float getValorDoPis() {
		return valorDoPis;
	}
	
	public Pis() {
	 aliquota = Float.parseFloat(ConfigSingleton.getInstance().getProperty("aliquota"));
	}
	
	@SuppressWarnings("deprecation")
	public void calcularImposto(float valor) {
		valorDoPis = valor * aliquota;
		
		// setChanged Altera o estado interno do objeto 
           // para true, pois houve alteração no estado valorDoPis 
		setChanged();
		logger.info("Calculando imposto");
		// Os observadores devem ser notificados
		// Envia o valor do PIS como parte da mensagem de 
           // notificação para a View que é um Observer
		notifyObservers(valorDoPis);
	}

	@Override
	public String toString() {
		return "Pis [ALIQUOTA=" + aliquota 
                                    + ", valorDoPis=" + valorDoPis + "]";
      }
}