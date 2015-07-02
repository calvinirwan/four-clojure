(ns four-clojure.part15)
;;problem 144
(defn p144
  [x & f]
  ((fn ocil
    [x [f1 & f]]
    (if f1
      (cons x (lazy-seq (ocil (f1 x) f)))
      [x])) x (cycle f)))

;;problem 150
(defn p150
  [x]
  (filter #(= (str %) (apply str (reverse (str %)))) (iterate inc x)))
