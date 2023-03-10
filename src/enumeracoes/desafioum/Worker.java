package enumeracoes.desafioum;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    //Atributes
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    private Department department;
    private List <HourContract> contracts = new ArrayList<>();

    //Constructor


    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    //Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    //Metods

    public void addContract (HourContract contract) { //Adiciona um novo contrato a lista de contratos passando parametros
        contracts.add(contract);
    }

    public void removeContract (HourContract contract) { //Remove um contrato da lista de contratos
        contracts.remove(contract);
    }

    public Double income (int year, int month){ //Realiza a soma do salário em um determinado mês.
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c: contracts) {
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if(year==c_year && month==c_month){
                sum += c.totalValue();
            }
        }
        return sum;
    }
}

