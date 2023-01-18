package enumeracoes.desafioum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Criando formatação da data

        // Coletando dados para instanciar nosso trabalhador.

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();

        System.out.println("Worker data: ");
        System.out.print("Enter worker name: ");
        String workerName = sc.nextLine();

        System.out.print("Enter worker level: ");
        String workerLevel = sc.nextLine();

        System.out.print("Enter worker base salary: ");
        double workerSalary = sc.nextDouble();

        //Trabalhador Instanciado.

        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), workerSalary, new Department(departmentName));

        //Definindo número de contrato desse trabalhador.

        System.out.println("How many contracts to this worker? ");
        int n = sc.nextInt();

        // For criando um números X de contratos e associando eles a lista de contratos do trabalhador.

        for (int i=1; i<=n; i++){
            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(sc.next());

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            System.out.print("Duration (Hours): ");
            int hours = sc.nextInt();

            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }

        //Recebendo mês e ano para fazer o filtro de salário daquele mês

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2)); // Separando o mês e convertendo em Integer
        int year = Integer.parseInt(monthAndYear.substring(3));

        //Exibindo informações finais na tela.

        System.out.println("Name: " + worker.getName());
        System.out.println("Deparment: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));

        sc.close();
    }
}

