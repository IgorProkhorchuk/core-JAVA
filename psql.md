In PostgreSQL, to select the last 10 rows from a table, you typically use the `ORDER BY` clause along with the `LIMIT` keyword. Here's how you can do it:

```sql
SELECT *
FROM your_table
ORDER BY your_column DESC
LIMIT 10;
```

### Explanation:
1. **`ORDER BY your_column DESC`**: Sorts the rows in descending order based on a column (e.g., `id`, `created_at`, etc.) that determines the order of the rows.
2. **`LIMIT 10`**: Limits the result to the top 10 rows after sorting.

### Example:
Assume you have a table `users` with the following columns: `id`, `name`, and `created_at`. To fetch the last 10 rows based on the `id`, you can write:

```sql
SELECT *
FROM users
ORDER BY id DESC
LIMIT 10;
```

### Note:
If you want the result in ascending order after fetching the last 10 rows, you can use a subquery:

```sql
SELECT *
FROM (
    SELECT *
    FROM your_table
    ORDER BY your_column DESC
    LIMIT 10
) subquery
ORDER BY your_column ASC;
```

This approach ensures that the rows are ordered as they were originally, from the last 10 records.