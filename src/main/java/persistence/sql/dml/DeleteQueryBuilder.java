package persistence.sql.dml;

import persistence.sql.QueryBuilder;
import persistence.sql.ddl.QueryValidator;
import persistence.sql.ddl.Table;

import java.util.List;

import static java.lang.String.format;

public class DeleteQueryBuilder implements QueryBuilder {
	private final static String DELETE_COMMAND = "DELETE FROM %s;";

	private final QueryValidator queryValidator;

	private final Table table;

	private final String whereClause;

	public DeleteQueryBuilder(QueryValidator queryValidator, Class<?> clazz, List<String> whereColumns, List<String> whereValues) throws Exception {
		this.queryValidator = queryValidator;
		queryValidator.checkIsEntity(clazz);
		this.table = new Table(clazz);
		this.whereClause = new WhereClauseBuilder(clazz, whereColumns, whereValues).buildClause();
	}

	@Override
	public String buildQuery() {
		return format(DELETE_COMMAND, table.getName() + whereClause);
	}
}