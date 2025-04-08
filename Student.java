import java.beans.Transient;
import java.io.Serializable;
import java.util.Map;

/**
 * @author avinash
 * 1. Records can not be extended to other classes.
 * 2. The class is marked final, so we cannot create a subclass.
 * 3. It does not have setter method , record instance is designed to be immutable.
 * 4. Records Type support generics <p> record Container<T>(int id, T value) { }<p/>
 * 5. We cannot add instance fields in a record.
 * 6. Annotations are allowed to be used in a record. ex : @Transient String email.
 * <p>
 * Use case : Records are ideal candidates when modeling things like domain model classes
 * (potentially to be persisted via ORM), or data transfer objects (DTOs)
 */

public record Student(Long id, String name, @Transient String email, int age,
                      Map<Integer, String> columns) implements College, Serializable {
    //private String instance; instance fields not allowed in a record.
    public static String instance; // Only static fields are allowed in a record.

    //Canonical constructor
    public Student {
        columns = Map.copyOf(columns); //Immutable copy of Map
    }
}
