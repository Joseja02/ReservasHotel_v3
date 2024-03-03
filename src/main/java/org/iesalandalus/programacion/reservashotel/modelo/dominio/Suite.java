package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public class Suite extends Habitacion{
    private static final int NUM_MAXIMO_PERSONAS = 4;
    public static final int MIN_NUM_BANOS = 1;
    public static final int MAX_NUM_BANOS = 2;
    private int numBanos;
    private boolean tieneJacuzzi;

    public Suite(int planta, int puerta, double precio, int numBanos, boolean tieneJacuzzi){
        super(planta, puerta, precio);
        setNumBanos(numBanos);
        setTieneJacuzzi(tieneJacuzzi);
    }
    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        if (numBanos < MIN_NUM_BANOS){
            throw new IllegalArgumentException("ERROR: No pueden haber -1 bañosss.");
        }
        this.numBanos = numBanos;
    }

    public boolean isTieneJacuzzi() {
        return tieneJacuzzi;
    }

    public void setTieneJacuzzi(boolean tieneJacuzzi) {
        this.tieneJacuzzi = tieneJacuzzi;
    }
    @Override
    public int getNumeroMaximoPersonas() {
        return NUM_MAXIMO_PERSONAS;
    }
    @Override
    public String toString() {
        return "Suite{" +
                "numBanos=" + numBanos +
                ", tieneJacuzzi=" + tieneJacuzzi +
                ", identificador='" + identificador + '\'' +
                ", planta=" + planta +
                ", puerta=" + puerta +
                ", precio=" + precio +
                '}';
    }
}
