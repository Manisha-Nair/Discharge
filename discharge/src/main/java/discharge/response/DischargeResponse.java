package discharge.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DischargeResponse {
	
	private long id;
	private String patient_name;
	private String treatment;
	private String transportation;
	private String homecare;
	private String clinicalequipment;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public String getHomecare() {
		return homecare;
	}
	public void setHomecare(String homecare) {
		this.homecare = homecare;
	}
	public String getClinicalequipment() {
		return clinicalequipment;
	}
	public void setClinicalequipment(String clinicalequipment) {
		this.clinicalequipment = clinicalequipment;
	}
	
}