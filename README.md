# File-Explorer
This Java project implements a file explorer that can browse the files and directories on a computer system. It utilizes the provided files called '**ControlPanel**', '**FileObject**', '**FileObjectException**', '**FileSystem**', '**ListNodes**', '**MyTextArea**', '**NameComparator**', '**PrintFileStructure**', '**SizeComparator**', '**SplitPanel**', '**StringComparator**', and '**SuffixComparator**'. The program can search for files of a specific type and look for files by name within a specified directory.

The project helped to develop programming skills in Java, including the use of classes, methods, constructors, and iterators. It also taught how to create a hierarchical data structure using a tree-like structure to represent the files and directories.

## Skills Learned
- Familiarity with Java classes and objects
- Understanding of recursion and iteration
- Implementation of a tree data structure using Nodes and Lists
- Ability to handle and throw custom exceptions in Java
- Working with file objects in Java
- Sorting and searching algorithms using comparators and iterators

## Usage
To use this program, simply run the ControlPanel.java file. The program will display a GUI with a search bar and buttons to explore the file system.

## Constants
This program does not have any constants.

##Functions

NLNode:
- '**Constructor #1**': initializes instance variables parent, children, and data
- '**Constructor #2**': initializes instance variables with given data and parent node
- '**setParent**': sets the parent node
- '**getParent**': returns the parent node
- '**addChild**': adds a child node
- '**getChildren**': returns an iterator of child nodes
- '**getChildren(sorter)**': returns an iterator of child nodes sorted by the given comparator
- '**getData**': returns the data of the node
- '**setData**': sets the data of the node

FileStructure:
- '**Constructor**': creates the file structure given a directory name
- '**createFileStructure**': recursive helper method to create the file structure
- '**getRoot**': returns the root node of the file structure
- '**filesOfType**': returns an iterator of file names of the given type
- '**addToIteratorByType**': recursive helper method to add file names to the iterator by type
- '**findFile**': returns the long name of a file with the given name
- '**findFileByName**': recursive helper method to find a file by name

## Limitations:
Currently, the program can only search for files within a single directory.
The program does not support file operations such as renaming or deleting files.

## Possible Improvements
- Allow for searching within multiple directories.
- Implement file operations such as renaming or deleting files.
- Add functionality for opening and editing files directly within the program.

## Conclusion
This project provided hands-on experience with working with file objects and creating a file explorer. It also taught me about implementing and working with a tree data structure and recursion in Java. The use of comparators and iterators for sorting and searching algorithms also expanded my knowledge in Java programming.
