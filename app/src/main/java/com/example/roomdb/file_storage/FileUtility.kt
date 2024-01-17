package com.example.roomdb.file_storage

import android.content.Context
import com.example.roomdb.debugLog
import java.io.File
import java.io.FileWriter
import java.io.IOException

//How to create files in android
//fun createFile(){
//    val myFile = File("/mnt/sdcard/0/", "myfile.txt")
//    myFile.createNewFile()
//}

// cache directory is very quick
// used if you want to create files and retrieve them very fast
// it has some limitations
// recommended to store files that are small below 50kb

// File directory is the complete oposite

// file directory and cache derectory represent different paths in the android file system


// 1. Lets create a generic function that creates and writes to file
fun writeToFile(file: File, content: String) {
    try {
        // this will make sure the file is created and that some content is written to it

//        val file = FileWriter(file)

        /*
        file.write(content)
        // this will flush out the resources
        file.flush()
        file.close()
        */

        // making the above code more kotlin

        /*
        with(file){
            write(content)
            flush()
            close()
        }
        */

        // best way
        FileWriter(file).apply {
            write(content)
            flush()
            close()
        }

    } catch (e: IOException) {
        debugLog("Failed to write to file to ${file.name}")
    }
}


// 2. Create a function to write to Cache Directory

enum class CacheDirectoryType {
    INTERNAL, EXTERNAL
}

// Since this is the application context, we will take context as a param
// because we can access all files from this context.cacheDir, context.externalCacheDir...
fun writeToCacheDirectory(
        context: Context, content: String, cacheDirectoryType: CacheDirectoryType
) {

    // 1. first retrieve the parent directory for the file
    val cacheDirectory =
        if (cacheDirectoryType == CacheDirectoryType.INTERNAL) context.cacheDir else
            context.externalCacheDir

    // 2. obtain an object of the actual file
    val file = File(cacheDirectory, "cache_file.txt")

    writeToFile(file = file, content = content)
}


