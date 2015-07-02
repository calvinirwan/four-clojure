(ns four-clojure.part11)
;;problem 105
(defn p105
  [coll]
  (if (seq coll)
    (if (keyword? (first coll))
      (assoc (p105 (rest coll)) (first coll) (take-while number? (rest coll)))
      (p105 (rest coll)))
    {}))

;;problem 110
(defn p110
  [coll]
  (let [x (first coll)
        a (take-while #(= x %) coll)
        b (drop-while #(= x %) coll)]
    (if x
      (conj (p110 b)
            x (count a))
      '())))

(defn p110
  [coll]
  (let [tiger (fn p110
                [coll]
                (let [x (first coll)
                      a (take-while #(= x %) coll)
                      b (drop-while #(= x %) coll)]
                  (if x
                    (conj (p110 b)
                          x (count a))
                    '())))]
    (iterate tiger (tiger coll)))) 
