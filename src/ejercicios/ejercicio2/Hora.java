package ejercicios.ejercicio2;

public class Hora {
    int hora;
    int minuto;
    int segundo;

    public Hora(int hora, int minuto, int segundo) throws NegativeHourException, NegativeMinuteException, NegativeSecondException {
        if (hora>=0)
            this.hora = hora;
        else throw new NegativeHourException();
        if (minuto>=0)
            this.minuto = minuto;
        else throw new NegativeMinuteException();
        if (segundo>=0)
        this.segundo = segundo;
        else throw new NegativeSecondException();
    }
    public Hora(){
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) throws NegativeHourException {
        if (hora>=0)
            this.hora = hora;
        else throw new NegativeHourException();
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) throws NegativeMinuteException {
        if (minuto>=0)
            this.minuto = minuto;
        else throw new NegativeMinuteException();
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) throws NegativeSecondException {
        if (segundo>=0)
            this.segundo = segundo;
        else throw new NegativeSecondException();
    }
    public void incrementarSegundo(int cant){
        /*
         * Recorremos el bucle hasta que i deje de ser menor a cant, a la vez que el valor de i va incrementandose.
         */
        for (int i = 0; i < cant; i++) {
            // Si los segundos son 59 lo ponemos a cero, sino aumentamos su valor en 1.
            if(segundo==59) {
                segundo=0;
                // Si los minutos son 59 los ponemos a cero, sino aumentamos su valor en 1.
                if(minuto==59) {
                    minuto=0;
                    // Si las horas son 23 las ponemos a cero, sino aumentamos su valor en 1.
                    if(hora==23) hora=0;
                    else hora++;
                }else minuto++;
            }else segundo++;
        }
    }
}