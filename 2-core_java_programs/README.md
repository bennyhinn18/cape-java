# Core Java Programs - Development Environment

This project is a comprehensive Java learning environment featuring database connectivity, threading examples, file manipulation, and network utilities, all set up without the need for Eclipse IDE.

## Project Structure

```
├── src/main/java/
│   └── com/cistron/
│       ├── app/
│       │   ├── start/Start.java           # Main application entry point
│       │   └── student/model/             # Student management models
│       │       ├── College.java
│       │       ├── Department.java
│       │       ├── Gender.java
│       │       └── Student.java
│       └── training/
│           ├── sample/                    # Sample utilities
│           │   ├── DataManipulation.java  # Database CRUD operations
│           │   ├── FileManipulation.java  # File I/O operations
│           │   └── NetworkUtil.java       # Network utilities
│           └── thread/                    # Threading examples
│               ├── HeavyWorkRunnable.java
│               ├── MyThread.java
│               └── ThreadRunExample.java
├── src/main/resources/
│   └── application.properties             # Configuration settings
├── db/
│   └── New Database and Tabsles.sql      # Database schema
├── .vscode/
│   ├── tasks.json                         # VS Code tasks
│   └── launch.json                        # Debug configurations
├── pom.xml                                # Maven configuration
└── dev.sh                                 # Development convenience script
```

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- Docker (for MySQL database)
- VS Code with Java Extension Pack

## Quick Start

### 1. Database Setup

```bash
# Start MySQL container
docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpassword -p 3306:3306 -d mysql:latest

# Create database and tables
docker exec -i mysql-container mysql -uroot -prootpassword student_management < db/New\ Database\ and\ Tabsles.sql
```

### 2. Build and Run

```bash
# Using the convenience script
./dev.sh setup    # Setup dependencies
./dev.sh compile  # Compile the project
./dev.sh run      # Run the application

# Or using Maven directly
mvn clean compile
mvn exec:java
```

## Development Commands

### Using the Development Script (`./dev.sh`)

- `./dev.sh compile` - Compile the Java project
- `./dev.sh run` - Run the main application
- `./dev.sh test` - Run tests
- `./dev.sh clean` - Clean compiled files
- `./dev.sh setup` - Setup database and dependencies
- `./dev.sh db-status` - Check database connection
- `./dev.sh help` - Show help message

### Using Maven Directly

- `mvn clean compile` - Clean and compile
- `mvn exec:java` - Run the main class
- `mvn test` - Run tests
- `mvn clean` - Clean build artifacts

### Using VS Code Tasks

Press `Ctrl+Shift+P` and type "Tasks: Run Task", then select:
- **Compile Java Project** - Compile the codebase
- **Run Java Application** - Execute the main application
- **Run Tests** - Execute unit tests
- **Clean Project** - Clean build artifacts
- **Setup Database** - Connect to MySQL database

## Configuration

### Database Settings

Edit `src/main/resources/application.properties`:

```properties
db.hostname=localhost
db.port=3306
db.database=student_management
db.username=root
db.password=rootpassword
```

### Java Main Class

The main entry point is `com.cistron.app.start.Start`. Change this in `pom.xml` if needed:

```xml
<plugin>
    <groupId>org.codehaus.mojo</groupId>
    <artifactId>exec-maven-plugin</artifactId>
    <configuration>
        <mainClass>com.cistron.app.start.Start</mainClass>
    </configuration>
</plugin>
```

## Features

### 1. Student Management System
- Complete CRUD operations for students, departments, colleges, and genders
- MySQL database integration with proper foreign key relationships

### 2. Database Operations (`DataManipulation.java`)
- Connection management with MySQL
- Prepared statements for secure SQL execution
- Transaction handling and resource cleanup
- CRUD operations: Create, Read, Update, Delete

### 3. File Operations (`FileManipulation.java`)
- File creation, reading, and writing
- Directory manipulation
- File system utilities

### 4. Network Utilities (`NetworkUtil.java`)
- HTTP client operations
- Network connectivity testing
- URL processing

### 5. Threading Examples
- Custom thread implementations
- Runnable interface examples
- Heavy computation in separate threads

## Debugging

### VS Code Debugging
1. Set breakpoints in your Java code
2. Press `F5` or use the Debug view
3. Select "Debug Start Class" configuration

### Command Line Debugging
```bash
mvn exec:java -Dexec.args="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"
```

## Database Schema

The project includes a complete student management database schema:

```sql
-- Tables included:
- genders (id, name)
- students (id, name, address, phone_number, email, gender_id)
```

### Sample Data
- Male and Female gender entries
- Foreign key relationships between students and genders

## Troubleshooting

### Common Issues

1. **"Class cannot be resolved" error**
   - Ensure MySQL JDBC driver is in classpath
   - Run `mvn clean compile` to refresh dependencies

2. **Database connection failed**
   - Check if MySQL container is running: `docker ps`
   - Verify connection settings in `application.properties`
   - Test connection: `./dev.sh db-status`

3. **Compilation errors**
   - Ensure Java 17+ is installed
   - Check if all required dependencies are downloaded
   - Run `mvn clean compile` to rebuild

4. **Module system issues**
   - The project is configured to work without JPMS modules
   - If using modules, ensure `module-info.java` is properly configured

### Logs and Output
- Maven output shows compilation and execution details
- Application logs are displayed in the console
- Database connection status is shown during execution

## Dependencies

- **MySQL Connector/J 8.3.0** - Database connectivity
- **JUnit 5.10.0** - Testing framework
- **Java 17** - Runtime and compilation target

## Development Tips

1. **Hot Reload**: Use `mvn compile exec:java` for quick iteration
2. **Database Access**: Use VS Code tasks to quickly access MySQL shell
3. **Code Style**: Follow standard Java conventions
4. **Testing**: Write unit tests for new functionality
5. **Version Control**: Project is git-ready with proper `.gitignore`

## Additional Resources

- [Maven Documentation](https://maven.apache.org/guides/)
- [MySQL Connector/J Documentation](https://dev.mysql.com/doc/connector-j/8.0/en/)
- [VS Code Java Development](https://code.visualstudio.com/docs/languages/java)
- [Docker MySQL Setup](https://hub.docker.com/_/mysql)

---

**Happy Coding!** 🚀

This environment provides everything you need for Java development without Eclipse IDE, using modern tools and best practices.
