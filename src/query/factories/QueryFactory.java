package query.factories;

/**
 *
 * @author Luan Nadaletti
 *
 */
import query.models.Query;

public interface QueryFactory {

    Query createQuery(String statement);

}
