#!/bin/bash

# Simple Java Compilation and Execution Script (No Maven Required)
# Usage: ./run.sh [compile|run|clean|help]

set -e

PROJECT_DIR="/workspaces/cape-java/2-core_java_programs"
cd "$PROJECT_DIR"

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Paths
SRC_DIR="src"
BUILD_DIR="build/classes"
LIB_DIR="lib"
MAIN_CLASS="com.cistron.app.start.Start"

print_usage() {
    echo -e "${BLUE}Simple Java Runner (No Maven)${NC}"
    echo "Usage: $0 [command]"
    echo ""
    echo "Commands:"
    echo "  compile     - Compile all Java files"
    echo "  run         - Run the main application"
    echo "  clean       - Clean compiled files"
    echo "  test-db     - Test database connectivity"
    echo "  help        - Show this help message"
    echo ""
    echo "Examples:"
    echo "  $0 compile"
    echo "  $0 run"
}

compile_java() {
    echo -e "${YELLOW}Compiling Java files...${NC}"
    
    # Create build directory
    mkdir -p "$BUILD_DIR"
    
    # Find all Java files
    JAVA_FILES=$(find "$SRC_DIR" -name "*.java")
    
    if [ -z "$JAVA_FILES" ]; then
        echo -e "${RED}No Java files found in $SRC_DIR${NC}"
        exit 1
    fi
    
    # Compile with classpath including MySQL JDBC driver
    if [ -f "$LIB_DIR/mysql-connector-j-8.3.0.jar" ]; then
        echo "Compiling with MySQL JDBC driver..."
        javac -cp "$LIB_DIR/mysql-connector-j-8.3.0.jar" -d "$BUILD_DIR" $JAVA_FILES
    else
        echo "Compiling without external dependencies..."
        javac -d "$BUILD_DIR" $JAVA_FILES
    fi
    
    echo -e "${GREEN}Compilation completed successfully!${NC}"
    echo "Compiled classes are in: $BUILD_DIR"
}

run_application() {
    echo -e "${YELLOW}Running Java application...${NC}"
    
    if [ ! -d "$BUILD_DIR" ]; then
        echo -e "${RED}No compiled classes found. Run 'compile' first.${NC}"
        exit 1
    fi
    
    # Run with classpath including build directory and MySQL JDBC driver
    if [ -f "$LIB_DIR/mysql-connector-j-8.3.0.jar" ]; then
        java -cp "$BUILD_DIR:$LIB_DIR/mysql-connector-j-8.3.0.jar" "$MAIN_CLASS"
    else
        java -cp "$BUILD_DIR" "$MAIN_CLASS"
    fi
}

test_database() {
    echo -e "${YELLOW}Testing database connectivity...${NC}"
    
    if [ ! -d "$BUILD_DIR" ]; then
        echo -e "${RED}No compiled classes found. Run 'compile' first.${NC}"
        exit 1
    fi
    
    # Run database test class
    if [ -f "$LIB_DIR/mysql-connector-j-8.3.0.jar" ]; then
        java -cp "$BUILD_DIR:$LIB_DIR/mysql-connector-j-8.3.0.jar" com.cistron.app.test.DatabaseTest
    else
        echo -e "${RED}MySQL JDBC driver not found. Database test cannot run.${NC}"
        exit 1
    fi
}

clean_build() {
    echo -e "${YELLOW}Cleaning build directory...${NC}"
    rm -rf "$BUILD_DIR"
    echo -e "${GREEN}Clean completed!${NC}"
}

check_dependencies() {
    echo -e "${BLUE}Checking dependencies...${NC}"
    
    # Check Java
    if command -v java &> /dev/null; then
        echo -e "${GREEN}✓ Java found:${NC} $(java -version 2>&1 | head -1)"
    else
        echo -e "${RED}✗ Java not found${NC}"
        exit 1
    fi
    
    # Check javac
    if command -v javac &> /dev/null; then
        echo -e "${GREEN}✓ javac found:${NC} $(javac -version 2>&1)"
    else
        echo -e "${RED}✗ javac not found${NC}"
        exit 1
    fi
    
    # Check MySQL JDBC driver
    if [ -f "$LIB_DIR/mysql-connector-j-8.3.0.jar" ]; then
        echo -e "${GREEN}✓ MySQL JDBC driver found${NC}"
    else
        echo -e "${YELLOW}! MySQL JDBC driver not found (database features disabled)${NC}"
    fi
    
    # Check Docker MySQL
    if docker ps | grep -q mysql-container; then
        echo -e "${GREEN}✓ MySQL container is running${NC}"
    else
        echo -e "${YELLOW}! MySQL container not running (start with: docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpassword -p 3306:3306 -d mysql:latest)${NC}"
    fi
}

# Main script logic
case "${1:-help}" in
    compile)
        check_dependencies
        compile_java
        ;;
    run)
        check_dependencies
        run_application
        ;;
    test-db)
        check_dependencies
        test_database
        ;;
    clean)
        clean_build
        ;;
    help|*)
        print_usage
        ;;
esac
