package com.cistron.exercises.day2;

/**
 * This class demonstrates the usage of FileCopyExercise
 * It provides examples of how to copy files between directories
 */
public class FileCopyDemo {

    public static void main(String[] args) {
        FileCopyExercise fileCopy = new FileCopyExercise();
        
        // Example paths - replace with actual paths when testing
        String sourceDirectory = "/workspaces/cape-java/src";
        String destinationDirectory = "/workspaces/cape-java/dest";

        System.out.println("=== File Copy Exercise - Day 2 ===");
        System.out.println("Copying files from: " + sourceDirectory);
        System.out.println("To: " + destinationDirectory);
        
        // Basic file copy (only files in the top directory)
        boolean success = fileCopy.copyAllFiles(sourceDirectory, destinationDirectory);
        
        if (success) {
            System.out.println("Basic file copy completed successfully!");
        } else {
            System.out.println("Basic file copy encountered errors.");
        }
        
        // Recursive file copy (includes subdirectories)
        System.out.println("\n=== Recursive File Copy ===");
        success = fileCopy.copyAllFilesRecursively(sourceDirectory, destinationDirectory);
        
        if (success) {
            System.out.println("Recursive file copy completed successfully!");
        } else {
            System.out.println("Recursive file copy encountered errors.");
        }
    }
}
