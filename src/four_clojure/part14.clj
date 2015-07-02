(ns four-clojure.part14)
;;problem 137
(defn p137
  [num base n]
  (let [x (int (Math/pow base (inc n)))
        y (int (Math/pow base n))]
    (if (> x num)
      ((fn conor [num base n]
         (let [a (int (Math/pow base n))
               ]
           (do (print num) (if (zero? n)
             []
             (if (< a num)
               (conj (conor (- num a) base (dec n)) 1)
               (conj (conor num base (dec n)) 0))
             )))) num base n)
      (p137 num base (inc n)))))

(defn p137
  [num base]
  (let [a (quot num base)
        b (rem num base)]
    (if (zero? a)
      [b]
      (conj (p137 a base) b))))
