(ns exponencial-function)

(defn factorial
  "Returns the factorial of a number"
  [input-number]
  (case input-number
    0 1N
    1 1N
    (*' (biginteger input-number)
        (factorial (dec (biginteger input-number))))))

(defn exponential-function
  "Returns the value of exponential function
   by Taylor series w/ specified number of terms-> f(x)=(pow e x)"
  [input-number number_of_terms]
  (case number_of_terms
    1N (+' input-number 1)
    (+' (/ (Math/pow input-number number_of_terms)
           (factorial number_of_terms))
        (exponential-function input-number (dec number_of_terms))))
  )

(defn exponential-function-10-terms
  "Returns the exponential function for the 10 first terms of expansion"
  [input-number]
  (exponential-function input-number 9))

(println (format "%.4f" (exponential-function-10-terms 2009.0000)))
;(println (format "%.4f" (exponential-function-10-terms 5.0000)))
;(println (format "%.4f" (exponential-function-10-terms 0.5000)))
;(println (format "%.4f" (exponential-function-10-terms -0.5000)))