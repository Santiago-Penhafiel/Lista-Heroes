import javax.swing.*;

public class Heroe {
    private String id;
    private String nombre;
    private String superpoder;
    private String mision;
    private int nivelDificultad;
    private double pagoMensual;
    private double aporteFondo;
    private double impuestoGobierno;

    public Heroe (String id, String nombre, String superpoder, String mision, int nivelDificultad, double pagoMensual){
        this.id = id;
        this.nombre = nombre;
        this.superpoder = superpoder;
        this.mision = mision;
        this.nivelDificultad = nivelDificultad;
        this.pagoMensual = pagoMensual;
        this.aporteFondo = pagoMensual*0.1;
        this.impuestoGobierno = calculoImpuesto(pagoMensual);
    }

    private double calculoImpuesto (double pagoMensual){
        double pagoAnual = pagoMensual*12;
        if (pagoAnual > 240000){
            return (pagoAnual-240000)*0.35;
        }else if (pagoAnual > 120000){
            return (pagoAnual-120000)*0.25;
        }else if (pagoAnual > 60000){
            return (pagoAnual-60000)*0.12;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "\nId : " + id+
                "\nNombre : " + nombre +
                "\nSuper poder : " + superpoder +
                "\nMision : " + mision +
                "\nNivel de dificultad : " + nivelDificultad +
                "\nPago mensual : " + pagoMensual +
                "\nAporte al fondo de héroes : " + aporteFondo +
                "\nImpuesto del gobierno : " + impuestoGobierno;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSuperpoder() {
        return superpoder;
    }

    public void setSuperpoder(String superpoder) {
        this.superpoder = superpoder;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public int getNivelDificultad() {
        return nivelDificultad;
    }

    public void setNivelDificultad(int nivelDificultad) {
        this.nivelDificultad = nivelDificultad;
    }

    public double getPagoMensual() {
        return pagoMensual;
    }

    public void setPagoMensual(double pagoMensual) {
        this.pagoMensual = pagoMensual;
    }

    public double getAporteFondo() {
        return aporteFondo;
    }

    public void setAporteFondo(double aporteFondo) {
        this.aporteFondo = aporteFondo;
    }

    public double getImpuestoGobierno() {
        return impuestoGobierno;
    }

    public void setImpuestoGobierno(double impuestoGobierno) {
        this.impuestoGobierno = impuestoGobierno;
    }
}
