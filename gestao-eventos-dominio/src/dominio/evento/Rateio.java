package dominio.evento;

import java.util.Date;

public class Rateio extends EntidadeDominio {
	
	private Date inicioRateio;
	private Date fimRateio;
	private double valorPagar = 0;
	
	public void pagarRateio(double valor) {
		this.valorPagar -= valor;
	}

	public void setValorPagar(double valor) {
		this.valorPagar = valor;
	}
	
	public double getValorPagar() {
		return this.valorPagar;
	}


	public Date getInicioRateio() {
		return inicioRateio;
	}


	public void setInicioRateio(Date inicioRateio) {
		this.inicioRateio = inicioRateio;
	}


	public Date getFimRateio() {
		return fimRateio;
	}


	public void setFimRateio(Date fimRateio) {
		this.fimRateio = fimRateio;
	}
	
	

}
