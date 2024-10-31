package com.revertescript.functional.reversers;

import com.revertescript.functional.models.CreateQuery;
import com.revertescript.functional.models.Query;

/**
 * Reverses a CreateQuery by generating the reversed SQL statement. This class
 * extends the {@link QueryReverser} class and provides the implementation to
 * reverse a CreateQuery.
 *
 * The class provides the {@link #reverse(Query)} method, which takes a
 * CreateQuery as input and generates the reversed SQL statement.
 *
 * Instances of this class are stateless and can be reused for multiple queries.
 *
 * @author Luan Nadaletti
 */
public class CreateQueryReverser extends QueryReverser {

    /**
     * Reverses a CreateQuery by generating the reversed SQL statement.
     *
     * @param query The CreateQuery to be reversed.
     *
     * @return The reversed SQL statement.
     *
     * @throws IllegalArgumentException If the provided query is not an instance
     *                                  of CreateQuery.
     */
    @Override
    public String reverse(Query query) {
        CreateQuery createQuery = (CreateQuery) query;

        return String.format("DROP %s %s;\n",
                createQuery.getCreateQueryType().getKeyWord(),
                createQuery.getTable());
    }

}
