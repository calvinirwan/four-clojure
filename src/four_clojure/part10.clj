(ns four-clojure.part10)
;;problem 92
(defn p92
  [num]
  (let [roman {"I" 1
               "V" 5
               "X" 10
               "L" 50
               "C" 100
               "D" 500
               "M" 1000}
        l ()]
    ()))

;;problem 93
(defn p93
  [coll]
  (if (seq coll)
    (if (coll? (ffirst coll))
      (concat (p93 (first coll)) (p93 (next coll)))
      (conj (p93 (next coll)) (first coll)))
    '()))

;;problem 96
(def a [1
        [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])

(def b [1
        [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])

(def c [1
        [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
        [2 [3 nil [4 [6 nil nil] nil]] nil]])

(defn mirror
  [coll]
  (let [node (first coll)
        childa (second coll)
        childb (last coll)]
    (if (seq childa)
      (if (seq childb)
        [node (mirror childb) (mirror childa)]
        [node childb (mirror childa)])
      (if (seq childb)
        [node (mirror childb) childa]
        [node childb childa]))))

(defn p96
  [coll]
  (let [childa (second coll)
        childb (last coll)]
    (= ((fn [coll] (let [node (first coll)
        childa (second coll)
        childb (last coll)]
    (if (seq childa)
      (if (seq childb)
        [node (mirror childb) (mirror childa)]
        [node childb (mirror childa)])
      (if (seq childb)
        [node (mirror childb) childa]
        [node childb childa])))) childa) childb)))

;;problem 98
(defn p98
  [f coll]
  (set (map #(into #{} (val %)) (group-by f coll))))
