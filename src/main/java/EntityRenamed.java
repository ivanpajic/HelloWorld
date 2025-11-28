import java.util.*;
import java.util.logging.Logger;

public class Entity {

    String entityName;

    public Entity() {
        this.entityName = "Entity1";
    }

    public CombineLeftover testMethod() {
        Map<List, String> leftoverTitles = new Map<List, String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean containsKey(Object key) {
                return false;
            }

            @Override
            public String get(Object key) {
                return null;
            }

            @Override
            public String put(List key, String value) {
                return null;
            }

            @Override
            public String remove(Object key) {
                return null;
            }

            @Override
            public void putAll(Map<? extends List, ? extends String> m) {

            }

            @Override
            public void putSome(Map<? extends List, ? extends String> m) {

            }

            @Override
            public void clear() {

            }

            @Override
            public Set<List> keySet() {
                return null;
            }

            @Override
            public Collection<String> values() {
                return null;
            }

            @Override
            public Set<Entry<List, String>> entrySet() {
                return null;
            }
        };
        List<ProcessBuilder.Redirect> redirectWorks = new ArrayList<>();
        Logger combineLog = null;
        return new CombineLeftover(leftoverTitles, redirectWorks, combineLog);
    }

    public record CombineLeftover(Map<List, String> titlesWithStillWrongWork,
                                  List<ProcessBuilder.Redirect> redirectWorks,
                                  Logger combineLog) {

    }

    public CombineLeftover generateCombineLeftover() {
        Map<List, String> mockTitles = new HashMap<>();
        mockTitles.put(Collections.singletonList("MockKey"), "MockValue");

        List<ProcessBuilder.Redirect> mockRedirectWorks = List.of(ProcessBuilder.Redirect.INHERIT);

        Logger mockLogger = Logger.getLogger(Entity.class.getName());

        return new CombineLeftover(mockTitles, mockRedirectWorks, mockLogger);
    }
    
    
}
