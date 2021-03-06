package net.avicus.quest.model;

import java.sql.ResultSet;
import java.util.Iterator;
import lombok.ToString;
import net.avicus.quest.database.DatabaseException;
import net.avicus.quest.query.RowIterator;

@ToString
public class ModelIterator<M extends Model> implements Iterator<M> {

  private final Table<M> table;
  private final RowIterator rowIterator;

  public ModelIterator(Table<M> table, ResultSet resultSet) {
    this.table = table;
    this.rowIterator = new RowIterator(resultSet);
  }

  @Override
  public boolean hasNext() {
    return this.rowIterator.hasNext();
  }

  @Override
  public M next() throws DatabaseException {
    return this.table.newInstance(this.rowIterator.next());
  }
}
