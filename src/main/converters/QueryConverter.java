package main.converters;

import main.models.Query;

/**
 *
 * @author Luan Nadaletti
 *
 */
public interface QueryConverter {

    public Query convert(String queryString);

}
