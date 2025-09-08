package com.cistron.exercises.day2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * FileCopyExercise - Assignment to copy all files from one folder to another
 * This class demonstrates file manipulation operations learned during Day 2
 */
public class FileCopyExercise {

    /**
     * Copies all files from source directory to destination directory
     * @param sourceDir Source directory path
     * @param destDir Destination directory path
     * @return true if all files are copied successfully, false otherwise
     */
    public boolean copyAllFiles(String sourceDir, String destDir) {
        try {
            // Create File objects for source and destination directories
            File sourceDirFile = new File(sourceDir);
            File destDirFile = new File(destDir);
            
            // Check if source directory exists and is a directory
            if (!sourceDirFile.exists() || !sourceDirFile.isDirectory()) {
                System.out.println("Source directory does not exist: " + sourceDir);
                return false;
            }
            
            // Create destination directory if it doesn't exist
            if (!destDirFile.exists()) {
                boolean created = destDirFile.mkdirs();
                if (!created) {
                    System.out.println("Failed to create destination directory: " + destDir);
                    return false;
                }
                System.out.println("Created destination directory: " + destDir);
            }
            
            // Get list of files in source directory
            File[] files = sourceDirFile.listFiles();
            
            if (files == null || files.length == 0) {
                System.out.println("No files found in source directory");
                return true; // No files to copy is still a successful operation
            }
            
            // Copy each file
            int successCount = 0;
            for (File file : files) {
                // Only copy files, not subdirectories
                if (file.isFile()) {
                    Path sourcePath = file.toPath();
                    Path destPath = Paths.get(destDir, file.getName());
                    
                    Files.copy(sourcePath, destPath, StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Copied: " + file.getName());
                    successCount++;
                }
            }
            
            System.out.println("Successfully copied " + successCount + " files");
            return true;
        } catch (IOException e) {
            System.err.println("Error copying files: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Enhanced version that recursively copies files and subdirectories
     * @param sourceDir Source directory path
     * @param destDir Destination directory path
     * @return true if all files are copied successfully, false otherwise
     */
    public boolean copyAllFilesRecursively(String sourceDir, String destDir) {
        try {
            File sourceDirFile = new File(sourceDir);
            File destDirFile = new File(destDir);
            
            // Check if source directory exists and is a directory
            if (!sourceDirFile.exists() || !sourceDirFile.isDirectory()) {
                System.out.println("Source directory does not exist: " + sourceDir);
                return false;
            }
            
            // Create destination directory if it doesn't exist
            if (!destDirFile.exists()) {
                boolean created = destDirFile.mkdirs();
                if (!created) {
                    System.out.println("Failed to create destination directory: " + destDir);
                    return false;
                }
                System.out.println("Created destination directory: " + destDir);
            }
            
            // Copy directory contents recursively
            return copyDirectory(sourceDirFile, destDirFile);
            
        } catch (IOException e) {
            System.err.println("Error copying files recursively: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    /**
     * Helper method to recursively copy directory contents
     */
    private boolean copyDirectory(File sourceDir, File destDir) throws IOException {
        File[] files = sourceDir.listFiles();
        
        if (files == null) {
            return false;
        }
        
        for (File file : files) {
            File destFile = new File(destDir, file.getName());
            
            if (file.isDirectory()) {
                // Create the destination directory
                if (!destFile.exists() && !destFile.mkdirs()) {
                    System.out.println("Failed to create directory: " + destFile);
                    return false;
                }
                
                // Recursively copy subdirectory
                if (!copyDirectory(file, destFile)) {
                    return false;
                }
            } else {
                // Copy the file
                Files.copy(file.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Copied: " + file.getAbsolutePath() + " to " + destFile.getAbsolutePath());
            }
        }
        
        return true;
    }
}
