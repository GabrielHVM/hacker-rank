(ns fibonacci)

(defn fibonacci
  "Given a number, calculates the fibonacci"
  ([number]
   (fibonacci number ()))

  ([number acc]
   (if (or (= number 1) (= number 0))
     (conj acc 0 0)
     (recur (dec number) (conj acc (+' (first acc) (second acc))))))
  )

(let [n (read-line)]
  (-> n
      (Integer/parseInt)
      (fibonacci)
      (println)))

;; fib(1, 0) = 0 -> 0
;; fib(2) = fib(1) + fib(0) ->
;; fib(3) = fib(2) + fib(1) = fib(1) = fib()