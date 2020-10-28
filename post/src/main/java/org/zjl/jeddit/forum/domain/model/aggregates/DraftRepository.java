package org.zjl.jeddit.forum.domain.model.aggregates;

import lombok.AllArgsConstructor;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;

/**
 * @author Junlin Zhou
 */
@AllArgsConstructor
@Component
public class DraftRepository {

    private final DatabaseClient databaseClient;

}
