# Day 2 File Manipulation Exercise

## Assignment
Create a function to copy all the files from one folder to another folder

## Implementation Details

### Classes Created:
1. **FileCopyExercise.java** - Main class that implements file copying functionality:
   - `copyAllFiles()` - Copies all files in the top level of source directory to destination directory
   - `copyAllFilesRecursively()` - Enhanced version that copies all files and subdirectories recursively

2. **FileCopyDemo.java** - Demo class showing how to use the FileCopyExercise class

### Key Java Features Used:
- `java.io.File` - For file and directory operations
- `java.nio.file.Files` - For advanced file manipulation operations
- `java.nio.file.Path` - For representing file paths
- `java.nio.file.StandardCopyOption` - For copy options like REPLACE_EXISTING

### How to Run:
1. Update the source and destination directories in `FileCopyDemo.java`
2. Run the `main()` method in `FileCopyDemo.java`

### Sample Usage:
```java
// Create an instance of the FileCopyExercise class
FileCopyExercise fileCopy = new FileCopyExercise();

// Basic file copy (only top-level files)
fileCopy.copyAllFiles("/path/to/source", "/path/to/destination");

// Recursive file copy (includes subdirectories)
fileCopy.copyAllFilesRecursively("/path/to/source", "/path/to/destination");
```

## Notes:
- The implementation handles various edge cases including:
  - Source directory doesn't exist
  - Destination directory doesn't exist (creates it automatically)
  - Empty source directory
  - Error handling for I/O exceptions
- The recursive version preserves the directory structure in the destination
