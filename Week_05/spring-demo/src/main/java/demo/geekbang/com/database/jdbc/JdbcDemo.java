package demo.geekbang.com.database.jdbc;

import java.sql.*;
import java.util.*;

public class JdbcDemo {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;

    public static void main(String[] args) {
        Map<String, Object> valuesMap = new HashMap<>();
        valuesMap.put("id", 0);
        valuesMap.put("name", "gavin");
        valuesMap.put("age", 20);
        valuesMap.put("certNo", "13012858512121");
        System.out.println(valuesMap.keySet().toString().substring(1, valuesMap.keySet().toString().length() - 1));

        try {
            JdbcDemo jdbcDemo = new JdbcDemo();
            jdbcDemo.createConnection();
            String table = "users";
            String columns = "(name, age, certNo)";
            List<Object> values = Arrays.asList("gavin", 20, "13012858512121");

            //插入数据
            jdbcDemo.insert(table, columns, values);

            //查询数据
            List<Map<String, Object>> results = jdbcDemo.query(table, valuesMap, null);
            for (Map r : results) {
                System.out.println(r.toString());
            }

            jdbcDemo.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println();
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find mysql jdbc driver");
            e.printStackTrace();
            return;
        }

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "123456");
            if (connection != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Connection failed!");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    public boolean insert(String table, String column, List<Object> values) {
        try {
            String insertTemplate = buildInsertSqlTemplate(table, column, values.size());
            preparedStatement = connection.prepareStatement(insertTemplate);
            for (int i = 1; i < values.size() + 1; i++) {
                preparedStatement.setObject(i, values.get(i - 1));
            }
            System.out.println(preparedStatement.toString());

            preparedStatement.execute();
            System.out.println("Insert successfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String buildInsertSqlTemplate(String table, String column, int valueAmount) {
        StringBuilder builder = new StringBuilder("?");
        builder.append("insert into");
        builder.append(table);
        builder.append(column);
        builder.append("values (?");
        for (int i = 0; i < valueAmount - 1; i++) {
            builder.append(",?");
        }
        builder.append(")");
        return builder.toString();
    }

    public List<Map<String, Object>> query(String table, Map<String, Object> values, String condition) {
        try {
            String sqlTemplate = buildQuerySqlTemplate(table, values, condition);

            preparedStatement = connection.prepareStatement(sqlTemplate);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Map<String, Object>> list = new ArrayList<>();
            while (resultSet.next()) {
                for (String key : values.keySet()) {
                    values.put(key, resultSet.getObject(key));
                }
                list.add(new HashMap<>(values));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String buildQuerySqlTemplate(String table, Map<String, Object> values, String condition) {
        String sqlTemplate = "select " + values.keySet().toString().substring(1,
                values.keySet().toString().length() - 1) + " from " + table;
        if (condition != null) {
            sqlTemplate += " where " + condition;
        }
        return sqlTemplate;
    }

    private void close() throws SQLException {
        preparedStatement.close();
        connection.close();
        System.out.println("Connection close");
    }


}
