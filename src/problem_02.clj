(ns problem_02)

(defn print_n_hello_worlds
  ;; Prints the hello world n times
  [n]
  (if
    (= n 1)
    "Hello world"
    (do
      (println "Hello world")
      (print_n_hello_worlds
        (- n 1))) ))

(println (print_n_hello_worlds 2))