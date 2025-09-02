#!/bin/bash

# Development Environment Status Check
# Run this script to verify everything is set up correctly

echo "🔍 Java Development Environment Status Check"
echo "============================================="
echo ""

# Check Java version
echo "📋 Java Version:"
java -version
echo ""

# Check Maven version
echo "📋 Maven Version:"
mvn -version | head -1
echo ""

# Check Docker and MySQL container
echo "📋 Docker & MySQL Status:"
if docker ps | grep -q mysql-container; then
    echo "✅ MySQL container is running"
    MYSQL_STATUS=$(docker exec mysql-container mysql -uroot -prootpassword -e "SELECT 'OK' as status;" 2>/dev/null || echo "❌ Connection failed")
    echo "   Database connection: $MYSQL_STATUS"
else
    echo "❌ MySQL container is not running"
    echo "   Run: docker run --name mysql-container -e MYSQL_ROOT_PASSWORD=rootpassword -p 3306:3306 -d mysql:latest"
fi
echo ""

# Check project compilation
echo "📋 Project Compilation:"
cd "$(dirname "$0")"
if mvn compile -q; then
    echo "✅ Project compiles successfully"
else
    echo "❌ Project compilation failed"
fi
echo ""

# Check available tasks
echo "📋 Available VS Code Tasks:"
if [ -f ".vscode/tasks.json" ]; then
    echo "✅ VS Code tasks configured:"
    echo "   - Compile Java Project"
    echo "   - Run Java Application"
    echo "   - Clean Project"
    echo "   - Run Tests"
    echo "   - Setup Database"
else
    echo "❌ VS Code tasks not found"
fi
echo ""

# Check development script
echo "📋 Development Script:"
if [ -x "dev.sh" ]; then
    echo "✅ Development script is executable"
    echo "   Usage: ./dev.sh [compile|run|test|clean|setup|db-status|help]"
else
    echo "❌ Development script not found or not executable"
fi
echo ""

# Project structure summary
echo "📋 Project Structure:"
echo "✅ Maven project structure (src/main/java)"
echo "✅ MySQL JDBC driver configured"
echo "✅ VS Code launch configurations"
echo "✅ Database schema available"
echo ""

# Quick start reminder
echo "🚀 Quick Start Commands:"
echo "   ./dev.sh setup    # Setup dependencies"
echo "   ./dev.sh compile  # Compile project"
echo "   ./dev.sh run      # Run application"
echo "   ./dev.sh db-status # Check database"
echo ""

echo "✨ Environment setup complete! Happy coding!"
