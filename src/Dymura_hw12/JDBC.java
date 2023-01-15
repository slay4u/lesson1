package Dymura_hw12;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBC {
    static Connection connection;
    static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String URL = "jdbc:mysql://localhost:3306/hillel";
    static final String USER = "root";
    static final String PASS = "root";

    static {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static List<Books> getAllBooks() throws SQLException {
        List<Books> books = new ArrayList<>();
        String SQL = " select books.Title as BookTitle, authors.Name as AuthorName, " +
                " authors.LastName as AuthorLastName from books " +
                " left join authors on authors.id = books.AuthorId; ";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                final String title = resultSet.getString("BookTitle");
                final String name = resultSet.getString("AuthorName");
                final String lastName = resultSet.getString("AuthorLastName");
                Authors authors = new Authors(name, lastName);
                Books books1 = new Books(title);
                books1.setAuthors(authors);
                books.add(books1);
            }
            return books;
        }
    }

    static List<Books> getAllBooksWithoutAuthors() throws SQLException {
        List<Books> books = new ArrayList<>();
        String SQL = " select books.Title as BookTitle from books " +
                " where books.AuthorId is null; ";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                final String title = resultSet.getString("BookTitle");
                Books books1 = new Books(title);
                books.add(books1);
            }
            return books;
        }
    }

    static Map<Authors, Integer> getAllAuthorsWithCountOfTheirBooks() throws SQLException {
        Map<Authors, Integer> map = new HashMap<>();
        String SQL = " select authors.Name as AuthorName, authors.LastName as AuthorLastName, " +
                " count(books.id) as BookCount from authors " +
                " join books on books.AuthorId = authors.id " +
                " group by books.AuthorId; ";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                final String name = resultSet.getString("AuthorName");
                final String lastName = resultSet.getString("AuthorLastName");
                final Integer count = resultSet.getInt("BookCount");
                Authors authors = new Authors(name, lastName);
                map.put(authors, count);
            }
            return map;
        }
    }

    static Map<Authors, Integer> getAllAuthorsWithMoreThanTwoBooks() throws SQLException {
        Map<Authors, Integer> map = new HashMap<>();
        String SQL = " select authors.Name as AuthorName, authors.LastName as AuthorLastName, " +
                " count(books.id) as BookCount from authors " +
                " join books on books.AuthorId = authors.id " +
                " group by books.AuthorId having BookCount > 3; ";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                final String name = resultSet.getString("AuthorName");
                final String lastName = resultSet.getString("AuthorLastName");
                final Integer count = resultSet.getInt("BookCount");
                Authors authors = new Authors(name, lastName);
                map.put(authors, count);
            }
            return map;
        }
    }

    public static void main(String[] args) throws SQLException {
        List<Books> allBooks = getAllBooks();
        System.out.println(allBooks);
        List<Books> allBooksWithoutAuthors = getAllBooksWithoutAuthors();
        System.out.println(allBooksWithoutAuthors);
        Map<Authors, Integer> allAuthorsWithCountOfTheirBooks = getAllAuthorsWithCountOfTheirBooks();
        System.out.println(allAuthorsWithCountOfTheirBooks);
        Map<Authors, Integer> allAuthorsWithMoreThanTwoBooks = getAllAuthorsWithMoreThanTwoBooks();
        System.out.println(allAuthorsWithMoreThanTwoBooks);
    }
}
