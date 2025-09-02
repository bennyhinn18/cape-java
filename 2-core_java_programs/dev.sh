#!/bin/bash

# Java Development Environment Script
# Usage: ./dev.sh [command] [options]

set -e

PROJECT_DIR="/workspaces/cape-java/2-core_java_programs"
cd "$PROJECT_DIR"

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

print_usage() {
    echo -e "${BLUE}Java Development Environment${NC}"
    echo "Usage: $0 [command] [options]"
    echo ""
    echo "Commands:"
    echo "  compile     - Compile the Java project"
    echo "  run         - Run the main application"
    echo "  test        - Run tests"
    echo "  clean       - Clean compiled files"
    echo "  setup       - Setup database and dependencies"
    echo "  db-status   - Check database connection"
    echo "  help        - Show this help message"
    echo ""
    echo "Examples:"
    echo "  $0 compile"
    echo "  $0 run"
    echo "  $0 setup"
}

setup_project() {
    echo -e "${YELLOW}Setting up project...${NC}"
    
    # Download dependencies
    mvn dependency:resolve
    
    # Compile the project
    mvn compile
    
    echo -e "${GREEN}Project setup complete!${NC}"
}

compile_project() {
    echo -e "${YELLOW}Compiling project...${NC}"
    mvn compile
    echo -e "${GREEN}Compilation complete!${NC}"
}

run_application() {
    echo -e "${YELLOW}Running application...${NC}"
    mvn exec:java
}

run_tests() {
    echo -e "${YELLOW}Running tests...${NC}"
    mvn test
}

clean_project() {
    echo -e "${YELLOW}Cleaning project...${NC}"
    mvn clean
    rm -rf bin/
    echo -e "${GREEN}Clean complete!${NC}"
}

check_db_status() {
    echo -e "${YELLOW}Checking database status...${NC}"
    
    if docker ps | grep -q mysql-container; then
        echo -e "${GREEN}MySQL container is running${NC}"
        docker exec mysql-container mysql -uroot -prootpassword -e "SELECT 'Database connection successful' as status;" 2>/dev/null || echo -e "${RED}Database connection failed${NC}"
    else
        echo -e "${RED}MySQL container is not running${NC}"
        echo "Run: docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpassword -p 3306:3306 -d mysql:latest"
    fi
}

# Main script logic
case "${1:-help}" in
    compile)
        compile_project
        ;;
    run)
        run_application
        ;;
    test)
        run_tests
        ;;
    clean)
        clean_project
        ;;
    setup)
        setup_project
        ;;
    db-status)
        check_db_status
        ;;
    help|*)
        print_usage
        ;;
esac
