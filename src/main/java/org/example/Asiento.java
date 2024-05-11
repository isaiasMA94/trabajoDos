package org.example;

public class Asiento {

    private int numero;
    private boolean ocupado;

    public Asiento(int numero) {
        this.numero = numero;
        this.ocupado = false;
    }

            public boolean isOcupado() {
            return ocupado;
        }

        public void reservar() {
        ocupado = true;
        }

        public int getNumero() {
        return numero;
        }

}
