public class MedicalRecord {
    private int patientId;
    private String diagnosis;
    private String medications;
    private String allergies;

    public MedicalRecord(int patientId, String diagnosis, String medications, String allergies) {
		super();
		this.patientId = patientId;
		this.diagnosis = diagnosis;
		this.medications = medications;
		this.allergies = allergies;
	}

	// Getters and setters for MedicalRecord attributes
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedications() {
        return medications;
    }

    public void setMedications(String medications) {
        this.medications = medications;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }
}
