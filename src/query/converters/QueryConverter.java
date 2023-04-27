package query.converters;

import query.models.Query;

/**
 *
 * @author Luan Nadaletti
 *
 */
public interface QueryConverter {

    public Query convert(String queryString);

}
