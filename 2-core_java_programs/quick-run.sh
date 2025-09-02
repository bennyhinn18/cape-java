#!/bin/bash

# Quick Java Runner - Compile and Run in one step
# Usage: ./quick-run.sh

echo "🚀 Quick Java Runner (No Maven)"
echo "================================"

cd /workspaces/cape-java/2-core_java_programs

# Clean previous build
echo "🧹 Cleaning previous build..."
rm -rf build/classes
mkdir -p build/classes

# Compile
echo "⚙️  Compiling Java files..."
javac -cp "lib/mysql-connector-j-8.3.0.jar" -d "build/classes" $(find src -name "*.java")

if [ $? -eq 0 ]; then
    echo "✅ Compilation successful!"
    echo ""
    echo "▶️  Running application..."
    echo "=========================="
    java -cp "build/classes:lib/mysql-connector-j-8.3.0.jar" com.cistron.app.start.Start
else
    echo "❌ Compilation failed!"
    exit 1
fi
