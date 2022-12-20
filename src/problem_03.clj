(ns problem_03)

(fn
  [num lst]
  (doseq [number lst]
    (dotimes [_ num]
      (println number))))