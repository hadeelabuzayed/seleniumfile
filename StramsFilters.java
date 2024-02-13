
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StramsFilters {

	public static void main(String[] args) {
		// count the number of names that starting with A from array list
		Long a = Stream.of("Ali", "rema", "Alina", "Ahmad", "Amer").filter(s -> s.startsWith("A")).count();
		System.out.println(a);
		// print all names
		List<String> name1 = Arrays.asList("mousa", "sami", "zain", "Ahmad");
		name1.stream().filter(s -> s.length() > 4).forEach(s -> System.out.println(s));
		// concat
		ArrayList<String> name = new ArrayList();
		name.add("man");
		name.add("OOO");
		Stream<String> newStream = Stream.concat(name.stream(), name1.stream());
		newStream.sorted().forEach(s -> System.out.print(s));

	}

}
