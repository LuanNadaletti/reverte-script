package query.converters;

import query.models.Query;

public interface QueryConverter {

    public Query convert(String queryString);

}
