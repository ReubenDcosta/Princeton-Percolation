# 📌 Percolation Simulation (Princeton Algorithms Part I)

This project simulates **percolation in an N-by-N grid**, based on the **Princeton University Algorithms, Part I course** on Coursera. It includes a Monte Carlo simulation to estimate the **percolation threshold**.

---

## 📁 Contents

- `Percolation.java` – models the percolation system using the Union-Find (UF) data structure.
- `PercolationStats.java` – performs T independent experiments to compute mean, stddev, and 95% confidence interval of percolation threshold.
- `algs4.jar` – library provided by Princeton that contains standard I/O and Union-Find implementations (required for compilation and execution).

---

## ✅ How to Compile & Run

Make sure you're in the project directory that contains the files.

> 📍 On **Windows (CMD or Git Bash)**:
```
javac -cp .;algs4.jar Percolation.java PercolationStats.java
java  -cp .;algs4.jar PercolationStats 200 100
```

## 🐧 On Mac/Linux:

```
javac -cp .:algs4.jar Percolation.java PercolationStats.java
java  -cp .:algs4.jar PercolationStats 200 100
```

Where:

- `200` = grid size (n)  
- `100` = number of simulation trials (T)

---

## 📊 Sample Output

```
mean                    = 0.592845
stddev                  = 0.008213
95% confidence interval = [0.57423, 0.60746]
```

---

## 🧠 Concepts Used

- Monte Carlo Simulation  
- Weighted Quick Union with Path Compression  
- Probabilistic Modeling  
- Performance Analysis (mean, stddev, confidence intervals)

---

## 📌 Skills Demonstrated

- Java programming (OOP, exception handling, arrays)  
- Efficient use of external libraries (`algs4.jar`)  
- Union-Find data structure usage  
- Data analysis and simulation techniques  
- Academic-level project based on Ivy League curriculum

---

## 🏅 Source

This project is based on the programming assignment from:

**Algorithms, Part I – Princeton University, Coursera**  
Instructors: *Kevin Wayne & Robert Sedgewick*

---

## 📄 License

This is an academic project for learning purposes and is **not for commercial redistribution**. Princeton materials copyright remain with the authors.

---

## 🔗 Connect

If you liked this, check out more projects or connect with me on [LinkedIn](www.linkedin.com/in/reuben-d-costa-681b70289).


