(ns problem_04 (:require [clojure.math]))

(def input '("8" "15" "22" "1" "10" "6" "2" "18" "18" "1"))

(println (doseq [odd-index (->> input
              count
              range
              (filter odd?))]
           (println (nth input odd-index))))

(def input2 [1 2 3 4 5 6 7 8 9 0])

(defn return-1
  [n]
  (if (= n 0)
    1
    n))

(->> input
     (map #(Integer/parseInt %))
     (map (fn [n] (if (= n 0) 1 n))))

(case 10
  1 "1"
  2 "2"
  "N eh 1 ou 2")
