# AlgoCore

![Data Structures](https://img.shields.io/badge/-Data%20Structures-blue)
![Algorithms](https://img.shields.io/badge/-Algorithms-green)
![Java](https://img.shields.io/badge/Language-Java-red)
![DSA](https://img.shields.io/badge/-DSA-yellow)
![Coding Interview](https://img.shields.io/badge/-Coding%20Interview-purple)
![License](https://img.shields.io/badge/License-MIT-brightgreen)
![Author](https://img.shields.io/badge/Author-Ho%C3%A0ng%20Chi%E1%BB%81u%20Nguy%E1%BB%85n%20Tu%E1%BA%A5n-blueviolet)

A Java-based Maven project implementing fundamental data structures and sorting algorithms from scratch, with detailed code for learning and reference.

## Author
**Hoàng Chiều Nguyễn Tuấn**  

- GitHub: [hoangtuan2k5](https://github.com/hoangtuan2k5)
- Email: hoangchieunguyentuan@gmail.com
- LinkedIn: [hoangchieunguyentuan](https://linkedin.com/in/hoangchieunguyentuan)

## Overview
Welcome to AlgoCore! This repository is a collection of fundamental data structures (e.g., Array, Dynamic Array, Linked List, Stack) and basic sorting algorithms (e.g., Bubble Sort, Insertion Sort) implemented in Java from scratch. Each implementation includes detailed code, such as Node classes for Linked List, to serve as a learning resource for understanding DSA foundations.

## Folder Structure
```
AlgoCore/
├── src/
│   ├── main/java/io/github/hoangtuan2k5/
│   │   ├── datastructures/
│   │   │   ├── array/            ← Static Array implementation
│   │   │   ├── dynamicarray/     ← Dynamic Array implementation
│   │   │   ├── linkedlist/       ← Linked List with Node class
│   │   │   ├── stack/
│   │   │   │   ├── arraybased/   ← Stack based on Array
│   │   │   │   └── linkedlistbased/ ← Stack based on Linked List
│   │   │   ├── heap/            ← Heap data structure implementation
│   │   │   ├── hash/            ← Hash data structure implementation
│   │   │   └── ...               ← Other data structures
│   │   ├── algorithms/
│   │   │   ├── sorting/          ← Sorting algorithms (Bubble, Selection, Insertion, etc.)
│   │   │   └── ...               ← Other algorithms
│   └── test/java/io/github/hoangtuan2k5/
│       └── ...                   ← Unit tests for data structures and algorithms
├── pom.xml                       ← Maven configuration
├── LICENSE                       ← MIT License
└── README.md                     ← This file
```

## Prerequisites

- **Java**: 23 or higher
- **Maven**: 3.9.9 or higher
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code (optional)
- **OS**: Windows, Linux, or macOS

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/hoangtuan2k5/AlgoCore.git
   cd AlgoCore
   ```

2. Verify Maven installation:
   ```bash
   mvn -version
   ```

3. Install dependencies:
   ```bash
   mvn install
   ```

## Running the Project

1. Compile the project:
   ```bash
   mvn compile
   ```

2. Run a specific implementation (replace Main with the class name, e.g., LinkedListDemo):
   ```bash
   mvn exec:java -Dexec.mainClass=io.github.hoangtuan2k5.Main
   ```

3. Run unit tests:
   ```bash
   mvn test
   ```

## How to Use

1. Navigate to a data structure or algorithm folder (e.g., `src/main/java/io/github/hoangtuan2k5/datastructures/linkedlist/`).
2. Open the Java file for the implementation. Each file includes:
   - Detailed code (e.g., Node class for Linked List).
   - Comments explaining the logic.
   - Test cases (in `src/test/java`).
3. Run the implementation using Maven or your IDE.
4. Add your own implementations or improvements to the corresponding folder.

## Data Structures Implemented

- **Array**: Static array operations.
- **Dynamic Array**: Resizable array with dynamic capacity.
- **Linked List**: Singly/Doubly Linked List with Node class.
- **Stack**:
  - Array-based Stack.
  - Linked List-based Stack.
- **Queue** (planned): Array-based and Linked List-based.
- **Heap**:
  - Min-Heap: Priority queue with minimum element at the root.
  - Max-Heap: Priority queue with maximum element at the root.
- **Hash**:
  - Hash Table/Map: Key-value storage with O(1) average lookup time.
  - Hash Set: Collection of unique elements with efficient membership tests.
- **Tree**:
  - Binary Tree: Tree with at most two children per node.
  - Binary Search Tree (BST): Ordered binary tree with efficient search operations.
  - AVL Tree: Self-balancing BST with height-balanced property.
  - Red-Black Tree: Self-balancing BST with color properties for balance.
  - Trie: Efficient string search data structure.
  - B-Tree: Self-balancing tree designed for disk-based storage systems.
- **Graph**:
  - Adjacency Matrix: 2D array representation of graphs.
  - Adjacency List: List-based representation of graphs.
  - Weighted Graph: Graph with weights/costs on edges.
  - Directed Graph: Graph with directed edges.
  - Undirected Graph: Graph with bidirectional edges.
- More to be added...

## Sorting Algorithms Implemented

- Bubble Sort
- Selection Sort
- Insertion Sort
- Merge Sort (planned)
- Quick Sort (planned)
- More to be added...

## Project Creation
This project was created using Maven with the following command:
```bash
mvn archetype:generate -DgroupId=io.github.hoangtuan2k5 -DartifactId=AlgoCore -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

## Contributing

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeature`).
3. Add your implementations or improvements.
4. Commit your changes (`git commit -m "Add your message"`).
5. Push to the branch (`git push origin feature/YourFeature`).
6. Open a Pull Request.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Happy Coding! 🚀