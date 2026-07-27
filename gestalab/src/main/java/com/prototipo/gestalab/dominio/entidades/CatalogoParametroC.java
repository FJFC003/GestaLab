package com.prototipo.gestalab.dominio.entidades;


public class CatalogoParametroC {
	
	private int idParametroC;
	private String ensayoParametroC;
	private String tecnicaParametroC;
	private String procedimientoInternoParametroC;
	private String normaReferencialParametroC;
	private String unidadParametroC;
	private String rangoTrabajoParametroC;
	private String componenteParametroC;
	private CondicionParametroC fkCondicionParametro;
	
	public CondicionParametroC getFkCondicionParametro() {
		return fkCondicionParametro;
	}
	public void setFkCondicionParametro(CondicionParametroC fkCondicionParametro) {
		this.fkCondicionParametro = fkCondicionParametro;
	}
	public int getIdParametroC() {
		return idParametroC;
	}
	public void setIdParametroC(int idParametroC) {
		this.idParametroC = idParametroC;
	}
	public String getEnsayoParametroC() {
		return ensayoParametroC;
	}
	public void setEnsayoParametroC(String ensayoParametroC) {
		this.ensayoParametroC = ensayoParametroC;
	}
	public String getTecnicaParametroC() {
		return tecnicaParametroC;
	}
	public void setTecnicaParametroC(String tecnicaParametroC) {
		this.tecnicaParametroC = tecnicaParametroC;
	}
	public String getProcedimientoInternoParametroC() {
		return procedimientoInternoParametroC;
	}
	public void setProcedimientoInternoParametroC(String procedimientoInternoParametroC) {
		this.procedimientoInternoParametroC = procedimientoInternoParametroC;
	}
	public String getNormaReferencialParametroC() {
		return normaReferencialParametroC;
	}
	public void setNormaReferencialParametroC(String normaReferencialParametroC) {
		this.normaReferencialParametroC = normaReferencialParametroC;
	}
	public String getUnidadParametroC() {
		return unidadParametroC;
	}
	public void setUnidadParametroC(String unidadParametroC) {
		this.unidadParametroC = unidadParametroC;
	}
	public String getRangoTrabajoParametroC() {
		return rangoTrabajoParametroC;
	}
	public void setRangoTrabajoParametroC(String rangoTrabajoParametroC) {
		this.rangoTrabajoParametroC = rangoTrabajoParametroC;
	}
	public String getComponenteParametroC() {
		return componenteParametroC;
	}
	public void setComponenteParametroC(String componenteParametroC) {
		this.componenteParametroC = componenteParametroC;
	}

}
