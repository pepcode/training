package pep.training.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StatesandUTs {
	
	static String fileName = "/Users/praveen/sandbox/training/src/main/resources/indian_states.txt";
	
	//static Function<String, List<State>> = state -> state.split("\t").
	public static void main(String args[]) throws IOException {
		
		try {

			List<State> states = Files.lines(Paths.get(fileName))
				.map(line -> line.split("\t"))
				.map(a -> new State(a[0],a[3], a[1], a[4],a[5],a[6]))
				.collect(Collectors.toList());
			
			System.out.println("States count :: " + states.stream().filter(s -> s.isState).count());
			System.out.println("Union Teritorry count :: " + states.stream().filter(s -> !s.isState).count());
			
			System.out.println("Distinct Language :: " + 
					states
						.stream()
						.filter(distinctByKey( state -> state.language))
						.collect(Collectors.toList()));
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		

	}
	
    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) 
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

}



class State {
	public String name;
	public String vechileCode;
	public boolean isState;
	public String region;
	public String capital;
	public String language;
	
	public State(String name, String vechileCode, String stateCode, String region, String capital,  String language) {
		this.name = name;
		this.vechileCode = vechileCode;
		this.isState = stateCode.equals("S");
		this.region = region;
		this.capital = capital;
		this.language = language;
	}

	@Override
	public String toString() {
		return "State [name=" + name + ", vechileCode=" + vechileCode + ", isState=" + isState + ", region=" + region
				+ ", capital=" + capital + ", language=" + language + "]";
	}
	
	
}
