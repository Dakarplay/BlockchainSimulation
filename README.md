
# 🧱 Simulación de Blockchain en Java (con Listas Enlazadas Simples)

Este proyecto es una **simulación básica de una blockchain** desarrollada en Java utilizando **listas enlazadas simples**. Se pueden realizar operaciones CRUD-S (Crear, Leer, Actualizar, Eliminar y Buscar) sobre los bloques de la cadena, lo que permite comprender los fundamentos de una estructura de datos dinámica simulando una red blockchain.

---

## 👨‍💻 Autores

- David Lopez Barbosa - 0222320001  
- Leon Alejandro Orrego Bello - 0222321002  
- Dago David Palmera Navarro - 0222321003  

---

## 📁 Estructura del Proyecto

```
BlockchainSim/
├── src/
│   ├── app/
│   │   └── App.java
│   └── blockchain/
│       ├── Bloque.java
│       └── Blockchain.java
├── README.md
```

---

## 🧠 Concepto

Una blockchain es una estructura de datos donde cada bloque contiene un conjunto de datos, un identificador y el hash del bloque anterior. En esta simulación, utilizamos una **lista enlazada simple**, donde cada nodo representa un bloque de la cadena.

---

## ⚙️ Funcionalidades

- 📦 **Añadir Bloques**: Inserta nuevos bloques con datos personalizados.
- 🔍 **Buscar Bloques**: Permite buscar un bloque por su hash.
- 📋 **Mostrar Cadena Completa**: Visualiza todos los bloques existentes.
- ✏️ **Actualizar Datos de un Bloque**: Modifica los datos de un bloque existente y actualiza sus hashes.
- ❌ **Eliminar un Bloque**: Elimina un bloque por su ID, reorganizando la cadena y recalculando hashes.

---

## 🚀 Instrucciones de Ejecución

### ✅ Requisitos

- JDK 17 o superior
- VSCode (recomendado con Java Extension Pack)

### 🛠️ Compilar y Ejecutar desde Terminal

```bash
cd src
javac app/App.java blockchain/Bloque.java blockchain/Blockchain.java
java app.App
```

### 💻 Ejecutar desde VSCode

1. Abre la carpeta del proyecto en VSCode.
2. Abre el archivo `App.java`.
3. Haz clic en el botón de **Run** (▶️) o presiona `F5`.

---

## 🧩 Descripción de Clases

### `Bloque.java`

Representa un bloque individual.

**Atributos:**
- `int idBloque`
- `String datos`
- `int hashAnterior`
- `int hashActual`
- `Bloque siguiente`

**Métodos importantes:**
- `calcularHash()`: simula un hash usando `Objects.hash(idBloque, 1000)`
- `mostrarBloque()`: imprime los datos del bloque

---

### `Blockchain.java`

Contiene la lógica de la lista enlazada que simula la blockchain.

**Atributos:**
- `Bloque primerBloque`

**Métodos principales:**
- `añadirBloque(String datos)`
- `mostrarBlockchain()`
- `buscarBloque(int hash)`
- `actualizarBloque(int id, String nuevosDatos)`
- `eliminarBloque(int id)`

---

### `App.java`

Clase principal con el método `main()` que permite probar el funcionamiento de la blockchain.

---

## 📌 Ejemplo de Salida

```
La Blockchain completa:
Bloque 1:
Datos: Alice envía 10 BTC a Bob
Hash anterior: None
Hash actual: 2125378565

Bloque 2:
Datos: Bob envía 5 BTC a Charlie
Hash anterior: 2125378565
Hash actual: 2125378566

...
```

---

## 📥 Posibles Mejoras Futuras

- Implementación de un algoritmo real de hashing (ej. SHA-256)
- Validación de integridad de la cadena
- Interfaz gráfica o API REST
- Almacenamiento persistente en archivos o base de datos

---

## 📘 Materia

**Estructura de Datos** – Simulación de listas enlazadas y estructuras dinámicas aplicadas a blockchain.

---