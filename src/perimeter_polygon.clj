(ns perimeter-polygon)

(defn calc-distance
  "Given a list with coordinates of two points, calculates the distance between them"
  [[x1 y1 x2 y2]]
  (let [diff-xs (- x2 x1)
        diff-ys (- y2 y1)
        square-dff-xs (* diff-xs diff-xs)
        square-dff-ys (* diff-ys diff-ys)
        sum-of-squares (+ square-dff-xs square-dff-ys)]
    ; for hackerrank use Math/sqrt
    (clojure.math/sqrt sum-of-squares)))

(defn line-segments
  "Given a list with points, returns the lines segments of the points"
  [points line-segments-list]
  (let [a (first points)
        b (second points)
        rest-of-points (next points)
        ab (concat a b)]
    (if (not rest-of-points)
      line-segments-list
      (recur rest-of-points (conj line-segments-list ab)))))

(defn sides-of-polygon [list-with-coordinates]
  "Given a list with coordinates, returns the sides of the polygon"
  (let [first-pair (first list-with-coordinates)
        last-pair (last list-with-coordinates)
        line-segments (line-segments list-with-coordinates [])
        last-coordinate-pair (concat first-pair last-pair)]
    (conj line-segments last-coordinate-pair)))

(defn read-n-lines-of-STDIN
  "Reads the STDIN n times, returning a list with the input"
  [n inputs]
  (let [size-of-inputs (count inputs)]
    (if (= size-of-inputs n)
      inputs
      (recur n (conj inputs (read-line))))))

(defn polygon-perimeter [sides-of-polygon]
  "Calculates polygon perimeter"
  (->> (map calc-distance sides-of-polygon)
      (apply +)))

(defn str-to-int
  "Converts string to integer"
  [str]
  (Integer/parseInt str))

(defn str-pair-to-int-pair [[x y]]
  "Given a pair of string, converts them to integer returning a pair of integers"
  (let [int-x (str-to-int x)
        int-y (str-to-int y)]
    (list int-x int-y)))

(defn split-line
  "Split str by space"
  [line]
  (clojure.string/split line #" "))

(let [n (read-line)]
  (require '[clojure.string :as str])
  (as-> (Integer/parseInt n) $
        (read-n-lines-of-STDIN $ [])
        (map split-line $)
        (map str-pair-to-int-pair $)
        (sides-of-polygon $)
        (polygon-perimeter $)
        (println $)
      ))