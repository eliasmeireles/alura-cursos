import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class TestandoDateAndDateTime {
	public static void main(String[] args) {
		
		LocalDate dataDeHoje = LocalDate.now();
		
		LocalDate anoAntingo = LocalDate.of(2009, Month.JANUARY, 25);
		
		
		Period periodo = Period.between(anoAntingo, dataDeHoje);
		
		System.out.println(periodo.getDays() + "/" + periodo.getMonths() + "/" + periodo.getYears());
		
		
		System.out.println(formataData(anoAntingo));
		
		System.out.println(formataData(dataDeHoje));
		
		
		
	}
	
	
	
	
	static String formataData(LocalDate date) {
		String formatedDate;
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		formatedDate = date.format(dateTimeFormatter);
		
		return formatedDate;
		
	}
}
