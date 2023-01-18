package enumeracoes.desafioum;

import java.util.Date;

public class HourContract {

    //Atributes
    private Date date;
    private Double valuePerHour;

    private Integer hours;

    //Constructors


    public HourContract(Date date, Double valuePerHour, Integer hours) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }

    public HourContract() {
    }

    // Getters and Setters


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    //Metods

    public Double totalValue() { // Retorna o valor total que o trabalhador ganhou nesse contrato específico.
        return valuePerHour*hours;
    }
}
