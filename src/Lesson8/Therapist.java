package Lesson8;

class Therapist extends Doctor {
    @Override
    public void treat() {
        System.out.println("Терапевт: Назначает анализы и выписывает рецепт на лекарства.");
    }
    public void assignDoctor(Patient patient) {
        int plan = patient.getTreatmentPlan();

        if (plan == 1) {
            patient.setDoctor(new Surgeon());
        } else if (plan == 2) {
            patient.setDoctor(new Dentist());
        } else {
            patient.setDoctor(new Therapist());
        }

        System.out.print("Для пациента с планом " + plan + " ");
        patient.getDoctor().treat();
    }
}