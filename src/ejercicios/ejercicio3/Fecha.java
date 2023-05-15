package ejercicios.ejercicio3;

import ejercicios.ejercicio2.NegativeHourException;
import ejercicios.ejercicio2.NegativeMinuteException;

public class Fecha {
    int dia;
    int mes;
    int año;
    public Fecha(){}

    public Fecha(int dia, int mes, int año) throws DayException, MonthException {
        if (dia>0 && dia<32)
            this.dia = dia;
        else throw new DayException();
        if (mes>0 && mes<13)
            this.mes = mes;
        else throw new MonthException();
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) throws DayException {
        if (dia>0 && dia<32){
            this.dia = dia;
        }else throw new DayException();
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) throws MonthException {
        if (mes>0 && mes<13){
            this.mes = mes;
        }else throw new MonthException();
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        if (año>=0){
            this.año = año;
        }
    }
    private boolean esBisiesto(){
        boolean bisiesto = false;
        if (año%4==0){
            bisiesto = true;
        }
        return bisiesto;
    }
    public boolean fechaCorrecta(){
        boolean correcta = true;
        if (esBisiesto() == true){
            if (mes == 2){
                if (dia>28 && dia<=0){
                    correcta = false;
                }
            }
        }
        return correcta;
    }
    public void diaSiguiente(){
        if (fechaCorrecta()!=true){
            if (dia==30){
                dia++;
            }else {
                dia = 1;
                if (mes != 12){
                    mes++;
                }else {
                    mes = 1;
                    año++;
                }
            }
        }else {
            if (mes == 2){
                if (dia == 29){
                    mes++;
                    dia = 1;
                }else
                    dia++;
            }
        }
    }

    @Override
    public String toString() {
        String fecha = "";
        if(año<10) {
            // Si los minutos son menores de 10 seguimos el programa, sino mostramos un mensaje distinto con la hora incrementada.
            if(mes<10) {
                // Si las horas son menores de 10 seguimos el programa, sino mostramos un mensaje distinto con la hora incrementada.
                if(dia<10) System.out.println(0+ dia + "-" + 0 + mes + "-" + 0 + año);
                else System.out.println(dia + "-" + 0 + mes + "-" + 0 + año);
            }else System.out.println(dia + "-" +mes + "-" + 0 + año);
        }else System.out.println(dia + "-" + mes + "-" + año);
        return fecha;
    }
}
