package gal.caronte.sw.custom;

import java.util.List;

public class GardarPercorridoParam {

	private PercorridoCustom percorrido;
	private List<PuntoIntereseCustom> listaPoi;
	
	public GardarPercorridoParam() {
		super();
	}

	public GardarPercorridoParam(PercorridoCustom percorrido, List<PuntoIntereseCustom> poi) {
		super();
		this.percorrido = percorrido;
		this.listaPoi = poi;
	}

	/**
	 * @return the percorrido
	 */
	public PercorridoCustom getPercorrido() {
		return this.percorrido;
	}

	/**
	 * @param percorrido the percorrido to set
	 */
	public void setPercorrido(PercorridoCustom percorrido) {
		this.percorrido = percorrido;
	}

	/**
	 * @return the lista poi
	 */
	public List<PuntoIntereseCustom> getListaPoi() {
		return this.listaPoi;
	}

	/**
	 * @param listaPoi the lista poi to set
	 */
	public void setListaPoi(List<PuntoIntereseCustom> listaPoi) {
		this.listaPoi = listaPoi;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GardarPercorridoParam [percorrido=");
		builder.append(this.percorrido);
		builder.append(", listaPoi=");
		builder.append(this.listaPoi);
		builder.append("]");
		return builder.toString();
	}
	
}
