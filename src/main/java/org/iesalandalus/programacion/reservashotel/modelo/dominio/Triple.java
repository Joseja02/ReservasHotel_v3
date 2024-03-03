package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public class Triple extends Habitacion {
    private static final int NUM_MAXIMO_PERSONAS = 3;
    public static final int MIN_NUM_BANOS = 1;
    public static final int MAX_NUM_BANOS = 2;
    public static final int MIN_NUM_CAMAS_INDIVIDUALES = 2;
    protected static final int MAX_NUM_CAMAS_INDIVIDUALES = 3;
    protected static final int MIN_NUM_CAMAS_DOBLES = 0;
    protected static final int MAX_NUM_CAMAS_DOBLES = 1;
    private int numBanos;
    private int numCamasIndividuales;
    private int numCamasDobles;

    public Triple(int planta, int puerta, double precio, int numBanos, int numCamasIndividuales, int numCamasDobles) {
        super(planta, puerta, precio);
        setNumCamasIndividuales(numCamasIndividuales);
        setNumBanos(numBanos);
        setNumCamasDobles(numCamasDobles);
        validaNumCamas();
    }
    public Triple(Triple habitacionTriple) {
        super(habitacionTriple);
        this.numCamasIndividuales = getNumCamasIndividuales();
        this.numBanos = getNumBanos();
        this.numCamasDobles = getNumCamasDobles();
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        if (numBanos < MIN_NUM_BANOS){
            throw new NullPointerException("ERROR: No pueden haber -1 baños.");
        }
        this.numBanos = numBanos;
    }

    public int getNumCamasIndividuales() {
        return numCamasIndividuales;
    }

    public void setNumCamasIndividuales(int numCamasIndividuales) {
        if (numCamasIndividuales < MIN_NUM_CAMAS_INDIVIDUALES){
            throw new NullPointerException("ERROR: No pueden haber -1 camas individuales.");
        }
        this.numCamasIndividuales = numCamasIndividuales;
    }

    public int getNumCamasDobles() {
        return numCamasDobles;
    }

    public void setNumCamasDobles(int numCamasDobles) {
        if (numCamasDobles < MIN_NUM_CAMAS_DOBLES){
            throw new NullPointerException("ERROR: No pueden haber -1 camas dobles.");
        }
        this.numCamasDobles = numCamasDobles;
    }
    private void validaNumCamas(){
        if ((numCamasIndividuales == MAX_NUM_CAMAS_INDIVIDUALES && numCamasDobles == MIN_NUM_CAMAS_DOBLES) || (numCamasIndividuales == MIN_NUM_CAMAS_INDIVIDUALES && numCamasDobles == MAX_NUM_CAMAS_DOBLES)){
            //No se lanza excepcion puesto que o hay 3 camas individuales o hay 1 cama doble y 2 individuales.
        } else {
            throw new IllegalArgumentException("ERROR: El número de camas es incorrecto.");
        }
    }
    @Override
    public int getNumeroMaximoPersonas() {
        return NUM_MAXIMO_PERSONAS;
    }

    @Override
    public String toString() {
        return "Triple{" +
                "numBanos=" + numBanos +
                ", numCamasIndividuales=" + numCamasIndividuales +
                ", numCamasDobles=" + numCamasDobles +
                ", identificador='" + identificador + '\'' +
                ", planta=" + planta +
                ", puerta=" + puerta +
                ", precio=" + precio +
                '}';
    }
}
