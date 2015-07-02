(ns four-clojure.part12)
;;problem 112
(defn p112
  [num coll]
  (let [n (first coll)]
    (if (coll? n)
      (if (first n)))))

;;problem 115
(defn p115
  [num]
  (let [s (str num)
        c (count s)
        [l r] (split-at (quot c 2) s)
        f (fn [coll] (- (reduce #(+ %1 (int %2)) 0 coll) (* 48 (count coll))))]
    (if (odd? c)
      (= (f l) (f (rest r)))
      (= (f l) (f r)))))
