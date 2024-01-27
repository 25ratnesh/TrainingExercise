public class Patient {
    private String patientName;
    private int age;
    private String city;
    private MedicalRecord medicalRecord;

    public Patient(String patientName, int age, String city, MedicalRecord medicalRecord) {
        this.patientName = patientName;
        this.age = age;
        this.city = city;
        this.medicalRecord = medicalRecord;
    }

    // Getters and setters for Patient attributes
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getter for MedicalRecord attribute
    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    // Setter for MedicalRecord attribute
    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public static void main(String[] args) {
        // Creating MedicalRecord instances
        MedicalRecord record1 = new MedicalRecord(123456, "Common Cold", "Paracetamol", "None");
        MedicalRecord record2 = new MedicalRecord(789012, "Influenza", "Tamiflu", "Penicillin allergy");
        MedicalRecord record3 = new MedicalRecord(345678, "Allergic Rhinitis", "Cetirizine", "None");

        // Creating Patient instances with the MedicalRecords
        Patient patient1 = new Patient("Sita Patel", 28, "Mumbai", record1);
        Patient patient2 = new Patient("Rahul Singh", 35, "Delhi", record2);
        Patient patient3 = new Patient("Priya Sharma", 22, "Bangalore", record3);

        // Displaying patient information and medical record details
        displayPatientDetails(patient1);
        displayPatientDetails(patient2);
        displayPatientDetails(patient3);
    }

    private static void displayPatientDetails(Patient patient) {
        System.out.println("\nPatient Name: " + patient.getPatientName());
        System.out.println("Patient Age: " + patient.getAge());
        System.out.println("Patient City: " + patient.getCity());

        // Accessing MedicalRecord details through Patient
        MedicalRecord patientMedicalRecord = patient.getMedicalRecord();
        System.out.println("Patient ID: " + patientMedicalRecord.getPatientId());
        System.out.println("Diagnosis: " + patientMedicalRecord.getDiagnosis());
        System.out.println("Medications: " + patientMedicalRecord.getMedications());
        System.out.println("Allergies: " + patientMedicalRecord.getAllergies());
    }
}
