# SQLUndo

**SQLUndo** is a Java-based software designed to receive a complete SQL script and perform reverse operations on each query. It is specifically built to identify and handle reversal operations for SQL statements that cannot be executed multiple times due to primary key (PK) constraints and other database restrictions.

## Project Status

⚠️ **Warning: This project is currently under development and may not be fully functional.**

The objective of this project is to develop software in Java capable of reversing SQL queries. At this stage, certain features are still in progress, meaning some functionalities may not yet be available. Currently, the project supports basic query analysis, while support for more complex queries is under active development.

### Implemented Features:
- Basic SQL query analysis.
- Reversal of basic operations.

### Features in Progress:
- Reversal of complex SQL queries.
- Handling of advanced constraints.

Feel free to explore the existing code and contribute with suggestions or improvements. Your collaboration is welcome!

## Features

**SQLUndo** offers the following key functionalities:

1. **Reversal of Operations**: The software analyzes each query within the provided SQL script and performs the necessary reverse operations to undo the effects of the query. This is particularly useful when you need to roll back changes made to a database.

2. **Constraint Handling**: The software manages primary key (PK) constraints and other restrictions that prevent a query from being reverted directly. It identifies queries that cannot be reversed straightforwardly and performs appropriate actions to ensure that subsequent queries can be executed successfully.

3. **Data Integrity Preservation**: During the reversal process, the software preserves data integrity within the database. It maintains data consistency and respects relationships defined by primary and foreign keys.

4. **Support for Multiple Databases**: **SQLUndo** is designed to work with various SQL-compatible database systems. It can handle SQL scripts written in multiple SQL dialects, such as MySQL, PostgreSQL, Oracle, SQL Server, among others.

---
