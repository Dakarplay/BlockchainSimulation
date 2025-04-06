# 🧱 Blockchain Simulation in Java (with Singly Linked Lists)

This project is a **basic simulation of a blockchain** developed in Java using **singly linked lists**. It allows performing CRUD-S operations (Create, Read, Update, Delete, and Search) on the chain’s blocks, helping to understand the fundamentals of a dynamic data structure that simulates a blockchain network.

---

## 👨‍💻 Authors

- David Lopez Barbosa - 0222320001  
- Leon Alejandro Orrego Bello - 0222321002  
- Dago David Palmera Navarro - 0222321003  

---

## 📁 Project Structure
```
BlockchainSimulation/
├── src/
│   ├── app/
│   │   └── App.java
│   └── blockchain/
│       ├── Bloque.java
│       └── Blockchain.java
├── README.md
```

---

## 🧠 Concept

A blockchain is a data structure where each block contains a set of data, an identifier, and the hash of the previous block. In this simulation, we use a **singly linked list**, where each node represents a block in the chain.

---

## ⚙️ Features

- 📦 **Add Blocks**: Inserts new blocks with custom data.
- 🔍 **Search Blocks**: Allows searching for a block by its hash.
- 📋 **Display Full Chain**: Shows all existing blocks.
- ✏️ **Update Block Data**: Modifies the data of an existing block and updates its hashes.
- ❌ **Delete a Block**: Deletes a block by its ID, reorganizing the chain and recalculating hashes.

---


## 🚀 Run Instructions

### ✅ Requirements

- JDK 17 or higher
- VSCode (recommended with Java Extension Pack)

### 🛠️ Compile and Run from Terminal

```bash
cd src
javac app/App.java blockchain/Bloque.java blockchain/Blockchain.java
java app.App

### 💻 Run from VSCode
1. Open the project folder in VSCode.

2. Open the App.java file.

3. lick on the Run button (▶️) or press F5.

---

## 🧩 Class Descriptions

### `Block.java`

Represents an individual block.

**Attributes:**
- `int blockId`
- `String transactionData`
- `int previousHash`
- `int currentHash`
- `Bloque nextBlock`

**Key Methods:**
- `calculateHash()`: Simulates a hash using `Objects.hash( blockId, transactionData, previousHash);`
- `displayBlockInfo()`: prints the block’s data

---

### `Blockchain.java`

Contains the logic of the linked list simulating the blockchain.

**Attributes:**


**Main Methods:**


---

### `App.java`

Main class with the main() method that tests the blockchain functionality.

---

## 📌 Example Output

```
Full Blockchain:
Block 1:
Data: Alice sends 10 BTC to Bob
Previous hash: None
Current hash: 2125378565

Block 2:
Data: Bob sends 5 BTC to Charlie
Previous hash: 2125378565
Current hash: 2125378566

...
```

---

## 📥 Possible Future Improvements

- Implementation of a real hashing algorithm (e.g., SHA-256)
- Blockchain integrity validation
- Graphical interface or REST API
- Persistent storage in files or database

---

## 📘 Subject

**Data Structures** – Simulation of linked lists and dynamic structures applied to blockchain.

---