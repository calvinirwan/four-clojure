(ns four-clojure.part6)

;;problem 53

;; (defn drill
;;   [[a & coll]]
;;   (if (= (inc a) (first coll))
;;     (conj (drill coll) a)
;;     [a]))

(defn drill
  [[a & coll] x]
  (if (= (inc a) (first coll))
    (conj (drill coll (conj x a)) a)
    (if (first x)
      [a]
      [])))

(defn p53
  [coll]
  (if (seq coll)
    (conj (p53 (rest coll))
          (reverse ((fn drill
                      [[a & coll] x]
                      (if (= (inc a) (first coll))
                        (conj (drill coll (conj x a)) a)
                        (if (first x)
                          [a]
                          []))) coll [])))
    []))


;;problem 60
(defn p60
  ([f x]
     (p60 f (first x) (rest x)))
  
  ([f x y]
     (if (seq y)
       (cons x (lazy-seq (p60 f (f x (first y)) (next y))))
       [x])))
